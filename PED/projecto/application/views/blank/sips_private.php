<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
echo '<form method="post" onSubmit="return checkForm()" action="'.TPL::base().$route.'/update" style="padding:10px;" enctype="multipart/form-data">
            <fieldset>
                <legend>Logs File:</legend> 
                <input type="hidden" id="form_id" name="form_id" value="'.$form_id.'"/>
                <input type="hidden" id="isForm" name="isForm" value="0"/>
                <table>
                    '.($canBePrivate ? '<tr><td>'.__('Private').': </td><td><input type="checkbox" name="privado" value="1"/></td></tr>' : '').'
				</table>
			</fieldset>
    '.TPL::BtnsForm($route).'
</form>';

?>
