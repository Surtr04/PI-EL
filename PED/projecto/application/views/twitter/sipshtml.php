<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
    echo '<style type="text/css">
    #rptitle{
        color:white !important;
        width:95% !important;
        height:50px !important;
        text-align:center !important;
        border-radius: 5px !important;
        background-image: linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
        background-image: -o-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
        background-image: -moz-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
        background-image: -webkit-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
        background-image: -ms-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;

        background-image: -webkit-gradient(
            linear,
            left top,
            left bottom,
            color-stop(0, rgb(54,111,180)),
            color-stop(1, rgb(0,42,89))
        ) !important;
        margin: auto !important;
    }
    .block{
        border-color: rgb(54,111,180) !important;
        border-style: ridge !important;
        border-width: 3px !important;
        border-radius: 5px !important;
        box-shadow: 0px 0px 2px 2px rgb(0,42,89) !important;
        padding: 5px !important;
        vertical-align: top !important;
    }	
    #rptitle h1{
        padding: 2px !important;
    }
    table{
        width:95% !important;
        border-spacing: 8px !important;
        border-collapse: separate !important;
        margin:auto !important;
    }
</style>';
	echo '<div style="margin: auto; padding: 15px; width: auto; text-align:left;">';
    echo '<div id="rptitle"><h1>['.$lista['titulo'].']</h1></div>';
	echo '<table>
        <tr>
            <td style="width:70%; text-align: justify;" class="block" rowspan="4">';
    if ($lista['subtitulo'] == '') $lista['subtitulo'] = __('Abstract');
    echo '     <h2>'.$lista['subtitulo'].'</h2>';
    foreach($lista["resumo"] as $valor)
        echo '<p>'.$valor['para'].'</p>';
	echo '  </td>
            <td style="width:30%;" class="block">';    
    if ($lista['data_inic'] !== null) echo '<b>'.__('Start Date').': </b>'.$lista['data_inic'].'<br>';
    echo '<b>'.__('End Date').': </b>'.$lista['data_fim'].'</td></tr>';
    
    
    echo '<tr><td style="width:30%;" class="block"><h2>'.__('Authors').':</h2><ul>';
    foreach($lista["autores"] as $valor)
        echo pessoa2string($valor);
    echo '</ul></td></tr>';
    
    echo '<tr><td style="width:30%;" class="block"><h2>'.__('Supervisors').':</h2><ul>';
    foreach($lista["supervisores"] as $valor)
        echo pessoa2string($valor);
    echo '</ul></td></tr>';
    
    echo '<tr><td style="width:30%;" class="block"><h2>'.__('Results').':</h2><ol>';
    foreach($lista["resultados"] as $valor)
        echo '<li><a target="_blank" alt="'.$valor['realname'].'" href="'.Route::url('resget', array('type' => 'doc', 'id' => $valor['id'])).'">'.$valor['desc'].'</a></li>';
    echo '
            </ol>
        </td></tr></table>
    <h5><b>'.__('Category').': </b><a href="'.Route::url('bycat', array('id' => $lista['id_categoria'])).'">'.$categoria.'</a></h5>';
    
    echo '</div>';
    
    function pessoa2string($p){
        return '<li>
                    <b>'.$p['nome'].'</b><br>
                    <ul>
                        <li><b>'.__('Identifier').': </b>'.$p['identificador'].'</li>
                        '.($p['email'] != '' ? '<li><b>'.__('Email').': </b><a href="malito:'.$p['email'].'">'.$p['email'].'</a></li>' : '').'
                        '.($p['web'] != '' ? '<li><b>'.__('Web').': </b><a href="'.$p['web'].'">'.$p['web'].'</a></li>' : '').'
                    </ul>
                </li>';
    }
?>