<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Categorias extends Model_Mymodel {

    private $_restrict;

	public function __construct(){
        parent::__construct("categorias");
        $query = DB::select($this->_table.'.*',$this->abertaExpr())->from($this->_table)
                ->order_by('fim', 'ASC');
        $this->setCacheQuery($query);
        $this->_restrict = false;
	}
	
	protected function format($linha){
        $res = DB::select()->from('categorias_grupos')->where('id_categoria', '=', (int)$linha["id"])->execute();
        $grps = array();
        foreach($res as $row)
            $grps[] = $row['id_grupo'];        
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"], "nome" => $linha["nome"], "inicio" => $linha["inicio"], "fim" => $linha["fim"], "aberta" => (int)$linha["aberta"], "grupos" => $grps));
	}
	
	public function	getAllCategorias(){ return $this->getList(); }
    
    public function getAllOpened(){
        
        $query = $this->addDateQuery(DB::select()->from($this->_table))->order_by('nome', 'ASC');
        if ($this->_restrict !== false) $query = $this->addVisibility($query, $this->_restrict);
        $res = $query->execute();
        $lista = array();
        foreach($res as $linha){
			$aux = $this->format($linha);
            if ($aux["key"] === null) $lista[] = $aux["value"]; else $lista[$aux["key"]] = $aux["value"];
        }
        return $lista;
    }
	
	public function apagarCategoria($id){
		$id = (int) $id;
        DB::delete($this->_table)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function editarCategoria($id, $nome, $inicio, $fim, $grupos){
		$id = (int) $id;
        $inicio = $this->translateDate($inicio);
        $fim = $this->translateDate($fim);
        
        $querys = array();
        $querys[] = DB::update($this->_table)->set(array('nome' => $nome, 'inicio' => $inicio, 'fim' => $fim))->where('id', '=', $id);
        $querys[] = DB::delete('categorias_grupos')->where('id_categoria', '=', $id);
        foreach($grupos as $valor)
            $querys[] = DB::insert('categorias_grupos')->values(array($id, (int)$valor));
        
        $this->executeInTransaction($querys);
	}
	
	
    protected function getBy($campo, $val){
        return DB::select('*',$this->abertaExpr())->from($this->_table)->where($campo, '=', $val)->execute()->next()->as_array();
    }
    
	public function getCategoriaWithId($id){
        return $this->findBy('id', $id);
	}
	
	public function insereCategoria($nome, $inicio, $fim, $grupos){
        $querys = array();
        $querys["id"] = DB::insert($this->_table)->values(array(null, $nome, $this->translateDate($inicio), $this->translateDate($fim)));
        foreach($grupos as $valor)
            $querys["ref_".$valor] = DB::insert('categorias_grupos')->values(array(':id', (int)$valor));
        $id = $this->executeInTransaction($querys);
        return $id;
	}

    private function getTimeInterval(){
        $agora = new DateTime();
        $amanha = new DateTime();
        $amanha->add(new DateInterval("P1D"));
        return array("agora" => $this->translateDate($agora), "amanha" => $this->translateDate($amanha));
    }
    
    private function addDateQuery($q){
        $dts = $this->getTimeInterval();
        $q->and_where_open()->and_where('inicio', '<', $this->translateDate($dts["agora"]))->and_where('fim', '>', $this->translateDate($dts["amanha"]))->and_where_close();
        return $q;
    }
    public function abertaExpr(){
        $dts = $this->getTimeInterval();
        return array(DB::expr('(inicio < :inicio AND fim > :fim)', array(":inicio" => $dts["agora"] , ":fim" => $dts["amanha"])), 'aberta');
    }
    public function canBeInsertedIn($cat){
        $query = $this->addDateQuery(DB::select($this->abertaExpr())->from($this->_table)->where('id', '=', $cat));
        $linha = $query->execute()->as_array();
        return ($linha[0]['aberta'] > 0);
    }
    
    private function addVisibility($query, $id){
        $query->join('categorias_grupos')->on('id_categoria', '=', 'id')
                ->and_where_open()->where('id_grupo', '=', (int)$id)->or_where('id_grupo', '=', Kohana::$config->load('defs.guest'))->and_where_close();
        $this->_restrict = $id;
        return $query;
    }
    
    public function setOnlyVisible($id) {$this->setCacheQuery($this->addVisibility($this->getCacheQuery(), $id));}
	public function getCategoriaAtPos($i){ return $this->getAtPos($i);}
	
	
} 
?>