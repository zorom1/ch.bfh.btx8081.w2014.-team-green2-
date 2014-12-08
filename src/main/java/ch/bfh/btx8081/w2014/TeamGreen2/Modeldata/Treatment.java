package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Treatment {
private String treatNb=null;
private String treatName=null;
Treatment(){
	}
Treatment(String treatNb, String treatName){
	this.treatNb=treatNb;
	this.treatName=treatName;
}
public String getTreatNb(){
	return treatNb;
}
public String getTreatName(){
	return treatName;
}
@Override
public String toString() {
  return getTreatNb()+" "+getTreatName();
}
}