package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.FileNotFoundException;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2014.TeamGreen2.Controller.FindFunctionAllCasesPID;
import ch.bfh.btx8081.w2014.TeamGreen2.Controller.FindFunctionCaseNb;
import ch.bfh.btx8081.w2014.TeamGreen2.Controller.StatePatternInterface;
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Allcases;
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Case;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

/**
 * The following class provides the Layout for the View of searching a existing case.
 * The Information is read from the XML-File that was Created in CaseLayout.
 */

public class FindCaseLayout extends BorderPanel implements
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
	private Label notification;
	private TextField patNb;
	private TextField caseNb;
	private TextField doctorUID;
	private TextField startDate;
	private TextField endDate;
	private TextField description;
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;
	private Button IndexButton5;
	private String MyCaseNb;
	private String MyPID;
	public String myDoctor;
    public String myDate1;
    public String myDate2;
    public String myDescr;
    public String myCNb;
    public String myPNb;
    
	public FindCaseLayout() {
		this.label = new Label("Looking for patient's cases");
		this.label.setWidth(null);
		this.label1 = new Label("PID");
		this.label2 = new Label("Case Number");
		this.label3 = new Label("Doctor UID");
		this.label4 = new Label("Start Date");
		this.label5 = new Label("End Date");
		this.label6 = new Label("Description");
		this.notification = new Label("First change Information then click edit to accept change");
		this.caseNb = new TextField();
		this.patNb = new TextField();
		this.doctorUID = new TextField();
		this.startDate = new TextField();
		this.endDate = new TextField();
		this.description = new TextField();

		// Set unneeded fields disabled until their used
		this.doctorUID.setEnabled(false);
		this.startDate.setEnabled(false);
		this.endDate.setEnabled(false);
		this.description.setEnabled(false);
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();

		vertlayout.addComponent(this.label);
		vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.label1);
		vertlayout.addComponent(this.patNb);
		vertlayout.addComponent(this.label2);
		vertlayout.addComponent(this.caseNb);
		vertlayout.addComponent(this.caseNb);
		vertlayout.addComponent(this.label3);
		vertlayout.addComponent(this.doctorUID);
		vertlayout.addComponent(this.label4);
		vertlayout.addComponent(this.startDate);
		vertlayout.addComponent(this.label5);
		vertlayout.addComponent(this.endDate);
		vertlayout.addComponent(this.label6);
		vertlayout.addComponent(this.description);

		
		vertlayout.addComponent(createFindCaseButton());
		vertlayout.addComponent(createFindCaseNbButton());
		vertlayout.addComponent(createFindAllCasesButton());
		vertlayout.addComponent(notification);
		vertlayout.addComponent(createHomeViewButton());
		vertlayout.addComponent(createCaseViewButton());
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}

	private Button createCaseViewButton() {
		IndexButton = new Button("Back");
		IndexButton.addStyleName("big");
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State1();
			}
		});

		return IndexButton;
	}

	private Button createFindCaseButton() {
		IndexButton3 = new Button("LookForCase");
		IndexButton3.addStyleName("big");
		IndexButton3.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {

				Notification
						.show("insert a case Nb and press: 'Find case Nb' Button or insert a PID Nb and press 'Find all cases to PID' Button");
			}
		});

		return IndexButton3;

	}

	private Button createHomeViewButton() {
		IndexButton2 = new Button("Edit");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State2();
			}
		});

		return IndexButton2;
	}

	private Button createFindCaseNbButton() {
		IndexButton4 = new Button("find Case Nb");
		IndexButton4.addStyleName("big");
		IndexButton4.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				doctorUID.setEnabled(true);
				startDate.setEnabled(true);
				endDate.setEnabled(true);
				description.setEnabled(true);
				State3();
			}
		});
		return IndexButton4;
	}


	private Button createFindAllCasesButton() {
		IndexButton5 = new Button("find all cases");
		IndexButton5.addStyleName("big");
		IndexButton5.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				doctorUID.setEnabled(true);
				startDate.setEnabled(true);
				endDate.setEnabled(true);
				description.setEnabled(true);
				State4();
			}
		});
		return IndexButton5;
	}
	@Override
	public void State1() {
		MyVaadinUI.setCaseView(new CaseView());

	}

	@Override
	public void State2() {
		// TODO Auto-generated method stub
		//MyVaadinUI.setHomeView(new HomeView());
		String myCNb=caseNb.getValue();
	    String myPNb =patNb.getValue();
	    String myDoctor=doctorUID.getValue();
	    String myDate1=startDate.getValue();
	    String myDate2=endDate.getValue();
	    String myDescr=description.getValue();
	    
	    Case mycase = new Case(myCNb, myPNb, myDoctor, myDate1, myDate2, myDescr);
	    Allcases.StatusC="Correct";
	    try {
			Allcases.makeSerial(mycase);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /*changed data from cases.xml
	     	     */
	   // Allcases allcases = new Allcases();
	    caseNb.setValue(Allcases.FoundCaseNb);  
	    patNb.setValue(Allcases.FoundPatNb);
	    doctorUID.setValue(Allcases.FoundDoctorUID);
	    startDate.setValue(Allcases.FoundStartDate);
	    endDate.setValue(Allcases.FoundEndDate);
	    description.setValue(Allcases.FoundDescription);
	  
	}

	@Override
	public void State3() {
		// TODO Auto-generated method stub
		MyCaseNb = caseNb.getValue();
		MyPID = patNb.getValue();
		FindFunctionCaseNb findFunctionCasesNb = new FindFunctionCaseNb();
		findFunctionCasesNb.CheckFound(MyCaseNb, MyPID);

		caseNb.setValue(findFunctionCasesNb.FoundCaseNb);
		patNb.setValue(findFunctionCasesNb.FoundPatNb);
		doctorUID.setValue(findFunctionCasesNb.FoundDoctorUID);
		startDate.setValue(findFunctionCasesNb.FoundStartDate);
		endDate.setValue(findFunctionCasesNb.FoundEndDate);
		description.setValue(findFunctionCasesNb.FoundDescription);
		Notification.show("Case is found");
	}

	@Override
	public void State4() {
		// TODO Auto-generated method stub
		MyCaseNb = caseNb.getValue();
		MyPID = patNb.getValue();
		FindFunctionAllCasesPID findFunctionAllCasesPID = new FindFunctionAllCasesPID();
		findFunctionAllCasesPID.CheckFound(MyCaseNb, MyPID);
		MyVaadinUI.setFindCasePIDView(new FindCasePIDView());

	}

}
