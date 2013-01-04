<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Resumos extends Model_Mymodel {

	public function __construct(){
        parent::__construct("resumos");
        $query = DB::select()->from($this->_table)->order_by('id_sip', 'ASC')->order_by('ordem', 'ASC');
        $this->setCacheQuery($query);
	}
	
	protected function format($linha){
		return array("key" => null,  "value" => array("id_sip" => (int)$linha["id_sip"],"ordem" => (int)$linha["ordem"], "para" => $linha["para"]));
	}
	
	public function	getAll(){ return $this->getList(); }
	
    public function getFromSip($sip){
        $query = DB::select()->from($this->_table)
                ->where('id_sip', '=', $sip)
                ->order_by('ordem', 'ASC');
        
        return $this->transformResult($query->execute());
    }
    
	public function getById($id){
        return $this->findBy('id', $id);
	}
   
    
   

	
    
 
	
	
} 
?>