package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch.bfh.btx8081.w2014.TeamGreen2.UI.CaseLayout;

public class TableElements {
	public  static ArrayList<String> myElements=new ArrayList<String>();
	//public static  ArrayList<String> myElements=null;
	public static  ArrayList<String> myPatients= new ArrayList<String>();
	//public static ArrayList<String> myPatients=null;
	   public TableElements(){
		   myElements= new ArrayList<String>();
		   myPatients= new ArrayList<String>();
	   }
	  
	   private static void addElement(String element){	
		   myElements.add(element);
	   }
	   public static  void addPatient(String patient){
		   myPatients.add(patient);
	   }
	   /*function sort and split elements of type Patient for the Table in HomeView
	   */
		public  ArrayList<String> countElements()  throws FileNotFoundException  {	
		//try{
			/*patients.txt is file with actual records of type Patient
						  */
			
			File inputfile = new File("patients.txt");
	  Scanner in = new Scanner(inputfile);
	  PrintWriter output= new PrintWriter("sortpatients1.txt");
		//}
		//catch(FileNotFoundException e){
		//	e.printStackTrace();
		//}
	  /*create an ArrayList from patients.txt for sorting the records in alphabetical order
	     */
	  while(in.hasNextLine()){
			 String myline=in.nextLine();
			 addPatient(myline);
		  }
	  int sortIndex=1;
		  /*call the function for sorting the records
		     */
		  mysort(sortIndex);
		  
		  for (int i=0; i<=myPatients.size()-1;i++){
				
				
				output.println(myPatients.get(i));
			}
		  in.close();
		  output.close();
		  File inputfile1 = new File("sortpatients1.txt");
		  Scanner in1 = new Scanner(inputfile1);
		  /*reads words from file with records in alphabetical order
		   * and take separate words to fill array with elements
		   */
	  while(in1.hasNext()){
		  String element=in1.next();
		  addElement(element);
		  System.out.println(element);
	  }
	
	  in1.close();
	 
	  //myPatients=null;
	return myElements;
		
	   }
		public static void DefineLastLine(){
			
		}
		public static ArrayList<String> mysort(int sortIndex){
			for(int i=0;i<myPatients.size()-1;i++) {	
				  String string1=myPatients.get(i);
				  String string2=myPatients.get(i+1);
				  if(string1.compareTo(string2)>0){
					myPatients.set(i,string2);
					myPatients.set(i+1,string1);
								  }
			  }
			sortIndex=sortIndex+1;
			if(sortIndex<myPatients.size()){
			mysort(sortIndex);
			}
			return myPatients;
			
		}
}
