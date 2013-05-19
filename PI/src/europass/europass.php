<?php
	session_start();	
	require_once('../bd.php');
    require_once('../myXPath.php');
    define('DEBUG', 0);
    
	
	
    $nvs = getInfos($_SESSION['id']);
    
	$xml = new DOMDocument("1.0", "UTF-8");
    $xml->formatOutput = true;
    //<SkillsPassport xmlns="http://europass.cedefop.europa.eu/Europass" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://europass.cedefop.europa.eu/Europass http://europass.cedefop.europa.eu/xml/EuropassSchema_V3.0.xsd" locale="en">
	$sk = $xml->createElement("SkillsPassport");
    $sk->setAttribute("xmlns", "http://europass.cedefop.europa.eu/Europass");
    $sk->setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    $sk->setAttribute("xsi:schemaLocation", "http://europass.cedefop.europa.eu/Europass http://europass.cedefop.europa.eu/xml/EuropassSchema_V3.0.xsd");
    $sk->setAttribute("locale", "pt");
    $xml->appendChild($sk);
    
    
    //DocumentInfo
    $di = $xml->createElement("DocumentInfo");
    $today = new DateTime();
    //Example: 2013-05-08T12:09:50.203Z
    $today = $today->format("Y-m-d\Th:i:sP");
    //$today = $today->format("c");
    $arr = array("DocumentType" => "ECV", "CreationDate" => $today, "LastUpdateDate" => $today, "XSDVersion" => "3.0", "Generator" => "GereCVs", "Comment" => "Europass CV");
    foreach($arr as $chave => $valor)
        $di->appendChild($xml->createElement($chave, $valor));
    
    $sk->appendChild($di);
    
    //PrintingPreferences
    $pp = $xml->createElement("PrintingPreferences");
    $di = $xml->createElement("Document");
    $fields = array(
            createField("LearnerInfo", true, "Identification Headline Education Skills WorkExperience Achievement ReferenceTo"),
            createField("LearnerInfo.Identification"),
            createField("LearnerInfo.Identification.PersonName", true, "FirstName Surname"),
            createField("LearnerInfo.Identification.ContactInfo.Address", false, null, "s, z m (c)"),
            createField("LearnerInfo.Identification.ContactInfo.Email"),
            createField("LearnerInfo.Identification.ContactInfo.Email[0]"),
            createField("LearnerInfo.Identification.ContactInfo.Telephone"),
            createField("LearnerInfo.Identification.ContactInfo.Telephone[0]"),
            createField("LearnerInfo.Identification.ContactInfo.Telephone[1]"),
            createField("LearnerInfo.Identification.ContactInfo.Website"),
            createField("LearnerInfo.Identification.ContactInfo.Website[0]"),
            createField("LearnerInfo.Identification.Demographics.Birthdate", true, null, "text/long"),
            createField("LearnerInfo.Identification.Demographics.Gender"),
            createField("LearnerInfo.Identification.Demographics.Nationality"),
            createField("LearnerInfo.Identification.Demographics.Nationality[0]"),
            createField("LearnerInfo.Identification.Demographics.Nationality[1]"),
            createField("LearnerInfo.Identification.Photo", (isset($nvs['photo']))),
            createField("LearnerInfo.Headline", false),
        );
    
	
	$fields[] = createField("LearnerInfo.Headline", false);
    $fields[] = createField("LearnerInfo.Education");
    foreach($nvs['Formations'] as $chave => $valor){
        $name = "LearnerInfo.Education[".$chave."]";
        $fields[] = createField($name);
        $fields[] = createField($name.".Period", true, null, "text/long");
        $fields[] = createField($name.".ReferenceTo", false);
        $fields[] = createField($name.".Title", true, null, "text/long");
        $fields[] = createField($name.".Activities");
        $fields[] = createField($name.".Organisation");
        $fields[] = createField($name.".Organisation.ContactInfo.Address", true, null, "s,m z c");
        $fields[] = createField($name.".Level");
        $fields[] = createField($name.".Field", false);
        
    }
    
    $fields[] = createField("LearnerInfo.Skills");
	$fields[] = createField("LearnerInfo.Skills.Linguistic.MotherTongue");
    $i = 0;
	foreach($nvs['Natlangs'] as $chave => $valor)
		$fields[] = createField("LearnerInfo.Skills.Linguistic.MotherTongue[".$i++."]");
    $fields[] = createField("LearnerInfo.Skills.Linguistic.ForeignLanguage", false);
    $fields[] = createField("LearnerInfo.Skills.Communication", false);
    $fields[] = createField("LearnerInfo.Skills.Organisational", false);
    $fields[] = createField("LearnerInfo.Skills.JobRelated", false);
    $fields[] = createField("LearnerInfo.Skills.Computer", false);
    $fields[] = createField("LearnerInfo.Skills.Driving", false);
    $fields[] = createField("LearnerInfo.Skills.Other", false);
    
    $fields[] = createField("LearnerInfo.WorkExperience");
    foreach($nvs['Activities'] as $chave => $valor){
        $name = "LearnerInfo.WorkExperience[".$chave."]";
        $fields[] = createField($name);
        $fields[] = createField($name.".Period", true, null, "text/long");
        $fields[] = createField($name.".ReferenceTo", false);
        $fields[] = createField($name.".Position");
        $fields[] = createField($name.".Activities");
        $fields[] = createField($name.".Employer");
        $fields[] = createField($name.".Employer.ContactInfo.Address", true, null, "s, z m (c)");
        $fields[] = createField($name.".Employer.Sector", true);
        
    }
    
    $fields[] = createField("LearnerInfo.Achievement");
    foreach($nvs['Publications'] as $chave => $valor){
        $name = "LearnerInfo.Achievement[".$chave."]";
        $fields[] = createField($name);
        $fields[] = createField($name.".ReferenceTo", false);
    }
    
    foreach($fields as $chave => $valor)
        addField($xml, $di, $valor);
      
    $di->setAttribute("type", "ECV");
    
    $pp->appendChild($di);
    $sk->appendChild($pp);
    
    //LearnerInfo
    $li = $xml->createElement("LearnerInfo");
    $ident = $xml->createElement("Identification");
    
    //PersonName
    $node = $xml->createElement("PersonName");
    $node->appendChild($xml->createElement("FirstName", $nvs["FirstName"]));
    $node->appendChild($xml->createElement("Surname", $nvs["Surname"]));
    $ident->appendChild($node);
    
    
    //ContactInfo
    $ci = $xml->createElement("ContactInfo");
    $node = $xml->createElement("Email");
    $node->appendChild($xml->createElement('Contact', $nvs['email']));
    $ci->appendChild($node);
    
    $arr = array("Website" => "website", "Telephone"=>"telephone");
    foreach($arr as $c => $v){
        $lst = $xml->createElement($c."List");
        foreach($nvs['Contacts'][$v] as $chave => $valor){
            $node = $xml->createElement($c);
            $node->appendChild($xml->createElement('Contact', $valor));
            $lst->appendChild($node);
        }
        $ci->appendChild($lst);
    }
    $ident->appendChild($ci);
    
    //Demographics
    $de = $xml->createElement("Demographics");
    $node = $xml->createElement("Birthdate");
    $node->setAttribute("year", $nvs['birthdate']['year']);
    $node->setAttribute("month", '--'.$nvs['birthdate']['month']);
    $node->setAttribute("day", '---'.$nvs['birthdate']['day']);
    $de->appendChild($node);
    
    $node = $xml->createElement("Gender");
    codeAndLabel($xml, $node, $nvs['Gender'], ($nvs['Gender'] == "M" ? "Masculino" : "Feminino"));
    $de->appendChild($node);
    
    
    $lst = $xml->createElement("NationalityList");
    foreach($nvs['Nationalitys'] as $chave => $valor){
        $node = $xml->createElement("Nationality");
        codeAndLabel($xml, $node, $chave, $valor);
        $lst->appendChild($node);
    }
    $de->appendChild($lst);
    
    $ident->appendChild($de);
	
	
	if (isset($nvs['photo'])){
		$ph = $xml->createElement("Photo");
		$ph->appendChild($xml->createElement("MimeType", $nvs['photo']['mt']));
		$ph->appendChild($xml->createElement("Data", $nvs['photo']['data']));
		$lst = $xml->createElement("MetadataList");
		$node = $xml->createElement("Metadata");
		$node->setAttribute('key', 'dimension');
		$node->setAttribute('value', $nvs['photo']['dimension']);
		$lst->appendChild($node);
		$node = $xml->createElement("Metadata");
		$node->setAttribute('key', 'number-of-pages');
		$node->setAttribute('value', $nvs['photo']['numpages']);
		$lst->appendChild($node);
		$ph->appendChild($lst);
		$ident->appendChild($ph);
	}
	
    $li->appendChild($ident);
    
    
    $li->appendChild(buildFormations($xml, $nvs['Formations']));
	
	$skills = $xml->createElement("Skills");
		$ling = $xml->createElement("Linguistic");
			$lst = $xml->createElement("MotherTongueList");
				foreach($nvs['Natlangs'] as $chave => $valor){
					$node = $xml->createElement("MotherTongue");
					$node->appendChild(codeAndLabel($xml, $xml->createElement("Description"), $chave, $valor));
				}
			$lst->appendChild($node);
		$ling->appendChild($lst);
	$skills->appendChild($ling);
	$li->appendChild($skills);
	
    $li->appendChild(buildActivities($xml, $nvs['Activities']));
    $li->appendChild(buildPublications($xml, $nvs['Publications']));
    
    
    $sk->appendChild($li);
    
	if ($_GET['t'] == 'pdf'){
		if (!DEBUG){
			header('Content-type: application/pdf');
			header('Content-Disposition: attachment; filename="myeuropasscv.pdf"');
		}
		echo requestRestPDF($xml); 
	} else
		if (!DEBUG){
			header('Content-type: application/xml');
			header('Content-Disposition: attachment; filename="myeuropasscv.xml"');
		}
		echo $xml->saveXML(); 
    
    function makePeriod(DOMDocument $xml, $from, $to){
        $p = $xml->createElement("Period");
        $node = $xml->createElement("From");
        foreach($from as $chave => $valor)
            testSetAtt($node, $from, $chave);
        $p->appendChild($node);
        
        $node = $xml->createElement("To");
        foreach($to as $chave => $valor)
            testSetAtt($node, $to, $chave);
        $p->appendChild($node);
        
        $p->appendChild($xml->createElement("Current", "false"));
        return $p;
    }
    function testSetAtt($node, $from, $chave){
        if (!isset($from[$chave]) || $from[$chave] == null || $from[$chave] == "") return;
        $value = $from[$chave];
        switch($chave){
            case 'month': $value = '--'.$value;break;
            case 'day' : $value = '---'.$value; break;
        }
         $node->setAttribute($chave, $value);
    }
    function buildFormations(DOMDocument $xml, $forms){
        $lst = $xml->createElement("EducationList");
        foreach($forms as $chave => $valor){
            $node = $xml->createElement("Education");
            $node->appendChild(makePeriod($xml, $valor['from'], $valor['to']));
            
            $node->appendChild($xml->createElement("Title", $valor['title']));
            $node->appendChild(makeOrg($xml, 'Organisation', $valor['org']));
            $node->appendChild(codeAndLabel($xml, $xml->createElement("Level"), null, $valor['level']));
            $lst->appendChild($node);
        }
        return $lst;
    }
        
    function buildActivities(DOMDocument $xml, $acts){
        $lst = $xml->createElement("WorkExperienceList");
        foreach($acts as $chave => $valor){
            $node = $xml->createElement("WorkExperience");
            $node->appendChild(makePeriod($xml, $valor['from'], $valor['to']));
            
            $node->appendChild(codeAndLabel($xml, $xml->createElement("Position"), null, $valor['label']));
            $node->appendChild($xml->createElement("Activities", $valor['description']));
            $node->appendChild(makeOrg($xml, 'Employer', $valor['org']));
            $lst->appendChild($node);
        }
        return $lst;
    }
        
    function buildPublications(DOMDocument $xml, $pubs){
         $lst = $xml->createElement("AchievementList");
         foreach($pubs as $chave => $valor){
             $node = $xml->createElement("Achievement");
             $node->appendChild(codeAndLabel($xml, $xml->createElement("Title"), $valor['code'], $valor['label']));
             $node->appendChild($xml->createElement("Description", $valor['description']));
             $lst->appendChild($node);
         }
         return $lst;
    }
    
    function makeOrg(DOMDocument $xml, $name, $info){
        $org = $xml->createElement($name);
        $org->appendChild($xml->createElement("Name", $info['name']));
            $ci = $xml->createElement("ContactInfo");
                $add = $xml->createElement("Address");
                    $con = $xml->createElement("Contact");
                    $con->appendChild($xml->createElement("Municipality",$info['address']));
                    $con->appendChild(codeAndLabel($xml, $xml->createElement("Country"), $info['code'], $info['label']));
                $add->appendChild($con);
            $ci->appendChild($add);
        $org->appendChild($ci);
        return $org;
    }
    
    function codeAndLabel(DOMDocument $xml,$node, $code = null, $label = null){
        if ($code != null) $node->appendChild($xml->createElement("Code", $code));
        if ($label != null) $node->appendChild($xml->createElement("Label", $label));
        return $node;
    }
    function createField($name, $show = true, $order = null, $format = null){
        $arr = array("name" => $name, "show" => $show);
        if ($order != null) $arr["order"] = $order;
        if ($format != null) $arr["format"] = $format;
        return $arr;
    }
    function addField($xml, $parent, $args = array()){
        $node = $xml->createElement("Field");
        foreach($args as $chave => $valor)
            if (is_bool ($valor)) $node->setAttribute($chave, ($valor ? "true" : "false")); else $node->setAttribute($chave, $valor);
        $parent->appendChild($node);
    }
    
    function toFancyHTML($txt){
        $txt = htmlentities($txt);
        $txt = str_replace(" ", "&nbsp;&nbsp;", $txt);
        $txt = nl2br($txt);
        return $txt;
    }
    
    
    function requestRestPDF($xml){
        $file = tempnam('tmp', 'eur');
        $output = $xml->saveXML();
		
		//if( $initialEncoding != 'UTF-8' )
			//mb_convert_encoding($output, 'ASCII', 'UTF-8');
		file_put_contents($file, $output);
		file_put_contents('europass.xml', $output);
		/*$xml->save($file);
        $output = $xml->save('europass.xml');*/
        
        $site = (DEBUG ? "http://localhost/alldump.php" : "https://europass.cedefop.europa.eu/rest/document/to/pdf");
        $ch = curl_init($site);
        $data = file_get_contents($file);//'@'.$file;
        curl_setopt($ch, CURLOPT_URL, $site);
        curl_setopt($ch, CURLOPT_SSLVERSION,3);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
        curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 2); 
        curl_setopt($ch, CURLOPT_USERAGENT, "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)"); 
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-type: application/xml', 'Accept: application/pdf', 'Accept-Language:pt'));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

        $aux = curl_exec($ch);
		unlink($file);
        return $aux;
    }
    
    //Já não é necessária
    function transform2JSON(DOMDocument $xml, $name = "", $fields = array()){
        $ret = array();
        $xpath = new myXPath($xml);
        $ret["SkillsPassport"] = array(
            "Locale" => "pt", 
            "PrintingPreferences" => array($name => $fields), 
            "DocumentInfo" => simplexml_load_string($xml->saveXML($xml->getElementsByTagName('DocumentInfo')->item(0))),
            "LearnerInfo" => array("Identification" =>  array(
                                    "PersonName" => simplexml_load_string($xml->saveXML($xpath->queryValue("//LearnerInfo/Identification/PersonName", null, myXPath::RES)->item(0))),
                                    "ContactInfo" => array("Email" => simplexml_load_string($xml->saveXML($xpath->queryValue("//LearnerInfo/Identification/ContactInfo/Email", null, myXPath::RES)->item(0)))),
                                    "Demographics" => array("Gender" => "M", "Birthdate" => "", "Nationality" => array()),
                                )),
                            //array("Identification" => array("PersonName" => array("FirstName" => $xpath->queryValue("//Identification/PersonName/FirstName"), "FirstName" => $xpath->queryValue("//Identification/PersonName/SurName") )) ),
            "type" => "_cv"
            );
        
        $arr = array("Telephone", "Website");
        foreach($arr as $v){
            foreach($xpath->queryValue("//LearnerInfo/Identification/ContactInfo/".$v."List/".$v, null, myXPath::RES) as $chave => $valor){
                $ret["SkillsPassport"]["LearnerInfo"]["Identification"]["ContactInfo"][$v][] = array("Contact" => $valor->textContent);
            }
        }
        $aux = json_encode($ret);
        //$aux = str_replace('"ContactInfo":[]', '"ContactInfo":{"Telephone":[{"Use":{"Code":"home","Label":"Casa"},"Contact":"236532","index":0,"current_pref_item":{"show":true}},{"Use":{"Code":"mobile","Label":"TelemÃ³vel"},"Contact":"213454354876","index":1,"current_pref_item":{"show":true}}],"Email":{"Contact":"sdfsdfsdf@asdsdfsdf"},"Website":[{"Contact":"sdfsffsdfsdfdsf","index":0,"current_pref_item":{"show":true}}]}', $aux);
        return $aux;
    }
    
    //Já não é necessária
    function sendJSON(DOMDocument $xml, $name = "", $fields = array()){
        
        
        $transformed = transform2JSON($xml, $name, $fields);
        
        //echo $transformed;
        
        /*$data = json_encode(simplexml_load_string($xml->saveXML()));
        $search = '"PrintingPreferences":{';
        $data = str_replace($search, $search.'"'.$name.'":'.json_encode($fields)."," , $data);
        $data = str_replace('"TelephoneList":{', '"Telephone":{', $data);
        $data = str_replace('"EmailList":{', '"Email":{', $data);
        $data = str_replace('"WebsiteList":{', '"Website":{', $data);*/
        
        /*var_dump($data);
        die();*/
        
        //$data = 'json=%7B%22SkillsPassport%22%3A%7B%22Locale%22%3A%22pt%22%2C%22PrintingPreferences%22%3A%7B%22ECV%22%3A%5B%7B%22name%22%3A%22LearnerInfo%22%2C%22show%22%3Atrue%2C%22order%22%3A%22Identification+Headline+WorkExperience+Education+Skills+Achievement+ReferenceTo%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.PersonName%22%2C%22show%22%3Atrue%2C%22order%22%3A%22FirstName+Surname%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Address%22%2C%22show%22%3Atrue%2C%22format%22%3A%22s%2C+z+m+(c)%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Telephone%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Telephone%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Telephone%5B1%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Email%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Website%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.Website%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.InstantMessaging%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.ContactInfo.InstantMessaging%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.Demographics.Gender%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.Demographics.Birthdate%22%2C%22show%22%3Afalse%2C%22format%22%3A%22text%2Flong%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.Demographics.Nationality%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.Demographics.Nationality%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Identification.Photo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Headline%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Period%22%2C%22show%22%3Atrue%2C%22format%22%3A%22text%2Flong%22%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Position%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Activities%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Employer%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Employer.ContactInfo.Address%22%2C%22show%22%3Afalse%2C%22format%22%3A%22s%2C+z+m+(c)%22%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Employer.ContactInfo.Website%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.Employer.Sector%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.WorkExperience%5B0%5D.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Period%22%2C%22show%22%3Atrue%2C%22format%22%3A%22text%2Flong%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Title%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Activities%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Organisation%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Organisation.ContactInfo.Address%22%2C%22show%22%3Afalse%2C%22format%22%3A%22s%2C+z+m+(c)%22%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Level%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.Field%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Education%5B0%5D.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.MotherTongue%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.MotherTongue%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%5B0%5D%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%5B0%5D.Certificate%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%5B0%5D.Certificate%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%5B0%5D.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Linguistic.ForeignLanguage%5B0%5D.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Communication%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Communication.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Communication.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Organisational%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Organisational.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Organisational.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.JobRelated%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.JobRelated.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.JobRelated.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Computer%22%2C%22show%22%3Atrue%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Computer.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Computer.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Driving%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Driving.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Driving.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Other%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Other.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Skills.Other.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Achievement%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Achievement%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Achievement%5B0%5D.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.Achievement%5B0%5D.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.ReferenceTo%22%2C%22show%22%3Afalse%7D%2C%7B%22name%22%3A%22LearnerInfo.ReferenceTo%5B0%5D%22%2C%22show%22%3Afalse%7D%5D%7D%2C%22DocumentInfo%22%3A%7B%22DocumentType%22%3A%22ECV%22%2C%22CreationDate%22%3A%222013-05-09T10%3A05%3A20.218Z%22%2C%22LastUpdateDate%22%3A%222013-05-09T10%3A05%3A20.218Z%22%2C%22XSDVersion%22%3A%22V3.0%22%2C%22Generator%22%3A%22EWA%22%2C%22Comment%22%3A%22Europass+CV%22%7D%2C%22LearnerInfo%22%3A%7B%22Identification%22%3A%7B%22PersonName%22%3A%7B%22FirstName%22%3A%22fdgwer%22%2C%22Surname%22%3A%22sffdsdfs%22%7D%2C%22ContactInfo%22%3A%7B%22Address%22%3A%7B%22Contact%22%3A%7B%22AddressLine%22%3A%22sfsdf%22%2C%22PostalCode%22%3A%22487112%22%2C%22Municipality%22%3A%22sdfsd%22%2C%22Country%22%3A%7B%22Label%22%3A%22Alb%C3%A2nia%22%2C%22Code%22%3A%22AL%22%7D%7D%7D%2C%22Telephone%22%3A%5B%7B%22Use%22%3A%7B%22Code%22%3A%22home%22%2C%22Label%22%3A%22Casa%22%7D%2C%22Contact%22%3A%22236532%22%2C%22index%22%3A0%2C%22current_pref_item%22%3A%7B%22show%22%3Atrue%7D%7D%2C%7B%22Use%22%3A%7B%22Code%22%3A%22mobile%22%2C%22Label%22%3A%22Telem%C3%B3vel%22%7D%2C%22Contact%22%3A%22213454354876%22%2C%22index%22%3A1%2C%22current_pref_item%22%3A%7B%22show%22%3Atrue%7D%7D%5D%2C%22Email%22%3A%7B%22Contact%22%3A%22sdfsdfsdf%40asdsdfsdf%22%7D%2C%22Website%22%3A%5B%7B%22Contact%22%3A%22httpdbbxptopcom%22%2C%22index%22%3A0%2C%22current_pref_item%22%3A%7B%22show%22%3Atrue%7D%7D%5D%7D%7D%7D%2C%22type%22%3A%22_cv%22%7D%7D';
    
        //$data = '{"SkillsPassport": {	"Locale": "pt",	"PrintingPreferences": {	"ECV": [{	"name": "LearnerInfo",	"show": true,	"order": "Identification Headline WorkExperience Education Skills Achievement ReferenceTo"	},	{	"name": "LearnerInfo.Identification",	"show": true	},	{	"name": "LearnerInfo.Identification.PersonName",	"show": true,	"order": "FirstName Surname"	},	{	"name": "LearnerInfo.Identification.ContactInfo.Address",	"show": true,	"format": "s, z m (c)"	},	{	"name": "LearnerInfo.Identification.ContactInfo.Telephone",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.Telephone[0]",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.Telephone[1]",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.Email",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.Website",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.Website[0]",	"show": true	},	{	"name": "LearnerInfo.Identification.ContactInfo.InstantMessaging",	"show": false	},	{	"name": "LearnerInfo.Identification.ContactInfo.InstantMessaging[0]",	"show": false	},	{	"name": "LearnerInfo.Identification.Demographics.Gender",	"show": false	},	{	"name": "LearnerInfo.Identification.Demographics.Birthdate",	"show": false,	"format": "text/long"	},	{	"name": "LearnerInfo.Identification.Demographics.Nationality",	"show": false	},	{	"name": "LearnerInfo.Identification.Demographics.Nationality[0]",	"show": false	},	{	"name": "LearnerInfo.Identification.Photo",	"show": false	},	{	"name": "LearnerInfo.Headline",	"show": true	},	{	"name": "LearnerInfo.WorkExperience",	"show": true	},	{	"name": "LearnerInfo.WorkExperience[0]",	"show": true	},	{	"name": "LearnerInfo.WorkExperience[0].Period",	"show": true,	"format": "text/long"	},	{	"name": "LearnerInfo.WorkExperience[0].Position",	"show": true	},	{	"name": "LearnerInfo.WorkExperience[0].Activities",	"show": true	},	{	"name": "LearnerInfo.WorkExperience[0].Employer",	"show": false	},	{	"name": "LearnerInfo.WorkExperience[0].Employer.ContactInfo.Address",	"show": false,	"format": "s, z m (c)"	},	{	"name": "LearnerInfo.WorkExperience[0].Employer.ContactInfo.Website",	"show": false	},	{	"name": "LearnerInfo.WorkExperience[0].Employer.Sector",	"show": false	},	{	"name": "LearnerInfo.WorkExperience[0].ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.WorkExperience[0].ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Education",	"show": true	},	{	"name": "LearnerInfo.Education[0]",	"show": true	},	{	"name": "LearnerInfo.Education[0].Period",	"show": true,	"format": "text/long"	},	{	"name": "LearnerInfo.Education[0].Title",	"show": true	},	{	"name": "LearnerInfo.Education[0].Activities",	"show": true	},	{	"name": "LearnerInfo.Education[0].Organisation",	"show": false	},	{	"name": "LearnerInfo.Education[0].Organisation.ContactInfo.Address",	"show": false,	"format": "s, z m (c)"	},	{	"name": "LearnerInfo.Education[0].Level",	"show": false	},	{	"name": "LearnerInfo.Education[0].Field",	"show": false	},	{	"name": "LearnerInfo.Education[0].ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Education[0].ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills",	"show": true	},	{	"name": "LearnerInfo.Skills.Linguistic.MotherTongue",	"show": true	},	{	"name": "LearnerInfo.Skills.Linguistic.MotherTongue[0]",	"show": true	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage",	"show": true	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage[0]",	"show": true	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage[0].Certificate",	"show": false	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage[0].Certificate[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage[0].ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Linguistic.ForeignLanguage[0].ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Communication",	"show": true	},	{	"name": "LearnerInfo.Skills.Communication.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Communication.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Organisational",	"show": true	},	{	"name": "LearnerInfo.Skills.Organisational.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Organisational.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.JobRelated",	"show": true	},	{	"name": "LearnerInfo.Skills.JobRelated.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.JobRelated.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Computer",	"show": true	},	{	"name": "LearnerInfo.Skills.Computer.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Computer.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Driving",	"show": false	},	{	"name": "LearnerInfo.Skills.Driving.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Driving.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Skills.Other",	"show": false	},	{	"name": "LearnerInfo.Skills.Other.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Skills.Other.ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.Achievement",	"show": false	},	{	"name": "LearnerInfo.Achievement[0]",	"show": false	},	{	"name": "LearnerInfo.Achievement[0].ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.Achievement[0].ReferenceTo[0]",	"show": false	},	{	"name": "LearnerInfo.ReferenceTo",	"show": false	},	{	"name": "LearnerInfo.ReferenceTo[0]",	"show": false	}]	},	"DocumentInfo": {	"DocumentType": "ECV",	"CreationDate": "2013-05-09T10:05:20.218+01:00",	"LastUpdateDate": "2013-05-09T10:05:20.218+01:00",	"XSDVersion": "V3.0",	"Generator": "EWA",	"Comment": "Europass CV"	},	"LearnerInfo": {	"Identification": {	"PersonName": {	"FirstName": "fdgwer",	"Surname": "sffdsdfs"	},	"ContactInfo": {	"Address": {	"Contact": {	"AddressLine": "sfsdf",	"PostalCode": "487112",	"Municipality": "sdfsd",	"Country": {	"Label": "Albânia",	"Code": "AL"	}	}	},	"Telephone": [],	"Email": {	"Contact": "sdfsdfsdf@asdsdfsdf"	},	"Website": [{	"Contact": "sdfsffsdfsdfdsf",	"index": 0,	"current_pref_item": {	"show": true	}	}]	}	}	},	"type": "_cv" 	} }';
        
        $data = '{"SkillsPassport":{"Locale":"pt","PrintingPreferences":{"ECV":[{"name":"LearnerInfo","show":true,"order":"Identification Headline WorkExperience Education Skills Achievement ReferenceTo"},{"name":"LearnerInfo.Identification","show":true},{"name":"LearnerInfo.Identification.PersonName","show":true,"order":"FirstName Surname"},{"name":"LearnerInfo.Identification.ContactInfo.Address","show":true,"format":"s, z m (c)"},{"name":"LearnerInfo.Identification.ContactInfo.Telephone","show":true},{"name":"LearnerInfo.Identification.ContactInfo.Telephone[0]","show":true},{"name":"LearnerInfo.Identification.ContactInfo.Telephone[1]","show":true},{"name":"LearnerInfo.Identification.ContactInfo.Email","show":true},{"name":"LearnerInfo.Identification.ContactInfo.Website","show":true},{"name":"LearnerInfo.Identification.ContactInfo.Website[0]","show":true},{"name":"LearnerInfo.Identification.ContactInfo.InstantMessaging","show":false},{"name":"LearnerInfo.Identification.ContactInfo.InstantMessaging[0]","show":false},{"name":"LearnerInfo.Identification.Demographics.Gender","show":false},{"name":"LearnerInfo.Identification.Demographics.Birthdate","show":false,"format":"text/long"},{"name":"LearnerInfo.Identification.Demographics.Nationality","show":false},{"name":"LearnerInfo.Identification.Demographics.Nationality[0]","show":false},{"name":"LearnerInfo.Identification.Photo","show":false},{"name":"LearnerInfo.Headline","show":true},{"name":"LearnerInfo.WorkExperience","show":true},{"name":"LearnerInfo.WorkExperience[0]","show":true},{"name":"LearnerInfo.WorkExperience[0].Period","show":true,"format":"text/long"},{"name":"LearnerInfo.WorkExperience[0].Position","show":true},{"name":"LearnerInfo.WorkExperience[0].Activities","show":true},{"name":"LearnerInfo.WorkExperience[0].Employer","show":false},{"name":"LearnerInfo.WorkExperience[0].Employer.ContactInfo.Address","show":false,"format":"s, z m (c)"},{"name":"LearnerInfo.WorkExperience[0].Employer.ContactInfo.Website","show":false},{"name":"LearnerInfo.WorkExperience[0].Employer.Sector","show":false},{"name":"LearnerInfo.WorkExperience[0].ReferenceTo","show":false},{"name":"LearnerInfo.WorkExperience[0].ReferenceTo[0]","show":false},{"name":"LearnerInfo.Education","show":true},{"name":"LearnerInfo.Education[0]","show":true},{"name":"LearnerInfo.Education[0].Period","show":true,"format":"text/long"},{"name":"LearnerInfo.Education[0].Title","show":true},{"name":"LearnerInfo.Education[0].Activities","show":true},{"name":"LearnerInfo.Education[0].Organisation","show":false},{"name":"LearnerInfo.Education[0].Organisation.ContactInfo.Address","show":false,"format":"s, z m (c)"},{"name":"LearnerInfo.Education[0].Level","show":false},{"name":"LearnerInfo.Education[0].Field","show":false},{"name":"LearnerInfo.Education[0].ReferenceTo","show":false},{"name":"LearnerInfo.Education[0].ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills","show":true},{"name":"LearnerInfo.Skills.Linguistic.MotherTongue","show":true},{"name":"LearnerInfo.Skills.Linguistic.MotherTongue[0]","show":true},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage","show":true},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage[0]","show":true},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage[0].Certificate","show":false},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage[0].Certificate[0]","show":false},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage[0].ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Linguistic.ForeignLanguage[0].ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.Communication","show":true},{"name":"LearnerInfo.Skills.Communication.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Communication.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.Organisational","show":true},{"name":"LearnerInfo.Skills.Organisational.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Organisational.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.JobRelated","show":true},{"name":"LearnerInfo.Skills.JobRelated.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.JobRelated.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.Computer","show":true},{"name":"LearnerInfo.Skills.Computer.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Computer.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.Driving","show":false},{"name":"LearnerInfo.Skills.Driving.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Driving.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Skills.Other","show":false},{"name":"LearnerInfo.Skills.Other.ReferenceTo","show":false},{"name":"LearnerInfo.Skills.Other.ReferenceTo[0]","show":false},{"name":"LearnerInfo.Achievement","show":false},{"name":"LearnerInfo.Achievement[0]","show":false},{"name":"LearnerInfo.Achievement[0].ReferenceTo","show":false},{"name":"LearnerInfo.Achievement[0].ReferenceTo[0]","show":false},{"name":"LearnerInfo.ReferenceTo","show":false},{"name":"LearnerInfo.ReferenceTo[0]","show":false}]},"DocumentInfo":{"DocumentType":"ECV","CreationDate":"2013-05-09T10:05:20.218+01:00","LastUpdateDate":"2013-05-09T10:05:20.218+01:00","XSDVersion":"V3.0","Generator":"EWA","Comment":"Europass CV"},"LearnerInfo":{"Identification":{"PersonName":{"FirstName":"fdgwer","Surname":"sffdsdfs"},"ContactInfo":{"Address":{"Contact":{"AddressLine":"sfsdf","PostalCode":"487112","Municipality":"sdfsd","Country":{"Label":"Albânia","Code":"AL"}}},"Telephone":[{"Use":{"Code":"home","Label":"Casa"},"Contact":"236532","index":0,"current_pref_item":{"show":true}},{"Use":{"Code":"mobile","Label":"Telemóvel"},"Contact":"213454354876","index":1,"current_pref_item":{"show":true}}],"Email":{"Contact":"sdfsdfsdf@asdsdfsdf"},"Website":[{"Contact":"sdfsffsdfsdfdsf","index":0,"current_pref_item":{"show":true}}]}}},"type":"_cv"}}';
        $data = str_replace("+", "%2B", $transformed);
        $data = 'json='.urlencode($data);
        
        $site = "https://europass.cedefop.europa.eu/api/document/to/pdf-cv";
        $ch = curl_init($site);

        curl_setopt($ch, CURLOPT_URL, $site);
        curl_setopt($ch, CURLOPT_SSLVERSION,3);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
        curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 2); 
        curl_setopt($ch, CURLOPT_USERAGENT, "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)"); 
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

        $aux = curl_exec($ch);
        //echo toFancyHTML($aux);
        if ($aux != false && $_GET['t'] != 2){
            //echo toFancyHTML(curl_exec($ch));
            header('Content-type: application/pdf');
            header('Content-Disposition: attachment; filename="downloaded.pdf"');
            echo $aux;
        } else{
            echo urldecode($data);
            echo toFancyHTML($aux);
        }

        
        curl_close($ch);
        
    }
    
    function getInfos($id){
        $arr = array();
        $db = new myDB();
        $query = $db->prepare('SELECT i.*, c.contact FROM info i, contacts c WHERE i.id = :id AND i.id = c.info_id AND c.type = "E" LIMIT 1');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $linha = $query->fetch();
        $pos = 0;
        for($i = strlen($linha['name']); $i >= 0; $i--)
            if (substr($linha['name'], $i, 1) == ' ') {$pos = $i; break;}
        //$aux = explode(" ", $linha['name']);
        //$pos = strpos($linha['name'], ' ', -1);
       
        $arr["FirstName"] = substr($linha['name'], 0, $pos);
        $arr["Surname"] = substr($linha['name'], $pos+1);
		/*echo "|".mb_detect_encoding($arr["FirstName"])."|";
		$arr["FirstName"] = utf8_encode($arr["FirstName"]);
		$arr["Surname"] = utf8_encode($arr["Surname"]);*/
        $arr['Contacts']['website'] = array($linha['web']);
        $bt = new DateTime($linha['birthdate']);
        $arr['birthdate']['year'] = $bt->format('Y');
        $arr['birthdate']['month'] = $bt->format('m');
        $arr['birthdate']['day'] = $bt->format('d');
        $arr['Gender'] = $linha['gender'];
        $arr['email'] = $linha['contact'];
        
		
		//$file = "C:\Program Files\wamp\www\PED\projecto\application\docs\pictures\_Vazio_.png";
		$file = realpath(dirname("../.")).DIRECTORY_SEPARATOR . "photos" . DIRECTORY_SEPARATOR . $id . ".png";
		if (file_exists($file)){
			$tams = getimagesize($file);
			$arr['photo'] = array('mt' => mime_content_type($file), 'data' => base64_encode(file_get_contents($file)), 'dimension' => $tams[0].'x'.$tams[1] , 'numpages' => 1);
		}
		
		
        $query = $db->prepare('SELECT contact FROM contacts c WHERE info_id = :id AND c.type = "T"');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Contacts']['telephone'] = array();
        while ($linha = $query->fetch()){
            $arr['Contacts']['telephone'][] = $linha['contact'];
        }
        
        $query = $db->prepare('SELECT nat FROM nationalities WHERE info_id = :id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Nationalitys'] = array();
        while ($linha = $query->fetch()){
            $arr['Nationalitys'][strtoupper(substr($linha['nat'], 0 ,2))] = $linha['nat'];
        }
		
		$query = $db->prepare('SELECT natlang FROM nativelang WHERE info_id = :id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Natlangs'] = array();
        while ($linha = $query->fetch()){
            $arr['Natlangs'][strtolower(substr($linha['natlang'], 0 ,2))] = $linha['natlang'];
        }
		
        
        $query = $db->prepare('SELECT ac.*, i.name, i.address, i.country, i.type as itype FROM activities ac, users_activities ua, institutions i
                                WHERE user_id = :id AND ua.activity_id = ac.id AND ac.inst = i.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Activities'] = array();
        while ($linha = $query->fetch()){
            $aux = array("from" => translateDate($linha['begin']), "to" => translateDate($linha['end']));
            $aux["label"] = ($linha['type'] == 'other' ? 'Actividade variada': $linha['type']);
            $aux["description"] = $linha["description"];
            $aux["org"] = array('name' => $linha['name'], 'address' => $linha['address'], 'code' => strtoupper(substr($linha['country'], 0, 2)), 'label' => $linha['country']);
            $arr['Activities'][] = $aux;
        }
        
        
        $query = $db->prepare('SELECT fo.*, i.name, i.address, i.country, i.type as itype FROM forms fo, forms_institutions fi, institutions i
                                WHERE pid = :id AND fi.id_form = fo.id AND fi.id_institution = i.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Formations'] = array();
        while ($linha = $query->fetch()){
            $aux = array("from" => translateDate($linha['begin']), "to" => translateDate($linha['end']));
            $aux["title"] = $linha['degreet'] . " " . $linha['degree'];
            $aux["level"] = $linha["result"];
            $aux["org"] = array('name' => $linha['name'], 'address' => $linha['address'], 'code' => strtoupper(substr($linha['country'], 0, 2)), 'label' => $linha['country']);
            $arr['Formations'][] = $aux;
        }
        
        $query = $db->prepare('SELECT pu.* FROM publications pu, users_publications up
                                WHERE up.info_id = :id AND up.publications_id = pu.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $arr['Publications'] = array();
        while ($linha = $query->fetch()){
            $aux['code'] = $linha['type'];
            $aux['label'] = 'Publicações';
            $aux['description'] = '('.$linha['key'].') - '.$linha['title'].'; '.$linha['year'];
            $arr['Publications'][] = $aux;
        }
        
        /*$arr["FirstName"] = "António Oliveira da";
        $arr["Surname"] = "Silva";*/
        //$arr['email'] = 'meuemail@xpto.pt';
        //$arr['Contacts']['telephone'] = array('252928322', '9135937779');
        /*$arr['Contacts']['website'] = array("http://xpto.com");
        $arr['birthdate']['year'] = '2006';
        $arr['birthdate']['month'] = '9';
        $arr['birthdate']['day'] = '13';*/
        //$arr['Gender'] = "M";
        //$arr['Nationalitys'] = array('PO' => 'Portugal', 'AN' => 'Andorra');
        
        
        /*$arr['Activities'] = array(
            array("from" => array("year" => 2001, "month" => 10, "day" => ""), "to" => array("year" => 2002, "month" => 02, "day" => ""),
                    "label" => "Researcher / Independent Consultant", "description" => "Working in a research team carrying out in-depth qualitative evaluation of the 2 year Advanced Training of Trainers in Europe using participant observations, in-depth interviews and focus groups. Work carried out in training courses in Strasbourg, Slovenia and Budapest.",
                    "org" => array('name' => 'Council of Europe', 'address' => 'Budapest', 'code' => 'HU', 'label' => 'Hungria')
                )
            
        );*/
        /*$arr['Formations'] = array(
            array("from" => array("year" => 1997), "to" => array("year" => "2001"), 
                  "title" => "PhD - Thesis Title: 'Young People in the Construction of the Virtual University', Empirical research on e-learning", "level" => "18,3 (180 ECTS)",
                  "org" => array('name' => 'Brunel University', 'address' => 'London', 'code' => 'RU', 'label' => 'Reino Unido')
            )    
        );*/
        /*$arr['Publications'] = array(
            array("code" => "publications" ,"label" => "Publicacoes" , "description" => "'How to do Observations: Borrowing techniques from the Social Sciences to help Participants do Observations in Simulation Exercises' Coyote EU/CoE Partnership Publication, (2002).")
        );*/
        if (DEBUG) var_dump($arr);
        return $arr;
    }
    
    function translateDate($date){
        $ret = array("year" => "", "month" => "" , "day" => "");
        if ($date == null) return $ret;
        $bt = new DateTime($date);
        $aux = $bt->format("Y");
        $ret["year"] = ($aux == "0000" ? "" : $aux);
        $aux = $bt->format("m");
        $ret["month"] = ($aux == "00" ? "" : $aux);
        $aux = $bt->format("d");
        $ret["day"] = ($aux == "00" ? "" : $aux);
        return $ret;
    }
    
?>