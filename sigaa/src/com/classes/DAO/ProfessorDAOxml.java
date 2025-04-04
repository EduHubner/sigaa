package com.classes.DAO;

import com.classes.DTO.ProfessorDTO;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOxml {

    final String NOMEARQUIVO = "professores.xml";

    private Document abrirDocumento() throws Exception {
        File file = new File(NOMEARQUIVO);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        if (file.exists()) {
            return dBuilder.parse(file);
        } else {
            Document doc = dBuilder.newDocument();
            Element raiz = doc.createElement("professores");
            doc.appendChild(raiz);
            salvarDocumento(doc);
            return doc;
        }
    }

    private void salvarDocumento(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(NOMEARQUIVO));
        transformer.transform(source, result);
    }

    public boolean inserir(ProfessorDTO professor) {
        try {
            Document doc = abrirDocumento();
            Element raiz = doc.getDocumentElement();

            Element novo = doc.createElement("professor");

            Element registro = doc.createElement("registro");
            registro.appendChild(doc.createTextNode(String.valueOf(professor.getRegistro())));
            novo.appendChild(registro);

            Element nome = doc.createElement("nome");
            nome.appendChild(doc.createTextNode(professor.getNome()));
            novo.appendChild(nome);

            raiz.appendChild(novo);

            salvarDocumento(doc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(ProfessorDTO professor) {
        try {
            Document doc = abrirDocumento();
            NodeList lista = doc.getElementsByTagName("professor");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int registroAtual = Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent());

                if (registroAtual == professor.getRegistro()) {
                    elem.getElementsByTagName("nome").item(0).setTextContent(professor.getNome());
                    salvarDocumento(doc);
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(ProfessorDTO professor) {
        try {
            Document doc = abrirDocumento();
            NodeList lista = doc.getElementsByTagName("professor");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int registroAtual = Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent());

                if (registroAtual == professor.getRegistro()) {
                    elem.getParentNode().removeChild(elem);
                    salvarDocumento(doc);
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProfessorDTO procurarPorCodigo(ProfessorDTO professor) {
        try {
            Document doc = abrirDocumento();
            NodeList lista = doc.getElementsByTagName("professor");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int registroAtual = Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent());

                if (registroAtual == professor.getRegistro()) {
                    ProfessorDTO obj = new ProfessorDTO();
                    obj.setRegistro(registroAtual);
                    obj.setNome(elem.getElementsByTagName("nome").item(0).getTextContent());
                    return obj;
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProfessorDTO procurarPorNome(ProfessorDTO professor) {
        try {
            Document doc = abrirDocumento();
            NodeList lista = doc.getElementsByTagName("professor");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                String nome = elem.getElementsByTagName("nome").item(0).getTextContent();

                if (nome.equalsIgnoreCase(professor.getNome())) {
                    ProfessorDTO obj = new ProfessorDTO();
                    obj.setRegistro(Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent()));
                    obj.setNome(nome);
                    return obj;
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(ProfessorDTO professor) {
        return procurarPorCodigo(professor) != null;
    }

    public List<ProfessorDTO> pesquisarTodos() {
        List<ProfessorDTO> lista = new ArrayList<>();
        try {
            Document doc = abrirDocumento();
            NodeList elementos = doc.getElementsByTagName("professor");

            for (int i = 0; i < elementos.getLength(); i++) {
                Element elem = (Element) elementos.item(i);
                ProfessorDTO obj = new ProfessorDTO();
                obj.setRegistro(Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent()));
                obj.setNome(elem.getElementsByTagName("nome").item(0).getTextContent());
                lista.add(obj);
            }

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
    }
}
