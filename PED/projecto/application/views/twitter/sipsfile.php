<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	$form = array();
	$form[] = array("tipo" => "hidden", "nome" => 'isForm', "valor" => 0);
	$form[] = array("label" => __('Category'), "nome" => 'categoria', "valor" => $categorias, "sel" => $categoria, "tipo" => "select");
	if ($canBePrivate) $form[] = array("label" => __('Private'), "nome" => 'privado', "tipo" => 'check', "valor" => 1);
	$form[] = array("label" => __('File'), "nome" => 'sip', "tipo" => 'file');
		
	echo TPL::makeForm($form, TPL::base().$route.'/insere2"', TPL::BtnsForm($route));

?>
