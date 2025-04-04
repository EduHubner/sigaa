package com.classes.BO;

import java.util.List;
import com.classes.DAO.AulaDAOxml;
import com.classes.DTO.Aula;

public class AulaBOxml implements AulaBO {

    public boolean inserir(Aula aula) {
        if (!existe(aula)) {
            AulaDAOxml aulaDAO = new AulaDAOxml();
            return aulaDAO.inserir(aula);
        }
        return false;
    }

    public boolean alterar(Aula aula) {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.alterar(aula);
    }

    public boolean excluir(Aula aula) {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.excluir(aula);
    }

    public Aula procurarPorCodigo(Aula aula) {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.procurarPorCodigo(aula);
    }

    public Aula procurarPorProfessor(Aula aula) {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.procurarPorProfessor(aula);
    }

    public boolean existe(Aula aula) {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.existe(aula);
    }

    public List<Aula> pesquisarTodos() {
        AulaDAOxml aulaDAO = new AulaDAOxml();
        return aulaDAO.pesquisarTodos();
    }
}
