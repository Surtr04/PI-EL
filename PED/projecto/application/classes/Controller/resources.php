<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Resources extends Controller_Mymain {
    
    const PATH = "docs/";
	const PICTURES = "pictures/";
    const RESULTS = "results/";

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
                    $this->sendFile($this->getPictures().$info["foto"], $info['username']);
                else
                    $this->redirect($info["foto"]);
                break;
            case 'doc' : 
                $url = new Model_Results();
                $info = $u->getResultWithId($id);
                $this->sendFile($this->getResults().$info["url"]);
                break;
            default:
                $this->notFound();
        }

    }
    public function sendFile($file, $name = '', $dsp = 'inline'){
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
    }
    
    public function getPath(){return APPPATH.self::PATH;}
    public function getPictures() {return $this->getPath().self::PICTURES;}
    public function getResults() {return $this->getPath().self::RESULTS;}
    
} 
?>