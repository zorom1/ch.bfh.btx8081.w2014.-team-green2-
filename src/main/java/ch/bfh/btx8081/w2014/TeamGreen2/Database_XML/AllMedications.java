package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*create root element AllMedications in file medications.xml,
 * contain methods save and load to transfer data of type Medication
 * from Array List medications to file medications.xml
 */
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Medication;
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
public class AllMedications {
	static{
		try{
			context3 = JAXBContext.newInstance(AllMedications.class);
		}
			catch(JAXBException e){
				e.printStackTrace();
				System.exit(0);
			}
			}	
		
		private static JAXBContext context3;
		@XmlElement(name="Medication")
		
		public static List<Medication> medications=null;
		public AllMedications(){
			medications= new ArrayList<Medication>();
		}
		public static void addMedication(Medication medication){
			medications.add(medication);
		}
		public static void makeSerial(Medication medication) throws FileNotFoundException  {
			Medication mymedication =medication;
					
				AllMedications allmedications=new AllMedications();
					AllMedications.load("medications.xml");
								
			addMedication(mymedication);
			allmedications.save("medications.xml");
		}
		private void save(String filename)throws FileNotFoundException{
			
			try{
			
			Marshaller m= context3.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(this, new File(filename));
				}
			catch (JAXBException e){
				e.printStackTrace();
			}	
		}
		//private static Schema readXmlSchema(String filename) throws SAXException{
//			SchemaFactory schemaFactory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		//return schemaFactory.newSchema(new File(filename));
		//}
		public static AllMedications load(String filename){
			try{
				Unmarshaller u =context3.createUnmarshaller();
			//	u.setSchema(readXmlSchema("patient2.xsd"));
				return (AllMedications) u.unmarshal(new File(filename));
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
