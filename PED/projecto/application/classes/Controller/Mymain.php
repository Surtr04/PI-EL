<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Mymain extends Controller {

    const THEME_DEFAULT = 'blank';
    const SESSION_ERROR = 'ERRORMSG';
    
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
		$this->user = Auth::instance()->get_user(new Model_User());
        if ($this->isManut()) $this->redirect($this->createUrl('manut'));
		$this->view = View::Factory('pagina');
        $this->view->set('theme', $this->getTheme());
        $this->view->set('dtheme', self::THEME_DEFAULT);
		$this->view->set('titulo', Kohana::$config->load('defs.titulo'));
		$this->view->set('youngtitle', '');
        $this->view->set('errors', $this->getErrors());
		$this->view->set('isManut', MANUT);
		$this->view->set('img', $this->createUrl() . "images/logo.gif");
        $this->view->set('route', strtolower($this->request->controller()));
		$this->fillMenus();
		$this->view->set('onload', '');
		$this->scripts = "";
		$this->nperm = "";
	}
    private function getErrors(){
        $errors = $this->session->get(self::SESSION_ERROR, array());
        $this->session->set(self::SESSION_ERROR, array());
        return $errors;
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
    
    protected function verifyAcess($perm, $name = ''){
        if ($name == '') $name = $this->nperm;
        return ($this->user && $this->user->canDo(Kohana::$config->load('perms.'.$name), $perm));
    }
    
    protected function restrictAcess($perm, $name = ''){
        if (!$this->verifyAcess($perm, $name))
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
            $this->createMenuLink('users', $this->createUrl("users"), "Users", 
                                           $this->createUrl("users", array("action" => "editar"), array("id"=>$this->user->getId())), "Change Profile"
                                 );
            $this->addMenu("sips", false, $this->createUrl("sips"), "Sips");
		}
		else
			$this->addMenu("auth", false,  url::base()."auth/login", "Enter");
        $this->createMenuLink('groups', $this->createUrl("groups"), "Groups");
        $this->createMenuLink('logs', $this->createUrl("logs"), "Logs");
        $this->createMenuLink('supervisors', $this->createUrl("supervisores"), "Supervisors");
        $this->createMenuLink('authors', $this->createUrl("autores"), "Authors");
        $this->createMenuLink('categories', $this->createUrl("categories"), "Categories");
        
		$this->updateHome(strtolower(str_replace("Controller_", "", get_class($this))));
	}
    private function createMenuLink($name, $urlT, $textT, $urlF = null, $textF = null){
        if($this->user->canDo(Kohana::$config->load('perms.'.$name), 'S')) 
            $this->addMenu($name, false, $urlT, $textT);
        else if($urlF !== null)
            $this->addMenu($name, false, $urlF, $textF);
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
	
    protected function setError($msg){
        $msgs = $this->session->get(self::SESSION_ERROR, array());
        $msgs[] = $msg;
        $this->session->set(self::SESSION_ERROR, $msgs);
    }
    
    protected function _initTable($m, $include = '', $render = true){
        $perms = $this->user->canDo(Kohana::$config->load('perms.').$this->nperm);
		$this->view->set('lista', $m->getList());
		$this->view->set('toinclude', $include); 
		$this->view->set('perms', $perms);
        $this->view->set('total', $m->getTotal());
		$this->view->set('min', $m->getMin());
		$this->view->set('int', $m->getIntervalo());
		if ($render) echo $this->view->render();
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
	protected function goHome(){
		$this->redirect($this->createUrl('default'));
	}
    protected function goBack(){
        $r = $this->request->referrer();
        if ($r !== null) $this->redirect($r); else $this->goHome ();
    }
    protected function getTheme(){
        return $this->session->get(Controller_Themes::THEME_SESSION, self::THEME_DEFAULT);
    }
	public static function isProduction(){
		return (Kohana::$environment === Kohana::PRODUCTION);
	}
	
}
?>