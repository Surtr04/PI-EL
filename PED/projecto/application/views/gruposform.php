<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" action="'.url::base().($form_id != NULL ? 'groups/update' : 'groups/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		Nome: <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />';
	if ($is_admin)
		echo '<p style="color:brown">Este grupo têm sempre todas as permissões e não pode ser alterado</p>';
	if (isset($is_v) && $is_v) 
		echo '<p style="color:red">Atenção, este é um grupo especial. Não pode ser eliminado e as suas alterações refletctem-se em todos os utilizadores não autenticados. <br/>
		Assim as permissões de inserção/modificação/eliminação devem ser cuidadosamente atribuídas já que um utilizador deste tipo não possui registo.</p>';
	echo '
		<table style="margin:10px;"><tr><th class="th_normal">Tipo</th><th class="th_normal" style="width:50px;">Ver</th><th class="th_normal" style="width:50px;">Inserir</th><th class="th_normal" style="width:50px;">Actualizar</th><th class="th_normal" style="width:50px;">Eliminar</th></tr>';
		foreach($gperms as $chave => $valor){
			echo "<tr><td class='td_normal' style='text-align:left'>".$valor['nome'].":</td>";
			echo "<td class='td_normal'><input type='checkbox' name='perms_s_$chave' ".($is_admin ? "disabled='true'" : "").($valor['S'] ? "checked='true'" : '')." value='s'></input></td>";
			echo "<td class='td_normal'><input type='checkbox' name='perms_i_$chave' ".($is_admin ? "disabled='true'" : "").($valor['I'] ? "checked='true'" : '')." value='i'></input></td>";
			echo "<td class='td_normal'><input type='checkbox' name='perms_u_$chave' ".($is_admin ? "disabled='true'" : "").($valor['U'] ? "checked='true'" : '')." value='u'></input></td>";
			echo "<td class='td_normal'><input type='checkbox' name='perms_r_$chave' ".($is_admin ? "disabled='true'" : "").($valor['R'] ? "checked='true'" : '')." value='r'></input></td>";
			echo "</tr>";
		}
	echo '</table><br/>';
	
		
	echo TPL::BtnsForm('groups/ver/?id='.$form_id).'</form></div>';

?>