<!DOCTYPE html>
<html>
<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

	require_once('tpl_functions.php');
    $t =  new Includes($theme, $dtheme);
    TPL::newInstance($theme);
	if ($t->can_include('header.php')) include_once($t->my_include('header.php'));
	
	if (isset($youngtitle) && $youngtitle != "") echo TPL::makeTitle(__($youngtitle));
	if (isset($beforehtml)) echo $beforehtml;
	if (isset($toinclude)){
		switch($toinclude){
			case 'login' : include($t->my_include('loginform.php')); break;
			case 'home': include($t->my_include('homepage.php')); break;
			case 'editor':  include($t->my_include('editor.php')); break;
			case 'opinioes': include($t->my_include('opinioes.php')); break;
			case 'opinioesform': include($t->my_include('opinioesform.php')); break;
			case 'eventos': include($t->my_include('eventos.php')); break;
			case 'eventosform': include($t->my_include('eventosform.php')); break;
			case 'calendar': include($t->my_include('eventos.php')); break;//include($t->my_include('calendar.php')); break;
			case 'contactos': include($t->my_include('contactos.php')); break;
			case 'contactosform': include($t->my_include('contactosform.php')); break;
			case 'docs': include($t->my_include('docs.php')); break;
			case 'docsform': include($t->my_include('docsform.php')); break;
			case 'org': include($t->my_include('org.php')); break;
			case 'orgform': include($t->my_include('orgform.php')); break;
			case 'paginaform': include($t->my_include('paginaform.php')); break;
			case 'paginas': include($t->my_include('paginas.php')); break;
			case 'utilizadores': include($t->my_include('utilizadores.php')); break;
			case 'utilizadoresform': include($t->my_include('utilizadoresform.php')); break;
			case 'grupos': include($t->my_include('grupos.php')); break;
			case 'gruposform': include($t->my_include('gruposform.php')); break;
			case 'gperms': include($t->my_include('gperms.php')); break;
            case 'logs' : include($t->my_include('logs.php')); break;
            case 'logsform' : include($t->my_include('logsform.php')); break;
            case 'categorias': include($t->my_include('categorias.php')); break;
            case 'categoriasform': include($t->my_include('categoriasform.php')); break;
            case 'pessoas': include($t->my_include('pessoas.php')); break;
            case 'pessoasform': include($t->my_include('pessoasform.php')); break;
            case 'sips': include($t->my_include('sips.php')); break;
            case 'sipsform': include($t->my_include('sipsform.php')); break;
            case 'sipsfile': include($t->my_include('sipsfile.php')); break;
            case 'sipshtml' : include($t->my_include('sipshtml.php')); break;
            case 'sips_private' : include($t->my_include('sips_private.php')); break;
            case 'stats' : include($t->my_include('stats.php')); break;
			//Errors
			case '404': include('errors/404.php'); break;
			default: break;
		}
	}
	if (isset($afterhtml)) echo $afterhtml;
	if ($t->can_include('footer.php')) include_once($t->my_include('footer.php'));
?>
</html>