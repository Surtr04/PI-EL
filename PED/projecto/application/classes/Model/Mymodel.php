<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Mymodel extends Model {

	protected $_intervalo;
	protected $_min;
	protected $_cached;
    protected $_table;
	protected $_debug;
    protected $_alwaysRollback;
    protected $_list;
    protected $_success;
    private $_cacheQuery;
	
	public function __construct($table){
		$this->_intervalo = Kohana::$config->load('defs.linhas_pagina');
		$this->_cached = false;
		$this->_min = -1;
        $this->_table = $table;
        $this->_debug = false;
        $this->_cacheQuery = '';
        $this->_list = array();
        $this->_alwaysRollback = false;
        $this->_success = false;
	}
	
    public function LastSuccessful(){return $this->_success;}
    
    protected function setCacheQuery($q) {$this->_cacheQuery = clone $q;}
    protected function getCacheQuery(){return clone $this->_cacheQuery;}
    public function cacheAll(){
		/*$aux = $this->_intervalo;
		$this->_intervalo = -1;*/
		$this->cache(0,0);
		//$this->_intervalo = $aux;
	}
    
    public function cache($min = 0, $num = -1){
        $min = (int) $min;
		if ($min < 0 ) $min = 0;
		$this->_min = $min;
        $query = clone $this->_cacheQuery;
        if ($num < 0) $num = $this->_intervalo;
        if ($num > 0) $query->limit($num)->offset($min);
        if ($this->_debug) echo $query;
        $res = $query->execute();
        $this->_list = $this->transformResult($res);
		$this->_cached = true;
    }
    
    protected function transformResult($res){
        $lista = array();
        foreach($res as $linha){
			$aux = $this->format($linha);
            if ($aux["key"] === null) $lista[] = $aux["value"]; else $lista[$aux["key"]] = $aux["value"];
        }
        return $lista;
    }
    
    public function getAtPos($i){
		if ($i > count($this->_list)) return array();
		return $this->_list[$i];
	}
    
    protected function getBy($campo, $val){
        return DB::select()->from($this->_table)->where($campo, '=', $val)->execute()->next()->as_array();
    }
    
    protected function findBy($campo, $val){
        foreach($this->_list as $chave => $valor)
			if ($valor[$campo] == $val) return $valor;
		
        $linha = $this->getBy($campo, $val);
		$linha = $this->format($linha[0]);
        return $linha["value"];
    }
    
    //public function cache($min = 0){}
    
    protected function format($l) {return array("key"=> null, "value"=>l);}
    
    public function getList() { return $this->_list;}
    
	public function getIntervalo(){return $this->_intervalo;}
	
	public function getMin(){ return $this->_min;}
    
    public function getTotal() {
        $query = clone $this->getCacheQuery();
        $query = $query->select(array(DB::expr('count(*)'), 'conta'));
        $linha = $query->execute()->as_array();
        return $linha[0]['conta'];
    }
	
    public function translateDate($data, $onlyday = false){
        if ($data instanceof DateTime){
            $aux = $data;
        } else{
            $aux = new DateTime();
            if (is_numeric($data)) $aux->setTimestamp($data); else $aux = new DateTime($data);
        }
            
        if ($onlyday) return $aux->format('Y-m-d'); else return $aux->format('Y-m-d H:i:s');
    }
    
    protected function parseNull($v){if ($v == null) return ""; else return $v;}
    
    protected function noConstraints($querys){
        $aux = array();
        $aux["__noConst"] = DB::query(Database::DELETE, 'SET FOREIGN_KEY_CHECKS=0;');
        foreach($querys as $chave => $valor)
            $aux[$chave] = $valor;
        $aux["__yesConst"] = DB::query(Database::DELETE, 'SET FOREIGN_KEY_CHECKS=1;');
        return $aux;
    }
    
	public function executeInTransaction($querys){
        $last_id = -1;
        $db = Database::instance();
        $db->begin();
        try{
            foreach($querys as $chave => $query){
                if (substr($chave,0,3) == "ref") $query->param("':id'", $last_id);
                if ($this->_debug) echo $query."<br/>\n";
                $v = $query->execute();
                if (substr($chave,0,2) == "id") $last_id = $v[0];
            }
            if ($this->_alwaysRollback) $db->rollback(); else $db->commit();
            //$db->commit();
            if ($this->_cached) $this->cache($this->_min);
            $this->_success = true;
            return $last_id;
        }
        catch(Database_Exception $e){
            $this->_success = false;
            $db->rollback();
            die ("DB Error: ".$e->getMessage());
        }
    }
} 

?>