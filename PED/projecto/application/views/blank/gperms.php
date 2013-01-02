<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	echo '<h2>'.$nome.' '.TPL::LinkEditar('groups/editar/?id='.$id, '').'</h2>';
	

	echo '<table style="margin:10px;"><tr><th class="th_normal">'.__('Type').'</th><th class="th_normal" style="width:50px;">'.__('See').'</th><th class="th_normal" style="width:50px;">'.__('Insert').'</th><th class="th_normal" style="width:50px;">'.__('Refresh').'</th><th class="th_normal" style="width:50px;">'.__('Eliminate').'</th></tr>';
	foreach($gperms as $chave => $valor){
		echo colocar(__($valor['nome']), $valor['S'], $valor['I'], $valor['U'], $valor['D']);
		$mtipos[$valor['id']] = true;
	}
	
	
	echo '</table>';
	
	echo '</div>';

	function colocar($nome, $s, $i, $u, $d){
		$aux = "";
		$aux .= "<tr><td class='td_normal'>".$nome."</td>";
        foreach(array($s, $i, $u, $d) as $v)
                $aux .= "<td class='td_normal'><img alt='".($v ? __('Permitted') : __('Denied'))."' src='".TPL::vazio()."' class='class_links class_".($v ? "accept":"cancel")."'></img></td>";

		$aux .= "</tr>";
		return $aux;
	}
?>