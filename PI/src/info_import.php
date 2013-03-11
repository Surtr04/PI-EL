<?php
	require_once('bd.php');

	if (!isset($_FILES['ficheiro'])){
		echo "<html><head></head>
		<body>
		<form method=\"post\" action=\"info_import.php\" enctype=\"multipart/form-data\">
            <fieldset>
                <legend>Info e Form:</legend> 
                <input type='file' name='ficheiro'/>
			</fieldset>
			<input type=\"submit\" name=\"Enviar\"/>
		</form>
		</body></html>";
		return;
	}
	
	$f = (popen('java -jar AntLRParser.jar "'.$_FILES['ficheiro']['tmp_name'].'"', "r"));

	$valor = "";
	while (!feof($f)) {$valor .= fread($f, 60);}
	
	
	$db = new myDB();
	$valor = explode("\n",$valor);
	
	$aux = json_decode($valor[0]);
	$pid = insertInfo($db, $aux->info);
	$i = 0;
	foreach($valor as $value){
		if ($i == 0) continue; else $i++;
		$aux = json_decode($value);
		insertForm($db, $pid, $aux->form);
	}
	
	$_SESSION['pid'] = $pid;
	
	function insertForm($db, $person_id, $txt){
		$db->beginTransaction();
		
		$query = $db->prepare("INSERT INTO forms VALUES(null, :pid, :begin, :end, :inst, :degreet, :degree, :result)");
		$query->bindValue(':pid', $person_id, PDO::PARAM_STR);
		$query->bindValue(':begin', $txt->begin, PDO::PARAM_STR);
		$query->bindValue(':end', $txt->end, PDO::PARAM_STR);
		$query->bindValue(':degreet', $txt->degree->type, PDO::PARAM_STR);
		$query->bindValue(':degree', $txt->degree->value, PDO::PARAM_STR);
		$query->execute() or die($db->errorInfo());
		
		$form = $db->lastInsertId();
		
		foreach($txt->institutions as $valor){
			$query = $db->prepare("INSERT INTO institutions VALUES(null, :name, :address, :country, :type)");
			$query->bindValue(':name', $valor->name, PDO::PARAM_STR);
			$query->bindValue(':address', $valor->address, PDO::PARAM_STR);
			$query->bindValue(':country', $valor->country, PDO::PARAM_STR);
			$query->bindValue(':type', $valor->type, PDO::PARAM_STR);
			$query->execute() or die($db->errorInfo());
			
			$inst = $db->lastInsertId();
			
			$query = $db->prepare("INSERT INTO forms_institutions VALUES(:form, :inst)");
			$query->bindValue(':form', $form, PDO::PARAM_STR);			
			$query->bindValue(':inst', $inst, PDO::PARAM_STR);			
			$query->execute() or die($db->errorInfo());
		}
		
		
		
		$db->commit();
	}
	function insertInfo($db, $txt){
		
		$db->beginTransaction();
		$query = $db->prepare("INSERT INTO info VALUES(null, :name, :birthdate, :gender, :web)");
		$query->bindValue(':name', $txt->name, PDO::PARAM_STR);
		$query->bindValue(':birthdate', $txt->birthdate, PDO::PARAM_STR);
		$query->bindValue(':gender', $txt->gender, PDO::PARAM_STR);
		$query->bindValue(':web', $txt->web, PDO::PARAM_STR);
		$query->execute() or die($db->errorInfo());
		
		
		$person_id = $db->lastInsertId();
		
		$query = $db->prepare("INSERT INTO nationalities VALUES(:id, :nat)");
		foreach($txt->nationalities as $value){
			$query->bindValue(':id', $person_id, PDO::PARAM_STR);
			$query->bindValue(':nat', $value, PDO::PARAM_STR);
			$query->execute() or die($db->errorInfo());
			$query->closeCursor();
		}
		
		$query = $db->prepare("INSERT INTO contacts VALUES(null, :id, :type, :contact)");
		foreach($txt->contacts as $value){
			$query->bindValue(':id', $person_id, PDO::PARAM_STR);
			$query->bindValue(':type', $value->type, PDO::PARAM_STR);
			$query->bindValue(':contact', $value->value, PDO::PARAM_STR);
			$query->execute() or die($db->errorInfo());
			$query->closeCursor();
		}
		
		$query = $db->prepare("INSERT INTO nativelang VALUES(:id, :nat)");
		foreach($txt->natlang as $value){
			$query->bindValue(':id', $person_id, PDO::PARAM_STR);
			$query->bindValue(':nat', $value, PDO::PARAM_STR);
			$query->execute() or die($db->errorInfo());
			$query->closeCursor();
		}
		$db->commit();
		return $person_id;
	}
	
	
?>
