<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" onSubmit="return checkForm()" action="'.url::base().($form_id != NULL ? 'users/update' : 'users/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		Nome de Utilizador: <input type="text" id="username" name="username" style="margin-top:10px;width:50%;" value="'.$username.'"/><br />
		Password: <input type="password" id="senha" name="senha" style="margin-top:10px;width:50%;"/><br />
		Repetir Password: <input type="password" id="rsenha" name="rsenha" style="margin-top:10px;width:50%;"/><br />
		Nome: <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />
		Email: <input type="text" id="email" name="email" style="margin-top:10px;width:50%;" value="'.$email.'"/><br />
		Grupo: <select type="text" id="grupo" name="grupo" style="margin-top:10px;width:50%;"/>';
	foreach($grupos as $chave => $valor){
		echo '<option '.($grupo == (int)$valor['id'] ? 'selected="true "' : '' ).'value="'.$valor['id'].'">'.$valor['nome'].'</option>';
	}
	
	echo '</select><br />';
	
	echo TPL::BtnsForm('users').'</form></div>';

?>