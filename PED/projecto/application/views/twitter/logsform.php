<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().($form_id != NULL ? 'logs/update' : 'logs/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		'.__('Username').': <input type="text" id="utilizador" name="utilizador" '.($form_id != NULL ? 'disabled="true" ' : '') .'style="margin-top:10px;width:50%;" value="'.$username.'"/><br />
		'.__('Time').': <input type="text" id="data" name="data" style="margin-top:10px;width:50%;" value="'.$data.'"/><br />
		'.__('Operation').': <input type="text" id="operacao" name="operacao" style="margin-top:10px;width:50%;" value="'.$operacao.'"/><br />
		'.__('Message').': <input type="text" id="descricao" name="descricao" style="margin-top:10px;width:50%;" value="'.$descricao.'"/><br />';
	
	echo TPL::BtnsForm('logs').'</form></div>';

?>