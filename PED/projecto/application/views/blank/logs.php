<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar('logs/insere', __('Insert new log')).'</p><br/><br/>';
	

    $c = array('Time', 'Operation', 'User', 'Message');
    $v = array('data' => 0, 'operacao' => 0, 'username' => 0, 'descricao' => 'makeDescription');
    echo TPL::showInfos($c, $v, $logs, $perms, $route, array('edit'=>'verificaP', 'delete'=>'verificaP'));
    
	/*echo '<table style="margin:10px;"><tr><th class="th_normal">'.__('Time').'</th><th class="th_normal">'.__('Operation').'</th><th class="th_normal">'.__('User').'</th><th class="th_normal">'.__('Message').'</th>'.(($perms['U'] || $perms['D']) ? '<th class="th_normal">'.__('Actions').'</th>' : '').'</tr>';
	foreach($logs as $chave => $valor){
		echo "<tr><td class='td_normal'>".$valor['data']."</td><td class='td_normal'>".$valor['operacao']."</td><td class='td_normal'>".$valor['username']."</td><td class='td_normal'>".__($valor['descricao'], array(':user' => $valor['utilizador'], ':username' => $valor['username'], ':time' => $valor['data']))."</td>";
		if (!$valor['auto'] && ($perms['U'] || $perms['D']))echo "<td class='td_normal'>".($perms['U'] ? TPL::LinkEditar('logs/editar/?id='.$valor['id'], '') :'').($perms['D'] ? (' '.TPL::LinkApagar('logs/apagar/?id='.$valor['id'], '')) :'')."</td>";
		echo "</tr>";
	}
	echo '</table>';*/
	echo TPL::NavLista($min, $int, count($logs), $route);
	echo '</div>';

    
    function verificaP($id, $perm, $valor){
        return !$valor['auto'] && $perm;
    }
    function makeDescription($desc, $valor){
        return __($desc, array(':user' => $valor['utilizador'], ':username' => $valor['username'], ':time' => $valor['data']));
    }
    
?>