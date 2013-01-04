<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Langs extends Controller_Mymain {

    const LANG_SESSION = 'lang';
    
	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
		
	}
	public function action_index(){
		return $this->goHome();
	}
	
	public function action_change(){
		$lang = $this->request->param('lang');
        switch($lang){
            case 'pt' : $lang = 'pt-pt'; break;
            case 'en' : default: $lang = 'en'; break;
        }
        $this->session->set(self::LANG_SESSION, $lang);
        return $this->goBack();
	}
	

} 
?>