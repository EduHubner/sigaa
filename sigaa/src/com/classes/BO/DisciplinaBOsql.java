package com.classes.BO;

import java.util.List;

import com.classes.DAO.DisciplinaDAO;
import com.classes.DTO.Disciplina;

public class DisciplinaBOsql implements DisciplinaBO{

	public boolean inserir(Disciplina disciplina) {
		if (existe(disciplina) != true) {
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            return disciplinaDAO.inserir(disciplina);
        }
        return false;
	}
	public boolean alterar(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.alterar(disciplina);
	}
	public boolean excluir(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.excluir(disciplina);
	}
	public Disciplina procurarPorCodigo(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.procurarPorCodigo(disciplina);
	}
	public Disciplina procurarPorNome(Disciplina disciplina) {
	    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.procurarPorNome(disciplina);
	}
	public boolean existe(Disciplina disciplina) {
	    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.existe(disciplina);
	}
	public List<Disciplina> pesquisarTodos() {
	    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.pesquisarTodos();
	}
}
