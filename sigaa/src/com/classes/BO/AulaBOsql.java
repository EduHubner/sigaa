package com.classes.BO;

import java.util.List;

import com.classes.DAO.AulaDAO;
import com.classes.DTO.Aula;

public class AulaBOsql implements AulaBO {

	public boolean inserir(Aula aula) {
		if (existe(aula) != true) {
            AulaDAO aulaDAO = new AulaDAO();
            return aulaDAO.inserir(aula);
        }
        return false;
	}
	public boolean alterar(Aula aula) {
		AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.alterar(aula);
	}
	public boolean excluir(Aula aula) {
		AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.excluir(aula);
	}
	public Aula procurarPorCodigo(Aula aula) {
		AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.procurarPorCodigo(aula);
	}
	public Aula procurarPorProfessor(Aula aula) {
	    AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.procurarPorProfessor(aula);
	}
	public boolean existe(Aula aula) {
	    AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.existe(aula);
	}
	public List<Aula> pesquisarTodos() {
	    AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.pesquisarTodos();
	}
}
