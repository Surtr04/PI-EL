<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Categorias extends Model_Mymodel {



	public function __construct(){
        parent::__construct("categorias");
        $query = DB::select('*',$this->abertaExpr())->from($this->_table)->order_by('fim', 'ASC');
        $this->setCacheQuery($query);
	}
	
	protected function format($linha){
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"], "nome" => $linha["nome"], "inicio" => $linha["inicio"], "fim" => $linha["fim"], "aberta" => (int)$linha["aberta"]));
	}
	
	public function	getAllCategorias(){ return $this->getList(); }
    
    public function getAllOpened(){
        
        $query = $this->addDateQuery(DB::select()->from($this->_table))->order_by('nome', 'ASC');
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
	
	public function editarCategoria($id, $nome, $inicio, $fim){
		$id = (int) $id;
        $inicio = $this->translateDate($inicio);
        $fim = $this->translateDate($fim);
        
        DB::update($this->_table)->set(array('nome' => $nome, 'inicio' => $inicio, 'fim' => $fim))->where('id', '=', $id)->execute();
	}
	
	
    protected function getBy($campo, $val){
        return DB::select('*',$this->abertaExpr())->from($this->_table)->where($campo, '=', $val)->execute()->next()->as_array();
    }
    
	public function getCategoriaWithId($id){
        return $this->findBy('id', $id);
	}
	
	public function insereCategoria($nome, $inicio, $fim){
        $id = DB::insert($this->_table)->values(array(null, $nome, $this->translateDate($inicio), $this->translateDate($fim)))->execute();
        return $id[0];
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
    
	public function getCategoriaAtPos($i){ return $this->getAtPos($i);}
	
	
} 
?>