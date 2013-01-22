<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	$form = array();
	$form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
    $form[] = array("label" => __('Username'), "nome" => 'utilizador', "tipo" => 'text', "valor" => $username, "disabled" => $form_id != null);
    $form[] = array("label" => __('Time'), "nome" => 'data', "tipo" => 'datetime', "valor" => $data);
    $form[] = array("label" => __('Operation'), "nome" => 'operacao', "tipo" => 'text', "valor" => $operacao);
    $form[] = array("label" => __('Message'), "nome" => 'descricao', "tipo" => 'text', "valor" => $descricao);

	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">'.
	TPL::makeForm($form, TPL::base().($form_id != NULL ? 'logs/update' : 'logs/insere2'), TPL::BtnsForm('logs')).
	'</div>';
	
?>
