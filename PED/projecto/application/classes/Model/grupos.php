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

	private $grps;
	
	public function __construct(){
        parent::__construct("groups");
        $this->grps = array();
	}
	
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
        $query = DB::select()->from($this->_table)->order_by('nome', 'ASC');
        if ($this->_intervalo > 0) $query->limit($min+$this->_intervalo)->offset($min);
        $res = $query->execute();
		$this->grps = array();
        foreach($res as $linha)
			$this->grps[$linha["id"]] = $this->formatGrp($linha["id"], $linha["nome"]);
		$this->_cached = true;
	}
	
	private function formatGrp($id, $nome){
		return array("id" => (int)$id, "nome" => $nome);
	}
	
	public function	getAllGrupos(){ return $this->grps; }
	
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
        foreach($perms as $chave => $valor){
                $str = ($perms[$chave]->getPerm('S') ? "S" : "-").($perms[$chave]->getPerm('I') ? "I" : "-").($perms[$chave]->getPerm('U') ? "U" : "-").($perms[$chave]->getPerm('R') ? "R" : "-");
                $querys[] = DB::insert('perms')->values(array($chave, $id, $str));
        }
        $this->executeInTransaction($querys);
	}
	
	
	public function getGrupoWithId($id){
		foreach($this->grps as $chave => $valor)
			if ($valor['id'] == $id) return $valor;
		$linha = DB::select()->from($this->_table)->where('id', '=', $id)->execute()->next()->as_array();
        $linha = $linha[0];
        return $this->formatGrp($linha["id"], $linha["nome"]);
	}
	
	public function insereGrupo($nome, $perms){
        $querys = array();
        $querys["id"] = DB::insert($this->_table)->values(array(null, $nome));
		foreach($perms as $chave => $valor){
			$str = ($perms[$chave]->getPerm('S') ? "S" : "-").($perms[$chave]->getPerm('I') ? "I" : "-").($perms[$chave]->getPerm('U') ? "U" : "-").($perms[$chave]->getPerm('R') ? "R" : "-");
            $querys["ref".$chave] = DB::insert('perms')->values(array($chave, ":id", $str));
		}
        $id = $this->executeInTransaction($querys);
        return $id;
	}
	
	public function getGrupoAtPos($i){
		if ($i > count($this->grps)) return array();
		return $this->grps[$i];
	}
	
	public function getAllPerms($id){
		$id = (int) $id;
		
		$nomes = $this->getAllTPerms();
		
		$res = DB::select()->from('perms')->where('id_grupo', '=', $id)->execute();
        foreach($res as $linha){
			$perms[$linha['id_perm']] = $linha['perm'];
		}
		
		$aux = array();
		foreach($nomes as $chave => $valor){
			if (!isset($perms[$chave])) $perms[$chave] = "----";
			if (self::isAdminGroup($id)) $perms[$chave] = "SIUR";
			$aux[$chave]= array('id' => $chave, 'nome' => $valor, 'S' => (bool)(substr($perms[$chave], 0, 1) == 'S'), 'I' => (bool)(substr($perms[$chave], 1, 1) == 'I'), 'U' => (bool)(substr($perms[$chave], 2, 1) == 'U'), 'R' => (bool)(substr($perms[$chave], 3, 1) == 'R'));
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
        $querys[] = DB::query(Database::DELETE, 'TRUNCATE TABLE '.$prefix."perms");
        $querys[] = DB::query(Database::DELETE, 'TRUNCATE TABLE '.$prefix."perms_tipo");
        
        $aux = $this->addTipo('users', 'Utilizadores');
        $querys = $this->copyArray($querys, $aux);
		$aux = $this->addTipo('groups', 'Grupos');
        $querys = $this->copyArray($querys, $aux);
        
        $this->executeInTransaction($querys);
	}
} 
?>