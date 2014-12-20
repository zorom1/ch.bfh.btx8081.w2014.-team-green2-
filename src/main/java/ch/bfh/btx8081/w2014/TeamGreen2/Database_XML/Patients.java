/**
 * 
 */
package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

/**
 * @author Manuel
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement 
public class Patients {

@XmlElement(name="Patient")	
private List<Patient> patients;


public Patients(){
	patients= new ArrayList<Patient>();
}
public void addPatient(Patient patient){
	patients.add(patient);
}
public void addList(){
	
}
}


