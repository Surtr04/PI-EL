<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Categories extends Controller_Mymain {


	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', "Categories");
        $this->nperm = 'categories';
	}
	
	
	public function action_index(){
		$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$cats = new Model_Categorias();
		$cats->cache($min);
		$this->initTable($cats);
	}
	
	public function action_apagar(){
		$this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id <= -1) return $this->action_index();
		$cats = new Model_Categorias();
		$cats->apagarCategoria($id);
		$this->action_index();
	}
	
	public function action_editar($id = -1){
		$this->restrictAcess('U');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		$cats = new Model_Categorias();
		$info = $cats->getCategoriaWithId($id);
		$this->view->set('toinclude', 'categoriasform');
		$this->view->set('form_id', $id);
		$this->view->set('nome', $info['nome']);
        $this->view->set('inicio', $info['inicio']);
        $this->view->set('fim', $info['fim']);

		echo $this->view->render();
	}
	
	public function action_update(){
		$this->restrictAcess('U');
		if (trim($_POST['nome']) == "" || trim($_POST['inicio']) == "" || trim($_POST['fim']) == "") return $this->action_editar($_POST['form_id']);
	
		$cats = new Model_Categorias();
		$cats->editarCategoria($_POST['form_id'], $_POST['nome'], $_POST['inicio'], $_POST['fim']);
		$this->goIndex();
	}
	
	public function action_insere(){
		$this->restrictAcess('I');

		$this->view->set('toinclude', 'categoriasform');
		$this->view->set('form_id', NULL);
		$this->view->set('nome', '');
        $this->view->set('inicio', '');
        $this->view->set('fim', '');
		echo $this->view->render();
	}
	
	public function action_insere2(){
		$this->restrictAcess('I');
		if (trim($_POST['nome']) == "" || trim($_POST['inicio']) == "" || trim($_POST['fim']) == "") return $this->action_insere();
		$cats = new Model_Categorias();
		$id = $cats->insereCategoria($_POST['nome'],$_POST['inicio'], $_POST['fim']);
		$this->goIndex();
	}
	
	private function initTable($lista){
        $this->_initTable($lista, 'categorias');
		/*$perms = $this->user->canDo(Kohana::$config->load('perms.'.$this->nperm));
		$this->view->set('lista', $lista->getList());
		$this->view->set('toinclude', 'categorias'); 
        $this->view->set('perms', $perms);
		$this->view->set('min', $lista->getMin());
		$this->view->set('int', $lista->getIntervalo());
		echo $this->view->render();*/
	}
} 
?>