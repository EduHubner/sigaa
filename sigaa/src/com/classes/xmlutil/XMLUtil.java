package com.classes.xmlutil;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLUtil {

    public static Document abrirXML(String nomeArquivo) throws Exception {
        File xmlFile = new File(nomeArquivo);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        if (!xmlFile.exists()) {
            Document doc = builder.newDocument();
            doc.appendChild(doc.createElement(nomeArquivo.replace(".xml", "")));
            salvarXML(doc, nomeArquivo);
        }

        return builder.parse(xmlFile);
    }

    public static void salvarXML(Document doc, String nomeArquivo) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nomeArquivo));
        transformer.transform(source, result);
    }
    
    
}
