//*create a Doctor (User)
//*@Version 1.0
//*@author Team Green

package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Doctor extends Person {
  private String UID=null;
  Doctor(){
	    }
  Doctor(String FirstName, String LastName,char Gender, String UID ){
	  super(FirstName, LastName, Gender);
	  this.UID=UID;
  }
  public String getUID(){
	  return UID;
  }
    public void setUID(String UID){
    	this.UID=UID;
    }
    @Override
	public String toString() {
		return String.format("%s, %s",super.toString(), UID);
	}	
}
