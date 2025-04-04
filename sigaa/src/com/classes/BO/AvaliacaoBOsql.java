package com.classes.BO;

import java.util.List;

import com.classes.DAO.AvaliacaoDAO;
import com.classes.DTO.Avaliacao;

public class AvaliacaoBOsql implements AvaliacaoBO {

	public boolean inserir(Avaliacao avaliacao) {
		if (existe(avaliacao) != true) {
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.inserir(avaliacao);
        }
        return false;
	}
	public boolean alterar(Avaliacao avaliacao) {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.alterar(avaliacao);
	}
	public boolean excluir(Avaliacao avaliacao) {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.excluir(avaliacao);
	}
	public Avaliacao procurarPorCodigo(Avaliacao avaliacao) {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.procurarPorCodigo(avaliacao);
	}
	public Avaliacao procurarPorProfessor(Avaliacao avaliacao) {
	    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.procurarPorProfessor(avaliacao);
	}
	public boolean existe(Avaliacao avaliacao) {
	    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.existe(avaliacao);
	}
	public List<Avaliacao> pesquisarTodos() {
	    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.pesquisarTodos();
	}
}
