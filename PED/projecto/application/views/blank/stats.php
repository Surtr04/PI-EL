<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
//http://www.1stwebdesigner.com/css/top-jquery-chart-libraries-interactive-charts/
//http://www.highcharts.com/demo/
    if ($sub != "") echo '<h3>'.__('Data from').": ".$sub.'</h3>';
    echo '<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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