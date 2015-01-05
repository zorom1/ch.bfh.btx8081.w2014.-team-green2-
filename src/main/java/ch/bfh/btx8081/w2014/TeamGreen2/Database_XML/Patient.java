/**
 * 
 */
package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

/**
 * @author Manuel
 *
 */

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import ch.bfh.btx8081.w2014.TeamGreen2.Modeldata.Address;



@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
public class Patient extends Person {

	@XmlAttribute
	private String PID;
		//@XmlElement(name="FName")
	//private String FirstName;
	//@//XmlElement(name="LName")
	//private String LastName;
	@XmlElement(name="Address")
	//private Address address=null;
	Address address= new Address("myStreet","MyCity","Postcode");
	@XmlElement(name="Birthday")
	private String Birthday;
	@XmlElement(name="Insurance")
	private String Insurance;
	Patient() {}
	public Patient(String PID, String LastName, String FirstName, Address address, String Gender, String Birthday, String Insurance ){
		super(FirstName, LastName,Gender);
		this.PID=PID;
				//this.LastName=LastName;
		//this.FirstName=FirstName;
		this.address =address;
		this.Birthday=Birthday;
		this.Insurance=Insurance;
		
	}
	public String getPID(){
		return PID;
			}
	public String getFirstName(){
		return FirstName;
	}
	public String getLastName(){
		return LastName;
	}
	public String getBirthday(){
		return Birthday;
	}
	public String getInsurance(){
		return Insurance;
	}
	@Override
	public String toString(){
		return (super.toString()+ " " +address.toString()+" "+getPID()+" "+getBirthday()+" "+ getInsurance()); 
	}
	}



