package com.classes.BO;

import com.classes.DAO.AlunoDAOxml;
import com.classes.DTO.Aluno;
import java.util.List;

public class AlunoBOxml {

    public boolean inserir(Aluno aluno) {
        if (!existe(aluno)) {
            AlunoDAOxml dao = new AlunoDAOxml();
            return dao.inserir(aluno);
        }
        return false;
    }

    public boolean alterar(Aluno aluno) {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.alterar(aluno);
    }

    public boolean excluir(Aluno aluno) {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.excluir(aluno);
    }

    public Aluno procurarPorCodigo(Aluno aluno) {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.procurarPorCodigo(aluno);
    }

    public Aluno procurarPorDescricao(Aluno aluno) {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.procurarPorNome(aluno);
    }

    public boolean existe(Aluno aluno) {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.existe(aluno);
    }

    public List<Aluno> pesquisarTodos() {
        AlunoDAOxml dao = new AlunoDAOxml();
        return dao.pesquisarTodos();
    }
}
