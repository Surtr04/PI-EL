<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar($route.'/insere', __('Insert new category')).'</p><br/><br/>';
	

    $c = array('Category', 'Start Date', 'End Date', 'Opened', 'Can delete sips');
    $v = array('nome' => 'makeLinkCat', 'inicio' => 0, 'fim' => 0, 'aberta' => 'YesNo', 'canDelete' => 'YesNo');
    echo TPL::showInfos($c, $v, $lista, $perms, $route, array('edit'=>true, 'delete'=>true, 'downzip'=>true));
    
	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';
    
    function YesNo($v, $valor){return ( $v ? __('Yes') : __('No'));}
    
    function makeLinkCat($cat, $valor){
        return '<a href="'.Route::url('bycat', array('id' => $valor['id'])).'">'.$valor['nome'].'</a>';
    }
?>