package ch.bfh.btx8081.w2014.TeamGreen2.Controller;
/**
 * @author Manuel
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class FindFunctionAllCasesPID {
	public String FoundCaseNb = null;
	public String FoundPatNb = null;
	public String FoundDoctorUID = null;
	public String FoundStartDate = null;
	public String FoundEndDate = null;
	public String FoundDescription = null;
	public static List<String> FindPIDResults = null;

	public Document createJDOMviaSAX(String filename) throws JDOMException,
			IOException {
		return new SAXBuilder().build(filename);
	}

	public FindFunctionAllCasesPID() {
		FindPIDResults =new ArrayList<String>();
	}

	public void CheckFound(String MyCaseNb, String MyPID) {

		Document doc = null;
		try {
			doc = new FindFunctionAllCasesPID().createJDOMviaSAX("cases.xml");

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();

		Iterator<Element> CaseIter = root.getChildren("Case").iterator();
		CaseIter = root.getChildren("Case").iterator();
		
		while (CaseIter.hasNext()) {
			Element Case = CaseIter.next();

			if (Case.getAttribute("pid").getValue().compareTo(MyPID) == 0) {

				FoundCaseNb = Case.getAttribute("caseNb").getValue();
				FoundPatNb = Case.getAttribute("pid").getValue();
				FoundDoctorUID = Case.getAttribute("uid").getValue();

				Iterator<Element> StartDateIter1 = Case
						.getChildren("StartDate").iterator();
				Iterator<Element> EndDateIter1 = Case.getChildren("EndDate")
						.iterator();
				Iterator<Element> DescriptionIter1 = Case.getChildren(
						"Description").iterator();

				Element StartDate1 = StartDateIter1.next();
				Element EndDate1 = EndDateIter1.next();
				Element Description1 = DescriptionIter1.next();

				ArrayList<String> FindResults1 = new ArrayList<String>();
				FindResults1.add(StartDate1.getText());
				FindResults1.add(EndDate1.getText());
				FindResults1.add(Description1.getText());

				FoundStartDate = FindResults1.get(0);
				FoundEndDate = FindResults1.get(1);
				FoundDescription = FindResults1.get(2);

				FindPIDResults.add(FoundCaseNb);
				FindPIDResults.add(FoundPatNb);
				FindPIDResults.add(FoundDoctorUID);
				FindPIDResults.add(FoundStartDate);
				FindPIDResults.add(FoundEndDate);
				FindPIDResults.add(FoundDescription);
			}
		}
		System.out.println("Anzahl Lines ist: "+FindPIDResults.size());
		System.out.println(FindPIDResults);
	}  
	}
	
