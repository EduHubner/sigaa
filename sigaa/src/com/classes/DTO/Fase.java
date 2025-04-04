package com.classes.DTO;

public class Fase {

	private int codigoFase;
	private int ano;
	private int semestre;
	protected Curso curso;
	
	public Fase() {
		
	}
	
	public Fase(int codigoFase) {
		this.codigoFase = codigoFase;
	}
	
	public Fase(int codigoFase, int ano, int semestre, Curso curso) {
		this.codigoFase = codigoFase;
		this.ano = ano;
		this.semestre = semestre;
		this.curso = curso;
	}
	
	public int getCodigoFase() {
		return codigoFase;
	}
	public void setCodigoFase(int codigoFase) {
		this.codigoFase = codigoFase;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fase [codigoFase=");
		builder.append(codigoFase);
		builder.append(", ano=");
		builder.append(ano);
		builder.append(", semestre=");
		builder.append(semestre);
		builder.append(", curso=");
		builder.append(curso);
		builder.append("]");
		return builder.toString();
	}
	
	
}
