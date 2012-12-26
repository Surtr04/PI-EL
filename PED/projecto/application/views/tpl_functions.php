<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class TPL {
	public static function vazio(){return self::base().'images/s.gif';}

    public static function base(){return Route::url('default', null, true);}
    
	private static function linkadd($action, $texto, $tipo){
        if ($texto === null) $texto = __($tipo);
		if ($texto != '' && substr($texto, 0, 1) != ' ') $texto = '&nbsp;'.$texto;
		return '<a class="splink" href="'.self::base().$action.'"><img class="class_links '.$tipo.'" src="'.self::vazio().'" alt="'.$texto.'"/>'.$texto.'</a>';
	}
	
	public static function LinkAdicionar($action, $texto = null){
		return self::linkadd($action, $texto, 'class_add');
	}
	
	public static function LinkEditar($action, $texto = null){
		return self::linkadd($action, $texto, 'class_edit');
	}
	
	public static function LinkApagar($action, $texto = null){
		return self::linkadd($action, $texto, 'class_delete');
	}
	
	public static function LinkVer($action, $texto = null){
		return self::linkadd($action, $texto, 'class_find');
	}
	
	public static function LinkAprovar($action, $texto = null){
		return self::linkadd($action, $texto, 'class_accept');
	}
	
	public static function LinkDesaprovar($action, $texto = null){
		return self::linkadd($action, $texto, 'class_cancel');
	}
	
	public static function BtnsForm($actionret = NULL, $onClick = NULL){
		return '<div align="right">
			<p>'.($actionret != NULL ? '<input onclick="window.location=\''.self::base().$actionret.'\';" type="button" value="'.__('Cancel').'" />' : '').'<input '.((isset($onClick) && $onClick != NULL) ? 'onclick="'.$onClick.'"' : '').' type="submit" value="'.__('Send').'" /></p>
		</div>';
	}
	
	public static function NavLista($min, $int, $total, $action){
		$aux = "";
		if ($min > 0) $aux .= '<a href="'.Route::url('default', null, true).$action.'/?s='.($min-$int).'">&lt;&lt;Retroceder</a> ';
		if ($min + $int <= $total) $aux .= '<a href="'.Route::url('default', null, true).$action.'/?s='.($min+$int).'">Avançar&gt;&gt;</a>';
		return $aux;
	}
}
?>