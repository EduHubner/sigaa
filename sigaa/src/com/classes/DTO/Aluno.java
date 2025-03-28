package com.classes.DTO;

import java.util.List;

public class Aluno {

	private int matricula;
	protected List<Turma> turmaCursando;
	protected List<Aula> aulaParticipou;
	
	public Aluno() {
		
	}
	
	public Aluno(int matricula) {
		
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
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
		builder.append(", turmaCursando=");
		builder.append(turmaCursando);
		builder.append(", aulaParticipou=");
		builder.append(aulaParticipou);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
