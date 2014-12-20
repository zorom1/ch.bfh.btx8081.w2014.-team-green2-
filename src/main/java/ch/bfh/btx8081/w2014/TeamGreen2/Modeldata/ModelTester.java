package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

import java.util.Date;

public class ModelTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Address address= new Address("Matterstr. 4", "Bern",3006);
		Patient patient =new Patient("Rene","Meier", 
								'm',address,"P25", "23.09.1965","Arcosana");
		Doctor doctor= new Doctor("Beat","Merz",'m',"D55");
System.out.println("Name is "+patient.getLastName()+"  "+doctor.getLastName());
System.out.println("First name is "+patient.getFirstName());
System.out.println("PID is" + patient.getPID()+"  "+"UID is"+doctor.getUID());

System.out.println(patient.getAddress());

System.out.print(patient.getGender());
//Date admdate=new Date("201425060830");
Case patcase=new Case(1,"P25","18.06.2014","Grippe");
System.out.println(patcase.getPID()+" "+patcase.getStartDay());
System.out.println(address.getPhone());
System.out.println(address.getPcode()); 
patcase.addMedication("Pantoprazol");
patcase.addDiagnose("Angina");
System.out.println(patcase.getDiagnose());
Diagnose diagnose = new Diagnose("Angina", 38);
System.out.println(diagnose.getDiagName());

	}

}


