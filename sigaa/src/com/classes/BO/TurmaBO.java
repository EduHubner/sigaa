package com.classes.BO;

import java.util.List;

import com.classes.DTO.Turma;

public interface TurmaBO {
	
	public boolean inserir(Turma turma);
    public boolean alterar(Turma turma);
    public boolean excluir(Turma turma);
    public Turma procurarPorCodigo(Turma turma);
    public Turma procurarPorSituacao(Turma turma);
    public boolean existe(Turma turma);
    public List<Turma> pesquisarTodos();
}
