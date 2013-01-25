<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Manut extends Controller_Mymain {

	private $MFILE;

	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
		$this->MFILE = APPPATH . "isManut.dat";
		
	}
	public function action_index(){
        if (!MANUT) $this->goHome();
		$this->view = View::Factory('manut');
		$this->view->set('theme', $this->getTheme());
        $this->view->set('dtheme', self::THEME_DEFAULT);
		$this->render(array('youngtitle' => "Maintenance", 'titulo'=> Kohana::$config->load('defs.titulo'), 'dtheme' => self::THEME_DEFAULT));
	}
	
	public function action_activate(){
		if (!$this->user->isAdmin()) if (MANUT) return $this->action_index() ;else return $this->goHome();
		$fp = fopen($this->MFILE, "w");
		fwrite($fp, "Manut");
		fclose($fp);
		$this->view->set('isManut', true);
        $this->log('Manut act');
		$this->goBack();
	}
	
	public function action_deactivate(){
		if (!$this->user->isAdmin()) if (MANUT) return $this->action_index();else return $this->goHome();
		unlink($this->MFILE);
		$this->view->set('isManut', false);
        $this->log('Manut deact');
		$this->goBack();
	}
} 
?>
