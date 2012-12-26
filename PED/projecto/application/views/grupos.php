<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar('groups/insere', __('Insert new group')).'</p><br/><br/>';
	

	echo '<table style="margin:10px;"><tr><th class="th_normal">'.__('Group').'</th>'.(($perms['U'] || $perms['D']) ? '<th class="th_normal">'.__('Actions').'</th>' : '').'</tr>';
	foreach($grupos as $chave => $valor){
		echo "<tr><td class='td_normal'>".$valor['nome']."</td>";
		if ($perms['U'] || $perms['D']) echo "<td class='td_normal'>".TPL::LinkVer('groups/ver/?id='.$valor['id'], '').' '.($perms['U'] ? TPL::LinkEditar('groups/editar/?id='.$valor['id'], '') :'').( isApagavel($perms, $valor['id']) ? (' '.TPL::LinkApagar('groups/apagar/?id='.$valor['id'], '')) :'')."</td>";
		echo "</tr>";
	}
	echo '</table>';
	echo TPL::NavLista($min, $int, count($grupos), 'groups');
	echo '</div>';
	function isApagavel($perms, $id){ return $perms['D'] && $id != Kohana::$config->load('defs.admin') && $id != Kohana::$config->load('defs.guest'); }
?>