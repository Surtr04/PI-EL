<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Themes extends Controller_Mymain {

    const THEME_SESSION = 'theme';
    
	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
		
	}
	public function action_index(){
		return $this->goHome();
	}
	
	public function action_change(){
		$theme = $this->request->param('theme');
        switch($theme){
            case 'ugly' : $lang = 'ugly'; break;
            case 'blank' : default: $lang = self::THEME_DEFAULT; break;
        }
        $this->session->set(self::THEME_SESSION, $theme);
        return $this->goBack();
	}
	

} 
?>