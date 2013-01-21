<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
?>
<script type="text/javascript">
    var cs = 1;
    var ca = 1;
    var cr = 1;
    function simpleadd(pre, conta){
        tr = document.createElement("TR");
        tr.innerHTML += 
           "<td>" + conta + "</td>" +
            "<td><input type='text' name='"+pre+"nome"+conta+"'/></td>" +
            "<td><input type='text' name='"+pre+"id"+conta+"'/></td>" + 
            "<td><input type='text' name='"+pre+"mail"+conta+"'/></td>" +
            "<td><input type='text' name='"+pre+"web"+conta+"'/></td>" ;
        return tr;
    }
    function adicionaSuper(nome){
        document.getElementById('tbl'+nome).appendChild(simpleadd('s',cs));
        cs++;
    }
    function adicionaAutor(nome){
        document.getElementById('tbl'+nome).appendChild(simpleadd('a',ca));
        ca++;
     }
     function adicionaRes(nome){
        tr = document.createElement("TR");
        tr.innerHTML += 
            "<td>" + cr + "</td>" +
            "<td><input type='file' name='rurl"+cr+"'/></td>" +
            "<td><input type='text' name='rdesc"+cr+"'/></td>";
        document.getElementById('tbl'+nome).appendChild(tr);
        cr++;
     }
</script>
<?php 

$sip['autores'] = Arr::get($sip, 'autores', array());
$sip['supervisores'] = Arr::get($sip, 'supervisores', array());
$sip['resultados'] = Arr::get($sip, 'resultados', array());
echo '<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().$route.($form_id != null ? '/update' : '/insere2').'" style="padding:10px;" enctype="multipart/form-data">
    <fieldset>
        <legend>SIP:</legend>
        <input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
        <input type="hidden" id="isForm" name="isForm" value="1"/>    
        <table>
            <tr><td>'.__('Category').': </td><td>'.TPL::createSelect('categoria', $categorias, $categoria).'</td></tr>
            '.($canBePrivate ? '<tr><td>'.__('Private').': </td><td><input type="checkbox" name="privado" value="1" '.(Arr::get($sip, 'privado', 0) ? 'checked="true" ': '').'/></td></tr>' : '').'
            <tr><td>'.__('Identifier').':</td><td> <input type="text" name="id" value="'.Arr::get($sip, 'ident', '').'"/><br/></td></tr>
            <tr><td>'.__('Title').':</td><td> <input type="text" name="titulo" value="'.Arr::get($sip, 'titulo', '').'"/><br/></td></tr>
            <tr><td>'.__('Subtitle').': </td><td><input type="text" name="subtitulo" value="'.Arr::get($sip, 'subtitulo', '').'"/><br/></td></tr>
            <tr><td>'.__('Start Date').': </td><td><input type="text" name="data_inic" value="'.Arr::get($sip, 'data_inic', '').'"/><br/></td></tr>
            <tr><td>'.__('End Date').':</td><td> <input type="text" name="data_fim" value="'.Arr::get($sip, 'data_fim', '').'"/><br/></td></tr>
            <tr><td><button type="button" onclick="javascript:adicionaSuper(\'Super\')">'.__('Add Supervisors').'</button><br/> </td>
            <td>
                <div id="Super">
                    <table style="text-align:center;" id="tblSuper"><tr><th>'.__('Supervisor').'</th><th>'.__('Name').'</th><th>'.__('Identifier').'</th><th>'.__('Email').'</th><th>'.__('Web').'</th></tr></table>
                </div>
            </td></tr>

            <tr><td><button type="button" onclick="javascript:adicionaAutor(\'Autor\')">'.__('Add Authors').'</button><br/> </td>
            <td>
                <div id="Autor">
                    <table style="text-align:center;" id="tblAutor"><tr><th>'.__('Author').'</th><th>'.__('Name').'</th><th>'.__('Identifier').'</th><th>'.__('Email').'</th><th>'.__('Web').'</th></tr></table>
                </div>
            </td></tr>

            <tr><td>'.__('Abstract').':</td><td> <textarea rows="10" cols="50" name="resumo">';
            
            $aux = "";
            foreach(Arr::get($sip, 'resumo', array()) as $valor)
                $aux .= $valor['para']."\n";
            echo substr($aux,0,-1).'</textarea><br/></td></tr>

            <tr><td><button type="button" onclick="javascript:adicionaRes(\'Resultados\')">'.__('Add Results').'</button><br/> </td>
            <td>
                <div id="Resultados">
                    <table style="text-align:center;" id="tblResultados"><tr><th>'.__('Result').'</th><th>Url</th><th>'.__('Description').'</th></tr></table>
                </div>
            </td></tr>

        </table>
    </fieldset>
    '.TPL::BtnsForm($route).'
</form>';


$c1 = array("id" => "identificador", "nome" => "nome", "mail"=>"email", "web"=>"web");
$c2 = array("url" => "", "desc" => "desc");
echo '<script type="text/javascript">
    '.createEnable($c1, $c2).'
    var el = null;';

echo javascriptAutoAdd('adicionaAutor',$sip['autores'], 'Autor', 'a', $c1);
echo javascriptAutoAdd('adicionaSuper',$sip['supervisores'], 'Super', 's', $c1);

echo javascriptAutoAdd('adicionaRes', $sip['resultados'], 'Resultados', 'r', $c2);

          
echo '</script>';

function createEnable($c1, $c2){
    return 'function checkForm(){
        var i;
        '.colocafor($c1, 'a').colocafor($c1, 's').colocafor($c2, 'r').'
        return true;
    }';
}

function colocafor($cm, $p){
    $aux = 'for(i=1;i<c'.$p.';i++){
            ';
    foreach ($cm as $c => $v)
        if ($v != "") $aux.= 'document.forms[0]["'.$p.$c.'"+i].disabled=false;'."\n";
    $aux .= "}\n";
    return $aux;
}

function javascriptAutoAdd($fn, $arr, $place, $pre, $campos){
    $i = 1;
    $aux = "";
    foreach($arr as $valor){
        $aux .= $fn.'("'.$place.'");'."\n";
        foreach($campos as $c => $v){
            $aux .= 'el = document.forms[0]["'.$pre.$c.$i.'"];';
            if ($v != "") $aux .= 'el.value="'.$valor[$v].'";'."\n";
            $aux .= 'el.disabled=true;';
        }
        $i++;
    }
    return $aux;
}

?>
