<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Mymain extends Controller {

	protected $view;
    protected $session;
	protected $user;
    protected $nperm;
    protected $picturesPath;
	private $scripts;
    
	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
        $this->session = Session::instance();
        $lang = $this->session->get(Controller_Langs::LANG_SESSION, null);
        if ($lang !== null) I18n::lang($lang);
        $this->picturesPath = APPPATH."docs/pictures";
		$this->user = Auth::instance()->get_user();
		if (!$this->user) $this->user = new Model_User();
		if ($this->isManut()) $this->redirect($this->createUrl('manut'));
		$this->view = View::Factory('pagina');
		$this->view->set('titulo', Kohana::$config->load('defs.titulo'));
		$this->view->set('youngtitle', '');
		$this->view->set('isManut', MANUT);
		$this->view->set('img', $this->createUrl() . "images/logo.gif");
		$this->fillMenus();
		$this->view->set('onload', '');
		$this->scripts = "";
		$this->nperm = "";
	}
	public function isManut(){
        $u = Auth::instance()->get_user();
		if (self::isProduction()) $b = ""; else $b = "/";
		if (get_class($this) == "Controller_Manut") return; //Everything is fine
		if (MANUT && (!$u || !$u->isAdmin()) && Request::current()->detect_uri() != $b.'manut'){
			$username = (Arr::get($_POST, 'username', ''));
			$password = (Arr::get($_POST, 'password', ''));
			if (Request::current()->detect_uri() != $b.'auth/login' || $username == '' || $password == '') return true;
		}
        return false;
	}
	protected function restrictAcess($perm, $name = ''){
        if ($name == '') $name = $this->nperm;
        if(!$this->user || !$this->user->canDo(Kohana::$config->load('perms.'.$name), $perm))
            return $this->goHome();            
    }
    protected function createUrl($name = 'default', $defs = null, $args = null){
		$x = Route::url($name, $defs, true);
		if ($args){
			$x .= "?";
			foreach($args as $chave => $valor)
				$x .= urlencode($chave) . "=". urlencode($valor) . "&";
			$x = substr($x, 0,-1);
		}
		return $x;
	}
	protected function log($desc = '', $action = null){
        $l = new Model_Logs();
        if ($action == null) $action = $this->request->controller() . "/". $this->request->action();
        $l->insereLog($this->user->getId(), time(), $action, $desc, Model_Logs::AUTO);
    }
	private function fillMenus(){
		$this->view->set('isUserAdmin', $this->user->isAdmin());
		$this->view->set('menus', array());
		$this->addMenu("home", true, $this->createUrl('default'), "Home");
		if (!$this->user->isGuest()){
			$this->addMenu("auth", false,  url::base()."auth/logout", "Logout");
			if($this->user->canDo(Kohana::$config->load('perms.users'), 'S')) 
				$this->addMenu("users", false, $this->createUrl("users"), "Users");
			else 
				$this->addMenu("users", false, $this->createUrl("users", array("action" => "editar"), array("id"=>$this->user->getId())), "Change Profile");
		}
		else
			$this->addMenu("auth", false,  url::base()."auth/login", "Enter");
        if($this->user->canDo(Kohana::$config->load('perms.groups'), 'S')) $this->addMenu("groups", false, $this->createUrl("groups"), "Groups");
        if($this->user->canDo(Kohana::$config->load('perms.logs'), 'S')) $this->addMenu("logs", false, $this->createUrl("logs"), "Logs");
		$this->updateHome(strtolower(str_replace("Controller_", "", get_class($this))));
	}
	protected function regenerate(){
		$this->user = Auth::instance()->get_user(new Model_User());
		if ($this->isManut()) $this->redirect($this->createUrl('manut'));
		$this->fillMenus();
	}
	
	
	public function render($assoc = array()){
		foreach($assoc as $chave => $valor)
			$this->view->set($chave, $valor);
		echo $this->view->render();
	}
	
	public function action_index(){
		$this->goHome();
	}
	
        
	public function addMenu($name, $home, $link, $text){
		$this->editMenu($name, $home, $link, $text);
	}
	
	public function delMenu($name){
		$menus = $this->view->__get('menus');
		unset($menus[$name]);
		$this->view->set('menus', $menus);
	}
	
	public function updateHome($name){
		$menus = $this->view->__get('menus');
		if (!isset($menus[$name])) return;
		foreach($menus as $chave => &$valor)
				$valor["home"] = false;
		$menus[$name]["home"] = true;
		$this->view->set('menus', $menus);
	}
	
	public function editMenu($name, $home, $link, $text){
		$menus = $this->view->__get('menus');
		$menus[$name] = array("home" => ($home ? true : false), "link" => $link, "text" => $text);
		$this->view->set('menus', $menus);
		if ($home) $this->updateHome($name);
	}
	protected function addStyleSheet($link = null, $code = null){
		if ($link != null){
			$this->scripts .= "
	<link type=\"text/css\" href=\"$link\" rel=\"stylesheet\"/>";
		} else if ($code != null){
			$this->scripts .= "
	<style type=\"text/css\">
		$code
	</style>";
		}
		$this->view->set('scripts', $this->scripts);
	}
	protected function addScript($link = null, $code = null){
		if ($link != null){
			$this->scripts .= "
	<script type=\"text/javascript\" src=\"$link\"></script>";
		} else if ($code != null){
			$this->scripts .= "
	<script type=\"text/javascript\">
		$code
	</script>";
		}
		$this->view->set('scripts', $this->scripts);
	}
		
	protected function goHome(){
		$this->redirect($this->createUrl('default'));
	}
    
    protected function notFound($silent = true){
        if ($silent){
            $this->response->status(404);
            echo $this->response->send_headers();
            die();
        } else
            throw HTTP_Exception::factory(404, 'Not Found!');
    }
	
    protected function goIndex(){
        $this->redirect($this->createUrl('default', array('action' => 'index', 'controller' => $this->request->controller())));
    }
	
	public static function isProduction(){
		return (Kohana::$environment === Kohana::PRODUCTION);
	}
	
}
?>