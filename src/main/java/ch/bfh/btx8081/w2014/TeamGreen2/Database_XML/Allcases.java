package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*create Root Element Allcases in file cases.xml,

 * contain methods save and load which bring data 
 * from Array List cases to cases.xml and back,allows to
 * add new case record and edit records
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
public class Allcases {

	static{
		try{
			context = JAXBContext.newInstance(Allcases.class);
		}
			catch(JAXBException e){
				e.printStackTrace();
				System.exit(0);
			}
			}	
		
		private static JAXBContext context;
		@XmlElement(name="Case")
		
				public static List<Case> cases=null;
	 /*next variables are for changing information between xml DB
	  * and TextFields in View
	    */
		public static String FoundCaseNb;
		public static  String FoundPatNb;
		public static  String FoundDoctorUID;
		 public static String FoundStartDate;
		 public static String FoundEndDate;
		 public static String FoundDescription;
		public static String StatusC;
			public Allcases(){
			cases= new ArrayList<Case>();
		}
		/*ad new record in array and than in xml file
		    		 */
		public static void addCase(Case myCase){
			cases.add(myCase);
		}
			public static void makeSerial(Case mycase) throws FileNotFoundException  {
			
			Case myCase=mycase;
				
		  
			Allcases allcases=new Allcases();
			/*variable sendCase Nb is defined for
			 * possibility to find a record and to
			 * change one or many elements in xml DB
			 */
			String sendCaseNb=myCase.getCaseNb();
			/*takes all records from xml to array list of objects of
			 * type Case
			 */
			Allcases.load("cases.xml");
			/*next if statement defines actions when we need to add new record 
			 *a xml DB 
			 */
			if (StatusC=="newRecord") {
			
			addCase(myCase);
			
			allcases.save("cases.xml");
			}
			/*next if statement defines actions we need to
			 *change something in existing records in xml DB 
			 */
			if (StatusC=="Correct"){
				for (int i=0; i<=cases.size()-1;i++){
					Case lookcase=cases.get(i);
					System.out.println("Correct");
				/*next if defines if we have found 
				 * 	a record where we need to make changements
				 */
					if(sendCaseNb.compareTo(lookcase.getCaseNb())==0){
												
				//patients.remove(i);		
						cases.set(i, myCase);
			/*changed data are saved in xml, in variables are
			 *saved empty fields, except in case Number is actual
			 *case number, content of variables 
			 *will be displayed in Text Fields in View FindCase,
			 *user can check by case number if data are changed 
			 		  			 */
						
						
						FoundCaseNb=myCase.getCaseNb();
						FoundPatNb="";
						FoundDoctorUID="";
						FoundStartDate="";
						FoundEndDate="";
						FoundDescription="";
						
									
					}
				
				}	
				allcases.save("cases.xml");
			}
			
			
		}
			private void save(String filename)throws FileNotFoundException{
			
			try{
			
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(this, new File(filename));
			
			}
			catch (JAXBException e){
				e.printStackTrace();
			}	
			
		}
	    private static Schema readXmlSchema(String filename) throws SAXException{
	  	SchemaFactory schemaFactory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		return schemaFactory.newSchema(new File(filename));
	}
	    public static Allcases load(String filename){
	    	try{
	    		Unmarshaller u =context.createUnmarshaller();
	    		//u.setSchema(readXmlSchema("patient2.xsd"));
	    		return (Allcases) u.unmarshal(new File(filename));
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
