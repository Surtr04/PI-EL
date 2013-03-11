<?php

	define('DEBUG', 0);
	
	
	if (isset($_POST['byfile']) && $_POST['byfile']) 
		$zip = $_FILES['file']['tmpname'];
	 else
		$zip = criaZip($_POST);
		
	processaZip($zip);

	
	function criaZip($nvs){
	
		$xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><cv></cv>');
		$info = $xml->addChild("info");
		$info->addChild("file", "01.txt");
		$activities = $xml->addChild("activities");
		$activities->addChild("file", "02.xml");
		$publications = $xml->addChild("publications");
		$publications->addChild("file", "03.bib");
		
		$tmpxml = tempnam("tmp","man");
        $xml->asXml($tmpxml);
		
		
		$file = tempnam("tmp","fcv"); 
        $zip = new ZipArchive();
        if ($zip->open($file, ZipArchive::OVERWRITE) != 1) return false;
		
		//1º Ficheiro
		$txt = "";
		$txt = '@info {';
		$txt .= 'Name: "'.$nvs['name'].'" ';
		$txt .= 'Nationalities: ['.$nvs['nacionalities'].'] ';
		$txt .= 'PersonalContacts: [';
		$entra = false;
		foreach($nvs['contactsT'] as $chave => $valor){
			$entra = true;
			switch($valor){
				case 'phone' : $txt .= 'Phone: "'.$nvs['contactsV'][$chave].'",'; break;
				case 'fax' : $txt .= 'Fax: "'.$nvs['contactsV'][$chave].'",'; break;
				case 'email' : $txt .= 'Email: '.$nvs['contactsV'][$chave].', '; break;
			}
		}
		if ($entra) $txt = substr($txt, 0, -1);
		$txt .= '] ';
		$data = new DateTime($nvs['birthdate']);
		$txt .= 'Birthdate: '.$data->format('d/m/Y').' ';
		$txt .= 'Gender: '.($nvs['gender'] == 'F' ? 'F' : 'M').' ';
		$txt .= 'NativeLang: ['.$nvs['nativelang'].'] ';
		$txt .= 'Web: '.$nvs['web'];
		$txt .= '} ';
		
		foreach($nvs['fBegin'] as $chave => $valor){
			$txt .= '@form {';
			$txt .= 'Begin: '.$nvs['fBegin'][$chave].' ';
			$txt .= 'End: '.$nvs['fEnd'][$chave].' ';
			$txt .= 'Institution: Name: "'.$nvs['insName'][$chave].'" Address: "'.$nvs['insAddress'][$chave].'" Country: '.$nvs['insCountry'][$chave].' Type: '.$nvs['insType'][$chave].' ';
			$txt .= 'Degree: '.$nvs['degreeT'][$chave] . ' "'.$nvs['degree'][$chave].'" ';
			$txt .= 'Result: '.(is_numeric($nvs['result'][$chave]) ? $nvs['result'][$chave] : '"'.$nvs['result'][$chave].'"');
			$txt .= '} ';
		}
		
		$info = tempnam("tmp","01i");
		file_put_contents($info, $txt);

		//2º Ficheiro
		$xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><activities></activities>');
		foreach($nvs['aKey'] as $chave => $valor){
			$act = $xml->addChild('activities');
			$act->addAttribute('key', $valor);
			$act->addChild('begin_date', $nvs['aBegin'][$chave]);
			$act->addChild('end_date', $nvs['aEnd'][$chave]);
			$act->addChild('description', $nvs['description'][$chave]);
			$org = $act->addChild('institution')->addChild('org');
			$org->addAttribute('type', $nvs['aInsType'][$chave]);
			$org->addChild('name', $nvs['aInsName'][$chave]);
			$org->addChild('address', $nvs['aInsAddress'][$chave]);
			$org->addChild('country', $nvs['aInsCountry'][$chave]);
			$par = $act->addChild('partners');
			foreach(explode(",", $nvs['partners'][$chave]) as $c => $v){
				$v = trim($v);
				if ($v != "") $par->addChild('partner', $v);
			}
			$type = $act->addChild($nvs['aType'][$chave]);
			$other = $conf1 = $conf2 = $internship = $phd = $msc = 0;
			switch($nvs['aType'][$chave]){
				case 'conference': 
					$type->addAttribute('is_organizator', $nvs['isOrganizator'][$conf1]);
					$type->addChild('name', $nvs['aConfName'][$conf1]);
					$type->addChild('place', $nvs['aConfPlace'][$conf1]);
					if ($nvs['isOrganizator'][$conf1] == 'true') $type->addChild('work', $nvs['aConfWork'][$conf2++]);
					$conf1++;
					break;
				case 'internship':
					$org = $type->addChild('org');
					$org->addAttribute('type', $nvs['aCompanyType'][$internship]);
					$org->addChild('name', $nvs['aCompanyName'][$internship]);
					$org->addChild('address', $nvs['aCompanyAddress'][$internship]);
					$org->addChild('country', $nvs['aCompanyCountry'][$internship]);
					$internship++;
					break;
				case 'phd_monitoring': 
					$type->addChild('student', $nvs['student'][$phd]);
					$type->addChild('pdh_title', $nvs['phdTitle'][$phd]);
					$phd++;
					break;
				case 'msc_monitoring': 
					$type->addChild('student', $nvs['student'][$msc]);
					$type->addChild('msc_title', $nvs['mscTitle'][$msc]);
					$msc++;
					break;
				case 'other': 
					$type->addChild('description', $nvs['aInfo'][$other]);
					$other++;
					break;
			}
		}
		
		
		$activities = tempnam("tmp","02a");
		$xml->asXml($activities);
		
		//3º Ficheiro
		
		
        //Termina a geração do ficheiro zipado
        $zip->addFile($tmpxml, "pr.xml");
		$zip->addFile($info, "01.txt");
		$zip->addFile($activities, "02.xml");
        $zip->close();


        unlink($tmpxml);
		unlink($info);
        return $file;
		
	
	}
	
	function processaZip($file){
		if (DEBUG){
			var_dump($_POST);
		} else {
			if ((int)$_POST['toSave']){
				$zip = new ZipArchive();
				$zip->open($file);
				$aux = $zip->getFromName('pr.xml');
				$xml = new DOMDocument();
				echo htmlentities($aux);
				$xml->loadXML($aux);
				//1ª Parte
				$list = $xml->getElementsByTagName('info');
				$txt = "";
				foreach($list as $chave => $valor){
					$txt .= $zip->getFromName($valor->textContent)." ";
				}
				$_FILES['ficheiro']['tmp_name'] = tempnam("tmp", "01i");
				file_put_contents($_FILES['ficheiro']['tmp_name'], $txt);
				require('info_import.php');
				
				//2ª Parte
				$list = $xml->getElementsByTagName('activities');
				foreach($list as $chave => $valor){
					$_FILES['ficheiro']['tmp_name'] = tempnam("tmp", "02a");
					file_put_contents($_FILES['ficheiro']['tmp_name'], $zip->getFromName($valor->textContent));
					require('activities_import.php');
				}
			} else {
				header("Content-type: application/zip");
				header("Content-Transfer-Encoding: binary");
				$len = filesize($file);
				header("Content-Length: $len");
				header("Content-Disposition: attachment; filename=\"fullcv.zip\"");
				readfile($file);
				
			}
			
			
		}
		unlink($file);
	}
	
?>