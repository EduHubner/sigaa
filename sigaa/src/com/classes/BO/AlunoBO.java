package com.classes.BO;

import java.util.List;

import com.classes.DTO.Aluno;

public interface AlunoBO {

	public boolean inserir(Aluno aluno);
    public boolean alterar(Aluno aluno);
    public boolean excluir(Aluno aluno);
    public Aluno procurarPorCodigo(Aluno aluno);
    public Aluno procurarPorDescricao(Aluno aluno);
    public boolean existe(Aluno aluno);
    public List<Aluno> pesquisarTodos();
}
