<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Pessoas extends Model_Mymodel {

    protected $campo = '';
    
	public function __construct($tabela){
        parent::__construct($tabela);
        $query = DB::select()->from($this->_table)->order_by('nome', 'ASC');
        $this->setCacheQuery($query);
	}
	
    
	protected function format($linha){
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"],"identificador" => $linha["identificador"], "nome" => $linha["nome"], "email" => $linha["email"], "web" => $linha["web"]));
	}
	
	public function	getAll(){ return $this->getList(); }
	
	public function apaga($id){
		$id = (int) $id;
        DB::delete($this->_table)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function edita($id, $identificador, $nome, $email, $web){
		$id = (int) $id;
        
        DB::update($this->_table)->set(array('nome' => $nome, 'identificador' => $identificador, 'nome' => $nome, "email" => $email, "web" => $web))->where('id', '=', $id)->execute();
	}
	
	public function getFromSip($sip){
        $query = DB::select()->from("sips_".$this->_table)
                ->join($this->_table)->on('id_'.$this->campo, '=', 'id')
                ->where('id_sip', '=', $sip);
        
        return $this->transformResult($query->execute());
    }
    
	public function getById($id){
        return $this->findBy('id', $id);
	}
    
    public function getByIdentificador($ident){
        return $this->findBy('identificador', $ident);
    }
    
	public function insere($identificador, $nome, $email, $web){
        $query = DB::insert($this->_table)->values(array(null, $identificador, $nome, $this->parseNull($email), $this->parseNull($web)));

        $id = $query->execute();
        return $id[0];
	}
	
    
 
	
	
} 
?>