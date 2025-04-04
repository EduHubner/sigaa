package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.CursoBO;
import com.classes.BO.CursoBOsql;
import com.classes.BO.CursoBOxml;
import com.classes.DTO.Curso;
import java.util.Scanner;

public class MainCurso {

	public static void main(String[] args) {
		// Teste Inserir
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Você deseja armazenar em XML (1) ou SQL (2)");
		int resp = sc.nextInt();
		
		CursoBO cursoBO = new CursoBOxml();
		
		if (resp == 2) {
			cursoBO = new CursoBOsql();
		}
		
		
		
		Curso curso = new Curso(5, "ADM");
		if (cursoBO.inserir(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		// Teste Alterar	
		/*cursoBO = new CursoBOsql();
		curso = new Curso(2,"Pedagogia");
		cursoBO.alterar(curso);
		curso = cursoBO.procurarPorCodigo(curso);
		System.out.println(curso);
		
		// Teste Excluir
		cursoBO = new CursoBOsql();
		curso = new Curso(3);
		if (cursoBO.excluir(curso))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");
		
		// Teste Pesquisar Todos (Retorna a Lista de Cursos)
		cursoBO = new CursoBOsql();
		List<Curso> lista = new ArrayList<Curso>();
		lista = cursoBO.pesquisarTodos();	
		for (Curso curso1 : lista) {
			System.out.println(curso.toString());
		}
		
		// Teste Procurar por Codigo
		cursoBO = new CursoBOsql();
		curso = new Curso(4);
		curso = cursoBO.procurarPorCodigo(curso);
		System.out.println(curso);
		
		// Teste Procurar por Descricao
		// retorna o primeiro encontrado
		cursoBO = new CursoBOsql();
		curso = new Curso("BCC");
		curso = cursoBO.procurarPorNome(curso);
		System.out.println(curso);*/
		
		
		
		
		/*CursoBO cursoBO = new CursoBOxml();
		// Teste Inserir XML
		Curso curso = new Curso(2, "Fisíca");
		if (cursoBO.inserir(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");*/
		
		// Teste Alterar
		/*cursoBO = new CursoBOxml();
		Curso curso = new Curso(2,"Pedagogia");
		cursoBO.alterar(curso);
		curso = cursoBO.procurarPorCodigo(curso);
		System.out.println(curso);*/
		
		// Teste Excluir
		/*cursoBO = new CursoBOxml();
		Cruso curso = new Curso(3);
		if (cursoBO.excluir(curso))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");*/
		
		
		

	}

}
