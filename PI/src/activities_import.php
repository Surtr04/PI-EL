<?php
	require_once('bd.php');
    class myXPath extends DOMXPath{
        const RES = 'RETURNRES';
        public function queryValue($query, $node = null, $default = null){
            $res = $this->query($query, $node);
            if ($default === self::RES) return $res;
            if ($res === false || $res->length < 1){
                $aux = $default;
            }else if ($res->length > 1){
                $aux = array();
                foreach($res as $valor)
                    $aux[] = $valor->textContent;
            }else{
                $aux = $res->item(0)->textContent;
            }
            return $aux;
        }
        public function recQueryToArray($query, $node){
            $arr = array();
            $res = $this->query($query, $node);
            if ($res === false || $res->length <= 0) return false;
            foreach($res as $chave => $valor) {
                $aux = $this->recQueryToArray($query, $valor);
                if ($aux === false)
                    $arr[$valor->localName]['__text'] = $valor->textContent;
                else 
                    $arr[$valor->localName] = $aux;
                if ($valor->hasAttributes()){
                    $arr[$valor->localName]['__atributes'] = array();
                    $length = $valor->attributes->length;
                    for ($i = 0; $i < $length; ++$i) {
                        $atr = $valor->attributes->item($i);
                        $arr[$valor->localName]['__atributes'][$atr->name] = $atr->value;  
                    }
                }
            }
            return $arr;
        }
    }
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
    
    var_dump($aux);
    
    die();
    insereDB($aux);
    
    
    
    
    function parseFile($tmpxml){
        $xml = new DOMDocument();    
        $xml->loadXML($tmpxml);
        
        libxml_use_internal_errors(true);
        if (!$xml->schemaValidate('activities.xsd')){
            $error = Arr::get(libxml_get_errors(), 0, new libXMLError());
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
            $query->bindValue(':key', $info['name'], PDO::PARAM_STR);
            $query->bindValue(':address', $info['address'], PDO::PARAM_STR);
            $query->bindValue(':country', $info['country'], PDO::PARAM_STR);
            $query->bindValue(':type', $info['type'], PDO::PARAM_INT);
            $query->execute();
            
            return $db->lastInsertId();
            
        }
    }
    
    function insereDB($info){
        $db = new myDB();    
        
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
        
        $query = $db->prepare("INSERT INTO activities_info VALUES(:act, :key, :value)");
        foreach($aux['npartenrs'] as $valor){
            $query->bindValue(':act', $act, PDO::PARAM_INT);
            $query->bindValue(':key', $valor, PDO::PARAM_STR);
            $query->bindValue(':value', $valor, PDO::PARAM_STR);
        }
        
        $db->commit();
        
    }
    
    
?>
