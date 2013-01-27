<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Resources extends Controller_Mymain {
    
    const NOPIC = "_Vazio_.png";
    const PATH = "docs/";
	const PICTURES = "pictures/";
    const RESULTS = "results/";
    const OTHERS = "others/";
    
	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
	}
	
    public function action_index(){
		return $this->goHome();
	}
	
    public function action_get(){
        $type = $this->request->param('type');
        $id = (int)$this->request->param('id');
        switch($type){
            case 'img' : 
                $u = new Model_Users();
                $info = $u->getUserWithId($id);
                if (strpos($info["foto"], "/") === false){
                    $file = self::getPictures().$info["foto"];
                    if (!file_exists(self::getPictures().$info["foto"]) || !is_file($file)) $file = self::getPictures().self::NOPIC;
                    $this->response->send_file($file, $info['username'], array('inline' => true));
                }else
                    $this->redirect($info["foto"]);
                break;
            case 'doc' : 
                $u = new Model_Results();
                $info = $u->getById($id);
                $this->response->send_file(self::getResults().$info["url"], $info['realname'], array('inline' => true));
                //$this->sendFile(self::getResults().$info["url"], $info['realname']);
                break;
            default:
                $this->notFound();
        }

    }
        
    public static function deleteFiles($path, $arr){
        foreach($arr as $valor){
            if (file_exists($path.$valor)) unlink($path.$valor);
        }
    }
    
    public static function randomize($path, $file){
        $ext = pathinfo($file, PATHINFO_EXTENSION);
        do{
            $fiche = tempnam($path, "");
            $aux = str_replace(".tmp", ".".$ext, $fiche);
        } while (file_exists($aux));
        rename($fiche, $aux);
        return pathinfo($aux, PATHINFO_BASENAME);
    }
    
    public static function getPath(){return APPPATH.self::PATH;}
    public static function getPictures() {return self::getPath().self::PICTURES;}
    public static function getResults() {return self::getPath().self::RESULTS;}
    public static function getOthers(){ return APPPATH.self::OTHERS;}
} 
?>