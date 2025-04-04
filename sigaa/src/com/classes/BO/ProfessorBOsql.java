package com.classes.BO;

import java.util.List;

import com.classes.DAO.ProfessorDAO;
import com.classes.DTO.ProfessorDTO;

public class ProfessorBOsql implements ProfessorBO{

	public boolean inserir(ProfessorDTO professor) {
		if (existe(professor) != true) {
            ProfessorDAO professorDAO = new ProfessorDAO();
            return professorDAO.inserir(professor);
        }
        return false;
	}
	public boolean alterar(ProfessorDTO professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.alterar(professor);
	}
	public boolean excluir(ProfessorDTO professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.excluir(professor);
	}
	public ProfessorDTO procurarPorCodigo(ProfessorDTO professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.procurarPorCodigo(professor);
	}
	public ProfessorDTO procurarPorNome(ProfessorDTO professor) {
	    ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.procurarPorNome(professor);
	}
	public boolean existe(ProfessorDTO professor) {
	    ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.existe(professor);
	}
	public List<ProfessorDTO> pesquisarTodos() {
	    ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.pesquisarTodos();
	}
}
