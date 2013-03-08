<?php
	class myDB extends PDO{
		public function __construct(){
			parent::__construct('mysql:host=localhost;dbname=elcvs', 'root', 'root');
		}
        public function executeOrDie($query){
            if(!$query->execute()){
                $this->rollBack();
                die($this->errorInfo());
            }
        }
	}
?>
