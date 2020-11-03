package atividade2.gestaoacademica;

import java.util.ArrayList;

import atividade2.gestaoacademica.util.Console;

public class Participantes {
	
	private ArrayList<Colaborador> participantes;
	
	public Participantes() {
		
		this.participantes = new ArrayList<Colaborador>();
	}
	
	public void editar(Colaborador[] colaboradores) {
		
		int option = 0;
		
		do {
			
			System.out.println("\n\n=== MENU DE EDIÇÃO DE PARTICIPANTES DO PROJETO ===\n");
			
			System.out.println(" 1 - Adicionar participaçnte");
			System.out.println(" 2 - Remover participaçnte");
			System.out.println(" 0 - Salvar edições");
			System.out.println("Escola uma opção:\n");
			
			option = Integer.parseInt(Console.readLine());
			
			switch(option) {
			
				case 1:
					adicionarParticipante(colaboradores);
					break;
				case 2:
					removerParticipante();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida.\n");
					break;
			}
			
		} while(option != 0);
	}
	
	public void adicionarParticipante(Colaborador[] colaboradores) {
		
		System.out.println("ID do participante: ");
		int id_participante = Integer.parseInt(Console.readLine());
		
		Colaborador colaborador = colaboradores[id_participante];
		participantes.add(colaborador);
		
		
		
	}
	
	public void removerParticipante() {
		
		System.out.println("Id do participante");
		int id_participante = Integer.parseInt(Console.readLine());
		
		for( int i = 0; i < participantes.size(); i++) {
			
			Colaborador colaborador = participantes.get(i);
			int id_colaborador = colaborador.getIdColaborador();
			
			if(id_colaborador == id_participante) {
				participantes.remove(i);
			}
		}
		
	}
	
	public String imprimir() {
		String data = "";
		
		for( int i = 0; i < participantes.size(); i++) {
			Colaborador colaborador = participantes.get(i);
			data = data.concat(colaborador.getNome());
			data = data.concat("\n");
		}
		
		return data;
	}
	
	public ArrayList<Colaborador> getParticipantes() {
		return this.participantes;
	}
}
