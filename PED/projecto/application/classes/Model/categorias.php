<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Categorias extends Model_Mymodel {



	public function __construct(){
        parent::__construct("categorias");
        $query = DB::select()->from($this->_table)->order_by('fim', 'ASC');
        $this->setCacheQuery($query);
	}
	
	protected function format($linha){
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"], "nome" => $linha["nome"], "inicio" => $linha["inicio"], "fim" => $linha["fim"], "aberta" => $this->canBeInsertedIn($linha["id"])));
	}
	
	public function	getAllCategorias(){ return $this->getList(); }
    
    public function getAllOpened(){
        $agora = new DateTime();
        $amanha = new DateTime();
        $amanha->add(new DateInterval("P1D"));
        
        $query = DB::select()->from($this->_table)->where('inicio', '<', $this->translateDate($agora))->and_where('fim', '>', $this->translateDate($amanha))->order_by('nome', 'ASC');
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
	
	
	public function getCategoriaWithId($id){
        return $this->findBy('id', $id);
	}
	
	public function insereCategoria($nome, $inicio, $fim){
        $id = DB::insert($this->_table)->values(array(null, $nome, $this->translateDate($inicio), $this->translateDate($fim)))->execute();
        return $id[0];
	}
	
    public function canBeInsertedIn($cat){
        $agora = new DateTime();
        $amanha = new DateTime();
        $amanha->add(new DateInterval("P1D"));
        
        $query = DB::select(array(DB::expr('count(*)'), 'conta'))->from($this->_table)->where('id', '=', $cat)->and_where('inicio', '<', $this->translateDate($agora))->and_where('fim', '>', $this->translateDate($amanha));
        $linha = $query->execute()->as_array();
        return ($linha[0]['conta'] > 0);
        //return true;
    }
    
	public function getCategoriaAtPos($i){ return $this->getAtPos($i);}
	
	
} 
?>