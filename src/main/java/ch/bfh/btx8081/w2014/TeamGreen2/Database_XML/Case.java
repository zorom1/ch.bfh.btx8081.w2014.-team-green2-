package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;
/*file creates a structure of nodes case
 * in file cases.xml 
 */
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Case {
	@XmlAttribute
	public String CaseNb;
	@XmlAttribute
	public String PID;	
	@XmlAttribute
	public String UID;
	@XmlElement
	private String StartDate;
	@XmlElement
	private String EndDate;
	@XmlElement(name="Description")
	private String Description;
	
//	private ArrayList<Diagnose> diagnoseList= new ArrayList<Diagnose>();
//	private ArrayList<Medication> medicationList= new ArrayList<Medication>();
	Case(){
			}
	public Case(String CaseNb, String PID, String UID, String StartDate, String EndDate, String Description ){
		this.CaseNb=CaseNb;
		this.PID=PID;
		this.UID=UID;
		this.StartDate=StartDate;
		this.EndDate=EndDate;
		this.Description=Description;
			
	}
	public String getCaseNb(){
		return CaseNb;
	}
	public String getPID(){
		return PID;
	}
	public String getStartDate(){
		return StartDate;
	}
	public String getEndDate(){
		return EndDate;
	}
	public String getDescription(){
		return Description;
	}
	public String getUID(){
		return UID;
	}
	@Override
	public String toString() {
		return (getCaseNb()+" "+getPID()+" "+getUID()+" "+ getStartDate()+" "+getEndDate()+" "+ getDescription());
	}	
}
