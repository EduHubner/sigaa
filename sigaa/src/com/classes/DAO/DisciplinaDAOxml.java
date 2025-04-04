package com.classes.DAO;

import com.classes.DTO.Disciplina;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOxml {
    private final String nomeArquivo = "disciplina.xml";

    public boolean inserir(Disciplina disciplina) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            Element raiz = doc.getDocumentElement();

            // Verifica se já existe
            if (existe(disciplina)) return false;

            Element disciplinaElement = doc.createElement("disciplina");

            Element codigoDisciplina = doc.createElement("codigoDisciplina");
            codigoDisciplina.appendChild(doc.createTextNode(String.valueOf(disciplina.getCodigoDisciplina())));
            disciplinaElement.appendChild(codigoDisciplina);

            Element nome = doc.createElement("nome");
            nome.appendChild(doc.createTextNode(disciplina.getNome()));
            disciplinaElement.appendChild(nome);

            Element cargaHoraria = doc.createElement("cargaHoraria");
            cargaHoraria.appendChild(doc.createTextNode(String.valueOf(disciplina.getCargaHoraria())));
            disciplinaElement.appendChild(cargaHoraria);

            Element codigoFase = doc.createElement("codigoFase");
            codigoFase.appendChild(doc.createTextNode(String.valueOf(disciplina.getFase().getCodigoFase())));
            disciplinaElement.appendChild(codigoFase);

            raiz.appendChild(disciplinaElement);
            XMLUtil.salvarXML(doc, nomeArquivo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Disciplina disciplina) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("disciplina");

            for (int i = 0; i < lista.getLength(); i++) {
                Element d = (Element) lista.item(i);
                int codigo = Integer.parseInt(d.getElementsByTagName("codigoDisciplina").item(0).getTextContent());

                if (codigo == disciplina.getCodigoDisciplina()) {
                    d.getElementsByTagName("nome").item(0).setTextContent(disciplina.getNome());
                    d.getElementsByTagName("cargaHoraria").item(0).setTextContent(String.valueOf(disciplina.getCargaHoraria()));
                    d.getElementsByTagName("codigoFase").item(0).setTextContent(String.valueOf(disciplina.getFase().getCodigoFase()));
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

    public boolean excluir(Disciplina disciplina) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("disciplina");

            for (int i = 0; i < lista.getLength(); i++) {
                Element d = (Element) lista.item(i);
                int codigo = Integer.parseInt(d.getElementsByTagName("codigoDisciplina").item(0).getTextContent());

                if (codigo == disciplina.getCodigoDisciplina()) {
                    d.getParentNode().removeChild(d);
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

    public Disciplina procurarPorCodigo(Disciplina disciplina) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("disciplina");

            for (int i = 0; i < lista.getLength(); i++) {
                Element d = (Element) lista.item(i);
                int codigo = Integer.parseInt(d.getElementsByTagName("codigoDisciplina").item(0).getTextContent());

                if (codigo == disciplina.getCodigoDisciplina()) {
                    Disciplina nova = new Disciplina();
                    nova.setCodigoDisciplina(codigo);
                    nova.setNome(d.getElementsByTagName("nome").item(0).getTextContent());
                    nova.setCargaHoraria(Integer.parseInt(d.getElementsByTagName("cargaHoraria").item(0).getTextContent()));
                    nova.getFase().setCodigoFase(Integer.parseInt(d.getElementsByTagName("codigoFase").item(0).getTextContent()));
                    return nova;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Disciplina procurarPorNome(Disciplina disciplina) {
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList lista = doc.getElementsByTagName("disciplina");

            for (int i = 0; i < lista.getLength(); i++) {
                Element d = (Element) lista.item(i);
                String nome = d.getElementsByTagName("nome").item(0).getTextContent();

                if (nome.equalsIgnoreCase(disciplina.getNome())) {
                    Disciplina nova = new Disciplina();
                    nova.setCodigoDisciplina(Integer.parseInt(d.getElementsByTagName("codigoDisciplina").item(0).getTextContent()));
                    nova.setNome(nome);
                    nova.setCargaHoraria(Integer.parseInt(d.getElementsByTagName("cargaHoraria").item(0).getTextContent()));
                    nova.getFase().setCodigoFase(Integer.parseInt(d.getElementsByTagName("codigoFase").item(0).getTextContent()));
                    return nova;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Disciplina disciplina) {
        return procurarPorNome(disciplina) != null;
    }

    public List<Disciplina> pesquisarTodos() {
        List<Disciplina> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML(nomeArquivo);
            NodeList disciplinas = doc.getElementsByTagName("disciplina");

            for (int i = 0; i < disciplinas.getLength(); i++) {
                Element d = (Element) disciplinas.item(i);
                Disciplina nova = new Disciplina();
                nova.setCodigoDisciplina(Integer.parseInt(d.getElementsByTagName("codigoDisciplina").item(0).getTextContent()));
                nova.setNome(d.getElementsByTagName("nome").item(0).getTextContent());
                nova.setCargaHoraria(Integer.parseInt(d.getElementsByTagName("cargaHoraria").item(0).getTextContent()));
                nova.getFase().setCodigoFase(Integer.parseInt(d.getElementsByTagName("codigoFase").item(0).getTextContent()));
                lista.add(nova);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
