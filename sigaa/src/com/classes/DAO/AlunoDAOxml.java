package com.classes.DAO;

import com.classes.DTO.Aluno;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAOxml {

    final String nomeArquivo = "aluno.xml";

    public boolean inserir(Aluno aluno) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            Element raiz = doc.getDocumentElement();

            Element elemAluno = doc.createElement("aluno");

            Element matricula = doc.createElement("matricula");
            matricula.appendChild(doc.createTextNode(String.valueOf(aluno.getMatricula())));
            elemAluno.appendChild(matricula);

            Element nome = doc.createElement("nome");
            nome.appendChild(doc.createTextNode(aluno.getNome()));
            elemAluno.appendChild(nome);

            raiz.appendChild(elemAluno);
            XMLUtil.salvarXML(doc, nomeArquivo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Aluno aluno) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aluno");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemAluno = (Element) lista.item(i);
                int matriculaAtual = Integer.parseInt(elemAluno.getElementsByTagName("matricula").item(0).getTextContent());

                if (matriculaAtual == aluno.getMatricula()) {
                    elemAluno.getElementsByTagName("nome").item(0).setTextContent(aluno.getNome());
                    XMLUtil.salvarXML(doc, nomeArquivo);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Aluno aluno) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aluno");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemAluno = (Element) lista.item(i);
                int matriculaAtual = Integer.parseInt(elemAluno.getElementsByTagName("matricula").item(0).getTextContent());

                if (matriculaAtual == aluno.getMatricula()) {
                    elemAluno.getParentNode().removeChild(elemAluno);
                    XMLUtil.salvarXML(doc, nomeArquivo);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Aluno procurarPorCodigo(Aluno aluno) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aluno");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemAluno = (Element) lista.item(i);
                int matriculaAtual = Integer.parseInt(elemAluno.getElementsByTagName("matricula").item(0).getTextContent());

                if (matriculaAtual == aluno.getMatricula()) {
                    Aluno encontrado = new Aluno();
                    encontrado.setMatricula(matriculaAtual);
                    encontrado.setNome(elemAluno.getElementsByTagName("nome").item(0).getTextContent());
                    return encontrado;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Aluno procurarPorNome(Aluno aluno) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aluno");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemAluno = (Element) lista.item(i);
                String nomeAtual = elemAluno.getElementsByTagName("nome").item(0).getTextContent();

                if (nomeAtual.equalsIgnoreCase(aluno.getNome())) {
                    Aluno encontrado = new Aluno();
                    encontrado.setMatricula(Integer.parseInt(elemAluno.getElementsByTagName("matricula").item(0).getTextContent()));
                    encontrado.setNome(nomeAtual);
                    return encontrado;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Aluno aluno) {
        return procurarPorCodigo(aluno) != null;
    }

    public List<Aluno> pesquisarTodos() {
        List<Aluno> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList elementos = doc.getElementsByTagName("aluno");

            for (int i = 0; i < elementos.getLength(); i++) {
                Element elemAluno = (Element) elementos.item(i);
                Aluno aluno = new Aluno();
                aluno.setMatricula(Integer.parseInt(elemAluno.getElementsByTagName("matricula").item(0).getTextContent()));
                aluno.setNome(elemAluno.getElementsByTagName("nome").item(0).getTextContent());
                lista.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
