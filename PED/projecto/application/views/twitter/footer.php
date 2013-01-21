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
		 echo '<a title="'.__('Maintenance').'" href="' .TPL::base()."manut/".($isManut ? "de" : "").'activate"> <img width="80" height="15" border="0" alt="'.__('Maintenance').'" '.($isManut ? 'style="opacity:1;"' : '' ) .'src="'.TPL::base().'images/button-manut.png" /> </a>';
	?>
    <br/>
    <a rel="language" href="<?php echo TPL::base(); ?>langs/pt"><img alt="Português" style="border-width: 0" src="<?php echo TPL::base(); ?>images/Portugal.png"/></a>
	<a rel="language" href="<?php echo TPL::base(); ?>langs/en"><img alt="Inglês" style="border-width: 0" src="<?php echo TPL::base(); ?>images/UK.png"/></a>
</p>


</div>

</body>
