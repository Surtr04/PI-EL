<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Logs extends Model_Mymodel {

    const AUTO = 1;
    const NOAUTO = 0;
    const ALLAUTO = -1;
    
    
	public function __construct(){
        parent::__construct('logs');
        $query = DB::select($this->_table.'.*', 'users.username')->from($this->_table)->join('users')->on($this->_table.'.utilizador', '=', 'users.id')->order_by('data', 'DESC');
        $this->setCacheQuery($query);
        
	}
	
    
	protected function format($linha){
		return array("key"=> null, "value"=>array("id" => (int)$linha["id"], "utilizador" => $linha["utilizador"], "username" => $linha["username"], "data" => $linha["data"], "operacao" => $linha["operacao"], "descricao" => $linha["descricao"], "auto" => $linha["auto"]));
	}
	
	public function	getAllLogs(){ return $this->getList();}
	
    
	public function apagarLog($id, $auto = self::NOAUTO){
		$id = (int) $id;
        $auto = (int) $auto;
        $query = DB::delete($this->_table)->where('id', '=', $id);
        if ($auto != self::ALLAUTO) $query->and_where ('auto', '=', $auto);
        $query->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function editarLog($id, $data, $operacao, $descricao, $auto){
		$id = (int) $id;
		
        $query = DB::update($this->_table)->set(array('data' => $data, 'operacao' => $operacao, 'descricao' => $descricao))->where('id', '=', $id);
        if ($auto != self::ALLAUTO) $query->and_where ('auto', '=', $auto);
        $query->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function getLogAtPos($i){ return $this->getAtPos($i);}
	public function getLogWithId($id){
		foreach($this->_list as $chave => $valor)
			if ($valor['id'] == $id) return $valor;
		
        $query = DB::select($this->_table.'.*', 'users.username')->from($this->_table)->join('users')->on($this->_table.'.utilizador', '=', 'users.id')->where($this->_table.'.id', '=', $id);
        $linha = $query->execute()->next()->as_array();
        $linha = $this->format($linha[0]);
        return $linha['value'];
	}
	
 
	public function insereLog($utilizador, $data, $operacao, $descricao, $auto){
        $auto = (int) $auto;
        if (is_numeric($utilizador)) 
            $utilizador = (int)$utilizador;
        else
            $utilizador = DB::select('id')->from('users')->where('username', '=', $utilizador);
        
        if ($auto != self::AUTO && $auto != self::NOAUTO) $auto = self::NOAUTO;
		DB::insert($this->_table)->values(array(null, $utilizador, $this->translateDate($data), $operacao, $descricao, $auto))->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
} 
?>