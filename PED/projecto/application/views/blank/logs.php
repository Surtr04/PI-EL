<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
    echo '
    <div class="form-inline">
        <span>De: </span>
        <input data-datepicker-format="dd/mm/yyyy" data-datepicker-nodefault="false" class="input-small" type="date" id="dia_from" name="dia_from"/>
        <span>Até:</span>
        <input data-datepicker-format="dd/mm/yyyy" data-datepicker-nodefault="false" class="input-small" type="date" id="dia_to" name="dia_to"/>
        <div class="btn-group">
            '.TPL::LinkDownZip(array('href' => '#', 'onclick' => 'javascript:sendDates()'), __('Get')).'
        </div>
    </div>
    <script type="text/javascript">
        function sendDates(){
            var loc = "'.TPL::base().'/logs/export?"
            var from = $("#dia_from").val();
            var to = $("#dia_to").val();
            loc += "after="+from+"&before="+to;
            window.location = loc;
        }
    </script>    
    <br/>';
	if ($perms['I']) echo '<p>'.TPL::LinkAdicionar('logs/insere', __('Insert new log')).'</p><br/><br/>';
	

    $c = array('Time', 'Operation', 'User', 'Message');
    $v = array('data' => 0, 'operacao' => 0, 'username' => 0, 'descricao' => 'makeDescription');
    echo TPL::showInfos($c, $v, $lista, $perms, $route, array('edit'=>'verificaP', 'delete'=>'verificaP'));
    

	echo TPL::NavLista($min, $int, $total, $route);
	echo '</div>';

    
    function verificaP($id, $perm, $valor){
        return !$valor['auto'] && $perm;
    }
    function makeDescription($desc, $valor){
        return __($desc, array_merge(array(':user' => $valor['utilizador'], ':username' => $valor['username'], ':time' => $valor['data']), $valor['params'] ));
    }
    
?>