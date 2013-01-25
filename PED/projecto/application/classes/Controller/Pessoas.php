<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Pessoas extends Controller_Mymain {
    
    private $_str = "";

	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', $this->request->param('tt'));
        $this->nperm = $this->request->param('perms');
        $this->_str = $this->request->param('table');
        $this->view->set('route', $this->_str);
        $this->updateHome($this->request->param('perms'));
	}
	
	
	public function action_index(){
		$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$pessoas = new Model_Pessoas($this->_str);
		$pessoas->cache($min);
		$this->initTable($pessoas);
	}
	
	public function action_apagar(){
		$this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id <= -1) return $this->action_index();
		$pessoas = new Model_Pessoas($this->_str);
		$pessoas->apagar($id);
		$pessoas->action_index();
	}
	
	public function action_editar($id = -1){
		$this->restrictAcess('U');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		$pessoas = new Model_Pessoas($this->_str);
		$info = $pessoas->getById($id);
		$this->view->set('toinclude', 'pessoasform');
		$this->view->set('form_id', $id);
        $this->view->set('identificador', $info['identificador']);
		$this->view->set('nome', $info['nome']);
        $this->view->set('email', $info['email']);
        $this->view->set('web', $info['web']);

		echo $this->view->render();
	}
	
	public function action_update(){
		$this->restrictAcess('U');
		if (trim($_POST['nome']) == "" || trim($_POST['identificador']) == "") return $this->action_editar($_POST['form_id']);
	
		$pessoas = new Model_Pessoas($this->_str);
		$pessoas->edita($_POST['form_id'], $_POST['identificador'], $_POST['nome'], $_POST['email'], $_POST['web']);
		$this->redirect($this->_str);
	}
	
	public function action_insere(){
		$this->restrictAcess('I');
		$this->view->set('toinclude', 'pessoasform');
		$this->view->set('form_id', NULL);
        $this->view->set('identificador', '');
		$this->view->set('nome', '');
        $this->view->set('email', '');
        $this->view->set('web', '');
		echo $this->view->render();
	}
	
	public function action_insere2(){
		$this->restrictAcess('I');
		if (trim($_POST['nome']) == "" || trim($_POST['identificador']) == "") return $this->action_insere();
		$pessoas = new Model_Pessoas($this->_str);
		$id = $pessoas->insere($_POST['identificador'], $_POST['nome'], $_POST['email'], $_POST['web']);
		$this->redirect($this->_str);
	}
	
	private function initTable($lista){
        $this->_initTable($lista, 'pessoas');
	}
} 
?>
