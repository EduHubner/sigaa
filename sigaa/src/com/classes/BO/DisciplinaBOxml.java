package com.classes.BO;

import java.util.List;
import com.classes.DAO.DisciplinaDAOxml;
import com.classes.DTO.Disciplina;

public class DisciplinaBOxml {

    public boolean inserir(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.inserir(disciplina);
    }

    public boolean alterar(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.alterar(disciplina);
    }

    public boolean excluir(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.excluir(disciplina);
    }

    public Disciplina procurarPorCodigo(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.procurarPorCodigo(disciplina);
    }

    public Disciplina procurarPorNome(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.procurarPorNome(disciplina);
    }

    public boolean existe(Disciplina disciplina) {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.existe(disciplina);
    }

    public List<Disciplina> pesquisarTodos() {
        DisciplinaDAOxml dao = new DisciplinaDAOxml();
        return dao.pesquisarTodos();
    }
}
