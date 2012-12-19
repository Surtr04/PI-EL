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
	<a title="XHTML 1.0 Válido" href="http://validator.w3.org/check?uri=<?php echo myspReplace(url::base());?>" target="_blank"> <img width="80" height="15" border="0" alt="XHTML 1.0 Válido" src="<?php echo url::base();?>images/button-xhtml.png" /> </a>
	<a title="CSS 3 Válido" href="http://jigsaw.w3.org/css-validator/check?uri=<?php echo myspReplace(url::base());?>" target="_blank"> <img width="80" height="15" border="0" alt="CSS 3 Válido" src="<?php echo url::base(); ?>images/button-css.png" /> </a>
	<?php 
		if ($isUserAdmin)
		 echo '<a title="Manutenção" href="' .url::base()."manut/".($isManut ? "de" : "").'activate"> <img width="80" height="15" border="0" alt="Manutenção" '.($isManut ? 'style="opacity:1;"' : '' ) .'src="'.url::base().'images/button-manut.png" /> </a>';
	?>
</p>


</div>

</div>

<!--</div>-->

</body>
</html>
