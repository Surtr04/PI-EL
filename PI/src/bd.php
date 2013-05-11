<?php
	class myDB extends PDO{
		public function __construct(){
			parent::__construct('mysql:host=localhost;dbname=elcvs', 'root', 'root');
		}
        public function executeOrDie($query){
			$query->execute();
            if($this->errorCode() > 0){
                $this->rollBack();
				print_r($this->errorInfo());
                die();
            }
        }
	}
?>
