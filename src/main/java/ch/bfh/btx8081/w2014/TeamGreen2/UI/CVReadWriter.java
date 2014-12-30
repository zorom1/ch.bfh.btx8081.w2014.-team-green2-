package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

/**
 * This class provides the methods to read a Patient Database and its life events and provide
 * the information for the CVLayout to show the data in a table. It also provides the methods
 * to add a new life event to the database.
 * @author JD
 *
 */

public class CVReadWriter {
	
	/**
	 * Methods to read the Patient-Database. Here simulated with an XML-File and a 
	 * dummy Patient (Jane Smith and Patrick Beispiel).
	 * @param filename
	 * @throws JDOMException
	 * @throws IOException
	 */
	
	public Document createJDOMviaSAX(String filename) throws JDOMException, IOException {
		return new SAXBuilder().build(filename);
	}
	
	public Document createJDOMviaDOM(String filename) throws SAXException, IOException, ParserConfigurationException {
		org.w3c.dom.Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filename);
		return new DOMBuilder().build(dom);
	}
	
	public Document createJDOMviaStAX(String filename) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError, JDOMException {
		XMLEventReader staxReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(filename));
		return new StAXEventBuilder().build(staxReader);
	}
	
	public static void main(String[] args) {
		
		/**
		 * The XML-Document is read via SAX
		 */
		
		Document doc;
		try {
			doc = new CVReadWriter().createJDOMviaSAX("patients.xml");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Element root = doc.getRootElement();

		/**
		 * The methods checks if there are any dates and events in the
		 * patients-record. It reads these informations and shows them in the
		 * Console.
		 */
		
		String pid1 = "123-456-789";
		String pid2 = "987-654-321";
		
		Iterator<Element> patIter = root.getChildren("Patients").iterator();
		while (patIter.hasNext()) {
			Element pat = patIter.next();
			if (pat.getAttribute("pid").getValue().compareTo(pid1) == 0) {
			//if (pat.getAttribute("name").getValue().compareTo(pid2) == 0) {
			
				Iterator<Element> date = pat.getChildren("date").iterator();
				Iterator<Element> event = pat.getChildren("event").iterator();
				while (date.hasNext() && event.hasNext()) {
					System.out.println(date.next().getText() + " "
							+ event.next().getText());
					
				}

			}

		}
		
		
		
		
		///---------------------------------------------------------------------------------/////
		
		
		/**
		 * This method adds a new date with the reffered life-event to a specific patient.
		 * (Here dummy Patient Jane Smith). 
		 * THIS METHOD IS NOT COMPLETELY IMPLEMENTED YET
		 */
		
		Iterator<Element> patientIter = root.getChildren("patient").iterator();
		while (patientIter.hasNext()) {
			Element patient = patientIter.next();
			if (patient.getAttribute("name").getValue().compareTo("Jane Smith") == 0) {
				Element date = new Element("date");
				root.addContent(date);
				break; //done
			}
		
		}
		
		/**
		 * The new date and event that was added is written in the same XML-File.
		 * THIS METHOD IS NOT COMPLETELY IMPLEMENTED YET
		 */
		
		try {
			new XMLOutputter(Format.getPrettyFormat()).output(doc, new FileWriter("NULL")); //File-Name of the XML-File
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
