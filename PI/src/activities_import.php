<?php
	session_start();	
	require_once('bd.php');
    require_once('myXPath.php');
	if (!isset($_FILES['ficheiro'])){
		echo "<html><head></head>
		<body>
		<form method=\"post\" action=\"activities_import.php\" enctype=\"multipart/form-data\">
            <fieldset>
                <legend>Activities:</legend> 
                <input type='file' name='ficheiro'/>
			</fieldset>
			<input type=\"submit\" name=\"Enviar\"/>
		</form>
		</body></html>";
		return;
	}

    
    $aux = parseFile(file_get_contents($_FILES['ficheiro']['tmp_name']));
    if (isset($aux[':erro']) && $aux[':erro'] != "") {
        echo $aux[':msg'].'(code: '.$aux[':code'].', line:'.$aux[':line'].")<br/>\n";
        exit(0);
    }
    
    //var_dump($aux);
    
    
    insereDB($aux);
    
    
    
    
    function parseFile($tmpxml){
        $xml = new DOMDocument();    
        $xml->loadXML($tmpxml);
        
        libxml_use_internal_errors(true);
        if (!$xml->schemaValidate('activities.xsd')){
			$arr = libxml_get_errors();
            $error = (isset($arr[0]) ? $arr[0] : new libXMLError());
            return array(':erro' => "ERR_SIP_SCHEMA", ':msg' => $error->message, ':code' => $error->code, ':line' => $error->line);
        }
        $info = array();
        
        $xpath = new myXPath($xml);
        $aux = $xpath->query("/activities/activity");
        foreach($aux as $node){
            $activity = array();
            $activity['key'] = $xpath->queryValue('@key', $node);
            $activity['institution'] = trataOrganismo($xpath, 'institution', $node);
            $activity['begin_date'] = $xpath->queryValue('begin_date', $node);
            $activity['end_date'] = $xpath->queryValue('end_date', $node);
            $activity['description'] = $xpath->queryValue('description', $node, '');
            $activity['partners'] = $xpath->queryValue('partners/partner', $node);
            
            //Tipos de actividades
            $act = array('conference',
                        'internship' , 
                        'phd_monitoring',
                        'msc_monitoring',
                        'other',
                );
            foreach($act as $valor){
                $nn = $xpath->queryValue($valor, $node, myXPath::RES);
                if ($nn->length > 0) {
                    $nn = $nn->item(0);
                    $activity['activity'] = $xpath->recQueryToArray('*', $nn);
                    $activity['activity']['__type'] = $nn->localName;
                    $activity['activity']['__xml'] = $xml->saveXML($nn);
                } 
            }
                
            
            $info[] = $activity;
        }
        return $info;
    }
    
    
    
    function trataOrganismo($xpath, $query, $node){
        $root = $query.'/org';
        if ($xpath->queryValue($root, $node) === null) return null;
        $root .= '/';
        $aux = array();
        $aux['type'] = $xpath->queryValue( $root.'@type', $node);
        $aux['name'] = $xpath->queryValue( $root.'name', $node);
        $aux['address'] = $xpath->queryValue( $root.'address', $node);
        $aux['country'] = $xpath->queryValue( $root.'country', $node);
        return $aux;
    }
    
    function trataNomes($lista){
        $ret = array();
        $ret['upartners'] = array();
        $ret['npartners'] = $lista;
        return $ret;
        foreach($lista as $valor){
            $f = (popen('perl fnames.pl -s "'.$valor.'" -p', "r"));
            $valor = "";
            while (!feof($f)) {$valor .= fread($f, 60);}
            fclose($f);
            $aux = explode("\t");
            if (count($aux) > 1 && $aux[1] > 0.75)
                $ret['upartenrs'][] = trim($aux[0]);
            else
                $ret['npartenrs'][] = trim($valor);
        }
        return $ret;
    }
    
    function getInst($db, $info){
        $query = $db->prepare("SELECT id FROM institutions WHERE name = :name LIMIT 1");
        $query->bindValue(':name', $info['name']);
        $query->execute();
        $arr = $query->fetchAll();
        if (count($arr) > 0)
            return (int) $arr[0]['id'];
        else {
            $query = $db->prepare("INSERT INTO institutions VALUES (null, :name, :address, :country, :type)");
            $query->bindValue(':name', $info['name'], PDO::PARAM_STR);
            $query->bindValue(':address', $info['address'], PDO::PARAM_STR);
            $query->bindValue(':country', $info['country'], PDO::PARAM_STR);
            $query->bindValue(':type', $info['type'], PDO::PARAM_INT);
            $query->execute();
            
            return $db->lastInsertId();
            
        }
    }
    
    function insereDB($infos){
        $db = new myDB();    

		foreach($infos as $chave => $info){

		    $inst = getInst($db, $info['institution']);
		    
		    $db->beginTransaction();
		    $query = $db->prepare("INSERT INTO activities VALUES(null, :key, :begin, :end, :inst, :description, :type, :info)");
		    $query->bindValue(':key', $info['key'], PDO::PARAM_STR);
		    $query->bindValue(':begin', $info['begin_date'], PDO::PARAM_STR);
		    $query->bindValue(':end', $info['end_date'], PDO::PARAM_STR);
		    $query->bindValue(':inst', $inst, PDO::PARAM_INT);
		    $query->bindValue(':description', $info['description'], PDO::PARAM_STR);
		    $query->bindValue(':type', $info['activity']['__type'], PDO::PARAM_STR);
		    $query->bindValue(':info', $info['activity']['__xml'], PDO::PARAM_STR);
		    $db->executeOrDie($query);
		    
		    $act = $db->lastInsertId();
		    
		    $aux = trataNomes($info['partners']);
		    $aux['upartners'][] = $_SESSION['id'];
		    $query = $db->prepare("INSERT INTO users_activities VALUES(:act, (SELECT id FROM info WHERE name = :name))");
		    foreach($aux['upartenrs'] as $valor){
		        $query->bindValue(':act', $act, PDO::PARAM_INT);
		        $query->bindValue(':name', $valor, PDO::PARAM_STR);
		        $db->executeOrDie($query);
		        $query->closeCursor();
		    }
		    
		    
		    $query = $db->prepare("INSERT INTO nonusers_activities VALUES(:act, :name)");
		    foreach($aux['npartenrs'] as $valor){
		        $query->bindValue(':act', $act, PDO::PARAM_INT);
		        $query->bindValue(':name', $valor, PDO::PARAM_STR);
		        $db->executeOrDie($query);
		        $query->closeCursor();
		    }
		    
		  
		    $db->commit();
        }
    }
    
    
?>
