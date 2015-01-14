package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * This class provides the methods to read a Patient Database and its life
 * events and provide the information for the CVLayout to show the data in a
 * table. It also provides the methods to add a new life event to the database.
 * 
 * @author JD
 *
 */

public class CVReadWr {
	public static List<String> myResult = null;

	public Document createJDOMviaSAX(String filename) throws JDOMException,
			IOException {
		return new SAXBuilder().build(filename);
	}

	public CVReadWr() {
		myResult = new ArrayList<String>();
	}

	public void cvread(String myPID) {

		/**
		 * The XML-Document is read via SAX
		 */

		Document doc;
		try {
			doc = new CVReadWr().createJDOMviaSAX("patients.xml");

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();

		//Sample Patients to use:
		// String pid1 = "123-456-789";
		// String pid2 = "987-654-321";

		Iterator<Element> patIter = root.getChildren("Patients").iterator();
		while (patIter.hasNext()) {
			Element pat = patIter.next();
			if (pat.getAttribute("pid").getValue().compareTo(myPID) == 0) {

				Iterator<Element> date = pat.getChildren("date").iterator();
				Iterator<Element> event = pat.getChildren("event").iterator();

				while (date.hasNext() && event.hasNext()) {

					myResult.add(date.next().getText());
					myResult.add(event.next().getText());

				}

			}

		}

	}

	/**
	 * The following method writes the date and textinput of the doctor to tha database.
	 * @param myPID
	 * @param date
	 * @param event
	 */
	
	public void cvwrite(String myPID, String date, String event) {

		/**
		 * The XML-Document is read via SAX
		 */

		Document doc;
		try {
			doc = new CVReadWr().createJDOMviaSAX("patients.xml");

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();

		Iterator<Element> patIter = root.getChildren("Patients").iterator();
		while (patIter.hasNext()) {
			Element pat = patIter.next();
			if (pat.getAttribute("pid").getValue().compareTo(myPID) == 0) {

				Element newdate = new Element("date");
				newdate.setText(date);
				pat.addContent(newdate);

				Element newevent = new Element("event");
				newevent.setText(event);
				pat.addContent(newevent);

				System.out.println("im here");
				System.out
						.println(newdate.getText() + " " + newevent.getText());

			}

			// Save as XML
			try {
				new XMLOutputter(Format.getPrettyFormat()).output(doc,
						new FileWriter("patients.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
