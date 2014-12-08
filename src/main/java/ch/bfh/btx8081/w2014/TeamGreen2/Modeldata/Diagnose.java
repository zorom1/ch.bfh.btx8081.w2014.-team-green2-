package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Diagnose {
private String DiagName=null;
private int CaseNb=0;
Diagnose(){
	}
Diagnose(String Diagname, int CaseNb){
	this.DiagName=Diagname;
	this.CaseNb=CaseNb;
}
public String getDiagName(){
	return DiagName;
}
public int getCaseNb(){
	return CaseNb;
}
public void setDiagName(String DiagName){
	this.DiagName=DiagName;
}
public void setCaseNb(int CaseNb){
	this.CaseNb=CaseNb;
}
}
