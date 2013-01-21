<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class themeTPL extends baseTpl{
    
    const NAVDIF = 2;
    
    public function makeTitle($title){ return '<div class="page-header">'.parent::makeTitle($title).'</div>';}
    
    public function makeForm($lista, $action, $btns){
        $aux = '<form method="post" class="form-horizontal" onSubmit="return checkForm()" action="'.$action.'">';
        foreach($lista as $valor){
            switch($valor['tipo']){
                case 'hidden' : $aux .= '<input type="hidden" id="'.$valor['nome'].'" name="'.$valor['nome'].'" value="'.$valor['valor'].'"/>'; break;
                case 'textarea':  $aux .= $this->createTextArea($valor['label'], $valor['nome'], $valor['valor'], $valor['linhas']); break;
                case 'select': $aux .= $this->surroundWithLabel($valor['label'], $valor['nome'], TPL::createSelect($valor['nome'], $valor['valor'], $valor['sel'])); break;
                case 'multi': $aux .= $this->surroundWithLabel($valor['label'], $valor['nome'], TPL::createMultiSelect($valor['nome'], $valor['valor'], $valor['sel'], (isset($valor['size']) ? $valor['size'] : 10))); break;
                default : $aux .= $this->createInput($valor['label'], $valor['nome'], $valor['valor'], '', '', $valor['tipo']); break;
            }
            $aux .= "\n";
        }
        return $aux.$btns.'</form>';
    }
    
    public function surroundWithLabel($label, $nome, $input){
        return '<div class="control-group">
                    <label class="control-label" for="'.$nome.'">'.$label.'</label>
                    <div class="controls">'.$input.'</div>
                </div>';
    }
    
    public function createTextArea($label, $nome, $value = '', $linhas = 5){
        return $this->surroundWithLabel($label, $nome, '<textarea class="input-xxlarge" id="'.$nome.'" name="'.$nome.'" rows="'.$linhas.'">'.$value.'</textarea>');
    }
    public function createInput($label, $nome, $value = '', $placeholder = '', $type = 'text'){
        return $this->surroundWithLabel($label, $nome, '<input class="input-xxlarge" type="'.$type.'" id="'.$nome.'" name="'.$nome.'" '.($placeholder != '' ? 'placeholder="'.$placeholder.'"' : '').($value != '' ? 'value="'.$value.'"' : '').'/>');
    }
    
    public function showInfos($captions, $values, $lista, $perms, $route, $action = array('edit'=>true, 'delete'=>true)){
        $act = (count($action) > 0);
        $aux = '<table class="table table-hover table-condensed"><thead><tr>';
        foreach($captions as $valor)
            $aux .= '<th>'.__($valor).'</th>';
        $aux .= ($act ? '<th>'.__('Actions').'</th>' : '').'</tr></thead>';
        foreach($lista as $chave => $valor){
            $aux.= '<tr>';
            foreach($values as $c => $v){
                if (is_callable($v))
                    $aux .= '<td>'.$v($valor[$c], $valor).'</td>';
                else
                    $aux .= '<td>'.$valor[$c].'</td>';
            }
            if ($act) $aux.= '<td>';
            if ((is_callable($action['see']) && $action['see']($valor['id'], $perms['S'], $valor)) || ($action['see'] === true && $perms['S'])) $aux .= $this->LinkVer($route.'/ver/?id='.$valor['id'], '').' ';
            if ((is_callable($action['edit']) && $action['edit']($valor['id'], $perms['U'], $valor)) || ($action['edit'] === true && $perms['U'])) $aux .= $this->LinkEditar($route.'/editar/?id='.$valor['id'], '').' ';
            if ((is_callable($action['delete']) && $action['delete']($valor['id'], $perms['D'], $valor)) || ($action['delete'] === true && $perms['D'])) $aux .= $this->LinkApagar($route.'/apagar/?id='.$valor['id'], '').' ';
            if ((is_callable($action['downzip']) && $action['downzip']($valor['id'], $perms['S'], $valor)) || ($action['downzip'] === true && $perms['S'])) $aux .= $this->LinkDownZip($route.'/downzip/?id='.$valor['id'], '').' ';
            if ($act) $aux .= '</td>';
            $aux .= '</tr>';
        }
        $aux .= '</table>';
        return $aux;
    }
    public function BtnsForm($actionret = null, $onClick = null){
		return '<div class="form-actions">
                <button '.((isset($onClick) && $onClick != null) ? 'onclick="'.$onClick.'"' : '').' type="submit" class="btn btn-primary">'.__('Send').'</button>
                '.($actionret != null ? '<button onclick="window.location=\''.TPL::base().$actionret.'\';" type="button" class="btn">'.__('Cancel').'</button>' : '').'
            </div>';
	}
	
	public function NavLista($min, $int, $total, $action){
		$max = (2 * self::NAVDIF) + 1;
        if ($total < $max * $int) $max = (int) $total / $int;
        $s = ($int * self::NAVDIF);
        if ($min + $s <= $total) $s = $min - $s; else $s = ($total - ($total % $int)) - ($s * 2);
        if ($s < 0) {$inicio = 1; $s = 0;} else $inicio = (int)(($s+$int)/$int);
        $txt['prev'] = '«'; $txt['next'] = '»';
        if ($min <= 0) {$class['prev'] = 'class="disabled"'; $url['prev'] = "#";} else {$class['prev'] = ''; $url['prev'] = TPL::base().$action.'/?s='.($min-$int);}
        for($i = $inicio; $i< $inicio + $max ;$i++, $s+=$int){
            if ($s == $min) {$class[$i] = 'class="active"'; $url[$i] = '#';} else {$class[$i] = ''; $url[$i] = TPL::base().$action.'/?s='.$s;}
            $txt[$i] = $i;
            
        }
        if ($min + $int >= $total) {$class['next'] = 'class="disabled"'; $url['next'] = "#";} else {$class['next'] = ''; $url['next'] = TPL::base().$action.'/?s='.($min+$int);}    
        $aux = '<div class="pagination">
                    <ul>';
        foreach($url as $chave => $valor)                
            $aux .= '<li '.$class[$chave]. '><a href="'.$url[$chave].'">'.$txt[$chave].'</a></li>';
                        
        $aux .= '</ul>
                </div>';
        
		return $aux;
	}
}

?>
