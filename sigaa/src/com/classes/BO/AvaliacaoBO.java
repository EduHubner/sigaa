package com.classes.BO;

import java.util.List;

import com.classes.DTO.Avaliacao;

public interface AvaliacaoBO {
	
	public boolean inserir(Avaliacao avaliacao);
    public boolean alterar(Avaliacao avaliacao);
    public boolean excluir(Avaliacao avaliacao);
    public Avaliacao procurarPorCodigo(Avaliacao avaliacao);
    public Avaliacao procurarPorProfessor(Avaliacao avaliacao);
    public boolean existe(Avaliacao aula);
    public List<Avaliacao> pesquisarTodos();

}
