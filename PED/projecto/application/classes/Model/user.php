<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_User extends Model {

	private $_id;
	private $_username;
	private $_name;
	private $_email;
	private $_grupo;
    private $_morada;
    private $_foto;

	public function __construct(){
		$this->_id = -1;
		$this->_grupo = -1;
	}
	
	public static function factory($name=""){return new Model_User();}
	
	public function tryLogin($username, $password){
		$query = DB::select()->from('users')->where('username', '=', $username)->and_where('senha' ,  '=', $password)->limit(1);
		$res = $query->execute();
		foreach($res as $u){
			$this->_id = $u['id'];
			$this->_username = $u['username'];
			$this->_name = $u['nome'];
			$this->_email = $u['email'];
			$this->_grupo = $u['grupo'];
            $this->_morada = $u['morada'];
            $this->_foto = $u['foto'];
            $this->setOnline(true);
		}
		return $this;
	}
	
    private function setOnline($b){
        DB::update('users')->set(array('is_online' => ($b ? 1 : 0)))->where('id', '=', $this->_id)->execute();
    }
    
	public function logout(){
      $this->setOnline(false);
      $this->_id = -1;
      $this->_grupo = Kohana::$config->load('defs.guest');
      $this->_username = "";
      $this->_name = "";
      $this->_email = "";
      $this->_morada = "";
      $this->_foto = "";
    }
	public function isGuest(){return ($this->_id <= 0 || $this->_grupo == Kohana::$config->load('defs.guest'));}
	public function isAdmin(){return $this->_grupo == Kohana::$config->load('defs.admin');}
	
	
	public function getId(){return $this->_id;}
	public function getUsername(){ return $this->_username;}
	public function getName(){ return $this->_name;}
	public function getEmail(){ return $this->_email;}
	
	
	public function canDo($tarefa, $tipo = ""){
		$pos = array("S"=> 0, "I" => 1, "U" => 2, "D" => 3);
		if ($this->isAdmin()) 
			$linha['perm'] = "SIUD";
		else {
			$query = DB::select("perm")->from('perms')->where('id_grupo', '=', $this->_grupo)->and_where('id_perm','=',$tarefa);
			$linha = $query->execute()->next()->as_array();
            $linha = $linha[0];
		}
		if (!$linha) 
			return false;
		else{
			if($tipo == "") {
				$res = array();
				foreach($pos as $chave => $valor)
					$res[$chave] = (substr($linha['perm'], $valor,1) == $chave);
				return $res;
			}
			else
				return (substr($linha['perm'], $pos[$tipo],1) == $tipo);
		}
	}
	
}

?>