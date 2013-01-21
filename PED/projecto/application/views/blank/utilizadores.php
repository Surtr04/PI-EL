<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar($route.'/insere', __('Insert new user')).'</p><br/><br/>';
	

	$c = array('Username', 'Name', 'Email', 'Group', 'Online');
    $v = array('username' => 0, 'nome' => 0, 'email' => 0, 'ngrupo' => 0, 'is_online' => 'YesNo');
    echo TPL::showInfos($c, $v, $lista, $perms, $route);
    
    
    /*echo '<table style="margin:10px;"><tr><th class="th_normal">'.__('Username').'</th><th class="th_normal">'.__('Name').'</th><th class="th_normal">'.__('Email').'</th><th class="th_normal">'.__('Group').'</th><th class="th_normal">'.__('Online').'</th>'.(($perms['U'] || $perms['D']) ? '<th class="th_normal">'.__('Actions').'</th>' : '').'</tr>';
	foreach($users as $chave => $valor){
		echo "<tr><td class='td_normal'>".$valor['username']."</td><td class='td_normal'>".$valor['nome']."</td><td class='td_normal'>".$valor['email']."</td><td class='td_normal'>".$grupos[$valor['grupo']]['nome']."</td><td class='td_normal'>".($valor['is_online'] ? __('Yes') : __('No'))."</td>";
		if ($perms['U'] || $perms['D'])echo "<td class='td_normal'>".($perms['U'] ? TPL::LinkEditar('users/editar/?id='.$valor['id'], '') :'').($perms['D'] ? (' '.TPL::LinkApagar('users/apagar/?id='.$valor['id'], '')) :'')."</td>";
		echo "</tr>";
	}
	echo '</table>';*/
	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';
    
    
    function YesNo($v, $valor){return ( $v ? __('Yes') : __('No'));}

?>