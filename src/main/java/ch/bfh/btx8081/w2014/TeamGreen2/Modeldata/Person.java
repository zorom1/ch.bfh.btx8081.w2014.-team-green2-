//*create a person
//@author Team Green


package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public abstract class Person {
  private String FirstName=null;
  private String LastName=null;
  private String Gender=null;
    @SuppressWarnings("null")
	
  
  Person(){
	    };
	Person(String aFirstName,String aLastName,String aGender){
		FirstName=aFirstName;
		LastName=aLastName;
		Gender=aGender;
	
			}
	public String getFirstName(){
		return FirstName;
	}
	public void setFirstName(String FirstName){
		this.FirstName=FirstName;
	
	}
	public String getLastName(){
		return LastName;
	}
	public void setLastName(String LastName){
		this.LastName=LastName;
	}
	
	
	
	
	@Override
	public String toString() {
		return String.format("%s, %s", FirstName, LastName, Gender);
	}	
	}

