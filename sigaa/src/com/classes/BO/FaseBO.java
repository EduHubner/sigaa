package com.classes.BO;

import java.util.List;

import com.classes.DTO.Fase;

public interface FaseBO {

	public boolean inserir(Fase fase);
    public boolean alterar(Fase fase);
    public boolean excluir(Fase fase);
    public Fase procurarPorCodigo(Fase fase);
    public Fase procurarPorAno(Fase fase);
    public boolean existe(Fase fase);
    public List<Fase> pesquisarTodos();
}
