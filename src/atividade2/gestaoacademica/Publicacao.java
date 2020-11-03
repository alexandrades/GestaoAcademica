package atividade2.gestaoacademica;

import java.util.ArrayList;

public class Publicacao {

	private ArrayList<String> autores;
	private String titulo;
	private String conferencia_publicacao;
	private int ano;
	private int projeto_associado;
	
	public Publicacao(String titulo, String conferencia_publicacao, int ano, int id_projeto, ArrayList<String> autores) {
		this.titulo = titulo;
		this.conferencia_publicacao = conferencia_publicacao;
		this.ano = ano;
		this.projeto_associado = id_projeto;
		this.autores = autores;
	}
	
	public String imprimir() {
		
		String autores = "";
		
		for( int i = 0; i < this.autores.size(); i++) {
			autores = autores.concat(this.autores.get(i));
			autores = autores.concat("\n");
		}
		
		return "Titulo: " + this.titulo + "\nConferencia onde foi publicada: " + this.conferencia_publicacao + ""
				+ "\nAno de publicação: " + this.ano + "\nID do projeto associado: " + this.projeto_associado + "\nAutores: \n" + autores + "\n--------------------";
	}
	
	public ArrayList<String> getAutores(){
		return this.autores;
	}
	
	public int getAno() {
		return this.ano;
	}
}
