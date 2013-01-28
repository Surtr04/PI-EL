<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Sips extends Controller_Mymain {

    const ERR_NOTHING = "";
    const ERR_MANIFESTO = "ERR_SIP_MANIFESTO";
    const ERR_FILE = "ERR_SIP_FILE";
    const ERR_SCHEMA = "ERR_SIP_SCHEMA";
    const ERR_DATA = "ERR_SIP_DATA";
    const MANIFESTO = "pr.xml";
    
    private $own = "ownsips";
    private $prv = "privatesips";

	public function __construct(Request $request, Response $response){
		parent::__construct($request,$response);
		$this->view->set('youngtitle', "Sips");
        $this->nperm = 'allsips';
	}
	
	protected function restrictAcess($perm, $name = ''){
        if ($name == '') $name = $this->nperm;
        $sips = new Model_Sips();
        if (!$this->verifyAcess($perm, $name)){
            if ($this->verifyAcess($perm, $this->own)) $sips->setOnlyBy($this->user->getId()); else return $this->goHome();
        }
        if (!$this->verifyAcess($perm, $this->prv)) $sips->setOnlyPublic($this->user->getId());
        if (!$this->verifyAcess('D', 'categories')) $sips->setonlyVisibleByGroup($this->user->getGrupo());
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
	
    public function writeManifestoCat($arr){
        $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><dip_container></dip_container>');
        foreach($arr as $valor){
            $elem = $xml->addChild('zip', $valor['titulo']);
            $elem->addAttribute('nome', $valor['nome']);
        }
        $tmpxml = tempnam("tmp","man");
        $xml->asXml($tmpxml);
        return $tmpxml;
    }
    
    public function action_zipcat(){
        parent::restrictAcess('S', 'categories');
        $id = (int) (Arr::get($_GET,'id',0));
        if ($id <= -1) return $this->goBack();
        $sips = $this->restrictAcess('S');
        $sips->cacheAllByCat($id);
        
        $file = tempnam("tmp","bycat"); 
        $bycat = new ZipArchive();
        if ($bycat->open($file, ZipArchive::OVERWRITE) != 1) return false;
        $catname = $id;
        $unlink = array();
        $arr = array();
        foreach($sips->getList() as $valor){
            $catname = $valor['categoria'];
            $infos = $this->buildZipFromDB($valor['id'], $sips);
            $nome = $valor['id'].'_'.$infos['ident'].'.zip';
            $bycat->addFile($infos['zip'], $nome);
            $arr[] = array('nome' => $nome, 'titulo' => $infos['titulo']);
            $unlink[] = $infos['zip'];
        }
        
        $man = $this->writeManifestoCat($arr);
        $bycat->addFile($man, self::MANIFESTO);
        
        $bycat->close();
        foreach($unlink as $valor)
            unlink($valor);
        unlink($man);
        $this->response->send_file($file, $catname.'.zip', array( 'delete'=>true));
    }
    
    private function buildZipFromDB($id, $sips = null){
        if ($sips == null) $sips = Model::factory('Sips');
        $info = $sips->getAllInfoSip($id);
        if ($info['ident'] == null) return $this->goBack();
        Model::factory('Stats')->logDownload($id, new DateTime());
        $info["id"] = $info["ident"];
        $info = array_merge($info, $this->arr2multi($info["supervisores"], 's'));
        $info = array_merge($info, $this->arr2multi($info["autores"], 'a'));
        $files = array();
        $i = 1;
        foreach($info['resultados'] as $chave => $valor){
            $files["rurl".$i] = array("error" => UPLOAD_ERR_OK, "name" => $valor["realname"], "tmp_name" => Controller_Resources::getResults().$valor['url']);
            $info["rdesc".$i] = $valor["desc"];
            $i++;
        }
        $info['cr'] = $i;
        $zip = $this->build($info, $files, 'dip', new DipBuild($info, $files));
        return array('zip'=>$zip, 'ident'=>$info['ident'], 'titulo' => $info['titulo']);
    }
    public function action_downzip(){
        $sips = $this->restrictAcess('S');
        $id = (int) (Arr::get($_GET,'id',0));
        if ($id <= -1) return $this->goBack();
        $infos = $this->buildZipFromDB($id, $sips);
        $this->response->send_file($infos['zip'], $infos['ident'].'.zip', array( 'delete'=>true));
    }
    
    private function arr2multi($arr, $pre){
        $i = 1;
        $res = array();
        foreach($arr as $valor){
            $res[$pre."nome".$i] = $valor["nome"];
            $res[$pre."id".$i] = $valor["identificador"];
            $res[$pre."mail".$i] = $valor["email"];
            $res[$pre."web".$i] = $valor["web"];
            $i++;
        }
        $res['c'.$pre] = $i;
        return $res;
    }
    
	public function action_apagar(){
		$sips = $this->restrictAcess('D');
		$id = (int) Arr::get($_GET,'id',-1);
		if ($id <= -1) return $this->action_index();
		//$sips = new Model_Sips();
        if (!$this->verifyAcess('D', 'categories')) $sips->restrictByCat();
        $info = $sips->getAllInfoSip($id);
        $arr = $this->processaResultsFromBD($info['resultados']);
		$sips->apaga($id);
        if ($sips->LastSuccessful()) Controller_Resources::deleteFiles(Controller_Resources::getResults(), $arr);
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
        if ($info['ident'] == null) return $this->goBack();
        Model::factory('Stats')->logView($id, new DateTime());
        $cat = Model::factory('Categorias')->getCategoriaWithId($info['id_categoria']);
        $this->view->set('youngtitle', "");
        $this->view->set('categoria', $cat['nome']);
        $this->view->set('toinclude', 'sipshtml');
        $this->view->set('lista', $info);
        echo $this->view->render();
    }
    
    private function processaResultsFromBD($res){
        $arr = array();
        foreach($res as $valor)
            $arr[] = $valor['url'];
        return $arr;
    }
    
	private function build($arr, $files, $root = "sip", $builder = null){
        $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><'.$root.'></'.$root.'>');
    
        $nvs = $this->trata($arr);

        /*$xml->addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        $xml->addAttribute("xsi:noNamespaceSchemaLocation","sip.xsd");*/
        $xml->addAttribute("ident", $nvs['id']);
        $meta = $xml->addChild("meta");

        $this->mostra($meta, true, $nvs, 'titulo');
        $this->mostra($meta, false, $nvs, 'subtitulo');
        $this->mostra($meta, false, $nvs, 'data-inic', 'data_inic');
        $this->mostra($meta, true, $nvs, 'data-fim', 'data_fim');
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
        if (is_array($nvs['resumo'])) $aux = $nvs['resumo']; else $aux = array_map("rtrim", explode("\n", $nvs['resumo']));//explode(PHP_EOL, $nvs['resumo']);
        foreach($aux as $chave => $valor)
            if (is_array($valor)) $resumo->addChild("para", $valor["para"]); else $resumo->addChild("para", $valor);

        $res = $xml->addChild("resultados");

        $file = tempnam("tmp","sip"); 
        $zip = new ZipArchive();
        if ($zip->open($file, ZipArchive::OVERWRITE) != 1) return false;

        $i = 0;
        foreach ($files as $chave => $valor) {
            if ($valor['error'] != UPLOAD_ERR_OK) continue;
            if (++$i > $nvs['cr']) break;
            $aux = $res->addChild("resultado", $nvs['rdesc'.((int)str_replace('rurl','',$chave))]);
            $aux->addAttribute('url', $valor['name']);
            $zip->addFile($valor['tmp_name'], $valor['name']);
        }
        
        if ($builder !== null) $builder->processa($xml, $zip);
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
        if (empty($nvs[$nx]) && $obr) {$this->setError('Missing field '. $x . "($nx)"); $this->goBack();} 
        if (!empty($nvs[$nx])) $fp->addChild($x, $nvs[$nx]);  
    }
    private function trata($arr){
        $nv = array();
        $nv = $arr;
		//Trata as datas
        if ($nv['data_inic'] != ''){
            $nv['data_inic'] = new DateTime($nv['data_inic']);
            $nv['data_inic'] = $nv['data_inic']->format('Y-m-d');
        }
        $nv['data_fim'] = new DateTime($nv['data_fim']);
        $nv['data_fim'] = $nv['data_fim']->format('Y-m-d');
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
    
	public function action_editar($id = -1){
		$sips = $this->restrictAcess('U');
		if ($id <= -1){
			$id = (int) Arr::get($_GET,'id',-1);
			if ($id <= -1) return $this->action_index();
		}
		
        if (!$this->verifyAcess('D', 'categories') ){
            if (!$this->verifyAcess('U', $this->prv)) return $this->goIndex();
            
            $sips->restrictByCat();
            $info = $sips->getAllInfoSip($id);
            
            $this->view->set('form_id', $id);
            $this->view->set('ident', $info["ident"]);
            $this->view->set('titulo', $info["titulo"]);
            $this->view->set('canBePrivate', $info["privado"]);
            $this->view->set('toinclude', 'sips_private');
        } else {
            $info = $sips->getAllInfoSip($id);
            $this->callForm($id, $info);
            $this->view->set('categoria', $info["id_categoria"]);
        }
        
		echo $this->view->render();
	}
	
	public function action_update(){
		$sips = $this->restrictAcess('U');
        
        $private = Arr::get($_POST,'onlyPrivate',0);
        $id = (int) Arr::get($_POST,'form_id',-1);
        if (!$this->verifyAcess('D', 'categories')) $sips->restrictByCat();
        
        if ($private) {
            $sips->setPrivate($id, (int)$_POST['privado']);
            return $this->goIndex();
        }
        
        $info = $sips->getAllInfoSip($id);
        
        $arr = $this->processaResultsFromBD($info['resultados']);
        $i = 1;
        foreach($info['resultados'] as $chave => $valor){
            $_FILES["rurl".$i] = array("error" => UPLOAD_ERR_OK, "name" => $valor["realname"], "tmp_name" => Controller_Resources::getResults().$valor['url']);
            $_POST["rdesc".$i] = $valor["desc"];
            $i++;
        }
        $res = $this->processaZip($this->build($_POST, $_FILES));
        if (!is_array($res)){
            $this->setError($res);
            $this->goBack();
        }
		$sips->edita($id, $res, ($this->verifyAcess('I', $this->prv) ? $_POST['privado'] : false));
        if ($sips->LastSuccessful()) {
            Controller_Resources::deleteFiles(Controller_Resources::getResults(), $arr);
            $this->log('Sip change', array('sip' => $id));
        }
        $_GET['id'] = $id;
		$this->action_ver();
	}
	
    
    
    public function action_insereFile(){
        $this->restrictAcess('I');
        $this->view->set('canBePrivate', $this->verifyAcess('I', $this->prv));
        $this->view->set('toinclude', 'sipsfile');
        $this->view->set('categoria', $this->request->param('catid', -1));
                $cats = new Model_Categorias();
        if (!$this->verifyAcess('D')) $cats->setOnlyVisible($this->user->getGrupo());
        $this->view->set('categorias', $cats->getAllOpened());
        echo $this->view->render();
    }
    
	public function action_insere(){
		$sips = $this->restrictAcess('I');
        
		$this->callForm();
        $this->view->set('categoria', $this->request->param('catid', -1));
		echo $this->view->render();
	}
    
    private function callForm($id = null, $sip = array()){
        $this->view->set('toinclude', 'sipsform');
        $this->view->set('canBePrivate', $this->verifyAcess('I', $this->prv));
        $this->view->set('form_id', $id);
        $this->view->set('sip', $sip);
        $cats = new Model_Categorias();
        if (!$this->verifyAcess('D')) $cats->setOnlyVisible($this->user->getGrupo());
        $this->view->set('categorias',$cats->getAllOpened());
    }
	
	public function action_insere2(){
		$sips = $this->restrictAcess('I');
        $aux = ((isset($_POST['isForm']) && $_POST['isForm']) ? 1 : 0);
        if ($aux == 1) $zip = $this->build($_POST, $_FILES); else $zip = $_FILES['sip']['tmp_name'];
                
        $res = $this->processaZip($zip);
        if (isset($res['erro']) && $res['erro'] !== self::ERR_NOTHING){
            $this->setError($res['erro'], $res);
            $this->goBack();
        }
        //$sips = new Model_Sips();
        $sips->restrictByCat();
        $sips->insere($_POST['categoria'], $this->user->getId(), $res, ($this->verifyAcess('I', $this->prv) ? (int)$_POST['privado'] : false));
        $this->view->set('afterhtml',$this->buildHtml($zip));
        echo $this->view->render();
	}
	
    private function processaZip($file){
        $zip = new ZipArchive();
        $zip->open($file);
        $tmpxml = $zip->getFromName(self::MANIFESTO);
        if ($tmpxml === false) return array('erro' => self::ERR_MANIFESTO, ':nome' => self::MANIFESTO);
        $xml = new DOMDocument();
        $xml->loadXML($tmpxml);
        libxml_use_internal_errors(true);
        if (!$xml->schemaValidate(Controller_Resources::getOthers().'sip.xsd')){
            $error = Arr::get(libxml_get_errors(), 0, new libXMLError());
            return array('erro' => self::ERR_SCHEMA, ':msg' => $error->message, ':code' => $error->code, ':line' => $error->line);
        }
        $info = array();
        
        $xpath = new DOMXPath($xml);
        $info["ident"] = $xpath->query("/sip/@ident")->item(0)->textContent;
        
        $with = "/sip/meta/";
        $aux = array("titulo", "subtitulo", "data-inic", "data-fim");
        foreach($aux as $valor)
            $info[$valor] = $xpath->query($with.$valor)->item(0)->textContent;
        
        if (isset($info['data-inic']) && $info['data-inic'] > $info['data-fim']) return array('erro' => self::ERR_DATA);
        
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
            if (($fiche = $zip->getFromName($res["@url"])) === false) return array('erro' => self::ERR_FILE, ':nome' => $res["@url"]);
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
		$this->_initTable($lista, 'sips', false);
        $perms = $this->user->canDo(Kohana::$config->load('perms.'.$this->nperm));
        $aux = $this->user->canDo(Kohana::$config->load('perms.'.$this->own));
        foreach(array('S', 'I', 'U', 'D') as $valor)
            $perms[$valor] = ($perms[$valor] ? 2 : ($aux[$valor] ? 1 : 0));
        $this->view->set('perms', $perms);
        $this->view->set('catperms', $this->user->canDo(Kohana::$config->load('perms.categories')));
        echo $this->view->render();
	}
} 

/*Classes auxiliares*/
interface RBuild{
    public function processa($xml, $zip);
} 

class DipBuild implements RBuild{
    private $_arr;
    private $_files;
    public function __construct($arr, $files){
        $this->_arr = $arr;
        $this->_files = $files;
    }
    public function processa($xml, $zip) {
        $xml->addChild("data-submissao", $this->_arr['data_submissao']);
        $xml->addChild("submetido", $this->_arr['username']);
        $xml->addChild("categoria", $this->_arr['categoria']);
        $xml->addAttribute("privado", ($this->_arr['privado'] ? "true" : "false"));
    }
}
?>
