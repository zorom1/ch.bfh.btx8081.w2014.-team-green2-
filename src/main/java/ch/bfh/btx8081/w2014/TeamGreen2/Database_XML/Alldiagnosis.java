package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*create Root Element Alldiagnosis for diagnosis.xml,
 * contain methods save and load for transfer data of type
 * Diagnose from Array List diagnosis to diagnosis.xml and back
 */
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Diagnose;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement 
public class Alldiagnosis {
	static{
		try{
			context2 = JAXBContext.newInstance(Alldiagnosis.class);
		}
			catch(JAXBException e){
				e.printStackTrace();
				System.exit(0);
			}
			}	
		
		private static JAXBContext context2;
		@XmlElement(name="Diagnose")
		
		public static List<Diagnose> diagnosis=null;
	
public Alldiagnosis(){
	diagnosis= new ArrayList<Diagnose>();
}
public static void addDiagnose(Diagnose diagnose){
	diagnosis.add(diagnose);
}
public static void makeSerial(Diagnose diagnose) throws FileNotFoundException  {
	Diagnose mydiagnose =diagnose;
			
		Alldiagnosis alldiagnosis=new Alldiagnosis();
			Alldiagnosis.load("diagnosis.xml");
						
	addDiagnose(mydiagnose);
	alldiagnosis.save("diagnosis.xml");
}
private void save(String filename)throws FileNotFoundException{
	
	try{
	//PrintWriter outpatient= new PrintWriter("patient.xml");
	Marshaller m= context2.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	m.marshal(this, new File(filename));
		}
	catch (JAXBException e){
		e.printStackTrace();
	}	
}
//private static Schema readXmlSchema(String filename) throws SAXException{
//	SchemaFactory schemaFactory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//return schemaFactory.newSchema(new File(filename));
//}
public static Alldiagnosis load(String filename){
	try{
		Unmarshaller u =context2.createUnmarshaller();
	//	u.setSchema(readXmlSchema("patient2.xsd"));
		return (Alldiagnosis) u.unmarshal(new File(filename));
		    	}
	catch(JAXBException e) {
		e.printStackTrace();
		return null;
		    	}
	//catch (SAXException e){
	//	e.printStackTrace();
	//return null;	
	//}
}
	
}
