package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*file create a structure of nodes Diagnose
 * in file diagnosis.xml
 */
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Diagnose {
	@XmlAttribute
	public String CaseNb=null;
	@XmlAttribute
	public String PatNb=null;
	@XmlElement(name="Diagnose")
	private String DiagName=null;
	@XmlElement
	private String Treatment;
	@XmlElement(name="medication")
	private ArrayList<String> medication=new ArrayList<String>();
	
	Diagnose(){
		}
	public Diagnose(String Diagname, String CaseNb, String PatNb, String Treatment ){
		this.DiagName=Diagname;
		this.CaseNb=CaseNb;
		this.PatNb=PatNb;
		this.Treatment=Treatment;
		
	}
	public String getDiagName(){
		return DiagName;
	}
	public String getCaseNb(){
		return CaseNb;
	}
	public void setDiagName(String DiagName){
		this.DiagName=DiagName;
	}
	public void setCaseNb(String CaseNb){
		this.CaseNb=CaseNb;
			}
	public String getDiagname(){
		return DiagName;
	}
	public String getTreatment(){
		return Treatment;
	}
	public String getPatientNb(){
		return PatNb;
	}
	public void addMedication(String medic){
		if(medication==null){
			throw new IllegalArgumentException();
		}
		 try {medication.add(medic);}
		 catch(Exception ex){
			 System.out.println("Null Pointer Exception");
		 }
				
	}
	@Override
	public String toString() {
		return (getPatientNb()+" "+ getCaseNb()+" "+getDiagName()+" "+ getTreatment());
	}	
}
