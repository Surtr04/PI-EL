<?php defined('SYSPATH') or die('No direct script access.'); 
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Autores extends Model_Pessoas {

	public function __construct(){
        parent::__construct("autores");
        $this->campo = 'autor';
	}
	
  
	
} 
?>