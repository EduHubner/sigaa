package com.classes.DTO;

public class Disciplina {

	private int codigoDisciplina;
	private String nome;
	private int cargaHoraria;
	protected Fase fase;
	
	
	public Disciplina() {
		
	}
	
	public Disciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Fase getFase() {
		return fase;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Disciplina [codigoDisciplina=");
		builder.append(codigoDisciplina);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cargaHoraria=");
		builder.append(cargaHoraria);
		builder.append(", fase=");
		builder.append(fase);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
