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
		//if (isset($_FILES['bibtex']) && $_FILES['bibtex']['error'] == UPLOAD_ERR_OK){
			$publications = $xml->addChild("publications");
			$publications->addChild("file", "03.bib");
		//}
		
		$tmpxml = tempnam("tmp","man");
        $xml->asXml($tmpxml);
		
		
		$file = tempnam("tmp","fcv"); 
        $zip = new ZipArchive();
        if ($zip->open($file, ZipArchive::OVERWRITE) != 1) return false;
		
		//1º Ficheiro
		$txt = "";
		$txt = '@info {'."\n";
		$txt .= 'Name: "'.$nvs['name'].'" '."\n";
		$txt .= 'Nationalities: ['.$nvs['nacionalities'].'] '."\n";
		$txt .= 'PersonalContacts: ['."\n";
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
		$txt .= '] '."\n";
		$data = new DateTime($nvs['birthdate']);
		$txt .= 'Birthdate: '.$data->format('d/m/Y')."\n";
		$txt .= 'Gender: '.($nvs['gender'] == 'F' ? 'F' : 'M')."\n";
		$txt .= 'NativeLang: ['.$nvs['nativelang'].'] '."\n";
		$txt .= 'Web: '.$nvs['web']."\n";
		$txt .= '} '."\n";
		
		foreach($nvs['fBegin'] as $chave => $valor){
			$txt .= '@form {'."\n";
			$txt .= 'Begin: '.$nvs['fBegin'][$chave]."\n";
			$txt .= 'End: '.$nvs['fEnd'][$chave]."\n";
			$txt .= 'Institution: '."\n".'Name: "'.$nvs['insName'][$chave]."\"\n".' Address: "'.$nvs['insAddress'][$chave]."\"\n".' Country: '.$nvs['insCountry'][$chave]."\n".' Type: '.$nvs['insType'][$chave]."\n";
			$txt .= 'Degree: '.$nvs['degreeT'][$chave] . ' "'.$nvs['degree'][$chave].'"'."\n";
			$txt .= 'Result: '.(is_numeric($nvs['result'][$chave]) ? $nvs['result'][$chave] : '"'.$nvs['result'][$chave].'"')."\n";
			$txt .= '} '."\n";
		}
		
		$info = tempnam("tmp","01i");
		file_put_contents($info, $txt);

		//2º Ficheiro
		$xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><activities></activities>');
		foreach($nvs['aKey'] as $chave => $valor){
			$act = $xml->addChild('activity');
			$act->addAttribute('key', $valor);
			$act->addChild('begin_date', date('Y-m-d',strtotime($nvs['aBegin'][$chave])));
			$act->addChild('end_date',  date('Y-m-d',strtotime($nvs['aEnd'][$chave])));
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
					if ($nvs['isOrganizator'][$conf1] == 'false') $type->addChild('work', $nvs['aConfWork'][$conf2++]);
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
		$txt = "";
		$match = '#pub$';
		$slen = strlen($match);
		$bibfields = array();
		foreach($nvs as $chave => $valor){
			if (substr($chave, 0, $slen) == $match){
				$aux = explode("$", $chave);
				if ($aux[2] == 'author')
					$bibfields[$aux[1]][$aux[2]] = json_decode($valor);
				else
					$bibfields[$aux[1]][$aux[2]] = $valor;
			}
		}

		$txt = "";
		foreach($bibfields as $chave => $valor){
			$txt .= "@" . $valor['__type'] . "{" . $chave . ",\n";
			unset($valor['__type']); 
			foreach($valor as $c => $v){
				$txt .= $c . ' = "';
				if ($c == 'author'){
					foreach($v as $autor)
						$txt .= $autor . " and ";
					$txt = substr($txt, 0, -5);
				}else
					$txt .= $v;
				$txt .= "\",\n";
			}
			$txt = substr($txt, 0, -2) . "\n}\n\n";
		}
		
		
		$pubs = tempnam("tmp","03p");
		file_put_contents($pubs, $txt);
		
		
		
		//Termina a geração do ficheiro zipado
        $zip->addFile($tmpxml, "pr.xml");
		$zip->addFile($info, "01.txt");
		$zip->addFile($activities, "02.xml");
		//if (isset($_FILES['bibtex']) && $_FILES['bibtex']['error'] == UPLOAD_ERR_OK) $zip->addFile($_FILES['bibtex']['tmp_name'], "03.bib");
		$zip->addFile($pubs, "03.bib");
        $zip->close();


        unlink($tmpxml);
		unlink($info);
        return $file;
		
	
	}
	
	function processaZip($file){
		if (DEBUG){
			var_dump($_POST);
			var_dump($_FILES);
		} else {
			if ((int)$_POST['toSave']){
				$zip = new ZipArchive();
				$zip->open($file);
				$aux = $zip->getFromName('pr.xml');
				$xml = new DOMDocument();
				$xml->loadXML($aux);
				//1ª Parte
				$list = $xml->getElementsByTagName('info');
				$txt = "";
				foreach($list as $chave => $valor){
					$txt .= $zip->getFromName($valor->textContent)." ";
				}
				$_FILES['ficheiro']['tmp_name'] = tempnam("tmp", "01i");
				chmod($_FILES['ficheiro']['tmp_name'], 0777);
				file_put_contents($_FILES['ficheiro']['tmp_name'], $txt);
				require('info_import.php');
				
				//2ª Parte
				$list = $xml->getElementsByTagName('activities');
				foreach($list as $chave => $valor){
					$_FILES['ficheiro']['tmp_name'] = tempnam("tmp", "02a");
					file_put_contents($_FILES['ficheiro']['tmp_name'], $zip->getFromName($valor->textContent));
					require('activities_import.php');
				}
				
				//3ª Parte
				
				header('Location: interface.php');

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
