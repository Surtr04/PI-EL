<?php

	$txt = file_get_contents($_FILES['ficheiro']['temp_name']);
	
	$db = new myDB();
	
	$txt = json_decode($txt);
	$db->beginTransaction();
	$query = $db->prepare("INSERT INTO info VALUES(:name, :birthdate, :gender, :web)");
	$query->bindValue(':name', $txt->name, PDO::PARAM_STR);
	$query->bindValue(':birthdate', $txt->birthdate, PDO::PARAM_STR);
	$query->bindValue(':gender', $txt->gender, PDO::PARAM_STR);
	$query->bindValue(':web', $txt->web, PDO::PARAM_STR);
	
	$query->execute();
?>