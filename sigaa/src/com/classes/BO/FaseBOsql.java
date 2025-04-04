package com.classes.BO;

import java.util.List;

import com.classes.DAO.FaseDAO;
import com.classes.DTO.Fase;

public class FaseBOsql implements FaseBO{

	public boolean inserir(Fase fase) {
		if (existe(fase) != true) {
            FaseDAO faseDAO = new FaseDAO();
            return faseDAO.inserir(fase);
        }
        return false;
	}
	public boolean alterar(Fase fase) {
		FaseDAO faseDAO = new FaseDAO();
        return faseDAO.alterar(fase);
	}
	public boolean excluir(Fase fase) {
		FaseDAO faseDAO = new FaseDAO();
        return faseDAO.excluir(fase);
	}
	public Fase procurarPorCodigo(Fase fase) {
		FaseDAO faseDAO = new FaseDAO();
        return faseDAO.procurarPorCodigo(fase);
	}
	public Fase procurarPorAno(Fase fase) {
	    FaseDAO faseDAO = new FaseDAO();
        return faseDAO.procurarPorAno(fase);
	}
	public boolean existe(Fase fase) {
	    FaseDAO faseDAO = new FaseDAO();
        return faseDAO.existe(fase);
	}
	public List<Fase> pesquisarTodos() {
	    FaseDAO faseDAO = new FaseDAO();
        return faseDAO.pesquisarTodos();
	}
}
