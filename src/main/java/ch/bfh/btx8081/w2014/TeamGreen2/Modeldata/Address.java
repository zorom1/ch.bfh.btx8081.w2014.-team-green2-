package ch.bfh.btx8081.w2014.TeamGreen2.Modeldata;

public class Address {
	private String Street=null;
	private String City=null;
	private String Pcode=null;
	


	Address(){
		}
	public Address(String aStreet, String aCity, String aPcode){
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
	public String getPcode(){
		return Pcode; 
	}
	public void setPcode(String Pcode){
		this.Pcode=Pcode;
	}	
	

	@Override
		public String toString() {
		
		return getStreet() + " "+getCity() +" "+ getPcode()+" " ;
	}
}
