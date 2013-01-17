<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Stats extends Controller_Mymain {
    
    const ALL = 0;
    const BYCAT = 1;
    const CAT = 2;
    
    
	public function __construct(Request $request, Response $response){
		parent::__construct($request, $response);
        $this->view->set('route', Route::name($this->request->route()));
	}
	
    public function action_index(){
		return $this->action_categorias();
	}
	
    private function trataLimites($stats, $all){
        $t = $this->request->param('type',null);
        $y = $this->request->param('year',null);
        $m = $this->request->param('month',null);
        $d = $this->request->param('day',null);
        $r = "";
        switch($t){
            case 'year': $rest = Model_Stats::YEAR; break;
            case 'month': $rest = Model_Stats::MONTH; break;
            case 'day': $rest = Model_Stats::DAY; break;
            default: $rest = Model_Stats::ALL; $r = "stats"; break;
        }
        $stats->setTime($rest, $all, $y, $m, $d);
        return array("type" => $rest, "y"=> $y, "m"=> $m, "d"=> $d, "r" => ($r == "" ? "stats_".$t : $r));
    }
    
    public function makeTitle($vals, $page = self::ALL){
        $title = "";
        $sub = "";
        switch ($page){
            case self::ALL: $title = 'Stats'; break;
            case self::BYCAT: $title = $vals['nome']; break;
            case self::CAT: $title = 'Stats of categories'; break;
        }
        switch((int)$vals['type']){
            case Model_Stats::YEAR: $sub = $vals['y']; break;
            case Model_Stats::MONTH: $sub = $vals['m'].'/'.$vals['y']; break;
            case Model_Stats::DAY: $sub = $vals['d'].'/'.$vals['m'].'/'.$vals['y']; break;
            default: $sub = ""; break;
        }
        $this->view->set('year', $vals['y']);
        $this->view->set('month', $vals['m']);
        $this->view->set('day', $vals['d']);
        $this->view->set('youngtitle', $title);
        $this->view->set('sub', $sub);
    }
    
    public function action_ver(){
        $stats = new Model_Stats();
        $v = $this->trataLimites($stats, false);
        $this->makeTitle($v, self::ALL);
        $stats->cacheAll();   
        $this->view->set('categoria', false);
        $this->initTable($stats);
    }
    
    public function action_categorias(){
        $stats = new Model_Stats();
        $v = $this->trataLimites($stats, false);
        $this->makeTitle($v, self::CAT);
        $stats->setCategorias();
        $stats->cacheAll();
        $this->view->set('categoria', true);
        $this->initTable($stats);
    }
    
    public function action_bycat(){
        $stats = new Model_Stats();
        $id = (int) (Arr::get($_GET,'id',-1));
        if ($id < 0) return $this->goIndex();
        $v = $this->trataLimites($stats, true);
        $v['nome'] = Model::factory('Categorias')->getCategoriaWithId($id);
        $v['nome'] = $v['nome']['nome'];
        $this->makeTitle($v, self::BYCAT);
        $stats->setByCat($id);
        $stats->cacheAll();
        $this->view->set('categoria', false);
        $this->initTable($stats);
    }
    
    private function initTable($lista){
        $this->_initTable($lista, 'stats');
    }
} 
?>