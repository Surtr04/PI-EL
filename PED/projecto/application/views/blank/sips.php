<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    if ($bycat) echo TPL::LinkDownZip('categories/downzip/?id='.$categoria['id'], __('Download category sips'));
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: auto; text-align:left;">';
    
    
    $show = (!$bycat || $categoria["aberta"]);
    
	if ($perms['I'] && $show){ 
        echo '<p>'.TPL::LinkAdicionar($route.'/insere'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('Form')).')<br/>';
        echo TPL::LinkAdicionar($route.'/insereFile'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('File')).')</p><br/><br/>';
    }
	
 
    $c = array('Identifier', 'Title', 'Subtitile', 'Start Date', 'End Date', 'Submission Date', 'User');
    $v = array('ident' => 0, 'titulo' => 0, 'subtitulo' => 0, 'data_inic' => 0, 'data_fim' => 0, 'data_submissao' => 0, 'username' => 0);
    if (!isset($bycat) || !$bycat) {$c[] = 'Category'; $v['categoria']= 'categoriaLink';}
    $actions = array('see'=> true, 'edit'=>false, 'downzip'=>true);
    $actions['delete'] = ($catperms['D'] ? true : 'canDelete');
    echo TPL::showInfos($c, $v, $lista, $perms, $route, $actions);
    

	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';

    function canDelete($id, $perm, $valor){
        return ($valor["categoria_aberta"] && $perm);
    }
    
    function categoriaLink($categoria, $valor){
        return '<a href="'.Route::url('bycat', array('id' => $valor['id_categoria'])).'">'.$categoria.'</a>';
    }
    
?>