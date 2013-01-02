<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().$route.($form_id != NULL ? '/update' : '/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
        '.__('Identifier').': <input type="text" id="identificador" name="identificador" style="margin-top:10px;width:50%;" value="'.$identificador.'"/><br />		
        '.__('Name').': <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />
		'.__('Email').': <input type="text" id="email" name="email" style="margin-top:10px;width:50%;" value="'.$email.'"/><br />
		'.__('Web').': <input type="text" id="web" name="web" style="margin-top:10px;width:50%;" value="'.$web.'"/><br />';
	
	echo TPL::BtnsForm($route).'</form></div>';

?>