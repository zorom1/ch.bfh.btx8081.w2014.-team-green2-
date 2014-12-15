package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Address {
private String Street=null;
private String City=null;
private int Pcode=0;
private String Phone =null;


Address(){
	}
	Address(String aStreet, String aCity, int aPcode, String Phone){
		Street=aStreet;
		City=aCity;
		Pcode=aPcode;
		
		
	}
public String getStreet(){
	return Street;
}
public void setStreet(String Street){
	this.Street=Street;
}
public String getCity(){
	return City;
}
public void setCity(String City){
	this.City=City;
}
public int getPcode(){
	return Pcode;
}
public void setPcode(int Pcode){
	this.Pcode=Pcode;
}	
public String getPhone(){
	return Phone;
}

@Override
	public String toString() {
	
	return getStreet() + " "+getCity() +" "+ getPcode()+" "+getPhone() ;
}
}
