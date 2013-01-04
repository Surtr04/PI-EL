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
echo '<form method="POST" onSubmit="return checkForm()" action="'.TPL::base().$route.($form_id != NULL ? '/update' : '/insere2').'" style="padding:10px;" enctype="multipart/form-data">
    <fieldset>
        <legend>SIP:</legend>
        <input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
        <input type="hidden" id="isForm" name="isForm" value="1"/>
        <table>
            <tr><td>'.__('Category').': </td><td>'.TPL::createSelect('categoria', $categorias, $categoria).'</td></tr>
            <tr><td>'.__('Identifier').':</td><td> <input type="text" name="id"/><br/></td></tr>
            <tr><td>'.__('Title').':</td><td> <input type="text" name="titulo"/><br/></td></tr>
            <tr><td>'.__('Subtitle').': </td><td><input type="text" name="subtitulo"/><br/></td></tr>
            <tr><td>'.__('Start Date').': </td><td><input type="text" name="data_inic"/><br/></td></tr>
            <tr><td>'.__('End Date').':</td><td> <input type="text" name="data_fim"/><br/></td></tr>
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

            <tr><td>'.__('Abstract').':</td><td> <textarea rows="10" cols="50" name="resumo"></textarea><br/></td></tr>

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

?>
