<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
        '.($form_id != null ? '<img src="'.TPL::base().'get/img/'.$form_id.'"/>' : '').'
		<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().($form_id != NULL ? 'users/update' : 'users/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		'.__('Username').': <input type="text" id="username" name="username" style="margin-top:10px;width:50%;" value="'.$username.'"/><br />
		'.__('Password').': <input type="password" id="senha" name="senha" style="margin-top:10px;width:50%;"/><br />
		'.__('Repeat Password').': <input type="password" id="rsenha" name="rsenha" style="margin-top:10px;width:50%;"/><br />
		'.__('Name').': <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />
		'.__('Email').': <input type="text" id="email" name="email" style="margin-top:10px;width:50%;" value="'.$email.'"/><br />
        '.__('Address').': <textarea id="morada" name="morada" style="margin-top:10px;width:50%;" rows="5">'.$morada.'</textarea><br />
        '.__('Picture').': <input type="text" id="foto" name="foto" style="margin-top:10px;width:50%;" value="'.$foto.'"/><br />
		'.__('Group').': <select type="text" id="grupo" name="grupo" style="margin-top:10px;width:50%;"/>';
	foreach($grupos as $chave => $valor){
		echo '<option '.($grupo == (int)$valor['id'] ? 'selected="true "' : '' ).'value="'.$valor['id'].'">'.$valor['nome'].'</option>';
	}
	
	echo '</select><br />';
	
	echo TPL::BtnsForm('users').'</form></div>';

?>