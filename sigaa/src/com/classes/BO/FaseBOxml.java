package com.classes.BO;

import java.util.List;
import com.classes.DAO.FaseDAOxml;
import com.classes.DTO.Fase;

public class FaseBOxml implements FaseBO {

    public boolean inserir(Fase fase) {
        if (!existe(fase)) {
            FaseDAOxml dao = new FaseDAOxml();
            return dao.inserir(fase);
        }
        return false;
    }

    public boolean alterar(Fase fase) {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.alterar(fase);
    }

    public boolean excluir(Fase fase) {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.excluir(fase);
    }

    public Fase procurarPorCodigo(Fase fase) {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.procurarPorCodigo(fase);
    }

    public Fase procurarPorAno(Fase fase) {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.procurarPorAno(fase);
    }

    public boolean existe(Fase fase) {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.existe(fase);
    }

    public List<Fase> pesquisarTodos() {
        FaseDAOxml dao = new FaseDAOxml();
        return dao.pesquisarTodos();
    }
}
