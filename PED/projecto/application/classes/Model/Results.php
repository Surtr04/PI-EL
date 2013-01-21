<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Results extends Model_Mymodel {

	public function __construct(){
        parent::__construct("resultados");
        $query = DB::select()->from($this->_table)->order_by('realname', 'ASC');
        $this->setCacheQuery($query);
	}
	
	protected function format($linha){
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"],"id_sip" => $linha["id_sip"], "realname" => $linha["realname"], "url" => $linha["url"], "desc" => $linha["desc"]));
	}
	
	public function	getAll(){ return $this->getList(); }
	
    public function getFromSip($sip){
        $query = DB::select()->from($this->_table)
                ->where('id_sip', '=', $sip);
        
        return $this->transformResult($query->execute());
    }
    
	public function getById($id){
        return $this->findBy('id', $id);
	}
    
    public function getBySip($sip){
        return $this->getBy('id_sip', $sip);
    }
    
 
	
	
} 
?>