<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

class Controller_Main extends Controller_Mymain {

	public function action_index(){

        
        $blocos = array();
        if (!$this->user->isGuest()) {
            $blocos = $this->addBloco($blocos,__('Users'), 'users' , array(
                                                            $this->returnLink('I', 'users/insere', 'Insert new user'),
                                                        ));
            $blocos = $this->addBloco($blocos,__('Groups'), 'groups' , array(
                                                            $this->returnLink('I', 'groups/insere', 'Insert new group'),
                                                        ));

            $blocos = $this->addBloco($blocos,__('Logs'), 'logs' , array(
                                                            $this->returnLink('I', 'logs/insere', 'Insert new log'),
                                                        ));

            $blocos = $this->addBloco($blocos,__('Sips'), 'sips' , array(
                                                            $this->returnLink('I', 'sips/insereFile', 'Insert new sip'),
                                                        ), null, 'home_desc_sips');

            $blocos = $this->addBloco($blocos,__('Supervisors'), 'supervisores' , array(
                                                            $this->returnLink('I', 'supervisores/insere', 'Insert new supervisor'),
                                                        ), 'supervisors');

            $blocos = $this->addBloco($blocos,__('Authors'), 'autores' , array(
                                                            $this->returnLink('I', 'autores/insere', 'Insert new author'),

                                                        ), 'authors');
            $today = new DateTime();
            $blocos = $this->addBloco($blocos,__('Stats'), 'stats' , array(
                                                            $this->returnLink('S', 'stats/day/'.$today->format('Y.m.d'), 'See today stats'),
                                                        ));

            $blocos = $this->addBloco($blocos, __('Categories'), 'categories' , array(
                                                            $this->returnLink('I', 'categories/insere', 'Insert new category'),
                                                        ));
        }
        
        $this->view->set('blocos', $blocos);
        $this->view->set('toinclude', 'home');
        echo $this->view->render();
	}
    private function addBloco($blocos, $titulo, $action, $links, $perm = '', $desc = null){
        if ($perm === '') $perm = $action;
        if ($desc === null) $desc = 'home_desc_'.$perm;
        if ($perm === null) $perms['S'] = $perms['I'] = true; else $perms = $this->user->canDo(Kohana::$config->load('perms.'.$perm));
        $nlinks = array();
        foreach($links as $chave => $valor){
            if ($perms[$valor['tipo']]) $nlinks[] = $valor;
        }
        if ($perms['S'])
            $blocos[] = array('titulo' => $titulo, 'action' => $action, 'links' => $nlinks, 'desc' => $desc);
        
        return $blocos;
    }
    
    private function returnLink($tipo, $action, $texto = ''){
        return array('tipo' => $tipo, 'action' => $action, 'texto' => $texto);
    }
	

}
