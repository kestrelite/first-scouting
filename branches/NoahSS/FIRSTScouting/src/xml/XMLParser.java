package xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {

    String documentName;
    File documentFile;
    Document document;

    public XMLParser(String documentName) throws ParserConfigurationException, SAXException, IOException {
        this.documentName = documentName;
        documentFile = new File(documentName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(documentFile);
        document.getDocumentElement().normalize();
    }
}
