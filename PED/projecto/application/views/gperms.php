<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
	echo '<h2>'.$nome.' '.TPL::LinkEditar('groups/editar/?id='.$id, '').'</h2>';
	

	echo '<table style="margin:10px;"><tr><th class="th_normal">Tipo</th><th class="th_normal" style="width:50px;">Ver</th><th class="th_normal" style="width:50px;">Inserir</th><th class="th_normal" style="width:50px;">Actualizar</th><th class="th_normal" style="width:50px;">Eliminar</th></tr>';
	foreach($gperms as $chave => $valor){
		echo colocar($valor['nome'], $valor['S'], $valor['I'], $valor['U'], $valor['R']);
		$mtipos[$valor['id']] = true;
	}
	
	
	echo '</table>';
	
	echo '</div>';

	function colocar($nome, $s, $i, $u, $r){
		$aux = "";
		$aux .= "<tr><td class='td_normal'>".$nome."</td>";
		$aux .= "<td class='td_normal'><img alt='".($s ? "Permitido": "Negado")."' src='".TPL::vazio()."' class='class_links class_".($s ? "accept":"cancel")."'></img></td>";
		$aux .= "<td class='td_normal'><img alt='".($i ? "Permitido": "Negado")."' src='".TPL::vazio()."' class='class_links class_".($i ? "accept":"cancel")."'></img></td>";
		$aux .= "<td class='td_normal'><img alt='".($u ? "Permitido": "Negado")."' src='".TPL::vazio()."' class='class_links class_".($u ? "accept":"cancel")."'></img></td>";
		$aux .= "<td class='td_normal'><img alt='".($r ? "Permitido": "Negado")."' src='".TPL::vazio()."' class='class_links class_".($r ? "accept":"cancel")."'></img></td>";
		$aux .= "</tr>";
		return $aux;
	}
?>