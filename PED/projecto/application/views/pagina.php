<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	require_once('tpl_functions.php');
	include_once('header.php');
	
	echo "<h1>".__($youngtitle)."</h1>";
	if (isset($beforehtml)) echo $beforehtml;
	if (isset($toinclude)){
		switch($toinclude){
			case 'login' : include('loginform.php'); break;
			case 'home': include('homepage.php'); break;
			case 'editor':  include('editor.php'); break;
			case 'opinioes': include('opinioes.php'); break;
			case 'opinioesform': include('opinioesform.php'); break;
			case 'eventos': include('eventos.php'); break;
			case 'eventosform': include('eventosform.php');break;
			case 'calendar': include('eventos.php');break;//include('calendar.php'); break;
			case 'contactos': include('contactos.php'); break;
			case 'contactosform': include('contactosform.php'); break;
			case 'docs': include('docs.php'); break;
			case 'docsform': include('docsform.php'); break;
			case 'org': include('org.php'); break;
			case 'orgform': include('orgform.php'); break;
			case 'paginaform': include ('paginaform.php'); break;
			case 'paginas': include ('paginas.php'); break;
			case 'utilizadores': include('utilizadores.php'); break;
			case 'utilizadoresform': include('utilizadoresform.php'); break;
			case 'grupos': include('grupos.php'); break;
			case 'gruposform': include('gruposform.php'); break;
			case 'gperms': include('gperms.php'); break;
            case 'logs' : include ('logs.php'); break;
            case 'logsform' : include ('logsform.php'); break;
			//Errors
			case '404': include ('errors/404.php'); break;
			default: break;
		}
	}
	if (isset($afterhtml)) echo $afterhtml;
	echo "</div><br/>";
	include_once('footer.php');

?>