<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/


class Controller_Main extends Controller_Mymain {

	public function action_index(){
		$body = "";
		$user = Auth::instance()->get_user();
		if ($user == null || $user->isGuest()) $body = "Hi guest!"; else $body = "Hi " . $user->getName();
		$this->view->set('beforehtml', $body.'<br/>Main page!');
		$this->render();		
	}

	

}
