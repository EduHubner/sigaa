package com.classes.DTO;

public class Curso {

	private int codigoCurso;
	private String nome;
	
	public Curso() {
		
	}
	
	public Curso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [codigoCurso=");
		builder.append(codigoCurso);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
	
}
