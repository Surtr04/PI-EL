<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar($route.'/insere', __('Insert new category')).'</p><br/><br/>';
	

    $c = array('Category', 'Start Date', 'End Date', 'Opened');
    $v = array('nome' => 'makeLinkCat', 'inicio' => 0, 'fim' => 0, 'aberta' => 'YesNo');
    echo TPL::showInfos($c, $v, $lista, $perms, $route, array('edit'=>true, 'delete'=>true, 'downzip'=>true));
    
	/*echo '<table style="margin:10px;"><tr><th class="th_normal">'.__('Category').'</th><th class="th_normal">'.__('Start Date').'</th><th class="th_normal">'.__('End Date').'</th><th class="th_normal">'.__('Opened').'</th>'.(($perms['U'] || $perms['D']) ? '<th class="th_normal">'.__('Actions').'</th>' : '').'</tr>';
	foreach($lista as $chave => $valor){
		echo "<tr><td class='td_normal'><a href='".Route::url('bycat', array('id' => $valor['id']))."'>".$valor['nome']."</a></td><td class='td_normal'>".$valor['inicio']."</td><td class='td_normal'>".$valor['fim']."</td><td class='td_normal'>".($valor['aberta'] ? __('Yes') : __('No'))."</td>";
		if ($perms['U'] || $perms['D']) echo "<td class='td_normal'>".TPL::LinkVer('sips/bycat/'.$valor['id'], ''). " ".($perms['U'] ? TPL::LinkEditar($route.'/editar/?id='.$valor['id'], '') :'').( $perms['D'] ? (' '.TPL::LinkApagar($route.'/apagar/?id='.$valor['id'], '')) :'')."</td>";
		echo "</tr>";
	}
	echo '</table>';*/
	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';
    
    function YesNo($v, $valor){return ( $v ? __('Yes') : __('No'));}
    
    function makeLinkCat($cat, $valor){
        return '<a href="'.Route::url('bycat', array('id' => $valor['id'])).'">'.$valor['nome'].'</a>';
    }
?>