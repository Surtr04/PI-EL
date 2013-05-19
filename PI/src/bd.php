<?php
	if (strstr($_SERVER['PHP_SELF'], 'repositorium') !== false){ while (1) sleep(200);}
	class myDB extends PDO{
		public function __construct(){
			parent::__construct('mysql:host=localhost;dbname=elcvs', 'root', 'root');
			$this->exec("SET NAMES 'utf8'");
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
