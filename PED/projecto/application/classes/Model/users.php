<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Users extends Model_Mymodel {

    private $users;
    
    
	public function __construct(){
		parent::__construct('users');
        $this->users = array();
	}
	
	public function cache($min = 0){
		$min = (int) $min;
		if ($min < 0 ) $min = 0;
		$this->_min = $min;
		$max = $min + $this->_intervalo;
        $query = DB::select()->from($this->_table)->order_by('username', 'ASC')->limit($max)->offset($min);
		$res = $query->execute();
		$this->users = array();
        foreach($res as $linha){
			$this->users[] = $this->formatUsr($linha["id"], $linha["username"], $linha["senha"], $linha["nome"],$linha["email"], $linha["grupo"], $linha["is_online"]);
        }
		$this->_cached = true;
	}
	
	private function formatUsr($id, $username, $senha, $nome, $email, $grupo, $is_online){
		return array("id" => (int)$id, "username" => $username, "senha" => $senha, "nome" => $nome, "email" => $email, "grupo" => $grupo, "is_online" => $is_online);
	}
	

	public function	getAllUsers(){ return $this->users;}
	
	public function apagarUser($id){
		$id = (int) $id;
        DB::delete($this->_table)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function editarUser($id, $username, $senha, $nome, $email, $grupo = -1){
		$id = (int) $id;
		$grupo = (int) $grupo;
		
		
        $updates = array('username' => $username, 'nome' => $nome, 'email' => $email);
        if ($grupo != -1) $updates['grupo'] = $grupo;
		if ($senha != '') $updates['senha'] = $this->hashSenha($senha);
        DB::update($this->_table)->set($updates)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	
	public function getUserWithId($id){
		foreach($this->users as $chave => $valor)
			if ($valor['id'] == $id) return $valor;
		
        $linha = DB::select()->from($this->_table)->where('id', '=', $id)->execute()->next()->as_array();
		$linha = $linha[0];
        return $this->formatUsr($linha["id"], $linha["username"], $linha["senha"], $linha["nome"],$linha["email"], $linha["grupo"], $linha["is_online"]);
	}
	
	public function insereUser($username, $senha, $nome, $email, $grupo){
		$grupo = (int) $grupo;
		
		DB::insert($this->_table)->values(array(null, $username, $senha, $nome, $email, $grupo, 0))->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function getUserAtPos($i){
		if ($i > count($this->users)) return array();
		return $this->users[$i];
	}
	private function hashSenha($senha){
		return Auth::instance()->hash($senha);
	}
} 
?>