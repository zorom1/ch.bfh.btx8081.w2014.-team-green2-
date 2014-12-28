package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*File creates a structure of nodes "Medication"
 * in xml.file medications.xml
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Medication {
	@XmlAttribute
	public String PatientNb;
	@XmlAttribute
	public String CaseNb;
	@XmlElement (name="Diagnose")
	public String Diagnose;
	@XmlElement (name="Treatment")
	public String Treatment;
	@XmlElement (name="Medication")
	private String MedName;
	@XmlElement (name="Dosage")
	private String Dosage;
	Medication(){
			}
	public Medication(String PatientNb,String CaseNb,String Diagnose, String Treatment, String MedName,String Dosage){
		this.PatientNb=PatientNb;
		this.CaseNb=CaseNb;
		this.MedName=MedName;
		this.Dosage=Dosage;
		this.Treatment=Treatment;
		this.Diagnose=Diagnose;
	}
	public String getPatNb(){
		return PatientNb;
	}
	public String getCaseNb(){
		return CaseNb;
	}
	public String getDiagName(){
		return Diagnose;
	}
	public String getTreatment(){
		return Treatment;
	}
	public String getMedName(){
		return MedName;
	}
	public String getDosage(){
		return Dosage;
	}
	@Override
	public String toString() {
		//return String.format("%s, %s", PatientNb, CaseNb, Diagnose,Treatment,MedName, Dosage);
		return (getPatNb()+" "+getCaseNb()+" "+getDiagName()+" "+getTreatment()+" "+getMedName()+" "+getDosage());
	}	
}
