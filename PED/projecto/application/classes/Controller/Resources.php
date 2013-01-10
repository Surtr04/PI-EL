<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Resources extends Controller_Mymain {
    
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
                if (strpos($info["foto"], "/") === false)
                    //$this->sendFile(self::getPictures().$info["foto"], $info['username']);
                    $this->response->send_file(self::getPictures().$info["foto"], $info['username'], array('inline' => true));
                else
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
    /*public function sendFile($file, $name = '', $dsp = 'inline'){
		if (file_exists($file)) {
			header('Content-Description: File Transfer');
			header('Content-Type: '.mime_content_type($file)); //octet-stream');
			header('Content-Disposition: '.$dsp.'; filename="'.($name = '' ? basename($file) : $name).'"');
			header('Content-Transfer-Encoding: binary');
            header('Content-Encoding: identity');
			header('Expires: 0');
			header('Cache-Control: must-revalidate, post-check=0, pre-check=0');
			header('Pragma: public');
			header('Content-Length: ' . filesize($file));
			ob_clean();
			flush();
			readfile($file);
		} else {
            $this->notFound();
        }
    }*/
    
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