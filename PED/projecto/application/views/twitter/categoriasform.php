<?php defined('SYSPATH') or die('No direct script access.'); //twitter
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    $guest = Kohana::$config->load('defs.guest');
    unset($allGroups[$guest]);
    $allGroups[$guest] = array("id" => $guest, "nome" => __('All Groups'));
    
    
    $form = array();
    $form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
    $form[] = array("label" => __('Category'), "nome" => 'nome', "tipo" => "text", "valor" => $nome);
    $form[] = array("label" => __('Start Date'), "nome" => 'inicio', "tipo" => "date", "valor" => $inicio);
    $form[] = array("label" => __('End Date'), "nome" => 'fim', "tipo" => "date", "valor" => $fim);
    $form[] = array("label" => __('Groups'), "nome" => 'selectedGroups', "valor" => $allGroups, "sel" => $selectedGroups, "tipo" => "multi");
    $form[] = array("label" => __('Can delete sips'), "nome"=> "canDelete", "valor" => 1, "checked" => $canDelete, "tipo" => "check", 'after' => '<span class="help-block">'.__('DELETE_CAT_SIP').'</span>');
    
    
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">'.
        TPL::makeForm($form, TPL::base().$route.($form_id != NULL ? '/update' : '/insere2'), TPL::BtnsForm($route));

	
	echo '</div>';

?>