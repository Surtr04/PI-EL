<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" action="'.TPL::base().($form_id != NULL ? 'groups/update' : 'groups/insere2').'" style="padding:10px;">
		<input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
		'.__('Name').': <input type="text" id="nome" name="nome" style="margin-top:10px;width:50%;" value="'.$nome.'"/><br />';
	if ($is_admin)
		echo '<p style="color:brown">'.__('This group always has all permissions and can not be changed').'</p>';
	if (isset($is_v) && $is_v) 
		echo '<p style="color:red">'.__('GuestGroupWarning').'</p>';
    $aux = array('S' => 's', 'I' => 'i', 'U' => 'u', 'D' => 'd' );
	echo '
		<table style="margin:10px;"><tr><th class="th_normal">'.__('Type').'</th><th class="th_normal" style="width:50px;">'.__('See').'</th><th class="th_normal" style="width:50px;">'.__('Insert').'</th><th class="th_normal" style="width:50px;">'.__('Refresh').'</th><th class="th_normal" style="width:50px;">'.__('Eliminate').'</th></tr>';
		foreach($gperms as $chave => $valor){
            echo "<tr><td class='td_normal' style='text-align:left'>".__($valor['nome']).":</td>";
            foreach($aux as $c => $v) 
                echo "<td class='td_normal'><input type='checkbox' name='perms_".$v."_$chave' ".($is_admin ? "disabled='true'" : "").($valor[$c] ? "checked='true'" : '')." value='$v'></input></td>";
			echo "</tr>";
		}
	echo '</table><br/>';
	
		
	echo TPL::BtnsForm('groups/ver/?id='.$form_id).'</form></div>';

?>