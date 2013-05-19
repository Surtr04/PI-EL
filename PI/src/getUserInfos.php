<?php
	session_start();
	require_once('bd.php');
	
	$aux = '';
	switch($_GET['t']){
		case 'info' : $aux = getInfos($_SESSION['id']); break;
		case 'pubs' : $aux = getPublications($_SESSION['id']); break;
		case 'acts' : $aux = getActivities($_SESSION['id']); break;
	}
	
	echo $aux;
	
	
	function getInfoFields($db, $id){
		$ret = array();
		$query = $db->prepare('SELECT * FROM contacts c WHERE c.info_id = :id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $contacts = array();
		while ($linha = $query->fetch()){
			switch($linha['type']){
				case 'E' : $type = 'email'; break;
				case 'T' : $type = 'phone'; break;
				case 'F' : $type = 'fax'; break;
			}
			$contacts[] = array('type' =>  $type, 'value' => $linha['contact']);
		}
		
		$query = $db->prepare('SELECT * FROM nationalities n WHERE n.info_id = :id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $nats = array();
		while ($linha = $query->fetch())
			$nats[] = $linha['nat'];
		
		
		$query = $db->prepare('SELECT * FROM nativelang n WHERE n.info_id = :id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $langs = array();
		while ($linha = $query->fetch())
			$langs[] = $linha['natlang'];
		
		$query = $db->prepare('SELECT i.* FROM info i WHERE i.id = :id LIMIT 1');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
        $linha = $query->fetch();
		$ret[] = array('name'=> "name", 'label' => "Nome", 'value'=> $linha['name'], 'type'=> "text");
		$ret[] = array('name'=> "nacionalities", 'label' => "Nacionalidades", 'value'=> $nats, 'type'=> "list", 'max'=>2, 'required'=> true);
		$ret[] = array('name'=> "contacts", 'label' => "Contactos Pessoais", 'values'=> $contacts , 'type'=> "contacts");
		$bt = new DateTime($linha['birthdate']);
		$ret[] = array('name'=> "birthdate", 'label' => "Data de Nascimento", 'value'=> $bt->format('d/m/Y'), 'type'=> "date");
		$ret[] = array('name'=> "gender", 'label' => "Sexo", 'value'=> $linha['gender'], 'values'=> array(array('name'=>"M", 'value'=>"Masculino"),array('name'=>"F", 'value'=>"Feminino")), 'type'=>"check");
		$ret[] = array('name'=> "nativelang", 'label' => "Linguagens Nativas", 'value'=> $langs, 'type'=> "list", 'max'=>0, 'required'=> true);
		$ret[] = array('name'=> "web", 'label' => "Endereço Web", 'value'=> $linha['web'], 'type'=> "url");
		return $ret;
	}
	
	function getInfoFormation($db, $id){
		$ret = array();
		$query = $db->prepare('SELECT fo.*, i.id as iid, i.name, i.address, i.country, i.type as itype FROM forms fo, forms_institutions fi, institutions i
                                WHERE pid = :id AND fi.id_form = fo.id AND fi.id_institution = i.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
		$sel = array();
        while ($linha = $query->fetch()){
			$aux = array();
			$bt = new DateTime($linha['begin']);
			$aux["begin"] = $bt->format('d/m/Y');
			$bt = new DateTime($linha['end']);
			$aux["end"] = $bt->format('d/m/Y');
            $aux["degreet"] = $linha['degreet'];
			$aux["degree"] = $linha['degree'];
			$aux["degreet"] = $linha['degreet'];
            $aux["result"] = $linha["result"];
			$sel[] = 'id'.$linha['iid'];
            $aux["inst"] = array('name' => $linha['name'], 'text' => $linha['name'], 'address' => $linha['address'], 'type' => getInstType($linha['itype']), 'country' => $linha['country']);
            $ret[] = $aux;
        }
		return array('formation' => $ret, 'selectedIns' => $sel);
	}
	function getInstType($i){
		switch($i){
			case 1: return 'Public University'; 
			case 2: return 'Private University'; 
		}
	}
	function getInstitutions($db){
		$ret = array();
		$ret['__new__'] = array('text'=> '--Nova--', 'name'=> '', 'country'=> '', 'type' => '');
		$query = $db->prepare('SELECT * FROM institutions i WHERE 1');
        $query->execute();
        while ($linha = $query->fetch()){
			$ret['id'.$linha['id']] = array('name' => $linha['name'], 'text' => $linha['name'], 'address' => $linha['address'], 'type' => getInstType($linha['type']), 'country' => $linha['country']);
		}
		return $ret;
	}
	function getInfos($id){
		$db = new myDB();
		$ret = array();
		$ret['fields'] = getInfoFields($db, $id);
		$aux = getInfoFormation($db, $id);
		$ret['formation'] = $aux['formation'];
		$ret['selectedIns'] = $aux['selectedIns'];
		$ret['institutions'] = getInstitutions($db);
		return json_encode($ret);
	}
	
	function getPublications($id){
		$db = new myDB();
		$ret = array();
		$fields[] = array();
		$query = $db->prepare('SELECT * FROM bibfields WHERE 1');
        $query->execute();
		while($linha = $query->fetch())
			$fields[(int)$linha['id']] = $linha['key'];
				
		$query = $db->prepare('SELECT pu.* FROM publications pu, users_publications up
                                WHERE up.info_id = :id AND up.publications_id = pu.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
		
		while($linha = $query->fetch()){
			$aux = $ret[$linha['key']];
			$ret['__type'] = $linha['type'];
			$ret['title'] = $linha['title'];
			$ret['year'] = $linha['year'];
			$nquery = $db->prepare('SELECT pf.* FROM publications_fields pf WHERE pf.publications_id = :id');
			$nquery->bindValue(':id', $linha['id'], PDO::PARAM_INT);
			$nquery->execute();
			while($row = $nquery->fetch())
				$aux[$fields[(int)$row['fields_id']]] = $row['value'];
		}
		if (count($ret) == 0) return "{}"; else return json_encode($ret);
	}
	
	function getActivities($id){
		$db = new myDB();
		$ret = array();
		$query = $db->prepare('SELECT ac.*, i.id as iid, i.name, i.address, i.country, i.type as itype FROM activities ac, users_activities ua, institutions i
                                WHERE ua.user_id = :id AND ua.activity_id = ac.id AND ac.inst = i.id');
        $query->bindValue(':id', $id, PDO::PARAM_INT);
        $query->execute();
		$ret['activities'] = array();
		while ($linha = $query->fetch()){
			$aux = array();
			$aux['partners'] = array();
			$nquery = $db->prepare('SELECT i.name FROM users_activities ua, info i
                                WHERE ua.activity_id = :id AND i.id = ua.user_id AND i.id <> :myid');
			$nquery->bindValue(':id', $linha['id'], PDO::PARAM_INT);
			$nquery->bindValue(':myid', $id, PDO::PARAM_INT);
			$nquery->execute();
			while($row = $nquery->fetch())
				$aux['partners'][] = $row['name'];
			
			$nquery = $db->prepare('SELECT name FROM nonusers_activities ua
                                WHERE ua.activity_id = :id');
			$nquery->bindValue(':id', $linha['id'], PDO::PARAM_INT);
			$nquery->execute();
			while($row = $nquery->fetch())
				$aux['partners'][] = $row['name'];
			
			
			$aux['key'] = $linha['key'];
			$bt = new DateTime($linha['begin']);
			$aux["begin"] = $bt->format('d/m/Y');
			$bt = new DateTime($linha['end']);
			$aux["end"] = $bt->format('d/m/Y');
			$aux['desc'] = $linha['description'];
			$aux['inst'] = array('name' => $linha['name'], 'text' => $linha['name'], 'address' => $linha['address'], 'type' => getInstType($linha['itype']), 'country' => $linha['country']);
			$aux['activity'] = array('type' => $linha['type'], 'isOrg' => false);
			$ret['activities'][] = $aux;
			$ret['selectedIns'][] = 'id'.$linha['iid'];
		}
		//{key: 'ex1', begin: '01/01/2012', end: '31/12/2012', desc: 'Exemplo de uma actividade', inst: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"},  org : {type: '', name: '', address: ''}, partners: ["J. J. Almeida", "Bruno Fernandes"], activity: { type: "conference", isorg: false, name: 'JOIN - Jornadas de Informática da Universidade do Minho', place: 'Universidade do Minho - Gualtar', work: 'Mobile Applications And Cloud Computing'}}
		$ret['institutions'] = getInstitutions($db);
		return json_encode($ret);
	}
?>