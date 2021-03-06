<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	if ($is_admin) echo '<div style="width:95%; margin: auto;" class="alert alert-error">'.__('This group always has all permissions and can not be changed').'</div>';
	if (isset($is_v) && $is_v) echo '<div style="width:95%; margin: auto;" class="alert">'.__('GuestGroupWarning').'</div>';
	
	
	$c = array('Type', 'See', 'Insert', 'Refresh', 'Delete');
    $v = array('nome' => 'makeNome', 'S' => 'makeCheckS', 'I' => 'makeCheckI', 'U' => 'makeCheckU', 'D' => 'makeCheckD');
	
	foreach($gperms as $chave => &$valor){
		$valor['chave'] = $chave;
		$valor['is_admin'] = $is_admin;
	}
	
	$form = array();
	$form[] = array("tipo" => "hidden", "nome" => 'form_id', "valor" => $form_id);
    $form[] = array("label" => __('Name'), "nome" => 'nome', "valor" => $nome);
    $form[] = array("tipo" => 'free', "valor" => TPL::showInfos($c, $v, $gperms, $perms, $route, array()));
    
    echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;  -moz-border-radius: 15px; border-radius: 15px;">'.
    TPL::makeForm($form, TPL::base().($form_id != NULL ? 'groups/update' : 'groups/insere2'), TPL::BtnsForm(($form_id != null ? 'groups/ver/?id='.$form_id : 'groups'))).
    '</div>';
	
	
    function makeNome($nome, $valor){return __($nome);}
	function makeCheckS($v, $valor){ return makeCheck('S', 's', $valor);}
	function makeCheckI($v, $valor){ return makeCheck('I', 'i', $valor);}
	function makeCheckU($v, $valor){ return makeCheck('U', 'u', $valor);}
	function makeCheckD($v, $valor){ return makeCheck('D', 'd', $valor);}
	function makeCheck($c, $v, $valor){
		//($is_admin ? "disabled='true'" : "")
		return TPL::instance()->createCheckbox(array('nome' => 'perms_'.$v.'_'.$valor['chave'], 'valor' => $v, 'checked' => $valor[$c], 'disabled' => $valor['is_admin']));
	}

?>
