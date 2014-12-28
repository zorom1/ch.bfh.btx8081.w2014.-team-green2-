package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*Create Root Element in file patients.xml, contain method which
 * serialize object of type Patient to xml.file and back
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement 
public class AllPatients {
	static{
		try{
			context1 = JAXBContext.newInstance(AllPatients.class);
		}
			catch(JAXBException e){
				e.printStackTrace();
				System.exit(0);
			}
			}	
		
		private static JAXBContext context1;
		@XmlElement(name="Patient")
/*List of elements of type Patients, nodes Patients in patients.xml
 * 		
 */
		public static List<Patient> patients=null;
		
		
		public AllPatients(){
			patients= new ArrayList<Patient>();
		}
		/*method which adds new record of type Patient
		 		 */
		public static void addPatient(Patient patient){
			patients.add(patient);
		
		}
			public static void makeSerial(Patient patient) throws FileNotFoundException  {
			Patient myPatient =patient;
					
				AllPatients allPatients=new AllPatients();
				
					AllPatients.load("patiens.xml");
					addPatient(myPatient);
		//loop shows contain of array List,
		//in form To String, can be used later for sending data to PatientView			
					for (int i=1; i<=patients.size()-1;i++){
						
						System.out.println(patients.get(i));
					}
	/*here new record in, before serialization in xml.file
	 				 */
			addPatient(myPatient);
			allPatients.save("patiens.xml");
		
		}
			/*method save bring renewed array list in xml.file
			 * 
			 */
			private void save(String filename)throws FileNotFoundException{
			
			try{
			//PrintWriter outpatient= new PrintWriter("patient.xml");
			Marshaller m= context1.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			//m.marshal(this, outpatient);
			m.marshal(this, new File(filename));
			
			}
			catch (JAXBException e){
				e.printStackTrace();
			}	
			
		}
	  //  private static Schema readXmlSchema(String filename) throws SAXException{
	  //	SchemaFactory schemaFactory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		//return schemaFactory.newSchema(new File(filename));
	//}
			/*method load takes records from xml.file and move them to Array List Patients
			 * 
			 */
	    public static AllPatients load(String filename){
	    	try{
	    		Unmarshaller u =context1.createUnmarshaller();
	    	//	u.setSchema(readXmlSchema("patient2.xsd"));
	    		return (AllPatients) u.unmarshal(new File(filename));
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
