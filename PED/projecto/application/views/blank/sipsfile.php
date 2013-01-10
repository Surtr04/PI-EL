<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
echo '<form method="post" onSubmit="return checkForm()" action="'.TPL::base().$route.'/insere2" style="padding:10px;" enctype="multipart/form-data">
            <fieldset>
                <legend>Logs File:</legend> 
                <input type="hidden" id="isForm" name="isForm" value="0"/>
                <table>
                    <tr><td>'.__('Category').': </td><td>'.TPL::createSelect('categoria', $categorias, $categoria).'</td></tr>
                    '.($canBePrivate ? '<tr><td>'.__('Private').': </td><td><input type="checkbox" name="privado" value="1"/></td></tr>' : '').'
					<tr><td>'.__('File').'</td><td><input type="file" name="sip"/></td><td></td></tr>
				</table>
			</fieldset>
    '.TPL::BtnsForm($route).'
</form>';

?>
