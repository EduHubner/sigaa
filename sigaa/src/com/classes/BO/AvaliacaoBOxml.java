package com.classes.BO;

import com.classes.DAO.AvaliacaoDAOxml;
import com.classes.DTO.Avaliacao;

import java.util.List;

public class AvaliacaoBOxml {

    AvaliacaoDAOxml avaliacaoDAO = new AvaliacaoDAOxml();

    public boolean inserir(Avaliacao avaliacao) {
        if (!avaliacaoDAO.existe(avaliacao)) {
            return avaliacaoDAO.inserir(avaliacao);
        }
        return false;
    }

    public boolean alterar(Avaliacao avaliacao) {
        if (avaliacaoDAO.existe(avaliacao)) {
            return avaliacaoDAO.alterar(avaliacao);
        }
        return false;
    }

    public boolean excluir(Avaliacao avaliacao) {
        if (avaliacaoDAO.existe(avaliacao)) {
            return avaliacaoDAO.excluir(avaliacao);
        }
        return false;
    }

    public Avaliacao procurarPorCodigo(Avaliacao avaliacao) {
        return avaliacaoDAO.procurarPorCodigo(avaliacao);
    }

    public List<Avaliacao> pesquisarTodos() {
        return avaliacaoDAO.pesquisarTodos();
    }
}
