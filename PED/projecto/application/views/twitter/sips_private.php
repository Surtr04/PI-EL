<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	$form = array();
	$form[] = array("tipo" => "hidden", "nome" => 'isForm', "valor" => 0);
    $form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
    $form[] = array("tipo" => "hidden", "nome" => 'onlyPrivate', "valor" => 1);
    $form[] = array("label" => __('Identifier'), "nome" => 'id', "valor" => $ident, "disabled" => true);
    $form[] = array("label" => __('Title'), "nome" => 'titulo', "valor" => $titulo, "disabled" => true);
	$form[] = array("label" => __('Private'), "nome" => 'privado', "tipo" => 'check', 'checked' => $canBePrivate, "valor" => 1);

		
	echo TPL::makeForm($form, TPL::base().$route.'/update"', TPL::BtnsForm($route));

?>
