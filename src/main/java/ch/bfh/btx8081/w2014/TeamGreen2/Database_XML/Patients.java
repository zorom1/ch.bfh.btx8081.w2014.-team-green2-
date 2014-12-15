package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ch.bfh.btx8081.w2014.TeamGreen2.Modeldata.Patient;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement 
public class Patients {

	static{
		try{
			context1 = JAXBContext.newInstance(Patients.class);
		}
			catch(JAXBException e){
				e.printStackTrace();
				System.exit(0);
			}
			}	
		
		private static JAXBContext context1;
		@XmlElement(name="Patients")
		public static List<Patient> patients=new ArrayList<Patient>();
	
}
