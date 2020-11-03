package atividade2.gestaoacademica;

import java.time.LocalDate;

public class Orientacao {
	
	private String titulo;
	private LocalDate inicio;
	private LocalDate termino;
	private String orientando;
	private String orientador;
	
	public Orientacao(String titulo, String data_inicio, String data_termino, String orientador, String orientando) {
		
		int dia = Integer.parseInt(data_inicio.substring(0, 2));
		int mes = Integer.parseInt(data_inicio.substring(3, 5));
		int ano = Integer.parseInt(data_inicio.substring(6, 10));
		this.inicio = LocalDate.of(ano, mes, dia);
		
		dia = Integer.parseInt(data_termino.substring(0, 2));
		mes = Integer.parseInt(data_termino.substring(3, 5));
		ano = Integer.parseInt(data_termino.substring(6, 10));
		this.termino = LocalDate.of(ano, mes, dia);
		
		this.titulo = titulo;
		this.orientador = orientador;
		this.orientando = orientando;
		
	}
	
	public String imprimir() {
		
		return "Titulo: " + this.titulo + "\nData de início: " + this.inicio.getDayOfMonth() + "/" + this.inicio.getMonthValue() + "/" + this.inicio.getYear() + ""
				+ "       Término: " + this.termino.getDayOfMonth() + "/" + this.termino.getMonthValue() + "/" + this.termino.getYear() +  "\n"
				+ "Orientador: " + this.orientador + "\nOrientando: " + this.orientando + "\n--------------------";
	}
	
	public LocalDate getDataInicio() {
		return this.inicio;
	}
	
	
	public LocalDate getDataTermino() {
		return this.termino;
	}
	
	public String getOrientador() {
		return this.orientador;
	}
	

	public String getOrientando() {
		return this.orientando;
	}
	
	
}
