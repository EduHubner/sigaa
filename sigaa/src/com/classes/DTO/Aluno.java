package com.classes.DTO;

import java.util.List;

public class Aluno {

	private int matricula;
	private String nome;
	protected List<Turma> turmaCursando;
	protected List<Aula> aulaParticipou;
	
	public Aluno() {
		
	}
	
	public Aluno(int matricula) {
		this.matricula = matricula;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Turma> getTurmaCursando() {
		return turmaCursando;
	}
	public void setTurmaCursando(List<Turma> turmaCursando) {
		this.turmaCursando = turmaCursando;
	}
	public List<Aula> getAulaParticipou() {
		return aulaParticipou;
	}
	public void setAulaParticipou(List<Aula> aulaParticipou) {
		this.aulaParticipou = aulaParticipou;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", turmaCursando=");
		builder.append(turmaCursando);
		builder.append(", aulaParticipou=");
		builder.append(aulaParticipou);
		builder.append("]");
		return builder.toString();
	}
	
	
}
