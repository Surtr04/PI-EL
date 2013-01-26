<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class themeTPL extends baseTpl{
    
    const NAVDIF = 2;
    
    public function makeTitle($title){ return '<div class="page-header">'.parent::makeTitle($title).'</div>';}
    
    private function linkadd($action, $texto, $tipo, $btnclass = ''){
        $size = ($texto == ''  ? 'mini' : 'small');
        if ($texto === null) $texto = __($tipo);
		if ($texto != '' && substr($texto, 0, 1) != ' ') $texto = '&nbsp;'.$texto;
        if (is_array($action)){
            $aux = "";
            foreach($action as $chave => $valor)
                $aux .= $chave.'="'.$valor.'" ';
        } else
            $aux = 'href="'.TPL::base().$action.'" ';
		return '<a class="btn '.$btnclass.' btn-'.$size.'" '.$aux.'><i class="'.$tipo.'"></i>'.$texto.'</a>';
	}
    
    public function LinkAdicionar($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-plus', 'btn-info');
	}
	
	public function LinkEditar($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-pencil', 'btn-warning');
	}
	
	public function LinkApagar($action, $texto = null){
        return $this->linkadd(array('href' => "#", 'onclick' => "javascript:callModal('".TPL::base().$action."', '')"), $texto, 'icon-trash', 'btn-danger');
	}
	
	public function LinkVer($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-eye-open');
	}
	
	public function LinkAprovar($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-ok', 'btn-success');
	}
	
	public function LinkDesaprovar($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-remove', 'btn-danger');
	}
    
    public function LinkDownZip($action, $texto = null){
		return $this->linkadd($action, $texto, 'icon-download-alt icon-white', 'btn-inverse');
	}
	
    public function makeForm($lista, $action, $btns){
        if (isset($lista['options'])) {$options = $lista['options']; unset($lista['options']);}
        $aux = '<form method="post" class="'.( isset($options['class']) ? $options['class'] : 'form-horizontal').'" onSubmit="return checkForm()" action="'.$action.'" enctype="multipart/form-data">';
        foreach($lista as $valor){
			//$valor = $this->parseArrayForm($valor);
            switch($valor['tipo']){
				case 'free' : $aux .= $valor['valor']; break;
				case 'file' : $aux .= $this->createInputFile($valor); break;
				case 'check' : $aux .= $this->createCheckbox($valor); break;
                case 'hidden' : $aux .= '<input type="hidden" id="'.$valor['nome'].'" name="'.$valor['nome'].'" value="'.$valor['valor'].'"/>'; break;
                case 'textarea':  $aux .= $this->createTextArea($valor); break;
                case 'select': $aux .= $this->surroundWithLabel($valor['label'], $valor['nome'], $this->_createSelect($valor)); break;//TPL::createSelect($valor['nome'], $valor['valor'], $valor['sel'])); break;
                case 'multi': $aux .= $this->surroundWithLabel($valor['label'], $valor['nome'], $this->_createSelect($valor)); break;//TPL::createMultiSelect($valor['nome'], $valor['valor'], $valor['sel'],  $valor['size'] )); break;
                default : $aux .= $this->createInput($valor); break;
            }
            $aux .= "\n";
        }
        return $aux.$btns.'</form>';
    }
        
    public function createCheckbox($valor){ //$label, $nome, $value, $checked = false, $disabled = false){
        $valor = $this->parseArrayForm($valor);
		return $this->surroundWithLabel($valor['label'], $valor['nome'], '<input type="checkbox" id="'.$valor['nome'].'" name="'.$valor['nome'].'" value="'.$valor['valor'].'" '.($valor['checked'] ? 'checked="true"' : '').$this->disabled($valor['disabled']).'/>'.$valor['after']);
		
	}
    
    public function createInputFile($valor){//$label, $nome, $disabled = false){
        $valor = $this->parseArrayForm($valor);
		return $this->surroundWithLabel($valor['label'], $valor['nome'], '<input type="file" id="'.$valor['nome'].'" name="'.$valor['nome'].'" '.$this->disabled($valor['disabled']).'/>'.$valor['after']);
	}
    
    public function disabled($d){return ($d ? ' disabled="true"' : '');}
    
    public function surroundWithLabel($label, $nome, $input){
        if ($label == '') return $input;
        return '<div class="control-group">
                    <label class="control-label" for="'.$nome.'">'.$label.'</label>
                    <div class="controls">'.$input.'</div>
                </div>';
    }
    
    public function createTextArea($valor){ //$label, $nome, $value = '', $linhas = 5, $disabled = false){
        $valor = $this->parseArrayForm($valor);
        return $this->surroundWithLabel($valor['label'], $valor['nome'], '<textarea class="input-xxlarge" id="'.$valor['nome'].'" name="'.$valor['nome'].'" rows="'.$valor['linhas'].'" '.$this->disabled($valor['disabled']).'>'.$valor['valor'].'</textarea>'.$valor['after']);
    }
    public function createInput($valor){ //$label, $nome, $value = '', $placeholder = '', $type = 'text', $disabled = false){
        $valor = $this->parseArrayForm($valor);
		$preaddon = '<div class="input-prepend input-append">'; $posaddon = '';
		$insert = '';
		switch ($valor['tipo']){
			case 'email': $preaddon .= ' <span class="add-on"><i class="icon-envelope"></i></span>'; break;
			case 'date' : 
                $posaddon .= '<span class="add-on"><i class="icon-time"></i></span>'; 
				$insert = 'data-datepicker-format="dd/mm/yyyy" data-datepicker-nodefault="false"';
				break;
            case 'datetime': 
				$posaddon .= '<span class="add-on"><i class="icon-time"></i></span>'; 
				$insert = 'data-datepicker-format="dd/mm/yyyy hh:ii:ss" data-datepicker-nodefault="false"';
				break;
			case 'web' : case 'url': $preaddon .= ' <span class="add-on"><i class="icon-globe"></i></span>'; break;
		}
        $posaddon .= '</div>'.$valor['after'];
		$input = $preaddon.'<input '.$insert.' class="'.$valor['class-size'].'" type="'.$valor['tipo'].'" id="'.$valor['nome'].'" name="'.$valor['nome'].'" '.($valor['placeholder'] != '' ? 'placeholder="'.$valor['placeholder'].'"' : '').($valor['valor'] != '' ? 'value="'.$valor['valor'].'"' : '').$this->disabled($valor['disabled']).'/>'.$posaddon;
        return $this->surroundWithLabel($valor['label'], $valor['nome'], $input);
    }
    private function _createSelect($valor){
        $valor = $this->parseArrayForm($valor);
        $s = array();
        foreach($valor['sel'] as $value)
            $s[$value] = 1;
        if ($valor['tipo'] == 'multi') $valor['nome'] .= "[]";
        
        $aux = '<select class="'.$valor['class-size'].'" type="text" id="'.$valor['nome'].'" name="'.$valor['nome'].'" '.($valor['tipo'] == 'multi' ? 'size="'.$valor['size'].'" multiple="true"' : '').'>';
        foreach($valor['valor'] as $chave => $value){
            $aux .= '<option '.($s[$value['id']] ? 'selected="true" ' : '' ).'value="'.$value['id'].'">'.$value['nome'].'</option>';
        }
        $aux .= '</select><br />';
        return $aux;
    }
    public function createSelect($name, $lista, $multi = 1, $sel = array()){
        return $this->_createSelect(array('nome' => $name, 'valor' => $lista, 'tipo' => ($multi > 1 ? 'multi' : 'select'), 'size' => $multi, 'sel' => $sel));
    }
    public function showInfos($captions, $values, $lista, $perms, $route, $action = array('edit'=>true, 'delete'=>true)){
        $act = (count($action) > 0);
        $aux = '<table class="table table-hover table-condensed"><thead><tr>';
        foreach($captions as $valor)
            $aux .= '<th>'.__($valor).'</th>';
        $aux .= ($act ? '<th>'.__('Actions').'</th>' : '').'</tr></thead>';
        foreach($lista as $chave => $valor){
            $aux.= '<tr '.(isset($valor['__class']) ? 'class = "'.$valor['__class'].'"' : '').'>';
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
