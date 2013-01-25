<?php
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Controller_Perms extends Controller{
	private $_SELECT = false;
	private $_INSERT = false;
	private $_UPDATE = false;
	private $_DELETE = false;
	public function __construct ($s, $i, $u, $r){
		$this->setSelect($s);
		$this->setInsert($i);
		$this->setUpdate($u);
		$this->setDelete($r);
	}
	
	public function action_index(){
		return;
	}
	public function getPerm($p){
		switch($p){
			case 'S': case 's': return $this->getSelect(); break;
			case 'I': case 'i': return $this->getInsert(); break;
			case 'U': case 'u': return $this->getUpdate(); break;
			case 'D': case 'd': case 'R': case 'r': return $this->getDelete(); break;
			default: return $this->getSelect();
		}
	}
    public function __toString() {
        $str = "";
        foreach(array('S' => $this->_SELECT, 'I' => $this->_INSERT, 'U' => $this->_UPDATE, 'D' => $this->_DELETE) as $chave => $valor)
                $str .= ($valor ? $chave : '-');
        return $str;
    }
	public function getSelect(){return $this->_SELECT;}
	public function getInsert(){return $this->_INSERT;}
	public function getUpdate(){return $this->_UPDATE;}
	public function getRemove(){return $this->getDelete();}
    public function getDelete(){return $this->_DELETE;}
	public function setSelect($value){$this->_SELECT = $value;}
	public function setInsert($value){$this->_INSERT = $value;}
	public function setUpdate($value){$this->_UPDATE = ($value && ($this->_SELECT || $this->_INSERT));}
    public function setRemove($value){$this->setDelete($value);}
	public function setDelete($value){$this->_DELETE = ($value && $this->_SELECT && $this->_INSERT && $this->_UPDATE);}
}
?>