<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
//http://www.1stwebdesigner.com/css/top-jquery-chart-libraries-interactive-charts/
//http://www.highcharts.com/demo/
    echo '
    <div class="input-append">
        <input data-datepicker-format="dd/mm/yyyy" data-datepicker-nodefault="false" class="input-small" type="date" id="dia" name="dia"/>
        <div class="btn-group">
            <button class="btn" tabindex="-1">
                '.__('View by').': 
            </button>
            <button class="btn dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:sendDate(0)">'.__('Day').'</a></li>
                <li><a href="#" onclick="javascript:sendDate(1)">'.__('Month').'</a></li>
                <li><a href="#" onclick="javascript:sendDate(2)">'.__('Year').'</a></li>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        function sendDate(d){
            var loc = "'.TPL::base().'/stats/"
            var valor = $("#dia").val().replace(/-/g, ".");
            switch(d){
                case 0: loc += "day/"+valor; break;
                case 1: loc += "month/"+valor.substr(0, 7); break;
                case 2: loc += "year/"+valor.substr(0, 4); break;
            }
            window.location = loc;
        }
    </script>';

    if ($sub != "") echo '<h3>'.__('Data from').": ".$sub.'</h3>';
    echo '
            <script src="http://code.highcharts.com/highcharts.js"></script>
            <script src="http://code.highcharts.com/modules/exporting.js"></script>
            <table><tr><td>
            <div id="containerViz" name="containerViz" style="width:45%; display:inline;"></div></td><td>
            <div id="containerDown" name="contaicontainerDown" style="width:45%; display:inline;"></div>
            </td></tr></table>
';
    $params = array("action" => "bycat");
    if (isset($year)) $params['year'] = $year;
    if (isset($month)) $params['month'] = $month;
    if (isset($day)) $params['day'] = $day;

    if (isset($categoria) && $categoria) $link = Route::url($route, $params, true)."?id="; else $link = TPL::base()."sips/ver/?id=";
    $s1 = ",series: [{
                type: 'pie',
                name: '".__('Views')."',
                data: [";
    $s2 = ",series: [{
                type: 'pie',
                name: '".__('Downloads')."',
                data: [";
    foreach ($lista as $valor){
        $s1 .= "{name :'".$valor['ident']."', y: " .$valor['visualizacoes']. ", url:'".$link.$valor['id']."'},";
        $s2 .= "{name :'".$valor['ident']."', y: " .$valor['downzip']. ", url:'".$link.$valor['id']."'},";
    }
    $s1 .= "]}]";
    $s2 .= "]}]";
    
    
    echo "<script text=\"text/javascript\">$(function () {
    var chart;
    $(document).ready(function() {
        ".drawChart('viz', 'containerViz', __('Views'), $s1).
        drawChart('donw', 'containerDown', __('Downloads'), $s2).
        "
       
    
    })
});</script>";
    function drawChart($var, $cont, $title, $series){
        return $var." = new Highcharts.Chart({
            chart: {
                renderTo: '".$cont."',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '".$title."'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
            	percentageDecimals: 2
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                          return '<b><a href=\"' + this.point.url + '\">'+ this.point.name +'</a></b>: '+ this.y;
                        }
                    },
                    showInLegend: true
                }
            }".$series."
         });";
        
    }
?>