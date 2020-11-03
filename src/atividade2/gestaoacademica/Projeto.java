package atividade2.gestaoacademica;

import java.time.LocalDate;

import atividade2.gestaoacademica.util.Console;

public class Projeto {

	private String titulo;
	private LocalDate inicio;
	private LocalDate termino;
	private String agencia_financiadora;
	private double valor_financiado;
	private String objetivo;
	private String descricao;
	private String coordenador;
	Participantes participantes;
	private int status;
	private int quantidade_publicacoes;
	
	public Projeto(String coordenador) {
		
		this.status = 0;
		this.coordenador = coordenador;
		
		this.titulo = "";
		this.inicio = LocalDate.of(0, 1, 1);
		this.termino = LocalDate.of(0, 1, 1);
		this.agencia_financiadora= "";
		this.valor_financiado = 0;
		this.objetivo = "";
		this.descricao = "";
		this.participantes = new Participantes();
		this.quantidade_publicacoes = 0;
	}
	
	public String imprimir() {
		return "Título: " + this.titulo + "\nInício: " + this.inicio.getDayOfMonth() + "/" + this.inicio.getMonthValue() + "/" + this.inicio.getYear() + ""
				+ "       Término: " + this.termino.getDayOfMonth() + "/" + this.termino.getMonthValue() + "/" + this.termino.getYear() + ""
				+ "\nAgencia financiadora: " + this.agencia_financiadora + "\nValor financiado: R$" + this.valor_financiado + ""
				+ "\nObjetivo:\n" + this.objetivo + "Descrição:\n" + this.descricao + "Professor Coordenador: " + this.coordenador + ""
				+ "\nParticipantes:\n" + this.participantes.imprimir() + "\nStatus: " + ((this.status == 0)?"Em elaboração" : (this.status == 1)?"Em andamento" : "Concluído") + "\n--------------------------";
			
	}
	
	public Projeto editar(Colaborador[] colaboradores) {
		
		System.out.println("\n" + this.imprimir());
		
		int option = 0;
		String data;
		
		
		do {
			System.out.println("\n\n=== MENU DE EDIÇÃO DE PROJETO ===\n");
			
			System.out.println(" 1 - Editar Título");
			System.out.println(" 2 - Editar Data de início");
			System.out.println(" 3 - Editar Data de término");
			System.out.println(" 4 - Editar Agencia financiadora");
			System.out.println(" 5 - Editar Valor financiado");
			System.out.println(" 6 - Editar Objetivo");
			System.out.println(" 7 - Editar Descrição");
			System.out.println(" 8 - Editar Professor coordenador");
			System.out.println(" 9 - Editar lista de participantes");
			System.out.println(" 10- Editar Status");
			System.out.println(" 0 - Salvar edições");
			
			option = Integer.parseInt(Console.readLine());
			
			switch(option) {
				case 1 :
					System.out.println("Novo título:\n");
					data = Console.readLine();
					this.setTitulo(data);
					break;
				case 2 :
					System.out.println("Nova data de início:\n");
					data = Console.readLine();
					this.setDataInicio(data);
					break;
				case 3 :
					System.out.println("Novdata de término:\n");
					data = Console.readLine();
					this.setDataTermino(data);
					break;
				case 4 :
					System.out.println("Nova agencia financiadora:\n");
					data = Console.readLine();
					this.setAgenciaFinanciadora(data);
					break;
				case 5 :
					System.out.println("Novo título:\n");
					double valor_financiado = Double.parseDouble(Console.readLine());
					this.setValorFinanciado(valor_financiado);
					break;
				case 6 :
					System.out.println("Novo objetivo:\n");
					data = Console.readLine();
					this.setObjetivo(data);
					break;
				case 7 :
					System.out.println("Novo título:\n");
					data = Console.readLine();
					this.setDescricao(data);
					break;
				case 8 :
					System.out.println("Novo professor coordenador:\n");
					data = Console.readLine();
					this.setCoordenador(data);
					break;
				case 9 :
					Participantes participantes = this.participantes;
					participantes.editar(colaboradores);
					break;
				case 10 :
					System.out.println("Novo Status:\n 0 - Em elaboração / 1 - Em andamento / 2 - Concluído");
					int status = Integer.parseInt(Console.readLine());
					this.setStatus(status);
					break;
				default:
					break;
			}
			
		} while(option != 0);
		System.out.println(this.imprimir());
		
		return this;
	}
	
	public boolean preenchido() {
		
		if(this.titulo == "") {
			return false;
		}
		
		if(this.inicio.getYear() == 0) {
			return false;
		}
		
		if(this.termino.getYear() == 0) {
			return false;
		}
		
		if(this.agencia_financiadora == "") {
			return false;
		}
		
		if(this.valor_financiado == 0) {
			return false;
		}
		
		if(this.objetivo == "") {
			return false;
		}
		
		if(this.descricao == "") {
			return false;
		}
		
		if(this.participantes.getParticipantes().size() == 0) {
			return false;
		}
		return true;
	}

	
	// Get e Set dos atributos
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public LocalDate getDataInicio() {
		return this.inicio;
	}

	public void setDataInicio(String data_inicio) {
		
		int dia = Integer.parseInt(data_inicio.substring(0, 2));
		int mes = Integer.parseInt(data_inicio.substring(3, 5));
		int ano = Integer.parseInt(data_inicio.substring(6, 10));
		this.inicio = LocalDate.of(ano, mes, dia);
	}
	
	public LocalDate getDataTermino() {
		return this.termino;
	}

	public void setDataTermino(String data_termino) {
		int dia = Integer.parseInt(data_termino.substring(0, 2));
		int mes = Integer.parseInt(data_termino.substring(3, 5));
		int ano = Integer.parseInt(data_termino.substring(6, 10));
		this.termino = LocalDate.of(ano, mes, dia);
	}
	
	public String getAgenciaFinanciadora() {
		return this.agencia_financiadora;
	}

	public void setAgenciaFinanciadora(String agencia_financiadora) {
		this.agencia_financiadora = agencia_financiadora;
	}
	
	public double getValorFinanciado() {
		return this.valor_financiado;
	}

	public void setValorFinanciado(double valor_financiado) {
		this.valor_financiado = valor_financiado;
	}
	
	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCoordenador() {
		return this.coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		switch(status) {
			case 1:
				this.andamento();
			case 2:
				this.concluido();
		}
	}
	
	private void andamento() {
		if(this.status == 0 && this.preenchido()) {
			this.status = 1;
		}
		else {
			System.out.println("Status inválido");
		}
	}
	
	private void concluido() {
		if(this.status == 1 && this.quantidade_publicacoes > 0) {
			this.status = 2;
		}
	}
	
	public void addPublicacao() {
		this.quantidade_publicacoes++;
	}
}
