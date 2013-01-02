<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Sips extends Controller_Mymain {

    const ERR_MANIFESTO = 1;
    const ERR_FILE = 2;
    const MANIFESTO = "manifesto.xml";
    
    private $own = "ownsips";

	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', "Sips");
        $this->nperm = 'allsips';
	}
	
	protected function restrictAcess($perm, $name = ''){
        $sips = new Model_Sips();
        if (!$this->verifyAcess($perm, $name)){
            if ($this->verifyAcess($perm, $this->own)) $sips->setOnlyBy($this->user->getId()); else return $this->goHome();
        }
        return $sips;
    }
    
	public function action_index(){
        //if (!$this->user || $this->user->isGuest()) return $this->goHome();
        //$this->restrictAcess('S');
		$min = (int) (Arr::get($_GET,'s',0));
		$sips = $this->restrictAcess('S');
        
		$sips->cache($min);
		$this->initTable($sips);
	}
	
	public function action_apagar(){
		$sips = $this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id <= -1) return $this->action_index();
		//$sips = new Model_Sips();
		$sips->apaga($id);
		$this->action_index();
	}
    
    public function action_bycat(){
        parent::restrictAcess('S', 'categories');
        $id = (int) $this->request->param('id', -1);
        $min = (int) (Arr::get($_GET,'s',0));
        if ($id <= -1) return $this->action_index();
        $cat = Model::factory('Categorias')->getCategoriaWithId($id);
        if ($cat == null) return $this->goIndex();
        //$sips = new Model_Sips();
        $sips = $this->restrictAcess('S');
		$sips->cacheByCat($id, $min);
        $this->view->set('youngtitle', 'Sips - '.$cat['nome']);
        $this->view->set('categoria', $cat);
        $this->view->set('bycat', true);
		$this->initTable($sips);
    }
    
    public function action_ver(){
        $sips = $this->restrictAcess('S');
		$id = (int) (Arr::get($_GET,'id',0));
        if ($id <= -1) return $this->goBack();
        //$sips = new Model_Sips();
        $info = $sips->getAllInfoSip($id);
        $cat = Model::factory('Categorias')->getCategoriaWithId($info['id_categoria']);
        $this->view->set('youngtitle', "");
        $this->view->set('categoria', $cat['nome']);
        $this->view->set('toinclude', 'sipshtml');
        $this->view->set('lista', $info);
        echo $this->view->render();
    }
    
    
	private function build(){
        $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><sip></sip>');
    
        $nvs = $this->trata($_POST);

        $xml->addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        $xml->addAttribute("xsi:noNamespaceSchemaLocation","sip.xsd");
        $xml->addAttribute("iden", $nvs['id']);
        $meta = $xml->addChild("meta");

        $this->mostra($meta, true, $nvs, 'titulo');
        $this->mostra($meta, false, $nvs, 'subtitulo');
        $this->mostra($meta, false, $nvs, 'data-inic');
        $this->mostra($meta, true, $nvs, 'data-fim');
        $sps = $meta->addChild("supervisores");
        for ($i=1;$i<$nvs['cs'];$i++){
            $aux = $sps->addChild("supervisor");
            $this->mostra($aux, true, $nvs, 'nome', 'snome'.$i);
            $this->mostra($aux, false, $nvs, 'identificador', 'sid'.$i);
            $this->mostra($aux, false, $nvs, 'email', 'smail'.$i);
            $this->mostra($aux, false, $nvs, 'web', 'sweb'.$i);
        }
        $sps = $meta->addChild("autores");
        for ($i=1;$i<$nvs['ca'];$i++){
            $aux = $sps->addChild("autor");
            $this->mostra($aux, true, $nvs, 'nome', 'anome'.$i);
            $this->mostra($aux, true, $nvs, 'identificador', 'aid'.$i);
            $this->mostra($aux, false, $nvs, 'email', 'amail'.$i);
            $this->mostra($aux, false, $nvs, 'web', 'aweb'.$i);
        }

        $resumo = $xml->addChild("resumo");
        $aux = array_map("rtrim", explode("\n", $nvs['resumo']));//explode(PHP_EOL, $nvs['resumo']);
        foreach($aux as $chave => $valor)
            $resumo->addChild("para", $valor);

        $res = $xml->addChild("resultados");

        $file = tempnam("tmp","sip"); 
        $zip = new ZipArchive();
        if ($zip->open($file, ZipArchive::OVERWRITE) != 1) return false;

        $i = 0;
        foreach ($_FILES as $chave => $valor) {
            if ($valor['error'] != UPLOAD_ERR_OK) continue;
            if (++$i > $nvs['cr']) break;
            $aux = $res->addChild("resultado", $_POST['rdesc'.((int)str_replace('rurl','',$chave))]);
            $aux->addAttribute('url', $valor['name']);
            $zip->addFile($valor['tmp_name'], $valor['name']);
        }

        $tmpxml = tempnam("tmp","man");
        $xml->asXml($tmpxml);

        //Termina a geração do ficheiro zipado
        $zip->addFile($tmpxml, self::MANIFESTO);
        $zip->close();


        unlink($tmpxml);
        return $file;


 
    }
    private function mostra($fp, $obr, $nvs, $x, $nx=""){
        if ($nx == "") $nx = $x;
        if (empty($nvs[$nx]) && $obr) die ('Missing field '. $x . "($nx)"); 
        if (!empty($nvs[$nx])) $fp->addChild($x, $nvs[$nx]);  
    }
    private function trata($arr){
        $nv = array();
        $nv = $arr;
		//Trata as datas
		$nv['data-inic'] = strtotime($nv['data-inic']);
		$nv['data-fim'] = strtotime($nv['data-fim']);
		if ($nv['data-inic'] > $nv['data-fim']) die('Data-inic greater than Data-fim');
		$nv['data-inic'] = date("Y-m-d",$nv['data-inic']);
		$nv['data-fim'] = date("Y-m-d",$nv['data-fim']);
		//Contabiliza os ficheiros, autores e supervisores
        foreach (array("a" => "nome", "s" => "nome", "r" => "desc") as $chave => $valor){
            $c = 1;            
            while(isset($nv[$chave.$valor.$c]) && !empty($nv[$chave.$valor.$c]))
                $c++;
            $nv["c".$chave]=$c;
        }
        return $nv;
    }
    private function buildHtml($file){
        $zip = new ZipArchive();
        $zip->open($file);
        $tmpxml = $zip->getFromName(self::MANIFESTO);
        
        $xml = new DOMDocument();
        $xml->loadXML($tmpxml);

        //Trata o xsl para gerar o html
        $xsl = new DOMDocument();
        $xsl->load(Controller_Resources::getOthers().'sip.xsl');

        $proc = new XSLTProcessor;
        $proc->importStyleSheet($xsl);

        return $proc->transformToXML($xml);
        
    }
    
	/*public function action_editar($id = -1){
		$sips = $this->restrictAcess('U');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		$cats = new Model_Categorias();
		$info = $cats->getCategoriaWithId($id);
		$this->view->set('toinclude', 'categoriasform');
		$this->view->set('form_id', $id);
		$this->view->set('nome', $info['nome']);
        $this->view->set('inicio', $info['inicio']);
        $this->view->set('fim', $info['fim']);

		echo $this->view->render();
	}*/
	
	/*public function action_update(){
		$this->restrictAcess('U');
		if (trim($_POST['nome']) == "" || trim($_POST['inicio']) == "" || trim($_POST['fim']) == "") return $this->action_editar($_POST['form_id']);
	
		$cats = new Model_Categorias();
		$cats->editarCategoria($_POST['form_id'], $_POST['nome'], $_POST['inicio'], $_POST['fim']);
		$this->goIndex();
	}*/
	
    public function action_insereFile(){
        $this->restrictAcess('I');
        $this->view->set('toinclude', 'sipsfile');
        $this->view->set('categoria', $this->request->param('catid', -1));
        $this->view->set('categorias', Model::factory('Categorias')->getAllOpened());
        echo $this->view->render();
    }
    
	public function action_insere(){
		$this->restrictAcess('I');
        
		$this->view->set('toinclude', 'sipsform');
		$this->view->set('form_id', NULL);
        $this->view->set('categoria', $this->request->param('catid', -1));
        $this->view->set('categorias', Model::factory('Categorias')->getAllOpened());
		echo $this->view->render();
	}
	
	public function action_insere2(){
		$sips = $this->restrictAcess('I');
        $aux = ((isset($_POST['isForm']) && $_POST['isForm']) ? 1 : 0);
        if ($aux == 1) $zip = $this->build(); else $zip = $_FILES['sip']['tmp_name'];
                
        $res = $this->processaZip($zip);
        if (!is_array($res)) die('Error! ' .$res );
        //$sips = new Model_Sips();
        $sips->insere($_POST['categoria'], $this->user->getId(), $res);
        $this->view->set('afterhtml',$this->buildHtml($zip));
        echo $this->view->render();
	}
	
    private function processaZip($file){
        $zip = new ZipArchive();
        $zip->open($file);
        $tmpxml = $zip->getFromName(self::MANIFESTO);
        if ($tmpxml === false) return self::ERR_MANIFESTO;
        $xml = new DOMDocument();
        $xml->loadXML($tmpxml);
        /*if (!$xml->schemaValidate(Controller_Resources::getOthers().'sip.xsd')) return false;*/
        $info = array();
        
        $xpath = new DOMXPath($xml);
        $info["iden"] = $xpath->query("/sip/@iden")->item(0)->textContent;
        
        $with = "/sip/meta/";
        $aux = array("titulo", "subtitulo", "data-inic", "data-fim");
        foreach($aux as $valor)
            $info[$valor] = $xpath->query($with.$valor)->item(0)->textContent;
        
        $info["supervisores"] = $this->processaPessoas($xpath, $with."supervisores/supervisor");
        $info["autores"] = $this->processaPessoas($xpath, $with."autores/autor");
        
        $with = "/sip/resumo/";
        $aux = $xpath->query($with."para");
        $info["resumo"] = array();
        $i = 0;
        foreach($aux as $node)
            $info["resumo"][++$i] = $node->textContent;
        
        $with = "/sip/resultados/";
        $info["resultados"] = array();
        $aux = $xpath->query($with."resultado");
        $naux = array("@url", ".");
        foreach($aux as $node){
            $res = array();
            foreach($naux as $valor)
                $res[$valor] = $xpath->query($valor, $node)->item(0)->textContent;
            if (($fiche = $zip->getFromName($res["@url"])) === false) return self::ERR_FILE;
            $res["name"] = $res["@url"];
            $res["desc"] = $res["."];
            $res["url"] = Controller_Resources::randomize(Controller_Resources::getResults(), $res["name"]);
            file_put_contents(Controller_Resources::getResults().$res["url"], $fiche);
            $info["resultados"][] = $res;
        }
        return $info;         
    }
    
    private function processaPessoas($xpath, $q){
        $pessoas = array();
        $aux = $xpath->query($q);
        $naux = array("nome", "identificador", "email", "web");
        foreach($aux as $node){
            $pessoa = array();
            foreach($naux as $valor)
                $pessoa[$valor] = $xpath->query($valor, $node)->item(0)->textContent;
            $pessoas[] = $pessoa;
        }
        return $pessoas;
    }
    
	private function initTable($lista){
		$this->_initTable($lista, 'sips');
        $perms = $this->user->canDo(Kohana::$config->load('perms.'.$this->nperm));
        $aux = $this->user->canDo(Kohana::$config->load('perms.'.$this->own));
        foreach(array('S', 'I', 'U', 'D') as $valor)
            $perms[$valor] = ($perms[$valor] || $aux[$valor]);
        $this->view->set('perms', $perms);
		/*$this->view->set('lista', $lista->getList());
		$this->view->set('toinclude', 'sips'); 
        $this->view->set('perms', $perms);
		$this->view->set('min', $lista->getMin());
		$this->view->set('int', $lista->getIntervalo());
		echo $this->view->render();*/
	}
} 
?>