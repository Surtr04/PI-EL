<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
/*<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />*/
/*<link rel="shortcut icon" href="<?php echo TPL::base()?>favicon.ico" type="image/x-icon" />*/
define('MSGS', 1);
?>
<head>
	
	<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
	<title><?php echo $titulo; ?></title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <link href="<?php echo TPL::base() ?>css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<?php echo TPL::base() ?>css/datepicker.css" rel="stylesheet" media="screen">
    <script src="<?php echo TPL::base() ?>js/bootstrap.min.js"></script>
    <script src="<?php echo TPL::base() ?>js/datepicker.js"></script>
    
<?php 
		foreach(array("style.css", "override.css") as $valor){
			if (file_exists(DOCROOT.$valor)) echo '<link href="'.TPL::base().$valor.'" rel="stylesheet" type="text/css" />'."\n";
		}
?>
	<link rel="icon" type="image/png" href="<?php echo TPL::base()?>favicon.png" />
	<link rel="shortcut icon" type="image/png" href="<?php echo TPL::base()?>favicon.png" />
	<?php if (isset($scripts)) echo $scripts."
"; ?>
</head>

<body <?php if ($onload != '') echo 'onload="'.$onload.'()" '?>>
	<div id="pack">
		<!--<div id="head">
			<!--<div id="text">
				<h1><?php echo $titulo; ?></h1>
			</div>
			<a href="<?php echo TPL::base();?>" style="margin-left:550px">
				<img style="width: 162px; margin-top:0px;" alt="head" src="<? echo TPL::base(); ?>images/site_logo.png" />
			</a>-->
			<!--<img style="max-width: 95%;  margin:0px auto 0px 2.5%;" alt="head" src="<? echo TPL::base(); ?>images/_cabecalho.png" />
		</div>-->

	<?php
	$degree = 45;
	if ($isManut)
		echo '<div style="overflow: hidden; position: fixed; width: 250px; height: 250px; right: 0pt; top: 0pt;">
    <div style="text-align: center; transform:rotate('.$degree.'deg); -ms-transform:rotate('.$degree.'deg); /* IE 9 */ -moz-transform:rotate('.$degree.'deg); /* Firefox */ -webkit-transform:rotate('.$degree.'deg); /* Safari and Chrome */ -o-transform:rotate('.$degree.'deg); /* Opera */ position: relative; line-height: 3em; width: 315px; top: 65px; text-transform: uppercase; font-weight: bold; color: White; background-color: Gold;">'.__('In Maintenance').'</div></div>';
	$home = false;
	if (!isset($menus)) $menus = array();
	echo "<div class='navbar'><div class='navbar-inner'><ul class='nav nav-tabs' id='nav'>";
	foreach ($menus as $menu){
		echo "<li";
		if ($menu['home'] == true && !$home){
			echo ' class="active"';
			$home = true;
		} 
		echo '><a href="'.$menu['link'].'">'.__($menu['text']).'</a></li>';
	}
	echo "</ul></div></div>";
	?>
    <?php
        $boxmsgs = array(
                'errors' => array('msg' => 'Error', 'type' => 'alert-error'), 
                'msgs' => array('msg' => 'Info', 'type' => 'alert-info'), 
                'warnings' => array('msg' => 'Warning', 'type' => ''),
                'successes' => array('msg' => 'Success', 'type' => 'alert-success'),
        );
        if (MSGS){
            $aux = '';
            foreach($boxmsgs as $chave => $valor){
                if (isset($$chave)) {
                    foreach($$chave as $erro)
                       $aux .= '<div class="alert '.$valor['type'].'"><button type="button" class="close" data-dismiss="alert">&times;</button>'.
                            ($valor['msg'] != "" ? '<strong>'.__($valor['msg']).': </strong>' : '').__($erro['msg'], $erro['params']).'</div>';
                 }
            }
            if ($aux != '') echo '<div style="margin:5px;">'.$aux.'</div>';
        }
    ?>
	</div>
	
