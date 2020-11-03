package atividade2.gestaoacademica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import atividade2.gestaoacademica.util.Console;

public class Programa {
	
	private static Colaborador[] colaboradores = new Colaborador[100];
	private static int num_colaboradores = 0;
	
	private static Projeto[] projetos = new Projeto[100];
	private static int num_projetos = 0;
	
	private static Publicacao[] publicacoes = new Publicacao[100];
	private static int num_publicacoes = 0;
	
	private static Orientacao[] orientacoes = new Orientacao[100];
	private static int num_orientacoes = 0;
	
	private static Comparator<Projeto> cmp = new Comparator<Projeto>() {
		public int compare(Projeto p1, Projeto p2) {
			if(p1.getDataTermino().isBefore(p2.getDataTermino())) {
				return 1;
			}
			else if(p1.getDataTermino().isEqual(p2.getDataTermino())) {
				return 0;
			}
			else {
				return -1;
			}
		}
	};
	
	private static Comparator<Orientacao> cmp_orientacao = new Comparator<Orientacao>() {
		public int compare(Orientacao o1, Orientacao o2) {
			if(o1.getDataTermino().isBefore(o2.getDataTermino())) {
				return 1;
			}
			else if(o1.getDataTermino().isEqual(o2.getDataTermino())) {
				return 0;
			}
			else {
				return -1;
			}
		}
	};
	
	
	private static Comparator<Publicacao> cmp_publicacao = new Comparator<Publicacao>() {
		public int compare(Publicacao p1, Publicacao p2) {
			if(p1.getAno() < p2.getAno()) {
				return 1;
			}
			else if(p1.getAno() == p2.getAno()) {
				return 0;
			}
			else {
				return -1;
			}
		}
	};
	
	public static void main(String[] args) {
		
		int option = 0;
		
		do {
			
			System.out.println("\n=== MENU PRINCIPAL ===\n");
			
			System.out.println(" 1 - Cadastrar colaborador");
			System.out.println(" 2 - Imprimir colaborador");
			System.out.println(" 3 - Cadastrar projeto");
			System.out.println(" 4 - Editar projeto");
			System.out.println(" 5 - Imprimir projetos");
			System.out.println(" 6 - Cadastrar publicação");
			System.out.println(" 7 - Imprimir publicações");
			System.out.println(" 8 - Cadastrar orintação");
			System.out.println(" 9 - Imprimir orientações");
			System.out.println(" 10 - Cunsultar colaborador");
			System.out.println(" 11 - Cunsultar projeto");
			System.out.println("Escolha uma opção:");
			
			option = Integer.parseInt(Console.readLine());
			
			switch(option) {
				case 1 :
					cadastrarColaborador();
					break;
				case 2 :
					imprimirColaboradores();
					break;
				case 3 :
					cadastrarProjeto();
					break;
				case 4 :
					editarProjeto();
					break;
				case 5 :
					imprimirProjetos();
					break;
				case 6:
					cadastrarPublicacao();
					break;
				case 7:
					imprimirPublicacoes();
					break;
				case 8:
					cadastrarOrientacao();
					break;
				case 9:
					imprimirOrientacoes();
					break;
				case 10:
					consultarColaborador();
					break;
				case 11 :
					consultarProjeto();
					break;
				default:
					System.out.println("Opção inválida!");
			}
			
		} while(option != 0);
		
		
	}
	
	public static void cadastrarColaborador() {
		
		System.out.println("\n\n=== CADASTRO DE COLABORADOR ===\n");
		
		System.out.println("Nome:");
		String nome = Console.readLine();
		
		System.out.println("Email:");
		String email = Console.readLine();
		
		System.out.println("Aluno ou Professor? 0 - Aluno; 1 - Professor");
		int professor = Integer.parseInt(Console.readLine());
		
		Colaborador colaborador = new Colaborador(nome, email, professor, num_colaboradores);
		colaboradores[num_colaboradores++] = colaborador;
		
	}
	
	public static void imprimirColaboradores() {
		
		for( int i = 0; i < num_colaboradores; i++) {
			
			Colaborador colaborador = colaboradores[i];
			System.out.println("ID: " + i + "\n" + colaborador.imprimir());
		}
	}
	
	public static void cadastrarProjeto() {
		
		System.out.println("\n\n=== CADASTRO DE PROJETO ===\n");
		
		System.out.println("Coordenador para o projeto:");
		String coordenador = Console.readLine();
		
		
		for(int i = 0; i < num_colaboradores; i++) {
			if(colaboradores[i].getNome().equals(coordenador) && colaboradores[i].getProfessor()) {
				
				Projeto projeto = new Projeto(coordenador);
				projetos[num_projetos++] = projeto;
				return;
			}
		}
		
		System.out.println("Erro! Coordenador deve ser Professor.");
		
	}
	
	private static void editarProjeto() {
		
		System.out.println("ID do projeto");
		int id_projeto = Integer.parseInt(Console.readLine());
		
		Projeto projeto = projetos[id_projeto];
		projetos[id_projeto] = projeto.editar(colaboradores);
		
		
	}
	
	private static void imprimirProjetos() {
		
		for( int i = 0; i < num_projetos; i++) {
			Projeto projeto = projetos[i];
			System.out.println("ID: " + i + "\n" + projeto.imprimir());
		}
	}
	
