//*create a Patient
//*@version 1.0
//* @author team Green

package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

import java.util.Date;

public class Patient extends Person {

	private String PID=null;
	private String Birthday=null;
	private String Insurance=null; 
	private Address address=null;
 Patient(){
	  }
 Patient(String FirstName, String LastName,char Gender,Address address, String PID,
		 String Birthday, String Insurance){
	 super(FirstName, LastName, Gender);
	 this.PID=PID;
	 this.address=address;
	 this.Birthday=Birthday;
	 this.Insurance=Insurance;
 }
 public String getPID(){
	 return PID;
 }
 public void setPID(String PID){
	 this.PID=PID;
	  }
 public Address getAddress(){
		return address;
	}
	public void setAddress(Address address){
		this.address=address;
	}	
 public String getBirthday(){
	 return Birthday;
 }
 public void setBirthday(String Birthday){
	 this.Birthday=Birthday;
 }
 public String getInsurance(){
	 return Insurance;
 }
 public void setInsurance(String Insurance){
	 this.Insurance=Insurance;
 }
 @Override
	public String toString() {
		return String.format("%s, %d, %s", super.toString(), address.toString(), PID,
					Birthday, Insurance);
	}

}
