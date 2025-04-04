package com.classes.BO;

import java.util.List;
import com.classes.DAO.CursoDAOxml;
import com.classes.DTO.Curso;

public class CursoBOxml implements CursoBO {

    public boolean inserir(Curso curso) {
        if (!existe(curso)) {
            CursoDAOxml cursoDAOxml = new CursoDAOxml();
            return cursoDAOxml.inserir(curso);
        }
        return false;
    }

    public boolean alterar(Curso curso) {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.alterar(curso);
    }

    public boolean excluir(Curso curso) {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.excluir(curso);
    }

    public Curso procurarPorCodigo(Curso curso) {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.procurarPorCodigo(curso);
    }

    public Curso procurarPorNome(Curso curso) {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.procurarPorNome(curso);
    }

    public boolean existe(Curso curso) {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.existe(curso);
    }

    public List<Curso> pesquisarTodos() {
        CursoDAOxml cursoDAOxml = new CursoDAOxml();
        return cursoDAOxml.pesquisarTodos();
    }
}
