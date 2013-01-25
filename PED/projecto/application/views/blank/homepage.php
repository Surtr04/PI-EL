<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

?>
<div style="width:90%; margin:auto;">
    <div class="hero-unit">
        <h1><?php echo $titulo; ?></h1>
    </div>
        <?php 
            $i = 0;
            foreach($blocos as $chave => $valor){
                if ($i % 3 == 0) echo '<div class="row-fluid">';
                echo '<div class="span4">';
                echo '<h2>'.$valor['titulo'].(isset($valor['action']) ?  ' '.TPL::LinkVer($valor['action'], '') : '').'</h2>';
                if (isset($valor['desc']) && $valor['desc'] != '')echo '<p>'.__($valor['desc']).'</p>';
                foreach($valor['links'] as $c => $v){
                    switch($v['tipo']){
                        case 'see' : case 'S': echo TPL::LinkVer($v['action'], __($v['texto'])); break;
                        case 'add' : case 'I': echo TPL::LinkAdicionar($v['action'], __($v['texto'])); break;
                        case 'edit' : case 'U': echo TPL::LinkEditar($v['action'], __($v['texto'])); break;
                        case 'delete' : case 'D': echo TPL::LinkApagar($v['action'], __($v['texto'])); break;
                        case 'download' : echo TPL::LinkDownZip($v['action'], __($v['texto'])); break;
                        default: continue;
                    }
                    echo "<br/>";
                }
                echo '</div>';
                $i++;
                if ($i % 3 == 0) echo '</div><br/>';
            }
            if ($i % 3 != 0) echo '</div>';
        ?>
        
</div>
<br/><br/><hr/>
