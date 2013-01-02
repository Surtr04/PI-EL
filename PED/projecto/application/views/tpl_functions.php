<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Includes{
    private $_theme;
    private $_dtheme;
    public function __construct($t, $d){
        $this->_theme = APPPATH."views/".$t;
        $this->_dtheme = APPPATH."views/".$d;
    }
    public function my_include($file){
        if (file_exists($this->_theme.'/'.$file)) return ($this->_theme.'/'.$file); else return($this->_dtheme.'/'.$file);
    }
    public function can_include($file){
        return ( file_exists($this->_theme.'/'.$file) || file_exists($this->_dtheme.'/'.$file) );
    }
}
class TPL {
    const DTPL = "tpl.php";
    private static $_instance = null;
    
    public static function newInstance($tema = ''){
        if ($tema == '')
            TPL::$_instance = new baseTpl();
        else{
            $t = new Includes($tema, 'blank');
            if ($t->can_include(self::DTPL)){
                include ($t->my_include(self::DTPL));
                TPL::$_instance = new themeTPL();
            } else
               TPL::$_instance = new baseTpl();
        }
    }
    
    public static function instance(){
        return TPL::$_instance;
    }
    
	public static function vazio(){return self::base().'images/s.gif';}

    public static function base(){return Route::url('default', null, true);}
    
	public static function LinkAdicionar($action, $texto = null){
		return TPL::$_instance->LinkAdicionar($action, $texto);
	}
	
	public static function LinkEditar($action, $texto = null){
        return TPL::$_instance->LinkEditar($action, $texto);
	}
	
	public static function LinkApagar($action, $texto = null){
        return TPL::$_instance->LinkApagar($action, $texto);
	}
	
	public static function LinkVer($action, $texto = null){
        return TPL::$_instance->LinkVer($action, $texto);
	}
	
	public static function LinkAprovar($action, $texto = null){
        return TPL::$_instance->LinkAprovar($action, $texto);
	}
	
	public static function LinkDesaprovar($action, $texto = null){
        return TPL::$_instance->LinkDesaprovar($action, $texto);
	}
	
    public static function showInfos($captions, $values, $lista, $perms, $route, $action = array('edit'=>true, 'delete'=>true)){
        return TPL::$_instance->showInfos($captions, $values, $lista, $perms, $route, $action);
    }
    
	public static function BtnsForm($actionret = null, $onClick = null){
		return TPL::$_instance->BtnsForm($actionret, $onclick);
	}
	
	public static function NavLista($min, $int, $total, $action){
		return TPL::$_instance->NavLista($min, $int, $total, $action);
	}
    
    public static function createSelect($nome, $lista, $sel = -1){
        return TPL::$_instance->createSelect($nome, $lista, $sel);
    }
    
}

class baseTpl {
    
    private function linkadd($action, $texto, $tipo){
        if ($texto === null) $texto = __($tipo);
		if ($texto != '' && substr($texto, 0, 1) != ' ') $texto = '&nbsp;'.$texto;
		return '<a class="splink" href="'.TPL::base().$action.'"><img class="class_links '.$tipo.'" src="'.TPL::vazio().'" alt="'.$texto.'"/>'.$texto.'</a>';
	}
	
	public function LinkAdicionar($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_add');
	}
	
	public function LinkEditar($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_edit');
	}
	
	public function LinkApagar($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_delete');
	}
	
	public function LinkVer($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_find');
	}
	
	public function LinkAprovar($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_accept');
	}
	
	public function LinkDesaprovar($action, $texto = null){
		return $this->linkadd($action, $texto, 'class_cancel');
	}
	
    public function showInfos($captions, $values, $lista, $perms, $route, $action = array('edit'=>true, 'delete'=>true)){//$see = false, $edit = true, $delete = true){
        //$act = ($see || ($edit && $perms['U']) || ($delete && $perms['D']));
        $act = (count($action) > 0);
        $aux = '<table style="margin:10px;"><tr>';
        foreach($captions as $valor)
            $aux .= '<th class="th_normal">'.__($valor).'</th>';
        $aux .= ($act ? '<th class="th_normal">'.__('Actions').'</th>' : '').'</tr>';
        foreach($lista as $chave => $valor){
            $aux.= "<tr>";
            foreach($values as $c => $v){
                if (is_callable($v))
                    $aux .= "<td class='td_normal'>".$v($valor[$c], $valor)."</td>";
                else
                    $aux .= "<td class='td_normal'>".$valor[$c]."</td>";
            }
            if ($act) $aux.= "<td class='td_normal'>";
            //foreach(array('see'=>'ver', 'edit'=>'editar', 'delete'=>'apagar') as $c => $v)
            if ((is_callable($action['see']) && $action['see']($valor['id'], $perms['S'], $valor)) || ($action['see'] === true && $perms['S'])) $aux .= $this->LinkVer($route.'/ver/?id='.$valor['id'], '').' ';
            if ((is_callable($action['edit']) && $action['edit']($valor['id'], $perms['U'], $valor)) || ($action['edit'] === true && $perms['U'])) $aux .= $this->LinkEditar($route.'/editar/?id='.$valor['id'], '').' ';
            if ((is_callable($action['delete']) && $action['delete']($valor['id'], $perms['D'], $valor)) || ($action['delete'] === true && $perms['D'])) $aux .= $this->LinkApagar($route.'/apagar/?id='.$valor['id'], '').' ';
            /*if ($edit && $perms['U']) $aux .= $this->LinkEditar($route.'/editar/?id='.$valor['id'],'').' ';
            if ($delete && $perms['D']) $aux .= $this->LinkApagar($route.'/apagar/?id='.$valor['id'],'').' ';*/
            if ($act) $aux .= "</td>";
            $aux .= "</tr>";
        }
        $aux .= '</table>';
        return $aux;
    }
    
	public function BtnsForm($actionret = null, $onClick = null){
		return '<div align="right">
			<p>'.($actionret != null ? '<input onclick="window.location=\''.TPL::base().$actionret.'\';" type="button" value="'.__('Cancel').'" />' : '').'<input '.((isset($onClick) && $onClick != null) ? 'onclick="'.$onClick.'"' : '').' type="submit" value="'.__('Send').'" /></p>
		</div>';
	}
	
	public function NavLista($min, $int, $total, $action){
		$aux = "";
		if ($min > 0) $aux .= '<a href="'.TPL::base().$action.'/?s='.($min-$int).'">&lt;&lt;'.__('Previous').'</a> ';
		if ($min + $int <= $total) $aux .= '<a href="'.TPL::base().$action.'/?s='.($min+$int).'">'.__('Next').'&gt;&gt;</a>';
		return $aux;
	}
    
    public function createSelect($name, $lista, $sel = -1){
        $aux = '<select type="text" id="'.$name.'" name="'.$name.'" style="margin-top:10px;"/>';
        foreach($lista as $chave => $valor){
            $aux .= '<option '.($sel == (int)$valor['id'] ? 'selected="true "' : '' ).'value="'.$valor['id'].'">'.$valor['nome'].'</option>';
        }
        $aux .= '</select><br />';
        return $aux;
    }
    
}
?>