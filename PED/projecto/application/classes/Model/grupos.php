<?php defined('SYSPATH') or die('No direct script access.'); //Não quero que fiques em ASCII
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Grupos extends Model_Mymodel {

	const NADA 		= "----";
	const VER 		= "S---";
	const INSERIR 		= "SI--";
	const ACTUALIZAR 	= "S-U-";
	const REMOVER 		= "SIUD";


	public function __construct(){
        parent::__construct("groups");
        $query = DB::select()->from($this->_table)->order_by('nome', 'ASC');
        $this->setCacheQuery($query);
	}
	
	protected function format($linha){
		return array("key" => (int)$linha["id"],  "value" => array("id" => (int)$linha["id"], "nome" => $linha["nome"]));
	}
	
	public function	getAllGrupos(){ return $this->getList(); }
	
	public function apagarGrupo($id){
		$id = (int) $id;
		if (self::isAdminGroup($id) || self::isVisitanteGroup($id)) return;
        DB::delete($this->_table)->where('id', '=', $id)->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function editarGrupo($id, $nome, $perms){
		$id = (int) $id;
		if (self::isAdminGroup($id)) return;
		
        $querys = array();
        $querys[] = DB::update($this->_table)->set(array('nome' => $nome))->where('id', '=', $id);
        $querys[] = DB::delete('perms')->where('id_grupo', '=', $id);
        foreach($perms as $chave => $valor)
                $querys[] = DB::insert('perms')->values(array($chave, $id, (string)$perms[$chave]));
        $this->executeInTransaction($querys);
	}
	
	
	public function getGrupoWithId($id){
        return $this->findBy('id', $id);
	}
	
	public function insereGrupo($nome, $perms){
        $querys = array();
        $querys["id"] = DB::insert($this->_table)->values(array(null, $nome));
		foreach($perms as $chave => $valor)
            $querys["ref".$chave] = DB::insert('perms')->values(array($chave, ":id", (string)$perms[$chave]));
		$id = $this->executeInTransaction($querys);
        return $id;
	}
	
	public function getGrupoAtPos($i){ return $this->getAtPos($i);}
	
	public function getAllPerms($id){
		$id = (int) $id;
		
		$nomes = $this->getAllTPerms();
		
		$res = DB::select()->from('perms')->where('id_grupo', '=', $id)->execute();
        foreach($res as $linha){
			$perms[$linha['id_perm']] = $linha['perm'];
		}
		
		$aux = array();
		foreach($nomes as $chave => $valor){
			if (!isset($perms[$chave])) $perms[$chave] = self::NADA;
			if (self::isAdminGroup($id)) $perms[$chave] = self::REMOVER;
			$aux[$chave]= array('id' => $chave, 'nome' => $valor, 'S' => (bool)(substr($perms[$chave], 0, 1) == 'S'), 'I' => (bool)(substr($perms[$chave], 1, 1) == 'I'), 'U' => (bool)(substr($perms[$chave], 2, 1) == 'U'), 'D' => (bool)(substr($perms[$chave], 3, 1) == 'D'));
		}
		
		return $aux;
	}
	
	public static function isAdminGroup($id){return ($id == Kohana::$config->load('defs.admin'));}
	public static function isVisitanteGroup($id){return ($id == Kohana::$config->load('defs.guest'));}
	
	private function addTipo($nome, $texto, $vperms = self::NADA){
		$id_perm = Kohana::$config->load('perms.'.$nome);
		$admin_grupo = Kohana::$config->load('defs.admin');
		$v_grupo = Kohana::$config->load('defs.guest');
		$querys = array();
        $querys[] = DB::insert('perms_tipo')->values(array($id_perm, $texto));
        $querys[] = DB::insert('perms')->values(array($id_perm, $admin_grupo, self::REMOVER));
        $querys[] = DB::insert('perms')->values(array($id_perm, $v_grupo, $vperms));
        return $querys;
	}
	
	public function getAllTPerms(){
		$res = DB::select()->from('perms_tipo')->order_by('nome', 'ASC')->execute();
        $nomes = array();
        foreach($res as $linha){
			$nomes[$linha['id_perm']] = $linha['nome'];
		}
		return $nomes;
	}
	private function copyArray($arr1, $arr2){
        foreach($arr2 as $valor)
            $arr1[] = $valor;
        return $arr1;
    }
	public function rePerms(){
        
		$querys = array();
		$prefix = Database::instance()->table_prefix();
        $querys[] = DB::query(Database::DELETE, 'TRUNCATE TABLE '.$prefix."perms_tipo");
        $querys[] = DB::query(Database::DELETE, 'TRUNCATE TABLE '.$prefix."perms");
        
        $aux = $this->addTipo('users', 'Users');
        $querys = $this->copyArray($querys, $aux);
		$aux = $this->addTipo('groups', 'Groups');
        $querys = $this->copyArray($querys, $aux);
        $aux = $this->addTipo('logs', 'Logs');
        $querys = $this->copyArray($querys, $aux);
        
        $this->executeInTransaction($querys);
	}
} 
?>