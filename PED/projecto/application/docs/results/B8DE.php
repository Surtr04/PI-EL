<?php
        
    $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><sip></sip>');
    
    $nvs = trata($_POST);

    $xml->addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	$xml->addAttribute("xsi:noNamespaceSchemaLocation","sip.xsd");
    $xml->addAttribute("iden", $nvs['id']);
    $meta = $xml->addChild("meta");
   
    mostra($meta, true, $nvs, 'titulo');
    mostra($meta, false, $nvs, 'subtitulo');
    mostra($meta, false, $nvs, 'data-inic');
    mostra($meta, true, $nvs, 'data-fim');
    $sps = $meta->addChild("supervisores");
    for ($i=1;$i<$nvs['cs'];$i++){
        $aux = $sps->addChild("supervisor");
        mostra($aux, true, $nvs, 'nome', 'snome'.$i);
        mostra($aux, false, $nvs, 'identificador', 'sid'.$i);
        mostra($aux, false, $nvs, 'email', 'smail'.$i);
        mostra($aux, false, $nvs, 'web', 'sweb'.$i);
    }
    $sps = $meta->addChild("autores");
    for ($i=1;$i<$nvs['ca'];$i++){
        $aux = $sps->addChild("autor");
        mostra($aux, true, $nvs, 'nome', 'anome'.$i);
        mostra($aux, true, $nvs, 'identificador', 'aid'.$i);
        mostra($aux, false, $nvs, 'email', 'amail'.$i);
        mostra($aux, false, $nvs, 'web', 'aweb'.$i);
    }
    
    $resumo = $xml->addChild("resumo");
    $aux = explode(PHP_EOL, $nvs['resumo']);
    foreach($aux as $chave => $valor)
        $resumo->addChild("para", $valor);
    
    $res = $xml->addChild("resultados");
    
    $file = tempnam("tmp","sip"); 
    $zip = new ZipArchive();
	if ($zip->open($file, ZipArchive::OVERWRITE) != 1) die('Failed to create the archieve');
    
	$i = 0;
    foreach ($_FILES as $chave => $valor) {
		if ($valor['error'] != UPLOAD_ERR_OK) continue;
		if (++$i > $nvs['cr']) break;
        $aux = $res->addChild("resultado", $_POST['rdesc'.((int)str_replace('rurl','',$chave))]);
        $aux->addAttribute('url', $valor['name']);
        $zip->addFile($valor['tmp_name'], $valor['name']);
    }
    
	//header("Content-type: text/xml; charset:UTF-8");
	$tmpxml = tempnam("tmp","man");
    $xml->asXml($tmpxml);
    
	//Termina a geração do ficheiro zipado
	$zip->addFile($tmpxml, 'manifesto.xml');
	$zip->close();
	
	
	//Trata o xsl para gerar o html
	$xml = new DOMDocument();
	$xml->load($tmpxml);

	$xsl = new DOMDocument();
	$xsl->load('sip.xsl');

	$proc = new XSLTProcessor;
	$proc->importStyleSheet($xsl);

	$aux = $proc->transformToXML($xml);
	
	$aux = str_replace("</head>", "<script type=\"text/javascript\">setTimeout(function () {
            document.location = \"download.php?file=".urlencode($file)."&tmpxml=".urlencode($tmpxml)."&id=".$nvs['id']."\";
        }, 1000);</script></head>",$aux);
	
	$aux = str_replace("<html>", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE html SYSTEM \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">", $aux);

	echo $aux;
    function mostra($fp, $obr, $nvs, $x, $nx=""){
        if ($nx == "") $nx = $x;
        if (empty($nvs[$nx]) && $obr) die ('Missing field '. $x . "($nx)"); 
        if (!empty($nvs[$nx])) $fp->addChild($x, $nvs[$nx]);  
    }

    function trata($arr){
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
?>
