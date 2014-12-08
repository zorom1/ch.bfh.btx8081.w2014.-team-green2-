package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Case {
	//public Patient patient;
	public String PID=null;
	private int CaseNb=0;
	private String StartDay=null;
    private String Description=null;
	
		private ArrayList<String> medication=new ArrayList<String>();
		private ArrayList<String> diagnosis=new ArrayList<String>();
		/*Shall we make List of Diagnosis? :
		 * private ArrayList<Diagnose> diagnoseList= new ArrayList<Diagnose>();
		 * 
		 */
		private ArrayList<Diagnose> diagnoseList= new ArrayList<Diagnose>();
		private ArrayList<Medication> medicationList= new ArrayList<Medication>();
	Case(int CaseNb, String PID, String StartDay , String Description){
		this.CaseNb=CaseNb;
		
		this.PID=PID;
		this.StartDay=StartDay;
		this.Description=Description;
		diagnosis.add("1.D");
				}
	public int getCaseNb(){
		return CaseNb;
	}
	public void setCaseNb(int caseNb){
		this.CaseNb=caseNb;
	}
		public String getPID(){
			return PID;
		}
		public void setPID(String PID){
			this.PID=PID;
		}
		public String getStartDay(){
			return StartDay;
		}
		public void setStartDay(String StartDay){
			this.StartDay=StartDay;
		}
		public String getDescription(){
			return Description;
		}
		public void setDescription(String Description){
			this.Description=Description;
		}
		//public Date getadmDay(){
			//return admDay;
		public void addDiagnose(String diagnose) {
			if(diagnose==null){
				throw new IllegalArgumentException();
			}
			 try {diagnosis.add(diagnose);}
			 catch(Exception ex){
				 System.out.println("Null Pointer Exception");
			 }
				} 
		public  ArrayList<String> getDiagnose(){
			return this.diagnosis;
		}
		public void addMedication(String medication) {
			this.medication.add(medication);
			if(medication==null){
				throw new IllegalArgumentException();}
	
		}
}
	


