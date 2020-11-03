package atividade2.gestaoacademica;

public class Colaborador {

	private int id_colaborador;
	private String nome;
	private String email;
	private boolean professor;
	
	public Colaborador(String nome, String email, int professor, int id_colaborador) {
		this.nome = nome;
		this.email = email;
		this.id_colaborador = id_colaborador;
		if(professor == 0) {
			this.professor = false;
		}
		else {
			this.professor = true;
		}
	}
	
	public String imprimir() {
		return "Nome: "+ this.nome + "\nE-mail: " + this.email + "\n" + ((professor)?"Professor": ""
				+ "Aluno") + "\n-----------------------\n";
	}
	
	public int getIdColaborador() {
		return this.id_colaborador;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean getProfessor() {
		return this.professor;
	}
}
