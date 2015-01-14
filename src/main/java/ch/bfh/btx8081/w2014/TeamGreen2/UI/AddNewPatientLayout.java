package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.AllPatients;
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Patient;





import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
//import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2014.TeamGreen2.Controller.StatePatternInterface;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeLayout;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;
import ch.bfh.btx8081.w2014.TeamGreen2.Modeldata.Address;

public class AddNewPatientLayout extends BorderPanel implements
		StatePatternInterface {

	private static final long serialVersionUID = 1L;
	private Button IndexButton;
	private Label label;
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	private Label label6;
	private Label label7;
	private Label label8;
	private Label label9;
	private TextField patId;
	private TextField lastName;
	private TextField street;
	private TextField city;
	private TextField postcode;
	private TextField gender;
	private TextField birthday;
	private TextField insurance;
	private TextField firstname;
	private Label space;
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;
	private String PID = null;
	private String LASTNAME = null;
	private String FIRSTNAME = null;
	private String STREET = null;
	private String CITY = null;
	private String POSTCODE = null;
	private String GENDER = null;
	private String BIRTHDAY = null;
	private String INSURANCE = null;
	private String currentPIDNb;
	
	public AddNewPatientLayout() {
		this.label = new Label("Add new patient");
		this.label.setWidth(null);
		this.label1 = new Label("PID");
		this.label2 = new Label("Last name");
		this.label9 = new Label("Street");
		this.label3 = new Label("First name");
		this.label4 = new Label("City");
		this.label5 = new Label("Postcode");
		this.label6 = new Label("Gender");
		this.label7 = new Label("Birthday");
		this.label8 = new Label("Insurance");
		this.patId = new TextField();
		this.lastName = new TextField();
		this.firstname = new TextField();
		this.street = new TextField();
		this.city = new TextField();
		this.postcode = new TextField();
		this.gender = new TextField();
		this.birthday = new TextField();
		this.insurance = new TextField();
		this.space = new Label("");
		
		//Set all Textfields as required
		this.patId.setRequired(true);
		this.firstname.setRequired(true);
		this.lastName.setRequired(true);
		this.street.setRequired(true);
		this.city.setRequired(true);
		this.postcode.setRequired(true);
		this.gender.setRequired(true);
		this.birthday.setRequired(true);
		this.insurance.setRequired(true);
		

		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		//vertlayout.addComponent(this.label);
		//vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.label1);
		vertlayout.setComponentAlignment(this.label1, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.patId);
		vertlayout.addComponent(this.label2);
		//vertlayout.setComponentAlignment(this.patId,Alignment.MIDDLE_CENTER);

		vertlayout.addComponent(this.lastName);
		vertlayout.addComponent(this.label3);
		vertlayout.addComponent(this.firstname);
		vertlayout.addComponent(this.label9);
		vertlayout.addComponent(this.street);
		vertlayout.addComponent(this.label4);
		vertlayout.addComponent(this.city);
		vertlayout.addComponent(this.label5);
		vertlayout.addComponent(this.postcode);
		vertlayout.addComponent(this.label6);
		vertlayout.addComponent(this.gender);
		vertlayout.addComponent(this.label7);
		vertlayout.addComponent(this.birthday);
		vertlayout.addComponent(this.label8);
		vertlayout.addComponent(this.insurance);
	
		vertlayout.addComponent(createNextPid());
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		
		vertlayout.addComponent(createReadyButton());
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);

		vertlayout.addComponent(createHomeViewButton());

		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);


		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}


	private Button createHomeViewButton() {
		IndexButton = new Button("Home");
		IndexButton.addStyleName("big");
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State1();
			}
		});

		return IndexButton;
	}
  
	private Button createNextPid(){
		IndexButton2 = new Button("Take next available PID");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State3();
				IndexButton4.setEnabled(true);
			}
		});

		return IndexButton2; 
	
	}

	private Button createReadyButton() {
		IndexButton4 = new Button("Save");
		IndexButton4.addStyleName("big");
		IndexButton4.setEnabled(false);
		IndexButton4.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State2();
				
			}
		});
		return IndexButton4;
	}

	@Override
	public void State1() {
		HomeLayout.tableFlag="0";
		MyVaadinUI.setHomeView(new HomeView());
	}

	@Override
	public void State2() {

		PID = patId.getValue();
		LASTNAME = lastName.getValue();
		FIRSTNAME = firstname.getValue();
		STREET = street.getValue();
		CITY = city.getValue();
		POSTCODE = postcode.getValue();
		GENDER = gender.getValue();
		BIRTHDAY = birthday.getValue();
		INSURANCE = insurance.getValue();
		Address address = new Address(STREET, CITY, POSTCODE);
//System.out.println("Address="+address.getCity()+address.getStreet()+address.getPcode());
		if(PID.compareTo(currentPIDNb)==0){
		Patient newpatient = new Patient(PID, LASTNAME, FIRSTNAME, address,
				GENDER, BIRTHDAY, INSURANCE);
		try {
			AllPatients.makeSerial(newpatient);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification.show("Done");
		}
		else {
			Notification.show("PID is not correct, please try again");
		}
	}

	@Override
	public void State3() {
		Notification
				.show("Next available PID");
		try {
			numberDefine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}

	@Override
	public void State4() {
		MyVaadinUI.setFindCaseView(new FindCaseView());
	}
	private void numberDefine() throws FileNotFoundException{
		File inputfile = new File("lastpatient.txt");
		Scanner in = new Scanner(inputfile);
		String lastNumber=in.next();
		System.out.println(lastNumber);
		String subnumber=lastNumber.substring(1,4);
		System.out.println(subnumber);
		int numb=Integer.parseInt(subnumber);
		numb=numb+1;
		lastNumber="p"+numb;;
		int len=lastNumber.length();
		if(len==3){
		lastNumber="p"+"0"+numb;	
		}
		patId.setValue(lastNumber);
		currentPIDNb=lastNumber;
		in.close();
		PrintWriter out= new PrintWriter("lastpatient.txt");
		out.println(lastNumber);
		out.close();
}
}