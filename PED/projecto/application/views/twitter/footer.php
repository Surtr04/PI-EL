<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

function myspReplace($txt){
	$txt = str_replace(':','%3a', $txt);
	$txt = str_replace('/','%2f', $txt);
	return $txt;
}
?>

<div id="down">
<p>Copyright @ António Silva e Rui Brito, 2012/2013. Todos os direitos reservados.
	<!--<a title="XHTML 1.0 Válido" href="http://validator.w3.org/check?uri=<?php echo myspReplace(TPL::base());?>" target="_blank"> <img width="80" height="15" border="0" alt="XHTML 1.0 Válido" src="<?php echo TPL::base();?>images/button-xhtml.png" /></a>&nbsp;
	<a title="CSS 3 Válido" href="http://jigsaw.w3.org/css-validator/check?uri=<?php echo myspReplace(TPL::base());?>" target="_blank"> <img width="80" height="15" border="0" alt="CSS 3 Válido" src="<?php echo TPL::base(); ?>images/button-css.png" /></a>&nbsp;-->
	<?php 
		if ($isUserAdmin)
		 echo '<a title="'.__('Maintenance').'" href="' .TPL::base()."manut/".($isManut ? "de" : "").'activate"> <img width="80" height="15" border="0" alt="'.__('Maintenance').'" '.($isManut ? 'style="opacity:1;"' : 'style="opacity:0.5;"' ) .' src="'.TPL::base().'images/button-manut.png" /> </a>';
	?>
    <br/>
    <a rel="language" href="<?php echo TPL::base(); ?>langs/pt"><img alt="Português" style="border-width: 0" src="<?php echo TPL::base(); ?>images/Portugal.png"/></a>
	<a rel="language" href="<?php echo TPL::base(); ?>langs/en"><img alt="Inglês" style="border-width: 0" src="<?php echo TPL::base(); ?>images/UK.png"/></a>
	<?php echo TPL::createSelect('themes', array(array('id' => 'twitter', 'nome' => 'Twitter'), array('id' => 'blank', 'nome' => 'Blank')), 'twitter'); ?>
</p>


</div>
<div id="modalDelete" class="modal hide fade">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h3><?php echo __('Confirmation'); ?></h3>
	</div>
	<div class="modal-body">
		<p id="modalText"></p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true"><?php echo __('Cancel'); ?></button>
		<a  id="modalApply" href="" class="btn btn-primary"><?php echo __('Confirm'); ?></a>
	</div>
</div>
<script type="text/javascript">
function callModal(action, text){
	if (text != null && text != '') $('#modalText').text(text); else $('#modalText').text('<?php echo __('Do you really want to delete the selected record?'); ?>');
	$('#modalApply').attr('href',action);
	$('#modalDelete').modal();
}

$("input[type='date']").datepicker({
    noDefault: false, // set this to true if you don't want the current date inserted if the value-attribute is empty
    format: 'yyyy-mm-dd',
    weekStart: 0,
    <?php echo 'days: ["'.__("_Sunday").'","'.__("_Monday").'","'.__("_Tuesday").'","'.__("_Wednesday").'","'.__("_Thursday").'","'.__("_Friday").'","'.__("_Saturday").'"],
    months: ["'.__("January").'","'.__("February").'","'.__("March").'","'.__("April").'","'.__("May").'","'.__("June").'","'.__("July").'","'.__("August").'","'.__("September").'","'.__("October").'","'.__("November").'","'.__("December").'"]';
    ?>
});

$("input[type='datetime']").datepicker({
    noDefault: false, // set this to true if you don't want the current date inserted if the value-attribute is empty
    format: 'yyyy-mm-dd hh:ii:ss',
    weekStart: 0,
    <?php echo 'days: ["'.__("_Sunday").'","'.__("_Monday").'","'.__("_Tuesday").'","'.__("_Wednesday").'","'.__("_Thursday").'","'.__("_Friday").'","'.__("_Saturday").'"],
    months: ["'.__("January").'","'.__("February").'","'.__("March").'","'.__("April").'","'.__("May").'","'.__("June").'","'.__("July").'","'.__("August").'","'.__("September").'","'.__("October").'","'.__("November").'","'.__("December").'"]';
    ?>
});
$("#themes").change(function(){
	window.location = "<?php echo Route::url('themeset', array('theme' => ''), true); ?>/"+$(this).val();
});
</script>

</body>
