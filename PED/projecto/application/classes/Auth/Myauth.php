<?php
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

class Auth_Myauth extends Auth{

	public function action_index(){return "";}

    private function isValidLogin($username, $password){
		$user = Model_User::factory()->tryLogin($username, $this->hash($password));
		if ($user->isGuest()) return false; return $user;
	}
	
	protected function _login($username, $password, $remember = false){
		$user = $this->isValidLogin($username, $password);
        $this->force_login($user);
    }
 
    public function password($username){ return "";} //Well I don't like to anyone see the password
 
    public function check_password($password){
        return ($this->isValidLogin($this->get_user()->getUsername(), $password) !== false);
    }
 
 	public function force_login($user, $mark_session_as_forced = false){
		if ($user === false) return false;
		$this->complete_login($user);
		return true;
	}
 
    public function logged_in($role = null){
        	$user = $this->get_user();
			if ( ! $user) return false; else return true;
    }
 
    public function get_user($default = null){
        return parent::get_user($default);
    }
	
	public function logout($destroy = false, $logout_all = false){
        $this->get_user()->logout();
		return parent::logout($destroy, $logout_all);
	}
}
?>