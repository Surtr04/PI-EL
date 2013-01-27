<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Users extends Model_Mymodel {

    
	public function __construct(){
        parent::__construct('users');
        $query = DB::select($this->_table.'.*', array('groups.nome', 'ngrupo'))->from($this->_table)
                ->join("groups")->on('grupo', '=', 'groups.id')
                ->order_by('username', 'ASC');//->limit($max)->offset($min);
        $this->setCacheQuery($query);
	}
	
	
	protected function format($linha){
		return array("key" => null, "value" => array("id" => (int)$linha["id"], "username" => $linha["username"], "senha" => $linha["senha"], "nome" => $linha["nome"], "email" => $linha["email"], "morada" => $linha["morada"], "foto" => $linha["foto"], "grupo" => $linha["grupo"], "is_online" => $linha["is_online"], "ngrupo"=>$linha["ngrupo"]));
	}
	

	public function	getAllUsers(){ return $this->getList();}
	
	public function apagarUser($id){
		$id = (int) $id;
        DB::delete($this->_table)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function editarUser($id, $username, $senha, $nome, $email, $morada, $foto, $grupo = -1){
		$id = (int) $id;
		$grupo = (int) $grupo;
		
        $updates = array('username' => $username, 'nome' => $nome, 'email' => $email, 'morada' => $morada);
        if ($grupo != -1) $updates['grupo'] = $grupo;
		if ($senha != '') $updates['senha'] = $this->hashSenha($senha);
        if ($foto != '') $updates['foto'] = $foto;
        $query = DB::update($this->_table)->set($updates)->where('id', '=', $id);
        $query->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
    public function resetImg($id){
        DB::update($this->_table)->set(array('foto' => ''))->where('id', '=', $id)->execute();
    }
	public function getUserWithId($id){
        return $this->findBy('id', $id);
	}
    
    public function getUserWithUsername($username){
        return $this->findBy('username', $username);
    }
	
	public function insereUser($username, $senha, $nome, $email, $morada, $foto, $grupo){
		$grupo = (int) $grupo;
		
		DB::insert($this->_table)->values(array(null, $username, $senha, $nome, $email, $morada, $foto, $grupo, 0))->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function getUserAtPos($i){return $this->getAtPos($i);}
	private function hashSenha($senha){ return Auth::instance()->hash($senha);}
} 
?>