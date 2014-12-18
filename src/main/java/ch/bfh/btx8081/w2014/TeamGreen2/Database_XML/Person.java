package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Person {
	@XmlElement(name="FNname")
	protected String FirstName;
	@XmlElement(name="LNname")
	  protected String LastName;
	  @XmlElement(name="Gender")
	  protected String Gender;
	   // @SuppressWarnings("null")
		
	  
	  Person(){
		    };
		Person(String aFirstName,String aLastName, String aGender){
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
		
		public String getGender(){
			return Gender;
		}
		public void setGender(String Gender){
			this.Gender=Gender;
		}
		
			
		
		@Override
		public String toString() {
			return String.format("%s, %s", FirstName, LastName,Gender);
		}	
		}
