<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar('users/insere', 'Inserir novo utilizador').'</p><br/><br/>';
	

	echo '<table style="margin:10px;"><tr><th class="th_normal">Nome de Utilizador</th><th class="th_normal">Nome</th><th class="th_normal">Email</th><th class="th_normal">Grupo</th><th class="th_normal">Online</th>'.(($perms['U'] || $perms['R']) ? '<th class="th_normal">Acções</th>' : '').'</tr>';
	foreach($users as $chave => $valor){
		echo "<tr><td class='td_normal'>".$valor['username']."</td><td class='td_normal'>".$valor['nome']."</td><td class='td_normal'>".$valor['email']."</td><td class='td_normal'>".$grupos[$valor['grupo']]['nome']."</td><td class='td_normal'>".($valor['is_online'] ? 'Sim' : 'Não')."</td>";
		if ($perms['U'] || $perms['D'])echo "<td class='td_normal'>".($perms['U'] ? TPL::LinkEditar('users/editar/?id='.$valor['id'], '') :'').($perms['D'] ? (' '.TPL::LinkApagar('users/apagar/?id='.$valor['id'], '')) :'')."</td>";
		echo "</tr>";
		/*echo "<p id='user".$valor['id']."'><b>".$valor["user"]."</b><br/>".$valor["descricao"]."</p><b>".$data."</b>
		".($perms['U'] ? TPL::LinkEditar('eventos/editar/?id='.$valor['id']) :'').($perms['R'] ? (' '.TPL::LinkApagar('eventos/apagar/?id='.$valor['id'])) :''). "
		<hr/><br/>";*/
	}
	echo '</table>';
	echo TPL::NavLista($min, $int, count($users), 'users');
	/*if ($min > 0) echo '<a href="'.url::base().'eventos/?s='.($min-$int).'">&lt;&lt;Retroceder</a> ';
	if ($min + $int <= count($evts)) echo '<a href="'.url::base().'eventos/?s='.($min+$int).'">Avançar&gt;&gt;</a>';*/
	echo '</div>';

?>