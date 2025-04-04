package com.classes.DAO;

import com.classes.DTO.Avaliacao;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAOxml {

    private final String NOME_ARQUIVO = "avaliacoes.xml";

    public boolean inserir(Avaliacao avaliacao) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            Element raiz = doc.getDocumentElement();

            Element elem = doc.createElement("avaliacao");

            Element cod = doc.createElement("codigoAvaliacao");
            cod.setTextContent(String.valueOf(avaliacao.getCodigoAvaliacao()));
            elem.appendChild(cod);

            Element data = doc.createElement("dataAvaliacao");
            data.setTextContent(avaliacao.getData().toString());
            elem.appendChild(data);

            Element turma = doc.createElement("codigoTurma");
            turma.setTextContent(String.valueOf(avaliacao.getTurmaAvaliacao().getCodigoTurma()));
            elem.appendChild(turma);

            Element prof = doc.createElement("registro");
            prof.setTextContent(String.valueOf(avaliacao.getProfessorMinistrou().getRegistro()));
            elem.appendChild(prof);

            raiz.appendChild(elem);

            XMLUtil.salvarXML(doc, NOME_ARQUIVO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Avaliacao avaliacao) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("avaliacao");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoAvaliacao").item(0).getTextContent());

                if (codigo == avaliacao.getCodigoAvaliacao()) {
                    elem.getElementsByTagName("dataAvaliacao").item(0).setTextContent(avaliacao.getData().toString());
                    XMLUtil.salvarXML(doc, NOME_ARQUIVO);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Avaliacao avaliacao) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("avaliacao");
            Element raiz = doc.getDocumentElement();

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoAvaliacao").item(0).getTextContent());

                if (codigo == avaliacao.getCodigoAvaliacao()) {
                    raiz.removeChild(elem);
                    XMLUtil.salvarXML(doc, NOME_ARQUIVO);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Avaliacao procurarPorCodigo(Avaliacao avaliacao) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("avaliacao");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoAvaliacao").item(0).getTextContent());

                if (codigo == avaliacao.getCodigoAvaliacao()) {
                    Avaliacao obj = new Avaliacao();
                    obj.setCodigoAvaliacao(codigo);
                    obj.setData(Date.valueOf(elem.getElementsByTagName("dataAvaliacao").item(0).getTextContent()));
                    obj.getTurmaAvaliacao().setCodigoTurma(Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent()));
                    obj.getProfessorMinistrou().setRegistro(Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent()));
                    return obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Avaliacao avaliacao) {
        return procurarPorCodigo(avaliacao) != null;
    }

    public List<Avaliacao> pesquisarTodos() {
        List<Avaliacao> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList elements = doc.getElementsByTagName("avaliacao");

            for (int i = 0; i < elements.getLength(); i++) {
                Element elem = (Element) elements.item(i);
                Avaliacao obj = new Avaliacao();
                obj.setCodigoAvaliacao(Integer.parseInt(elem.getElementsByTagName("codigoAvaliacao").item(0).getTextContent()));
                obj.setData(Date.valueOf(elem.getElementsByTagName("dataAvaliacao").item(0).getTextContent()));
                obj.getTurmaAvaliacao().setCodigoTurma(Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent()));
                obj.getProfessorMinistrou().setRegistro(Integer.parseInt(elem.getElementsByTagName("registro").item(0).getTextContent()));
                lista.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