	private static void cadastrarPublicacao() {
		
		System.out.println("Titulo: ");
		String titulo = Console.readLine();
		
		System.out.println("Conferencia onde foi publicada: ");
		String conferencia_publicacao = Console.readLine();
		
		System.out.println("Ano de publicação: ");
		int ano_publicacao = Integer.parseInt(Console.readLine());
		
		System.out.println("ID do projeto associado: ");
		int id_projeto = Integer.parseInt(Console.readLine());
		
		if(id_projeto >= num_projetos) {
			System.out.println("ID do projeto inválido: ID não existe.");
			return;
		}
		
		int option = 2;
		ArrayList<String> autores = new ArrayList<String>();
		
		do {
			System.out.println("ID do autor:");
			int id_autor = Integer.parseInt(Console.readLine());
			
			if(id_autor >= num_colaboradores) {
				System.out.println("ID do colaborador inválido: ID não existe.");
				continue;
				
			}
			
			autores.add(colaboradores[id_autor].getNome());
			
			System.out.println("\n\n=== ADIÇÃO DE AUTORES ===\n");
			
			System.out.println(" 1 - Adicionar autor");
			System.out.println(" 2 - Concluir");
			
			option = Integer.parseInt(Console.readLine());
			
		} while(option == 1);
		
		if(projetos[id_projeto].getStatus() == 1) {
			Publicacao publicacao = new Publicacao(titulo, conferencia_publicacao, ano_publicacao, id_projeto, autores);
			publicacoes[num_publicacoes++] = publicacao;
			projetos[id_projeto].addPublicacao();
		}
		else {
			System.out.println("O projeto deve estar em andamento.");
		}
		
	}
	
	private static void imprimirPublicacoes() {
		
		for( int i = 0; i < num_publicacoes; i++) {
			Publicacao publicacao = publicacoes[i];
			System.out.println("ID: " + i + "\n" + publicacao.imprimir());
		}
	} 
	
	private static void cadastrarOrientacao() {
		
		System.out.println("Titulo: ");
		String titulo = Console.readLine();
		
		System.out.println("Data de início:");
		String data_inicio = Console.readLine();

		System.out.println("Data de término:");
		String data_termino = Console.readLine();
		
		System.out.println("ID do Orientador:");
		int orientador = Integer.parseInt(Console.readLine());
		
		System.out.println("Orientando:");
		int orientando = Integer.parseInt(Console.readLine());
		
		if(colaboradores[orientador].getProfessor() && !(colaboradores[orientando].getProfessor())) {
			
			Orientacao orientacao = new Orientacao(titulo, data_inicio, data_termino, colaboradores[orientador].getNome(), colaboradores[orientando].getNome());
			orientacoes[num_orientacoes++] = orientacao;
			return;
		}
		
		System.out.println("Orientando ou Orientador inválidos!\nOrientando deve ser aluno e Orientador deve ser Professor.");
		
	}
	
	private static void imprimirOrientacoes() {
		
		for( int i = 0; i < num_orientacoes; i++) {
			Orientacao orientacao = orientacoes[i];
			System.out.println("ID: " + i + "\n" + orientacao.imprimir());
		}
	}

	private static void consultarColaborador() {
		
		System.out.println("Nome do colaborador: ");
		String nome_colaborador = Console.readLine();
		
		ArrayList<Projeto> lista_auxiliar = new ArrayList<Projeto>();
		ArrayList<Orientacao> lista_orientacao = new ArrayList<Orientacao>();
		ArrayList<Publicacao> lista_publicacao = new ArrayList<Publicacao>();
		Colaborador colaborador;
		
		for( int i = 0; i < num_colaboradores; i++) {
			
			colaborador = colaboradores[i];
			
			if(colaborador.getNome().equals(nome_colaborador)) {
				System.out.println(colaborador.imprimir());
				
			}
			
		}
		
		System.out.println("Lista de projetos:\n");
		
		for( int h = 0; h < num_projetos; h++) {
			
			Projeto projeto = projetos[h];
			ArrayList<Colaborador> participantes = projeto.participantes.getParticipantes();
			
			for( int j = 0; j < participantes.size(); j++) {
				colaborador = participantes.get(j);
				
				if(colaborador.getNome().equals(nome_colaborador) || projeto.getCoordenador().equals(nome_colaborador)) {
					
					lista_auxiliar.add(projeto);
					break;
				}
			}
		}
		
		Collections.sort(lista_auxiliar, cmp);
		
		for( int i = 0; i < lista_auxiliar.size(); i++) {
			System.out.println(lista_auxiliar.get(i).imprimir());
		}
		
		System.out.println("Lista de orientações:\n");
		
		for( int h = 0; h < num_orientacoes; h++) {
			
			Orientacao orientacao = orientacoes[h];
			
			if(orientacao.getOrientador().equals(nome_colaborador) || orientacao.getOrientando().equals(nome_colaborador)) {
				lista_orientacao.add(orientacao);
			}
		}
		
		Collections.sort(lista_orientacao, cmp_orientacao);
		
		for( int i = 0; i < lista_orientacao.size(); i++) {
			System.out.println(lista_orientacao.get(i).imprimir());
		}
		
		System.out.println("Lista de publicações:\n");
		
		for( int h = 0; h < num_publicacoes; h++) {
			
			Publicacao publicacao = publicacoes[h];
			
			ArrayList<String> autores = publicacao.getAutores();

			for( int j = 0; j < autores.size(); j++) {
				
				if(autores.get(j).equals(nome_colaborador)) {
					
					lista_publicacao.add(publicacao);
					break;
				}

			}
		}
		
		Collections.sort(lista_publicacao, cmp_publicacao);
		
		for( int i = 0; i < lista_publicacao.size(); i++) {
			System.out.println(lista_publicacao.get(i).imprimir());
		}
		
			
		
	}
	
	private static void consultarProjeto() {
		
	}
}
