package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

/**
 * 
 */


/**
 * @author Manuel
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
//import org.jdom2.output.Format;
//import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

public class Betalogginauth {

	public Document createJDOMviaSAX(String filename) throws JDOMException,
			IOException {
		return new SAXBuilder().build(filename);
	}

	public Document createJDOMviaDOM(String filename) throws SAXException,
			IOException, ParserConfigurationException {
		org.w3c.dom.Document dom = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(filename);
		return new DOMBuilder().build(dom);
	}

	public Document createJDOMviaStAX(String filename)
			throws FileNotFoundException, XMLStreamException,
			FactoryConfigurationError, JDOMException {
		XMLEventReader staxReader = XMLInputFactory.newInstance()
				.createXMLEventReader(new FileInputStream(filename));
		return new StAXEventBuilder().build(staxReader);
	}

	public static void main(String[] args) {
		// 1. Read the document via SAX
		Document doc;
		try {
			doc = new Betalogginauth().createJDOMviaSAX("BetaSecUIDSecPW.xml");
			// doc = new XmlParser().createJDOMviaDOM("party.xml");
			// doc = new XmlParser().createJDOMviaStAX("party.xml");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();

		Iterator<Element> secUIDIter = root.getChildren("SecUID").iterator();

		// check if SecUID fits to SecuPW->A12 soll ein Bsp sein f�r eingegebene UID
		secUIDIter = root.getChildren("SecUID").iterator();
		while (secUIDIter.hasNext()) {
			Element SecUID = secUIDIter.next();
			if (SecUID.getAttribute("name").getValue().compareTo("A12") == 0) {
				Iterator<Element> secuPWIter = SecUID.getChildren("SecuPW")
						.iterator();
				while (secuPWIter.hasNext()) {
					Element SecuPW = secuPWIter.next();
					// ->129jkj soll ein Bsp sein f�r eingegebenes Passwort
					if (SecuPW.getText().compareTo("129jkj") == 0) {
						SecUID.removeContent(SecuPW);
						System.out.println("access sucessful->run programm");
					} else
						System.out.println("no access-> repeat login");
					break;
				}

			}

		}

	}
}
