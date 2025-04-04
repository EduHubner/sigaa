package com.classes.BO;

import java.util.List;

import com.classes.DAO.CursoDAO;
import com.classes.DTO.Curso;

public class CursoBOsql implements CursoBO {

	public boolean inserir(Curso curso) {
		if (existe(curso) != true) {
            CursoDAO cursoDAO = new CursoDAO();
            return cursoDAO.inserir(curso);
        }
        return false;
	}
	public boolean alterar(Curso curso) {
		CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.alterar(curso);
	}
	public boolean excluir(Curso curso) {
		CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.excluir(curso);
	}
	public Curso procurarPorCodigo(Curso curso) {
		CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.procurarPorCodigo(curso);
	}
	public Curso procurarPorNome(Curso curso) {
	    CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.procurarPorNome(curso);
	}
	public boolean existe(Curso curso) {
	    CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.existe(curso);
	}
	public List<Curso> pesquisarTodos() {
	    CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.pesquisarTodos();
	}

}
