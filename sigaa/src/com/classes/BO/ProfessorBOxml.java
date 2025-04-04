package com.classes.BO;

import com.classes.DAO.ProfessorDAOxml;
import com.classes.DTO.ProfessorDTO;

import java.util.List;

public class ProfessorBOxml implements ProfessorBO {

    public boolean inserir(ProfessorDTO professor) {
        if (!existe(professor)) {
            ProfessorDAOxml dao = new ProfessorDAOxml();
            return dao.inserir(professor);
        }
        return false;
    }

    public boolean alterar(ProfessorDTO professor) {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.alterar(professor);
    }

    public boolean excluir(ProfessorDTO professor) {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.excluir(professor);
    }

    public ProfessorDTO procurarPorCodigo(ProfessorDTO professor) {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.procurarPorCodigo(professor);
    }

    public ProfessorDTO procurarPorNome(ProfessorDTO professor) {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.procurarPorNome(professor);
    }

    public boolean existe(ProfessorDTO professor) {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.existe(professor);
    }

    public List<ProfessorDTO> pesquisarTodos() {
        ProfessorDAOxml dao = new ProfessorDAOxml();
        return dao.pesquisarTodos();
    }
}
