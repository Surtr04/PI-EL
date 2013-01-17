<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Stats extends Model_Mymodel {
    
    const ALL = 0;
    const YEAR = 1;
    const MONTH = 2;
    const DAY = 3;
    
    private $_y;
    private $_m;
    private $_d;
    private $_type;
    
	public function __construct(){
        parent::__construct('sips_stats');
        $this->setTime(self::ALL);
	}
	
    private function addTime($y = null, $m = null, $d = null){
        $this->_y = $y = (int) $y;
        $this->_m = $m = (int) $m;
        $this->_d = $d = (int) $d;
        $inicio = new DateTime();
        $fim = new DateTime();
        switch($this->_type){
            case self::YEAR :
                $inicio->setDate($y, 1, 1);
                $fim->setDate($y, 12, 31);
                break;
            case self::MONTH:
                $inicio->setDate($y, $m, 1);
                $fim->setDate($y, $m, 31);
                break;
            case self::DAY:
                $inicio->setDate($y, $m, $d);
                $fim->setDate($y, $m, $d);
                break;
        }
        $this->setAfter($inicio);
        $this->setBefore($fim);
    }
    
    public function setTime($rest, $all = false, $y = null, $m = null, $d = null){
        $query = DB::select(array(DB::expr('SUM(visualizacoes)'), 's_visualizacoes'), array(DB::expr('SUM(downzip)'), 's_downzip'), 'id', 'ident')->from('sips')
                ->join($this->_table, ($all ? 'LEFT' : 'INNER'))->on('id', '=', 'id_sip')
                ->group_by('id_sip', 'ident');
        $this->setCacheQuery($query);
        $this->_type = $rest;
        if ($rest != self::ALL) $this->addTime($y, $m, $d);
    }
    
    public function setCategorias($all = true) {
        $query = DB::select(array(DB::expr('SUM(visualizacoes)'), 's_visualizacoes'), array(DB::expr('SUM(downzip)'), 's_downzip'), 'id_categoria', 'nome')->from('sips')
                ->join($this->_table, ($all ? 'LEFT' : 'INNER'))->on('id', '=', 'id_sip')
                ->join('categorias', ($all ? 'LEFT' : 'INNER'))->on('categorias.id', '=', 'id_categoria')
                ->group_by('id_categoria', 'nome');
        $this->setCacheQuery($query);
        
        if ($this->_type != self::ALL) $this->addTime($this->_y, $this->_m, $this->_d);
    }
    
	protected function format($linha){
        if (isset($linha['id']))
            return array("key"=> $linha["id"], "value"=>array("id" => (int)$linha["id"], "ident" => $linha["ident"], "visualizacoes" => (int)$linha["s_visualizacoes"], "downzip" => (int)$linha["s_downzip"]));
        else
            return array("key"=> $linha["id_categoria"], "value"=>array("id" => (int)$linha["id_categoria"], "ident" => $linha["nome"], "visualizacoes" => (int)$linha["s_visualizacoes"], "downzip" => (int)$linha["s_downzip"]));
	}
	
    private function _update($id, $data, $campo){
        $id = (int) $id;
        $data = $this->translateDate($data, true);
        
        $query = DB::select(array(DB::expr("COUNT(*)"), 'conta'))->from($this->_table)->where('id_sip', '=', $id)->and_where('dia', '=', $data);
        $linha = $query->execute()->as_array();
        if ($linha[0]['conta'] < 1)
            DB::insert($this->_table, array('id_sip', 'dia', $campo))->values(array($id, $data, 1))->execute();
        else
            DB::update($this->_table)->set(array($campo => DB::expr($campo. ' + 1')))->where('id_sip', '=', $id)->and_where('dia', '=', $data)->execute();
    }
    
    public function logView($id, $data){
        $this->_update($id, $data, 'visualizacoes');
    }
    
    public function logDownload($id, $data){
        $this->_update($id, $data, 'downzip');
    }
    
	public function setByCat($id){ $this->setCacheQuery($this->getCacheQuery()->where('id_categoria', '=', $id));}
    
    public function setBefore($data){$this->setCacheQuery($this->getCacheQuery()->where('dia' , '<=', $this->translateDate($data, true)));}
    public function setAfter($data){$this->setCacheQuery($this->getCacheQuery()->where('dia' , '>=', $this->translateDate($data, true)));}
    
    
} 
?>