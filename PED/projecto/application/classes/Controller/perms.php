<?php
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Perms extends Controller{
	private $_SELECT = false;
	private $_INSERT = false;
	private $_UPDATE = false;
	private $_REMOVE = false;
	function __construct ($s, $i, $u, $r){
		$this->setSelect($s);
		$this->setInsert($i);
		$this->setUpdate($u);
		$this->setRemove($r);
	}
	
	function action_index(){
		return;
	}
	function getPerm($p){
		switch($p){
			case 'S': case 's': return $this->getSelect(); break;
			case 'I': case 'i': return $this->getInsert(); break;
			case 'U': case 'u': return $this->getUpdate(); break;
			case 'D': case 'd': case 'R': case 'r': return $this->getRemove(); break;
			default: return $this->getSelect();
		}
	}
	function getSelect(){return $this->_SELECT;}
	function getInsert(){return $this->_INSERT;}
	function getUpdate(){return $this->_UPDATE;}
	function getRemove(){return $this->_REMOVE;}
	function setSelect($value){$this->_SELECT = $value;}
	function setInsert($value){$this->_INSERT = ($value && $this->_SELECT);}
	function setUpdate($value){$this->_UPDATE = ($value && $this->_SELECT);}
	function setRemove($value){$this->_REMOVE = ($value && $this->_SELECT && $this->_INSERT && $this->_UPDATE);}
}
?>