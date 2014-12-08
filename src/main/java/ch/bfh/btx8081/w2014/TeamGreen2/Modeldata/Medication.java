package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Medication {
private String MedName=null;
private double MedDosage=0;
String treatNb;
Medication(){
	}
  Medication(String Medname, double MedDose,String treatNb){
	  this.MedName=Medname;
	  this.MedDosage=MedDose;
	  this.treatNb=treatNb;
	  }
  public String getMedName(){
	  return MedName;
  }
  public double getMedDosage(){
	  return MedDosage;
  }
  public String getTreatNb(){
	  return treatNb;
  }
}
