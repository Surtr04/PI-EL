<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
    
    
    
    $show = (!$bycat || $categoria["aberta"]);
	if ($perms['I'] && $show){ 
        echo '<div class="btn-group">';
        echo TPL::LinkAdicionar($route.'/insere'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('Form'). ')');
        echo TPL::LinkAdicionar($route.'/insereFile'.(isset($bycat) && $bycat ? '/'.$categoria['id'] : ''), __('Insert new sip') . ' (' . __('File').')');
    }
    
    if ($bycat) echo TPL::LinkDownZip('categories/downzip/?id='.$categoria['id'], __('Download category sips'))."<br/><br/>";

    if ($perms['I'] && $show) echo '</div><br/><br/>'; else echo '<br/><br/>';
    
    foreach($lista as &$valor){
        $valor["own"] = ($valor["submetido"] == $userid);
        if ($valor["privado"]) $valor['__class'] = 'warning';
    }
    
    
    $c = array('Identifier', 'Title', 'Subtitile', 'Start Date', 'End Date', 'Submission Date', 'User', 'Private');
    $v = array('ident' => 0, 'titulo' => 0, 'subtitulo' => 0, 'data_inic' => 0, 'data_fim' => 0, 'data_submissao' => 0, 'username' => 0, 'privado' => 'YesNo');
    if (!isset($bycat) || !$bycat) {$c[] = 'Category'; $v['categoria']= 'categoriaLink';}
    $special = ($catperms['D']  ? true : 'canDelete');
    $actions = array('see'=> true, 'edit'=>true, 'downzip'=>true, 'delete' => $special);
    
    echo TPL::showInfos($c, $v, $lista, $perms, $route, $actions);
    

	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';

    function YesNo($v, $valor){return ( $v ? __('Yes') : __('No'));}
    
    function canDelete($id, $perm, $valor){
        return ($valor["canDelete"] && $valor["categoria_aberta"] && ($perm > 1 || $valor["own"]));
    }
    
    function categoriaLink($categoria, $valor){
        return '<a href="'.Route::url('bycat', array('id' => $valor['id_categoria'])).'">'.$categoria.'</a>';
    }
    
?>