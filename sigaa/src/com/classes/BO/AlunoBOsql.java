package com.classes.BO;

import java.util.List;

import com.classes.DAO.AlunoDAO;
import com.classes.DTO.Aluno;

public class AlunoBOsql implements AlunoBO{

	public boolean inserir(Aluno aluno) {
		if (existe(aluno) != true) {
            AlunoDAO alunoDAO = new AlunoDAO();
            return alunoDAO.inserir(aluno);
        }
        return false;
	}
	public boolean alterar(Aluno aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.alterar(aluno);
	}
	public boolean excluir(Aluno aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.excluir(aluno);
	}
	public Aluno procurarPorCodigo(Aluno aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorCodigo(aluno);
	}
	public Aluno procurarPorDescricao(Aluno aluno) {
	    AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorNome(aluno);
	}
	public boolean existe(Aluno aluno) {
	    AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.existe(aluno);
	}
	public List<Aluno> pesquisarTodos() {
	    AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.pesquisarTodos();
	}
}
