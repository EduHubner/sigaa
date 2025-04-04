package com.classes.DTO;

import java.sql.Date;
import java.util.List;

public class Avaliacao {

	private int codigoAvaliacao;
	private Date data;
	protected ProfessorDTO professorMinistrou;
	protected Turma turmaAvaliacao;
	protected List<Aluno> alunoParticiparam;
	
	public Avaliacao() {
		
	}
	
	public Avaliacao(int codigoAvaliacao) {
		
	}
	
	public int getCodigoAvaliacao() {
		return codigoAvaliacao;
	}
	public void setCodigoAvaliacao(int codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ProfessorDTO getProfessorMinistrou() {
		return professorMinistrou;
	}
	public void setProfessorMinistrou(ProfessorDTO professorMinistrou) {
		this.professorMinistrou = professorMinistrou;
	}
	public Turma getTurmaAvaliacao() {
		return turmaAvaliacao;
	}
	public void getTurmaAvaliacao(Turma turmaAvaliacao) {
		this.turmaAvaliacao = turmaAvaliacao;
	}
	public List<Aluno> getAlunoParticiparam() {
		return alunoParticiparam;
	}
	public void setAlunoParticiparam(List<Aluno> alunoParticiparam) {
		this.alunoParticiparam = alunoParticiparam;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avaliacao [codigoAvaliacao=");
		builder.append(codigoAvaliacao);
		builder.append(", data=");
		builder.append(data);
		builder.append(", professorMinistrou=");
		builder.append(professorMinistrou);
		builder.append(", turmaAvaliacao=");
		builder.append(turmaAvaliacao);
		builder.append(", alunoParticiparam=");
		builder.append(alunoParticiparam);
		builder.append("]");
		return builder.toString();
	}
	
	
	 
	
	
}
