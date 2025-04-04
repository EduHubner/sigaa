package com.classes.BO;

import java.util.List;

import com.classes.DTO.ProfessorDTO;

public interface ProfessorBO {

	public boolean inserir(ProfessorDTO professor);
    public boolean alterar(ProfessorDTO professor);
    public boolean excluir(ProfessorDTO professor);
    public ProfessorDTO procurarPorCodigo(ProfessorDTO professor);
    public ProfessorDTO procurarPorNome(ProfessorDTO professor);
    public boolean existe(ProfessorDTO professor);
    public List<ProfessorDTO> pesquisarTodos();
}
