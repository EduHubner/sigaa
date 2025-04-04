package com.classes.DTO;

import java.sql.Date;
import java.util.List;

public class Turma extends Disciplina {

	private int codigoTurma;
	private String situacaoTurma;
	private Date dataInicio;
	protected List<Aluno> aluno;
	protected List<ProfessorDTO> professor;
	
	public Turma() {
		
	}
	
	public Turma(int codigoTurma) {
		
	}
	
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getSituacaoTurma() {
		return situacaoTurma;
	}
	public void setSituacaoTurma(String situacaoTurma) {
		this.situacaoTurma = situacaoTurma;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	public List<ProfessorDTO> getProfessor() {
		return professor;
	}
	public void setProfessor(List<ProfessorDTO> professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Turma [codigoTurma=");
		builder.append(codigoTurma);
		builder.append(", situacaoTurma=");
		builder.append(situacaoTurma);
		builder.append(", dataInicio=");
		builder.append(dataInicio);
		builder.append(", aluno=");
		builder.append(aluno);
		builder.append(", professor=");
		builder.append(professor);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
