package com.classes.DTO;

import java.util.List;

public class ProfessorDTO {

	private int registro;
	protected List<Turma> turmaMinistrando;
	
	public ProfessorDTO() {
		
	}
	
	public ProfessorDTO(int registro) {
		this.registro = registro;
	}
	
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public List<Turma> getTurmaMinistrando() {
		return turmaMinistrando;
	}
	public void setTurmaMinistrando(List<Turma> turmaMinistrando) {
		this.turmaMinistrando = turmaMinistrando;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfessorDTO [registro=");
		builder.append(registro);
		builder.append(", turmaMinistrando=");
		builder.append(turmaMinistrando);
		builder.append("]");
		return builder.toString();
	}
		
	
}
