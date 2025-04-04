package com.classes.DTO;

import java.sql.Date;
import java.util.List;

public class Aula {

	private int codigoAula;
	private Date data;
	private int cargaHoraria;
	protected ProfessorDTO professorMinistrou;
	protected Turma turmaAula;
	protected List<Aluno> alunoParticiparam;
	
	public Aula() {
		
	}
	
	public Aula(int codigoAula, ProfessorDTO professorMinistrou, Turma turmaAula) {
		this.codigoAula = codigoAula;
		this.professorMinistrou = professorMinistrou;
		this.turmaAula = turmaAula;
	}
	
	public int getCodigoAula() {
		return codigoAula;
	}
	public void setCodigoAula(int codigoAula) {
		this.codigoAula = codigoAula;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public ProfessorDTO getProfessorMinistrou() {
		return professorMinistrou;
	}
	public void setProfessorMinistrou(ProfessorDTO professorMinistrou) {
		this.professorMinistrou = professorMinistrou;
	}
	public Turma getTurmaAula() {
		return turmaAula;
	}
	public void setTurmaAula(Turma turmaAula) {
		this.turmaAula = turmaAula;
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
		builder.append("Aula [codigoAula=");
		builder.append(codigoAula);
		builder.append(", data=");
		builder.append(data);
		builder.append(", cargaHoraria=");
		builder.append(cargaHoraria);
		builder.append(", professorMinistrou=");
		builder.append(professorMinistrou);
		builder.append(", turmaAula=");
		builder.append(turmaAula);
		builder.append(", alunoParticiparam=");
		builder.append(alunoParticiparam);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
