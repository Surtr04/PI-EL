<div class="span3">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
<?php
	$campos = array("Opções" => array(_makeEntry('Formulário', 'interface.php'), _makeEntry('Ficheiro (pacote)', 'upload_package.php')),
					"Obter" => array(_makeEntry('Europass XML', 'europass/europass.php?t=xml'), _makeEntry('Europass PDF', 'europass/europass.php?t=pdf')),
					"Actualizar" => array(_makeEntry('Publicações', 'repositorium_oaipmh.php'))
					);
	foreach($campos as $chave => $valor){
		echo '<li class="nav-header">'.$chave.'</li>';
		foreach($valor as $c => $v){
			$is = (strstr($_SERVER['PHP_SELF'],$v['file']) === false ? false : true);
			echo '<li ' . ($is ? 'class="active"' : '') . '><a href="'.($is ? '#' : $v['href']).'">'.$v['label'].'</a></li>';
		}
	}
	
	function _makeEntry($label, $file, $href = null) { if ($href == null) $href = $file; return array('file' => $file, 'href' => $href, 'label' => $label);}
?>
		</ul>
	</div>
</div>
<!--<div class="span3">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<li class="nav-header">Opções</li>
			<li class="active"><a href="interface.php">Formulário</a></li>
			<li><a href="upload_package.html">Ficheiro (Pacote)</a></li>
			<li class="nav-header">Obter</li>
			<li><a href="europass/europass.php?t=xml">Europass XML</a></li>
			<li><a href="europass/europass.php?t=pdf">Europass PDF</a></li>
			<li class="nav-header">Actualizar</li>
			<li><a href="#">Publicações</a></li>
		</ul>
	</div>
</div>-->