<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	$form = array();
	$form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
	$form[] = array("label" => __('Identifier'), "nome" => 'identificador', "tipo" => "text", "valor" => $identificador);
	$form[] = array("label" => __('Name'), "nome" => 'nome', "tipo" => "text", "valor" => $nome);
	$form[] = array("label" => __('Email'), "nome" => 'email', "tipo" => "email", "valor" => $email);
	$form[] = array("label" => __('Web'), "nome" => 'web', "tipo" => "url", "valor" => $web);
	
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">'.
	TPL::makeForm($form, TPL::base().$route.($form_id != NULL ? '/update' : '/insere2'), TPL::BtnsForm($route)).
	'</div>';
	
?>
