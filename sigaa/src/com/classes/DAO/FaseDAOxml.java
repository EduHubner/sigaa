package com.classes.DAO;

import com.classes.DTO.Fase;
import com.classes.DTO.Curso;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

public class FaseDAOxml {

    public boolean inserir(Fase fase) {
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            Element root = doc.getDocumentElement();

            Element novaFase = doc.createElement("Fase");

            Element codigoFase = doc.createElement("codigoFase");
            codigoFase.setTextContent(String.valueOf(fase.getCodigoFase()));
            Element ano = doc.createElement("ano");
            ano.setTextContent(String.valueOf(fase.getAno()));
            Element semestre = doc.createElement("semestre");
            semestre.setTextContent(String.valueOf(fase.getSemestre()));
            Element codigoCurso = doc.createElement("codigoCurso");
            codigoCurso.setTextContent(String.valueOf(fase.getCurso().getCodigoCurso()));

            novaFase.appendChild(codigoFase);
            novaFase.appendChild(ano);
            novaFase.appendChild(semestre);
            novaFase.appendChild(codigoCurso);

            root.appendChild(novaFase);
            XMLUtil.salvarXML(doc, "fases.xml");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Fase fase) {
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            NodeList fases = doc.getElementsByTagName("Fase");

            for (int i = 0; i < fases.getLength(); i++) {
                Element faseEl = (Element) fases.item(i);
                if (Integer.parseInt(faseEl.getElementsByTagName("codigoFase").item(0).getTextContent()) == fase.getCodigoFase()) {
                    faseEl.getElementsByTagName("semestre").item(0).setTextContent(String.valueOf(fase.getSemestre()));
                    XMLUtil.salvarXML(doc, "fases.xml");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Fase fase) {
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            NodeList fases = doc.getElementsByTagName("Fase");

            for (int i = 0; i < fases.getLength(); i++) {
                Element faseEl = (Element) fases.item(i);
                if (Integer.parseInt(faseEl.getElementsByTagName("codigoFase").item(0).getTextContent()) == fase.getCodigoFase()) {
                    faseEl.getParentNode().removeChild(faseEl);
                    XMLUtil.salvarXML(doc, "fases.xml");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Fase procurarPorCodigo(Fase fase) {
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            NodeList fases = doc.getElementsByTagName("Fase");

            for (int i = 0; i < fases.getLength(); i++) {
                Element faseEl = (Element) fases.item(i);
                if (Integer.parseInt(faseEl.getElementsByTagName("codigoFase").item(0).getTextContent()) == fase.getCodigoFase()) {
                    return montarFase(faseEl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Fase procurarPorAno(Fase fase) {
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            NodeList fases = doc.getElementsByTagName("Fase");

            for (int i = 0; i < fases.getLength(); i++) {
                Element faseEl = (Element) fases.item(i);
                if (Integer.parseInt(faseEl.getElementsByTagName("ano").item(0).getTextContent()) == fase.getAno()) {
                    return montarFase(faseEl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Fase fase) {
        return procurarPorCodigo(fase) != null;
    }

    public List<Fase> pesquisarTodos() {
        List<Fase> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML("fases.xml");
            NodeList fases = doc.getElementsByTagName("Fase");

            for (int i = 0; i < fases.getLength(); i++) {
                Element faseEl = (Element) fases.item(i);
                lista.add(montarFase(faseEl));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Fase montarFase(Element el) {
        int codigoFase = Integer.parseInt(el.getElementsByTagName("codigoFase").item(0).getTextContent());
        int ano = Integer.parseInt(el.getElementsByTagName("ano").item(0).getTextContent());
        int semestre = Integer.parseInt(el.getElementsByTagName("semestre").item(0).getTextContent());
        int codigoCurso = Integer.parseInt(el.getElementsByTagName("codigoCurso").item(0).getTextContent());

        Curso curso = new Curso();
        curso.setCodigoCurso(codigoCurso);

        Fase fase = new Fase();
        fase.setCodigoFase(codigoFase);
        fase.setAno(ano);
        fase.setSemestre(semestre);
        fase.setCurso(curso);
        return fase;
    }
}
