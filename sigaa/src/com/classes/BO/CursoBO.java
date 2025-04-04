package com.classes.BO;

import java.util.List;

import com.classes.DTO.Curso;

public interface CursoBO {

	public boolean inserir(Curso curso);
    public boolean alterar(Curso curso);
    public boolean excluir(Curso curso);
    public Curso procurarPorCodigo(Curso curso);
    public Curso procurarPorNome(Curso curso);
    public boolean existe(Curso curso);
    public List<Curso> pesquisarTodos();
}
