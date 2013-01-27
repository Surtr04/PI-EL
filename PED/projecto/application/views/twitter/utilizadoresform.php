<?php defined('SYSPATH') or die('No direct script access.'); //twitter
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    if (!isset($isSee)) $isSee = false;
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
        '.($form_id != null ? '<img src="'.TPL::base().'get/img/'.$form_id.'"/><br/>'.(!$isSee ? TPL::LinkApagar('resetImg/'.$form_id, __('Remove Image')) : '') : '').'<br/>';
    
    $form = array();
    $form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
    $form[] = array("label" => __('Username'), "nome" => 'username', "valor" => $username , 'disabled' => $isSee);
    if (!$isSee){
        $form[] = array("label" => __('Password'), "nome" => 'senha', "tipo" => 'password' );
        $form[] = array("label" => __('Repeat Password'), "nome" => 'rsenha', "tipo" => 'password' );
    }
    $form[] = array("label" => __('Name'), "nome" => 'nome', "valor" => $nome, 'disabled' => $isSee);
    $form[] = array("label" => __('Email'), "nome" => 'email', "tipo" => 'email', "valor" => $email, 'disabled' => $isSee);
    $form[] = array("label" => __('Address'), "nome" => 'morada', "tipo" => 'textarea', "valor" => $morada, "linhas" => 5, 'disabled' => $isSee);
    if (!$isSee){
        $form[] = array("label" => __('Upload Picture'), "nome" => 'ffoto', "tipo" => "file");
        $form[] = array("label" => __('Picture'), "nome" => 'foto', "valor" => $foto);
    }
    $form[] = array("label" => __('Group'), "nome" => 'grupo', "valor" => $grupos, "sel" => $grupo, "tipo" => 'select', 'disabled' => $isSee);
    
    echo TPL::makeForm($form, TPL::base().($form_id != NULL ? 'users/update' : 'users/insere2'), (!$isSee ? TPL::BtnsForm('users') : ''));
    
	
	echo '</div>';

?>
