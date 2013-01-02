<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
    
	if ($perms['I'] && (!$bycat || $categoria["aberta"])){ 
        echo '<p>'.TPL::LinkAdicionar($route.'/insere'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('Form')).')<br/>';
        echo TPL::LinkAdicionar($route.'/insereFile'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('File')).')</p><br/><br/>';
    }
	

    $c = array('Identifier', 'Title', 'Subtitile', 'Start Date', 'End Date', 'Submission Date', 'User', 'Category');
    $v = array('ident' => 0, 'titulo' => 0, 'subtitulo' => 0, 'data_inic' => 0, 'data_fim' => 0, 'data_submissao' => 0, 'username' => 0, 'categoria' => 'categoriaLink');
    echo TPL::showInfos($c, $v, $lista, $perms, $route, array('see'=> true, 'edit'=>false, 'delete'=>true));
    

	echo TPL::NavLista($min, $int, count($lista), $route);
	echo '</div>';

    function categoriaLink($categoria, $valor){
        return '<a href="'.Route::url('bycat', array('id' => $valor['id_categoria'])).'">'.$categoria.'</a>';
    }
    
?>