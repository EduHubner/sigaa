package com.classes.BO;

import java.util.List;

import com.classes.DTO.Aula;

public interface AulaBO {

	public boolean inserir(Aula aula);
    public boolean alterar(Aula aula);
    public boolean excluir(Aula aula);
    public Aula procurarPorCodigo(Aula aula);
    public Aula procurarPorProfessor(Aula aula);
    public boolean existe(Aula aula);
    public List<Aula> pesquisarTodos();
}
