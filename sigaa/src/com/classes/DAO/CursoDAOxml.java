package com.classes.DAO;

import com.classes.DTO.Curso;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

public class CursoDAOxml {

    public boolean inserir(Curso curso) {
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            Element root = doc.getDocumentElement();

            Element novoCurso = doc.createElement("Curso");

            Element codigo = doc.createElement("codigo");
            codigo.setTextContent(String.valueOf(curso.getCodigoCurso()));
            Element nome = doc.createElement("nome");
            nome.setTextContent(curso.getNome());

            novoCurso.appendChild(codigo);
            novoCurso.appendChild(nome);
            root.appendChild(novoCurso);

            XMLUtil.salvarXML(doc, "curso.xml");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Curso curso) {
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            NodeList cursos = doc.getElementsByTagName("Curso");

            for (int i = 0; i < cursos.getLength(); i++) {
                Element cursoEl = (Element) cursos.item(i);
                if (Integer.parseInt(cursoEl.getElementsByTagName("codigo").item(0).getTextContent()) == curso.getCodigoCurso()) {
                    cursoEl.getElementsByTagName("nome").item(0).setTextContent(curso.getNome());
                    XMLUtil.salvarXML(doc, "curso.xml");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Curso curso) {
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            NodeList cursos = doc.getElementsByTagName("Curso");

            for (int i = 0; i < cursos.getLength(); i++) {
                Element cursoEl = (Element) cursos.item(i);
                if (Integer.parseInt(cursoEl.getElementsByTagName("codigo").item(0).getTextContent()) == curso.getCodigoCurso()) {
                    cursoEl.getParentNode().removeChild(cursoEl);
                    XMLUtil.salvarXML(doc, "curso.xml");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Curso procurarPorCodigo(Curso curso) {
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            NodeList cursos = doc.getElementsByTagName("Curso");

            for (int i = 0; i < cursos.getLength(); i++) {
                Element cursoEl = (Element) cursos.item(i);
                int codigo = Integer.parseInt(cursoEl.getElementsByTagName("codigo").item(0).getTextContent());
                if (codigo == curso.getCodigoCurso()) {
                    String nome = cursoEl.getElementsByTagName("nome").item(0).getTextContent();
                    return new Curso(codigo, nome);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curso procurarPorNome(Curso curso) {
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            NodeList cursos = doc.getElementsByTagName("Curso");

            for (int i = 0; i < cursos.getLength(); i++) {
                Element cursoEl = (Element) cursos.item(i);
                String nome = cursoEl.getElementsByTagName("nome").item(0).getTextContent();
                if (nome.equalsIgnoreCase(curso.getNome())) {
                    int codigo = Integer.parseInt(cursoEl.getElementsByTagName("codigo").item(0).getTextContent());
                    return new Curso(codigo, nome);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Curso curso) {
        return procurarPorCodigo(curso) != null;
    }

    public List<Curso> pesquisarTodos() {
        List<Curso> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML("curso.xml");
            NodeList cursos = doc.getElementsByTagName("Curso");

            for (int i = 0; i < cursos.getLength(); i++) {
                Element cursoEl = (Element) cursos.item(i);
                int codigo = Integer.parseInt(cursoEl.getElementsByTagName("codigo").item(0).getTextContent());
                String nome = cursoEl.getElementsByTagName("nome").item(0).getTextContent();
                lista.add(new Curso(codigo, nome));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
