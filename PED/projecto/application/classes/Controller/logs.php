<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

class Controller_Logs extends Controller_Mymain {


	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
		$this->view->set('youngtitle', "Logs");
        $this->nperm = 'logs';
	}
	public function action_index(){
		$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$log = new Model_Logs();
		$log->cache($min);
		$this->initTable($log);
	}
	
	
	public function action_apagar(){
		$this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id == -1) return $this->action_index();
		$log = new Model_Logs();
		$log->apagarLog($id, Model_Logs::NOAUTO);
		$this->action_index();
	}
	
	public function action_editar(){
		$id = (int) Arr::get($_GET,'id',-1);
		$this->restrictAcess('U');
		
		if ($id == -1) return $this->action_index();
		$log = new Model_Logs();
		$info = $log->getLogWithId($id);
        if ($info["auto"] == Model_Logs::AUTO) return $this->action_index();
		$log->cache(0);
		$this->callForm($id, $info['username'], $info['data'], $info['operacao'], $info['descricao']);
	}
	
	public function action_update(){
		$id = (int) Arr::get($_POST,'form_id',-1);
		$this->restrictAcess('U');
		
		if (trim($_POST['data']) == "" || trim($_POST['operacao']) == "" || trim($_POST['descricao']) == "") {$_GET['id'] = $id; return $this->action_editar();}
		$log = new Model_Logs();

		$log->editarLog($id, $_POST['data'], $_POST['operacao'], $_POST['descricao'], Model_Logs::NOAUTO);
		$this->action_index();
	}
	
	private function callForm($id = NULL, $username='', $data='', $operacao='', $descricao=''){
		$this->view->set('toinclude', 'logsform');
		$this->view->set('form_id', $id);
		$this->view->set('username', $username);
		$this->view->set('data', $data);
		$this->view->set('operacao', $operacao);
		$this->view->set('descricao', $descricao);
		echo $this->view->render();
	}
	public function action_insere(){
		$this->restrictAcess('I');
		$this->callForm();
	}
	
	public function action_insere2(){
		$this->restrictAcess('I');
		if (trim($_POST['utilizador']) == "" || trim($_POST['data']) == "" || trim($_POST['operacao']) == "" || trim($_POST['descricao']) == "") return $this->action_insere();
		$log = new Model_Logs();
		$log->insereLog($_POST['utilizador'], $_POST['data'], $_POST['operacao'], $_POST['descricao'], Model_Logs::NOAUTO);
		$log->cache(0);
		$this->initTable($log);
	}
	
	private function initTable($log){
		$perms = $this->user->canDo(Kohana::$config->load('perms.'.$this->nperm));
		$this->view->set('logs', $log->getAllLogs());
		$this->view->set('toinclude', 'logs'); 
		$this->view->set('perms', $perms);
		$this->view->set('min', $log->getMin());
		$this->view->set('int', $log->getIntervalo());
		echo $this->view->render();
	}
} 
?>