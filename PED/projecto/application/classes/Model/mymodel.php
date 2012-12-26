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
    protected $_list;
    private $_cacheQuery;
	
	public function __construct($table){
		$this->_intervalo = Kohana::$config->load('defs.linhas_pagina');
		$this->_cached = false;
		$this->_min = -1;
        $this->_table = $table;
        $this->_debug = false;
        $this->_cacheQuery = '';
        $this->_list = array();
	}
	
    protected function setCacheQuery($q) {$this->_cacheQuery = $q;}
    public function cacheAll(){
		$aux = $this->_intervalo;
		$this->_intervalo = -1;
		$this->cache(0);
		$this->_intervalo = $aux;
	}
    
    public function cache($min = 0){
        $min = (int) $min;
		if ($min < 0 ) $min = 0;
		$this->_min = $min;
        if ($this->_intervalo > 0) $this->_cacheQuery->limit($min+$this->_intervalo)->offset($min);
        if ($this->_debug) echo $this->_cacheQuery;
        $res = $this->_cacheQuery->execute();
		$this->_list = array();
        foreach($res as $linha){
			$aux = $this->format($linha);
            if ($aux["key"] === null) $this->_list[] = $aux["value"]; else $this->_list[$aux["key"]] = $aux["value"];
        }
		$this->_cached = true;
    }
    
    public function getAtPos($i){
		if ($i > count($this->_list)) return array();
		return $this->_list[$i];
	}
    
    protected function findBy($campo, $val){
        foreach($this->_list as $chave => $valor)
			if ($valor[$campo] == $val) return $valor;
		
        $linha = DB::select()->from($this->_table)->where($campo, '=', $val)->execute()->next()->as_array();
		$linha = $this->format($linha[0]);
        return $linha["value"];
    }
    
    //public function cache($min = 0){}
    
    protected function format($l) {return array("key"=> null, "value"=>l);}
    
    public function getList() { return $this->_list;}
    
	public function getIntervalo(){return $this->_intervalo;}
	
	public function getMin(){ return $this->_min;}
	
	public function executeInTransaction($querys){
        $last_id = -1;
        $db = Database::instance();
        $db->begin();
        try{
            foreach($querys as $chave => $query){
                if ($this->_debug) echo $query."<br/>\n";
                if (substr($chave,0,3) == "ref") $query->param("':id'", $last_id);
                $v = $query->execute();
                if (substr($chave,0,2) == "id") $last_id = $v[0];
            }
            $db->commit();
            if ($this->_cached) $this->cache($this->_min);
            return $last_id;
        }
        catch(Database_Exception $e){
            $db->rollback();
            die ("DB Error: ".$e->getMessage());
        }
    }
} 
?>