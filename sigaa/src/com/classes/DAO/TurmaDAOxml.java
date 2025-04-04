package com.classes.DAO;

import com.classes.DTO.Turma;
import com.classes.xmlutil.XMLUtil;
import org.w3c.dom.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOxml {

    private final String NOME_ARQUIVO = "turma.xml";

    public boolean inserir(Turma turma) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            Element raiz = doc.getDocumentElement();

            Element elemTurma = doc.createElement("turma");

            Element codigo = doc.createElement("codigoTurma");
            codigo.setTextContent(String.valueOf(turma.getCodigoTurma()));
            elemTurma.appendChild(codigo);

            Element dataInicio = doc.createElement("dataInicio");
            dataInicio.setTextContent(turma.getDataInicio().toString());
            elemTurma.appendChild(dataInicio);

            Element situacao = doc.createElement("situacaoTurma");
            situacao.setTextContent(turma.getSituacaoTurma());
            elemTurma.appendChild(situacao);

            Element codDisc = doc.createElement("codigoDisciplina");
            codDisc.setTextContent(String.valueOf(turma.getCodigoDisciplina()));
            elemTurma.appendChild(codDisc);

            raiz.appendChild(elemTurma);
            XMLUtil.salvarXML(doc, NOME_ARQUIVO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Turma turma) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("turma");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent());
                if (codigo == turma.getCodigoTurma()) {
                    elem.getElementsByTagName("situacaoTurma").item(0).setTextContent(turma.getSituacaoTurma());
                    XMLUtil.salvarXML(doc, NOME_ARQUIVO);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Turma turma) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("turma");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent());
                if (codigo == turma.getCodigoTurma()) {
                    elem.getParentNode().removeChild(elem);
                    XMLUtil.salvarXML(doc, NOME_ARQUIVO);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Turma procurarPorCodigo(Turma turma) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("turma");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                int codigo = Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent());
                if (codigo == turma.getCodigoTurma()) {
                    Turma obj = new Turma();
                    obj.setCodigoTurma(codigo);
                    obj.setDataInicio(Date.valueOf(elem.getElementsByTagName("dataInicio").item(0).getTextContent()));
                    obj.setSituacaoTurma(elem.getElementsByTagName("situacaoTurma").item(0).getTextContent());
                    obj.setCodigoDisciplina(Integer.parseInt(elem.getElementsByTagName("codigoDisciplina").item(0).getTextContent()));
                    return obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Turma procurarPorSituacao(Turma turma) {
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList lista = doc.getElementsByTagName("turma");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elem = (Element) lista.item(i);
                String situacao = elem.getElementsByTagName("situacaoTurma").item(0).getTextContent();
                if (situacao.equals(turma.getSituacaoTurma())) {
                    Turma obj = new Turma();
                    obj.setCodigoTurma(Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent()));
                    obj.setDataInicio(Date.valueOf(elem.getElementsByTagName("dataInicio").item(0).getTextContent()));
                    obj.setSituacaoTurma(situacao);
                    obj.setCodigoDisciplina(Integer.parseInt(elem.getElementsByTagName("codigoDisciplina").item(0).getTextContent()));
                    return obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existe(Turma turma) {
        return procurarPorCodigo(turma) != null;
    }

    public List<Turma> pesquisarTodos() {
        List<Turma> lista = new ArrayList<>();
        try {
            Document doc = XMLUtil.abrirXML(NOME_ARQUIVO);
            NodeList nodes = doc.getElementsByTagName("turma");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element elem = (Element) nodes.item(i);
                Turma obj = new Turma();
                obj.setCodigoTurma(Integer.parseInt(elem.getElementsByTagName("codigoTurma").item(0).getTextContent()));
                obj.setDataInicio(Date.valueOf(elem.getElementsByTagName("dataInicio").item(0).getTextContent()));
                obj.setSituacaoTurma(elem.getElementsByTagName("situacaoTurma").item(0).getTextContent());
                obj.setCodigoDisciplina(Integer.parseInt(elem.getElementsByTagName("codigoDisciplina").item(0).getTextContent()));
                lista.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
