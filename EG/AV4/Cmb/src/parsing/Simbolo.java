package parsing;

import java.util.ArrayList;


public class Simbolo {
	private String id;
	private String tipo;
	private String classe;
	private String classeTipo;
	private int tamanho;
	private int linha;
	private int coluna;
	private ArrayList<String> params;
	private int endMCode;
	private int endMDados;
	
	
	
	public Simbolo(String id, String tipo, String classe, String classeTipo,
			int tamanho, int linha, int coluna, ArrayList<String> params,
			int endMCode, int endMDados) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.classe = classe;
		this.classeTipo = classeTipo;
		this.tamanho = tamanho;
		this.linha = linha;
		this.coluna = coluna;
		this.params = params;
		this.endMCode = endMCode;
		this.endMDados = endMDados;
	}
	
	
	
	public Simbolo() {
		super();
		this.id = "";
		this.tipo = "";
		this.classe = "";
		this.classeTipo = "";
		this.tamanho = 0;
		this.linha = 0;
		this.coluna = 0;
		this.params = new ArrayList<String>();
		this.endMCode = 0;
		this.endMDados = 0;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getClasse() {
		return classe;
	}



	public void setClasse(String classe) {
		this.classe = classe;
	}



	public String getClasseTipo() {
		return classeTipo;
	}



	public void setClasseTipo(String classeTipo) {
		this.classeTipo = classeTipo;
	}



	public int getTamanho() {
		return tamanho;
	}



	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}



	public int getLinha() {
		return linha;
	}



	public void setLinha(int linha) {
		this.linha = linha;
	}



	public int getColuna() {
		return coluna;
	}



	public void setColuna(int coluna) {
		this.coluna = coluna;
	}



	public ArrayList<String> getParams() {
		return params;
	}



	public void setParams(ArrayList<String> params) {
		this.params = params;
	}



	public int getEndMCode() {
		return endMCode;
	}



	public void setEndMCode(int endMCode) {
		this.endMCode = endMCode;
	}



	public int getEndMDados() {
		return endMDados;
	}



	public void setEndMDados(int endMDados) {
		this.endMDados = endMDados;
	}



	@Override
	public String toString() {
		return "Simbolo [id=" + id + ", tipo=" + tipo + ", classe=" + classe
				+ ", classeTipo=" + classeTipo + ", tamanho=" + tamanho
				+ ", linha=" + linha + ", coluna=" + coluna + ", params="
				+ params + ", endMCode=" + endMCode + ", endMDados="
				+ endMDados + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}
