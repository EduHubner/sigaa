package com.classes.DAO;

import com.classes.DTO.Aula;
import com.classes.DTO.ProfessorDTO;
import com.classes.DTO.Turma;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AulaDAOxml {

    private final String nomeArquivo = "aula.xml";

    public boolean inserir(Aula aula) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            Element raiz = doc.getDocumentElement();

            Element aulaElement = doc.createElement("aula");

            aulaElement.setAttribute("codigoAula", String.valueOf(aula.getCodigoAula()));

            Element dataElement = doc.createElement("dataAula");
            dataElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(aula.getData()));
            aulaElement.appendChild(dataElement);

            Element cargaElement = doc.createElement("cargaHoraria");
            cargaElement.setTextContent(String.valueOf(aula.getCargaHoraria()));
            aulaElement.appendChild(cargaElement);

            Element turmaElement = doc.createElement("codigoTurma");
            turmaElement.setTextContent(String.valueOf(aula.getTurmaAula().getCodigoTurma()));
            aulaElement.appendChild(turmaElement);

            Element professorElement = doc.createElement("registro");
            professorElement.setTextContent(String.valueOf(aula.getProfessorMinistrou().getRegistro()));
            aulaElement.appendChild(professorElement);

            raiz.appendChild(aulaElement);

            XMLUtil.salvarXML(doc, nomeArquivo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Aula aula) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aula");

            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                if (el.getAttribute("codigoAula").equals(String.valueOf(aula.getCodigoAula()))) {
                    NodeList filhos = el.getChildNodes();
                    for (int j = 0; j < filhos.getLength(); j++) {
                        if (filhos.item(j).getNodeName().equals("cargaHoraria")) {
                            filhos.item(j).setTextContent(String.valueOf(aula.getCargaHoraria()));
                        }
                    }
                    XMLUtil.salvarXML(doc, nomeArquivo);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Aula aula) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aula");
            Element raiz = doc.getDocumentElement();

            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                if (el.getAttribute("codigoAula").equals(String.valueOf(aula.getCodigoAula()))) {
                    raiz.removeChild(el);
                    XMLUtil.salvarXML(doc, nomeArquivo);
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Aula procurarPorCodigo(Aula aula) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aula");

            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                if (el.getAttribute("codigoAula").equals(String.valueOf(aula.getCodigoAula()))) {
                    return montarAula(el);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Aula procurarPorProfessor(Aula aula) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("aula");

            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                NodeList filhos = el.getChildNodes();
                for (int j = 0; j < filhos.getLength(); j++) {
                    if (filhos.item(j).getNodeName().equals("registro") &&
                        filhos.item(j).getTextContent().equals(String.valueOf(aula.getProfessorMinistrou().getRegistro()))) {
                        return montarAula(el);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(Aula aula) {
        return procurarPorCodigo(aula) != null;
    }

    public List<Aula> pesquisarTodos() {
        try {
            List<Aula> lista = new ArrayList<>();
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList aulas = doc.getElementsByTagName("aula");

            for (int i = 0; i < aulas.getLength(); i++) {
                Element el = (Element) aulas.item(i);
                lista.add(montarAula(el));
            }

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Aula montarAula(Element el) {
        try {
            Aula aula = new Aula();
            aula.setCodigoAula(Integer.parseInt(el.getAttribute("codigoAula")));

            NodeList filhos = el.getChildNodes();
            for (int i = 0; i < filhos.getLength(); i++) {
                Node n = filhos.item(i);
                switch (n.getNodeName()) {
                    case "dataAula":
                        aula.setData(java.sql.Date.valueOf(n.getTextContent()));
                        break;
                    case "cargaHoraria":
                        aula.setCargaHoraria(Integer.parseInt(n.getTextContent()));
                        break;
                    case "codigoTurma":
                        Turma turma = new Turma();
                        turma.setCodigoTurma(Integer.parseInt(n.getTextContent()));
                        aula.setTurmaAula(turma);
                        break;
                    case "registro":
                        ProfessorDTO professor = new ProfessorDTO();
                        professor.setRegistro(Integer.parseInt(n.getTextContent()));
                        aula.setProfessorMinistrou(professor);
                        break;
                }
            }
            return aula;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
