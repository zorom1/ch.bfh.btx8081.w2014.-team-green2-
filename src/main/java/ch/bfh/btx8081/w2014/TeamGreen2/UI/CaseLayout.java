package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Case;
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Allcases;

import com.vaadin.client.metadata.Property;
import com.vaadin.client.ui.Field;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.FieldEvents.TextChangeNotifier;
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

/**
 * The following class provides the Layout for the View of the Case.
 * A new Case can be created, making sure that there are no overlapping PID's or CaseNumbers
 * Further there's a Button that directs to the FindCaseLayout
 */



public class CaseLayout extends BorderPanel implements StatePatternInterface{
	//Initializing The Labels and Textfields for later use
	
	private static final long serialVersionUID = 1L;
	private Button IndexButton;
	private Label label;
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	private Label label6;
	private TextField patNb;
	private TextField caseNb;
	private TextField doctorUID;
	private TextField startDate;
	private TextField endDate;
	private TextField description;
    private Label space;
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;
	private String PatNb=null;
	private String CaseNb=null;
	private String DoctorNb=null;
	private String StartDate=null;
	private String EndDate= null;
	private String Description =null;
	private String currentNb;
	/** 
	 *  Layout of the Case UI with vertical Layout
	 */
public CaseLayout() {
		this.label = new Label("Cases of Patients");
		this.label.setWidth(null);
		this.label1 = new Label("PID");
		
		this.label2 = new Label("Case Number");
	    this.caseNb = new TextField();
		this.label3 = new Label("Doctor's ID");
		this.label4 = new Label("Date of begin");
		this.label5 = new Label("Date of the end");
		this.label6 = new Label("Description of the case");
		this.doctorUID = new TextField();
		this.patNb = new TextField();
		this.startDate = new TextField();
		this.endDate =new TextField();
		this.description = new TextField();
		this.space = new Label("");
		
		
		//Set all Textfields as required
		this.caseNb.setRequired(true);
		this.doctorUID.setRequired(true);
		this.patNb.setRequired(true);
		this.startDate.setRequired(true);
		this.endDate.setRequired(true);
		this.description.setRequired(true);
		
		
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.label);
		vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.label1);
		//vertlayout.setComponentAlignment(this.label1, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.patNb);
		vertlayout.addComponent(this.label2);
		//vertlayout.setComponentAlignment(this.patNb, Alignment.MIDDLE_CENTER);
		
		vertlayout.addComponent(this.caseNb);
		vertlayout.addComponent(this.label3);
		vertlayout.addComponent(this.doctorUID);
		vertlayout.addComponent(this.label4);
		vertlayout.addComponent(this.startDate);
		vertlayout.addComponent(this.label5);
		vertlayout.addComponent(this.endDate);
		vertlayout.addComponent(this.label6);
		vertlayout.addComponent(this.description);
		vertlayout.addComponent(this.space);
	
		
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createNewCaseButton());
		
		vertlayout.addComponent(createReadyButton());
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createHomeViewButton());
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		
		vertlayout.addComponent(this.space);
		
		vertlayout.addComponent(createLookForCaseButton());
		vertlayout.setComponentAlignment(IndexButton3, Alignment.BOTTOM_CENTER);

		
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}	
/**
 * Adds a Button for finding the right case
 * @return FindButton
 */
private Button createLookForCaseButton() {
	IndexButton3 = new Button("Find");
	IndexButton3.addStyleName("big");
	IndexButton3.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID =1L;
		public void buttonClick(ClickEvent event) {
			State4();
		}
	});
	return IndexButton3;
}
/**
 * adds a Button that redirects you to the Home View
 * @return
 */
private Button createHomeViewButton() {
	IndexButton = new Button("Home");
	IndexButton.addStyleName("big");
	IndexButton.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID =1L;
		public void buttonClick(ClickEvent event) {
		
			State1();
		}
	});
										
	return IndexButton;
}
/**
 * adds a Button which saves the Input Info in the case View
 */
private Button createReadyButton(){
	IndexButton4 = new Button("Save");
	IndexButton4.addStyleName("big");
	IndexButton4.setEnabled(false);

	IndexButton4.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID =1L;
		public void buttonClick(ClickEvent event) {
			State2();
		
		}
	});
	return IndexButton4;
}
/**
 * Adds a Button to initialize the Creation of a new Case
 */
private Button createNewCaseButton() {
	IndexButton2 = new Button("Take next available Case Number");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				State3();
				IndexButton4.setEnabled(true);
			}
		});
											
		return IndexButton2;
		
}

	@Override
	public void State1(){
		HomeLayout.tableFlag="1";
	MyVaadinUI.setHomeView(new HomeView());
	}
	
	@Override
		public void State2() {
		PatNb=patNb.getValue();
		CaseNb=caseNb.getValue();
		DoctorNb=doctorUID.getValue();
		StartDate=startDate.getValue();
		EndDate=endDate.getValue();
		Description=description.getValue();
		/*next if statement defines if user give in the case number that
		 * matches with next available case number,  if not data are not saved
		 * in DB, user gets notification that it is necessary to try again
		 */
		if(CaseNb.compareTo(currentNb)==0){
		Case mycase = new Case(CaseNb,PatNb,DoctorNb,StartDate,EndDate,Description); 
		try {
			Allcases.makeSerial(mycase);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification.show("Done");
		}
		else{
			Notification.show("Case number is not correct, please try again");
		}
		}
	@Override
	public void State3(){
		Notification.show("Next available Case Number");
		try {
			numberDefine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void State4(){
		MyVaadinUI.setFindCaseView(new FindCaseView());
	}
	/*this function defines the available number for the next new case
	 	 */
	private void numberDefine() throws FileNotFoundException{
		File inputfile = new File("lastCaseNb.txt");
		Scanner in = new Scanner(inputfile);
		String lastNumber=in.next();
		
		System.out.println(lastNumber);
		String subnumber=lastNumber.substring(1,4);
		System.out.println(subnumber);
		int numb=Integer.parseInt(subnumber);
		numb=numb+1;
		lastNumber="c"+numb;;
		int len=lastNumber.length();
		if(len==3){
		lastNumber="c"+"0"+numb;	
		}
		caseNb.setValue(lastNumber);
		currentNb=lastNumber;
		PrintWriter out= new PrintWriter("lastCaseNb.txt");
		out.println(lastNumber);
		out.close();
		in.close();
	}
}
