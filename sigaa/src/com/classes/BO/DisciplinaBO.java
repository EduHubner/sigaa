package com.classes.BO;

import java.util.List;

import com.classes.DTO.Disciplina;

public interface DisciplinaBO {

	public boolean inserir(Disciplina disciplina);
    public boolean alterar(Disciplina disciplina);
    public boolean excluir(Disciplina disciplina);
    public Disciplina procurarPorCodigo(Disciplina disciplina);
    public Disciplina procurarPorNome(Disciplina disciplina);
    public boolean existe(Disciplina disciplina);
    public List<Disciplina> pesquisarTodos();
}
