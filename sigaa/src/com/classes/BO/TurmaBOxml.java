package com.classes.BO;

import com.classes.DAO.TurmaDAOxml;
import com.classes.DTO.Turma;

import java.util.List;

public class TurmaBOxml implements TurmaBO {


    public boolean inserir(Turma turma) {
        if (!existe(turma)) {
        	TurmaDAOxml turmaDAO = new TurmaDAOxml();
            return turmaDAO.inserir(turma);
        }
        return false;
    }

    public boolean alterar(Turma turma) {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.alterar(turma);
    }

    public boolean excluir(Turma turma) {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.excluir(turma);
    }

    public Turma procurarPorCodigo(Turma turma) {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.procurarPorCodigo(turma);
    }

    public Turma procurarPorSituacao(Turma turma) {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.procurarPorSituacao(turma);
    }

    public boolean existe(Turma turma) {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.existe(turma);
    }

    public List<Turma> pesquisarTodos() {
    	TurmaDAOxml turmaDAO = new TurmaDAOxml();
        return turmaDAO.pesquisarTodos();
    }
}
