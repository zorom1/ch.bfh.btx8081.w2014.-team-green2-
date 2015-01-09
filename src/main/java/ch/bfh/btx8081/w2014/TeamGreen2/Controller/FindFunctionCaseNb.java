package ch.bfh.btx8081.w2014.TeamGreen2.Controller;

/**
 * @author Manuel
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class FindFunctionCaseNb {
	public String FoundCaseNb = null;
	public String FoundPatNb = null;
	public String FoundDoctorUID = null;
	public String FoundStartDate = null;
	public String FoundEndDate = null;
	public String FoundDescription = null;

	public Document createJDOMviaSAX(String filename) throws JDOMException,
			IOException {
		return new SAXBuilder().build(filename);
	}

	public FindFunctionCaseNb() {

	}

	public void CheckFound(String MyCaseNb, String MyPID) {

		Document doc = null;
		try {
			doc = new FindFunctionCaseNb().createJDOMviaSAX("cases.xml");

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();

		Iterator<Element> CaseIter = root.getChildren("Case").iterator();

		CaseIter = root.getChildren("Case").iterator();
		while (CaseIter.hasNext()) {
			Element Case = CaseIter.next();
			if (Case.getAttribute("caseNb").getValue().compareTo(MyCaseNb) == 0) {

				FoundCaseNb = Case.getAttribute("caseNb").getValue();
				FoundPatNb = Case.getAttribute("pid").getValue();
				FoundDoctorUID = Case.getAttribute("uid").getValue();

				Iterator<Element> StartDateIter = Case.getChildren("StartDate")
						.iterator();
				Iterator<Element> EndDateIter = Case.getChildren("EndDate")
						.iterator();
				Iterator<Element> DescriptionIter = Case.getChildren(
						"Description").iterator();
				{

					Element StartDate = StartDateIter.next();
					Element EndDate = EndDateIter.next();
					Element Description = DescriptionIter.next();

					ArrayList<String> FindResults = new ArrayList<String>();
					FindResults.add(StartDate.getText());
					FindResults.add(EndDate.getText());
					FindResults.add(Description.getText());

					FoundStartDate = FindResults.get(0);
					FoundEndDate = FindResults.get(1);
					FoundDescription = FindResults.get(2);

					System.out.println(FoundCaseNb + (" ") + FoundPatNb + (" ")
							+ FoundDoctorUID + (" ") + FoundStartDate + (" ")
							+ FoundEndDate + (" ") + FoundDescription);
					break;

				}
			}
		}
	}
}
