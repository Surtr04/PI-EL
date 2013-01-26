<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar($route.'/insere', __('Insert new')).'</p><br/><br/>';
	

    $c = array('Identifier', 'Name', 'Email', 'Web');
    $v = array('identificador' => 0, 'nome' => 0, 'email' => 'makeMail', 'web' => 'makeWeb');
    echo TPL::showInfos($c, $v, $lista, $perms, $route);
    
	
	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';
    
    function makeMail($v, $valor){return '<a href="mailto:'.$v.'">'.$v.'</a>';}
    function makeWeb($v, $valor){return '<a href="'.$v.'">'.$v.'</a>';}
?>