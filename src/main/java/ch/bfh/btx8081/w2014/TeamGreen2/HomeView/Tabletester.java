package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import java.io.FileNotFoundException;



public class Tabletester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] temp_elem= new String[5];
		try {
			TableElements telements= new TableElements();
			//TableElements.countElements();
			telements.countElements();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ArraySize= TableElements.myElements.size();
		int i=0;
		int k=1;
		  while(i<ArraySize-1){
			  for (int j=0;j<5;j++){
				temp_elem[j] = TableElements.myElements.get(i); 
				System.out.println("From Tester"+" "+temp_elem[j]+" "+i+" "+k);
				i++;
			  }
			  int j=0;
//System.out.println("From Tester"+" "+temp_elem[j]+" "+temp_elem[j+1]+" "+temp_elem[j+2]+" "+temp_elem[j+3]+" "+temp_elem[j+4]+" "+k); 
String result=temp_elem[j]+" "+temp_elem[j+1]+" "+temp_elem[j+2]+" "+temp_elem[j+3]+" "+temp_elem[j+4]+" ";
System.out.println(result);
			  k++;
				
		  }
	}

}
