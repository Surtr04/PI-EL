<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    $guest = Kohana::$config->load('defs.guest');
    unset($allGroups[$guest]);
    $allGroups[$guest] = array("id" => $guest, "nome" => __('All Groups'));
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().$route.($form_id != NULL ? '/update' : '/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		'.__('Category').': <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />
		'.__('Start Date').': <input type="text" id="inicio" name="inicio" style="margin-top:10px;width:50%;" value="'.$inicio.'"/><br />
		'.__('End Date').': <input type="text" id="fim" name="fim" style="margin-top:10px;width:50%;" value="'.$fim.'"/><br />
        '.__('Groups').': '.TPL::createMultiSelect('selectedGroups', $allGroups, $selectedGroups, 10);
	
	echo TPL::BtnsForm($route).'</form></div>';

?>