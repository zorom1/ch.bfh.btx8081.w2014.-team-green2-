package ch.bfh.btx8081.w2014.TeamGreen2.Database_XML;

import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2014.TeamGreen2.Modeldata.Address;
/*class is for testing of transfer of data of types 
 * Patient, diagnose, Case, Medication from Array Lists 
 * to files patients.xml, cases.xml,diagnosis.xml,medication.xml
 * and back
 */


public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String Drug;
		final String myPID ="m45";
		final String myFirstName="Anna";
		final String myLastName="Hofer";
		final String myGender="f";
		final String myBirthday="23.04.1976";
		final String myInsurance="Arcosana";
		Address address = new Address("MyStreet","MyCity","postcode");
		AllPatients allPatients = new AllPatients();
   Patient patient = new Patient(myPID, myLastName, myFirstName,address,myGender,myBirthday,myInsurance);
   
 //AllPatients.Status="new";   
    AllPatients.makeSerial(patient);
     Patient patient3= new Patient("a44","Meier","Rene",address,"m","2.10.1952","Insurance1");
     //AllPatients.makeSerial(patient3);
     Patient patient4= new Patient("a22", "Wyss","Stephan", address,"m","12.09.1986","Insurance2");
     AllPatients.makeSerial(patient4);
     Patient patient5= new Patient("a28", "Wyss","Gino", address,"m","21.06.1967","Insurance3");
     AllPatients.makeSerial(patient5);
    Case myCase=new Case("25","p25","d24","23.11.2014","28.11.2014","Depression"); 
    //Allcases.makeSerial(myCase);
    Diagnose mydiagnose= new Diagnose("Angina","c34","p25","Antibiotics");
    Drug="Aspirin";
    mydiagnose.addMedication(Drug);
    Drug="Pantoprazol";
    mydiagnose.addMedication(Drug);
   
    //Alldiagnosis.makeSerial(mydiagnose);
    Medication newmedication = new Medication("p25","c14","Angina","Antibiotics","Amoxicillin","1g/200");
    //AllMedications.makeSerial(newmedication);
    
	}

	}


