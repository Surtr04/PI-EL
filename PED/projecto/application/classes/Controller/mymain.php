<?php defined('SYSPATH') or die('No direct script access.'); //Não quero que fiques em ASCII
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Mymain extends Controller {

	protected $view;
	protected $session;
	protected $user;
	private $scripts;
	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->user = Auth::instance()->get_user();
		if (!$this->user) $this->user = new Model_User();
		if ($this->isManut()) $this->redirect($this->createUrl('manut'));
		$this->view = View::Factory('pagina');
		$this->view->set('titulo', Kohana::$config->load('defs.titulo'));
		$this->view->set('youngtitle', '');
		$this->view->set('isManut', MANUT);
		$this->view->set('img', url::base() . "images/logo.gif");
		$this->fillMenus();
		$this->view->set('onload', '');
		$this->scripts = "";
		
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
	protected function restrictAcess($name, $perm){
            if(!$this->user || !$this->user->canDo(Kohana::$config->load('perms.'.$name), $perm))
		return $this->goHome();            
        }
	protected function createUrl($name, $defs = null, $args = null){
		$x = Route::url($name, $defs, true);
		if ($args){
			$x .= "?";
			foreach($args as $chave => $valor)
				$x .= urlencode($chave) . "=". urlencode($valor) . "&";
			$x = substr($x, 0,-1);
		}
		return $x;
	}
	
	private function fillMenus(){
		$this->view->set('isUserAdmin', $this->user->isAdmin());
		$this->view->set('menus', array());
		$this->addMenu("home", true, $this->createUrl('default'), "Home");
		if (!$this->user->isGuest()){
			$this->addMenu("auth", false,  url::base()."auth/logout", "Sair");
			if($this->user->canDo(Kohana::$config->load('perms.users'), 'S')) 
				$this->addMenu("users", false, $this->createUrl("users"), "Utilizadores");
			else 
				$this->addMenu("users", false, $this->createUrl("users", array("action" => "editar"), array("id"=>$this->user->getId())), "Editar Perfil");
		}
		else
			$this->addMenu("auth", false,  url::base()."auth/login", "Entrar");
        if($this->user->canDo(Kohana::$config->load('perms.groups'), 'S')) $this->addMenu("groups", false, $this->createUrl("groups"), "Grupos");
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
	
	
	public static function isProduction(){
		return (Kohana::$environment === Kohana::PRODUCTION);
	}
	
}
?>