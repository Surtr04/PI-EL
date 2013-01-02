<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
class Model_Sips extends Model_Mymodel {

    private $onlyby;
    
	public function __construct(){
        parent::__construct('sips');
        $query = DB::select($this->_table.'.*', 'users.username', 'categorias.nome')->from($this->_table)
                ->join('users')->on($this->_table.'.submetido', '=', 'users.id')
                ->join('categorias')->on($this->_table.'.id_categoria', '=', 'categorias.id')
                ->order_by('data_submissao', 'DESC');
        $this->setCacheQuery($query);
        $this->onlyby = -1;
	}
	
    public function cacheByCat($id, $min){
        $query = $this->getCacheQuery();
        $this->setCacheQuery($query->where($this->_table.'.id_categoria', '=', $id));
        $this->cache($min);
        $this->setCacheQuery($query);
    }
    
	protected function format($linha){
		return array("key"=> null, "value"=>array("id" => (int)$linha["id"], "ident" => $linha["ident"], "titulo" => $linha["titulo"], "subtitulo" => $linha["subtitulo"], "data_inic" => $linha["data_inic"], "data_fim" => $linha["data_fim"], "data_submissao" => $linha["data_submissao"], "submetido" => $linha["submetido"], "username" => $linha["username"], "id_categoria" => $linha["id_categoria"], "categoria" => $linha["nome"]));
	}
	
	public function	getAllSips(){ return $this->getList();}
	
    public function setOnlyBy($id){ $this->onlyby = $id; $this->setCacheQuery($this->getCacheQuery()->where('submetido', '=', $id));}
    
    public function getAllInfoSip($id){
        $info = $this->getById($id);
        $info["autores"] = Model::factory('Autores')->getFromSip($id);
        $info["supervisores"] = Model::factory('Supervisores')->getFromSip($id);
        $info["resultados"] = Model::factory('Results')->getFromSip($id);
        $info["resumo"] = Model::factory('Resumos')->getFromSip($id);
        return $info;
    }
    
    private function canBe($id){
        if ($this->onlyby > 0) {
            $query = DB::select(array(DB::expr('count(*)'), 'conta'))->from ($this->_table)->where('id', '=' ,$id)->and_where('submetido', '=', $this->onlyby);
            $linha = $query->execute()->as_array();
            return ($linha[0]['conta'] > 0);
        } else 
            return true;
    }
    
	public function apaga($id){
		$id = (int) $id;

        if (!$this->canBe($id)) return false;
        
        $querys = array();
        
        foreach(array("sips_autores", "sips_supervisores", "resumos", "resultados") as $tbl)
            $querys[] = DB::delete($tbl)->where('id_sip', '=', $id);        
        
        $querys[] = DB::delete($this->_table)->where('id', '=', $id);
        $this->executeInTransaction($querys);
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function edita($id, $data, $operacao, $descricao, $auto){
        /*Not implemented yet*/
		$id = (int) $id;
		
        $query = DB::update($this->_table)->set(array('data' => $data, 'operacao' => $operacao, 'descricao' => $descricao))->where('id', '=', $id);
        if ($auto != self::ALLAUTO) $query->and_where ('auto', '=', $auto);
        $query->execute();
		if ($this->_cached) $this->cache($this->_min);
	}
	
	public function getAtPos($i){ return $this->getAtPos($i);}
	public function getById($id){
        foreach($this->_list as $chave => $valor)
			if ($valor['id'] == $id) return $valor;
		
        $query = $this->getCacheQuery()->where($this->_table.'.id', '=', $id);
        $linha = $query->execute()->next()->as_array();
        $linha = $this->format($linha[0]);
        return $linha['value'];
	}
	
	public function insere($cat, $user , $sip){
        
        $cats = new Model_Categorias();
        if (!$cats->canBeInsertedIn($cat)) return false;
        
        $querys = array();
        
        //Verifica os autores e supervisores
        $autores = $this->verificaPessoas(new Model_Autores(), $sip["autores"]);
        $supervisores = $this->verificaPessoas(new Model_Supervisores(), $sip["supervisores"]);
        
        $querys["id"] = DB::insert($this->_table)->values(array(null,$sip["iden"], $sip["titulo"], $sip["subtitulo"], $sip["data-inic"], $sip["data-fim"], $this->translateDate(time()), $user, $cat));
        
        $i = 0;
        foreach($autores as $valor)
            $querys["ref_autores".$i] = DB::insert("sips_autores")->values(array(':id', $valor));
        
        $i = 0;
        foreach($autores as $valor)
            $querys["ref_supervisores".$i] = DB::insert("sips_supervisores")->values(array(':id', $valor));
        
        foreach($sip["resumo"] as $chave => $valor)
            $querys["ref_resumo".$chave] = DB::insert("resumos")->values(array(':id', $chave, $valor));
        
        foreach($sip["resultados"] as $chave => $valor)
            $querys["ref_resultados".$chave] = DB::insert("resultados")->values(array(null, ':id', $valor["name"], $valor["url"], $valor["desc"]));
        
        $this->executeInTransaction($querys);
        
        
		if ($this->_cached) $this->cache($this->_min);
	}
    
    private function verificaPessoas($model, $pessoas){
        $torret = array();
        foreach($pessoas as $valor){
            $p = $model->getByIdentificador($valor["identificador"]);
            if ($p["identificador"] === null) $torret[] = $model->insere($valor["identificador"], $valor["nome"], $valor["email"], $valor["web"]); else $torret[] = $p["id"];
        }
        return $torret;
    }
	
} 
?>