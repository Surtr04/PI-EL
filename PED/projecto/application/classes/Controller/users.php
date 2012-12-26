<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

class Controller_Users extends Controller_Mymain {


	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
		$this->view->set('youngtitle', "Users");
        $this->nperm = 'users';
	}
	public function action_index(){
		$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$users = new Model_Users();
		$users->cache($min);
		$this->initTable($users);
	}
	
	
	public function action_apagar(){
		$this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id == -1 || ($id == $this->user->getId())) return $this->action_index();
		$users = new Model_Users();
		$users->apagarUser($id);
		$this->action_index();
	}
	
	public function action_editar(){
		$id = (int) Arr::get($_GET,'id',-1);
		
        
        $this->canEdit($id);

        $users = new Model_Users();
		$info = $users->getUserWithId($id);
		$users->cache(0);
		$this->view->set('grupochange', $change);
        if (($aux = $this->uploadfFoto($id)) !== '') $info['foto'] = $aux;
		$this->callForm($id, $info['username'], $info['senha'], $info['nome'], $info['email'], $info['morada'], $info['foto'], $info['grupo']);
	}
    
    private function uploadfFoto($id){
        if (isset($_FILES['ffoto']) && $_FILES['ffoto']['error'] == UPLOAD_ERR_OK){
            $fiche = $_FILES['ffoto'];
            $fotolink = $id . substr($fiche['name'], strrpos($fiche['name'], '.')+1);
            move_uploaded_file($fiche['tmp_name'], $this->picturesPath . $fotolink);
            return $fotolink;
        } else
            return '';
        
    }
    
	private function canEdit($id){
        if ($id == -1) return $this->goHome();
        $change = $this->user->canDo(Kohana::$config->load('perms.'.$this->nperm), 'U');
		if(!$this->user || (!$change && !$this->user->getId() == $id))
			return $this->goHome();
    }
	public function action_update(){
		$id = (int) Arr::get($_POST,'form_id',-1);

        $this->canEdit($id);
		if (trim($_POST['username']) == "" || trim($_POST['nome']) == "" || trim($_POST['email']) == "" || trim($_POST['grupo']) == "") return $this->action_insere();
		$users = new Model_Users();
		$info = $users->getUserWithId($id);
		$users->editarUser($id, $_POST['username'], $_POST['senha'], $_POST['nome'], $_POST['email'], $_POST['morada'], $_POST['foto'], ($change ? $_POST['grupo'] : -1));
		$this->action_index();
	}
	
	private function callForm($id = NULL, $username = "", $senha = "", $nome = "", $email = "", $morada="", $foto="", $grupo = ""){
		$grps = new Model_Grupos();
		$grps->cacheAll();
		$this->addScript(NULL, 'function checkForm(){
			if (document.getElementById("senha").value != document.getElementById("rsenha").value) {
				alert("As senhas colocadas não coicidem!"); 
				return false;
			}
			return true;
		}');
		$this->view->set('toinclude', 'utilizadoresform');
		$this->view->set('form_id', $id);
		$this->view->set('username', $username);
		$this->view->set('senha', $senha);
		$this->view->set('nome', $nome);
		$this->view->set('email', $email);
        $this->view->set('morada', $morada);
		$this->view->set('foto', $foto);
		$this->view->set('grupo', $grupo);
		$this->view->set('grupos', $grps->getAllGrupos());
		echo $this->view->render();
	}
	public function action_insere(){
		$this->restrictAcess('I');
		$this->callForm();
	}
	
	public function action_insere2(){
		$this->restrictAcess('I');
		if (trim($_POST['username']) == "" || trim($_POST['senha']) == "" || trim($_POST['nome']) == "" || trim($_POST['email']) == "" || trim($_POST['grupo']) == "") return $this->action_insere();
		$users = new Model_Users();
		$users->insereUser($_POST['username'], $_POST['senha'], $_POST['nome'], $_POST['email'], $_POST['morada'], $_POST['foto'], $_POST['grupo']);
		$users->cache(0);
		$this->initTable($users);
	}
	
	private function initTable($users){
		$grps = new Model_Grupos();
		$grps->cacheAll();
		$perms = $this->user->canDo(Kohana::$config->load('perms.users'));
		$this->view->set('users', $users->getAllUsers());
		$this->view->set('toinclude', 'utilizadores'); 
		$this->view->set('grupos', $grps->getAllGrupos());
		$this->view->set('perms', $perms);
		$this->view->set('min', $users->getMin());
		$this->view->set('int', $users->getIntervalo());
		echo $this->view->render();
	}
} 
?>