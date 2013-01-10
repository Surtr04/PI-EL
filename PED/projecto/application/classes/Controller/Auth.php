<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

class Controller_Auth extends Controller_Mymain {


	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', "Authentication");
	}
	public function action_login(){
		if (!$this->user->isGuest()) $this->goHome(); //Há uma sessão activa
        
		$username = (Arr::get($_POST, 'username', ''));
		$password = (Arr::get($_POST, 'password', ''));

		if ($username != '' && $password != ''){ //Quer fazer login
            Auth::instance()->login($username, $password);
            $this->user = Auth::instance()->get_user(new Model_User());
            if (!$this->user->isGuest()){
                if ($this->user->isAdmin()) $this->log('Admin login');
                $this->goHome();
			} else{
				$this->setError("Invalid User!");
				$this->goLogin();
			}
		} else
			$this->goLogin();
	}
	
	public function action_logout(){
        if ($this->user->isAdmin()) $this->log('Admin logout');
        Auth::instance()->logout();
        $this->goHome();
	}
	private function goLogin(){
        $this->view->set('toinclude', "login");
		$_POST['username'] = $_POST['password'] = '';
		$this->regenerate();
		$this->updateHome("auth");
		echo $this->view->render();
	}
} 
?>