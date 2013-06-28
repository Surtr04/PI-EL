package parsing;

import java.util.HashMap;

public class Tabela {
	private HashMap<Pair<String, String>, Simbolo> simbolos;

	public Tabela (){
		this.simbolos = new HashMap<Pair<String, String>, Simbolo>();
		Simbolo int_simbolo = new Simbolo(
				"int", "int", "TYPE", "ATOM", 4, 0, 0, null, 0,0  
				);
		Simbolo bool_simbolo = new Simbolo(
				"bool", "bool", "TYPE", "ATOM", 1, 0, 0, null, 0,0  
				);
		Simbolo string_simbolo = new Simbolo(
				"string", "string", "TYPE", "ATOM", 1, 0, 0, null, 0,0  
				);
		Simbolo void_simbolo = new Simbolo(
				"void", "void", "TYPE", "ATOM", 0, 0, 0, null, 0,0  
				);
		this.simbolos.put(new Pair<String, String>("int", ""), int_simbolo);
		this.simbolos.put(new Pair<String, String>("bool", ""), bool_simbolo);
		this.simbolos.put(new Pair<String, String>("string", ""), string_simbolo);
		this.simbolos.put(new Pair<String, String>("void", ""), void_simbolo);
	}
	
	
	
	public HashMap<Pair<String, String>, Simbolo> getSimbolos(){
		return this.simbolos;
	}
	
	
	
	public void setSimbolos(HashMap<Pair<String, String>, Simbolo> simbolos) {
		this.simbolos = simbolos;
	}
	
	
	
	public void addSimbolo(String ctx, Simbolo v) {
		if(! this.simbolos.containsKey(new Pair<String, String>(v.getId(), ctx))) {
			this.simbolos.put(new Pair<String, String>(v.getId(), ctx) , v);
		}
	}
	
	
	
	public boolean contains(Pair<String, String> ch, int line, int col){
		return this.simbolos.containsKey(ch) && 
					this.simbolos.get(ch).getLinha() == line &&
						this.simbolos.get(ch).getColuna() == col ;
	}
	
	
	public boolean contains(Pair<String, String> ch){
		return this.simbolos.containsKey(ch) ;
	}
	
	
	public String getType(Pair<String, String> ch) {
		return this.simbolos.get(ch).getTipo();
	}
	
	

	public String toString(){
		String res = "";
		
		for(Pair<String, String> ch : this.simbolos.keySet()) {
			res += ">> " + ch + " << " + this.simbolos.get(ch) + "\n";
		}
		return res;
	}
	
	
}
