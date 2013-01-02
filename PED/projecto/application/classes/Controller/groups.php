<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Groups extends Controller_Mymain {


	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', "Groups");
        $this->nperm = 'groups';
	}
	
	
	public function action_index(){
		$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$grupos = new Model_Grupos();
		$grupos->cache($min);
		$this->initTable($grupos);
	}
	public function action_rePerms(){
		if (!$this->user || !$this->user->isAdmin())
			return $this->goHome();
		$grps = new Model_Grupos();
		$grps->rePerms();
		$this->goIndex();
	}
	public function action_ver($id =-1){
		$this->restrictAcess('S');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		$grps = new Model_Grupos();
		$info = $grps->getGrupoWithId($id);
		$this->view->set('toinclude', 'gperms');
		$this->view->set('id', $id);
		$this->view->set('nome', $info['nome']);
		$this->view->set('gperms', $grps->getAllPerms($id));
		echo $this->view->render();
	}
	public function action_apagar(){
		$this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id <= -1) return $this->action_index();
		$grupos = new Model_Grupos();
		$grupos->apagarGrupo($id);
		$this->action_index();
	}
	
	public function action_editar($id = -1){
		$this->restrictAcess('U');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		$grps = new Model_Grupos();
		$info = $grps->getGrupoWithId($id);
		$this->view->set('toinclude', 'gruposform');
		$this->view->set('form_id', $id);
		$this->view->set('nome', $info['nome']);
		$this->view->set('gperms', $grps->getAllPerms($id));
		$this->view->set('is_admin', Model_Grupos::isAdminGroup($id));
		$this->view->set('is_v', Model_Grupos::isVisitanteGroup($id));
		echo $this->view->render();
	}
	private function tratarPerms(){
		$grps = new Model_Grupos();
		$mds = $grps->getAllTPerms();
		foreach($mds as $chave => $valor)
			$perms[$chave] = new Controller_Perms(isset($_POST['perms_s_'.$chave]), isset($_POST['perms_i_'.$chave]), isset($_POST['perms_u_'.$chave]), isset($_POST['perms_d_'.$chave]));
		return $perms;
	}
	public function action_update(){
		$this->restrictAcess('U');
		if (trim($_POST['nome']) == "") return $this->action_insere();
		$perms = $this->tratarPerms();
		
		$grupos = new Model_Grupos();
		$grupos->editarGrupo($_POST['form_id'], $_POST['nome'], $perms);
		$this->action_ver((int)$_POST['form_id']);
	}
	
	
	public function action_insere(){
		$this->restrictAcess('I');
		$grps = new Model_Grupos();
		$this->view->set('toinclude', 'gruposform');
		$this->view->set('form_id', NULL);
		$this->view->set('nome', '');
		$this->view->set('gperms', $grps->getAllPerms(-1));
		$this->view->set('is_admin', false);
		echo $this->view->render();
	}
	
	public function action_insere2(){
		$this->restrictAcess('I');
		if (trim($_POST['nome']) == "" ) return $this->action_insere();
		$grupos = new Model_Grupos();
		$perms = $this->tratarPerms();
		$id = $grupos->insereGrupo($_POST['nome'],$perms);
		$this->action_ver((int)$id);
	}
	
	private function initTable($grupos){
		$this->_initTable($grupos, 'grupos');
        /*$perms = $this->user->canDo(Kohana::$config->load('perms.grupos'));
		$this->view->set('lista', $grupos->getAllGrupos());
		$this->view->set('toinclude', 'grupos'); 
		$this->view->set('perms', $perms);
		$this->view->set('min', $grupos->getMin());
		$this->view->set('int', $grupos->getIntervalo());
		echo $this->view->render();*/
	}
} 
?>