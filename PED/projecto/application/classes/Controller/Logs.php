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
	
	public function action_export(){
        $this->restrictAcess('S');
        $log = new Model_Logs();
        
        $min = (int) (Arr::get($_GET,'s',0));
        $num = (int) (Arr::get($_GET,'n',-1));
        
        $b = Arr::get($_REQUEST,'before',null);
        if ($b !== null) $log->setBefore($b);
        $a = Arr::get($_REQUEST,'after',null);
        if ($a !== null) $log->setAfter($a); 
        
        if ($a !== null && $b !== null) $num = 0;

        $log->cache($min, $num);
        $file = $this->writeLog($log->getList());
        $this->response->send_File($file, 'logs.xml' ,array('delete' => true));
    }
    
    public function writeLog($lista){
        $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><logs></logs>');
        $campos = array('username' => 'utilizador', 'data' => 'data', 'operacao' => 'operacao', 'descricao' => 'descricao', 'auto' => 'auto');
        foreach($lista as $valor){
            $log = $xml->addChild("log");
            foreach($campos as $c => $v)
                $log->addChild($v, $valor[$c]);
            $params = $log->addChild('params');
            foreach($valor['params'] as $c => $v){
                $p = $params->addChild('param', $v);
                $p->addAttribute('key', $c);
            }
        }
        
        $tmpxml = tempnam("tmp","man");
        $xml->asXml($tmpxml);
        
        return $tmpxml;
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
		//$log->cache(0);
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
        $this->_initTable($log, 'logs');
	}
} 
?>