<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Mymodel extends Model {

	protected $_intervalo;
	protected $_min;
	protected $_cached;
    protected $_table;
	
	
	public function __construct($table){
		$this->_intervalo = Kohana::$config->load('defs.linhas_pagina');
		$this->_cached = false;
		$this->_min = -1;
        $this->_table = $table;
	}
	
    public function cache($min = 0){}
    
	public function getIntervalo(){return $this->_intervalo;}
	
	public function getMin(){ return $this->_min;}
	
	public function executeInTransaction($querys){
        $last_id = -1;
        $db = Database::instance();
        $db->begin();
        try{
            foreach($querys as $chave => $query){
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