package ch.bfh.btx8081.w2014.TeamGreen2.UI;

/**
 * The following class provides the Layout for the View of a New diagnosis.
 * The saved diagnosis is written in an XML File
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Alldiagnosis; 
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Diagnose; 


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

public class AddNewDiagnosisLayout extends BorderPanel implements
		StatePatternInterface {

	private static final long serialVersionUID = 1L;
	private Button IndexButton;
	private Label label;
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	
	private TextField caseNumber;
	private TextField patId;
	private TextField diagnose;
	private TextField treatment;
	private TextField medication;
	private Label space;
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;
	private String CASENUMBER = null;
	private String PATID = null;
	private String DIAGNOSE = null;
	private String TREATMENT = null;
	private String MEDICATION = null;

	/**
	 * Creates the Layout of The Diagnosis GUI
	 */
	public AddNewDiagnosisLayout() {
		this.label = new Label("Add new diagnosis");
		this.label.setWidth(null);
		this.label1 = new Label("Case Number");
		this.label2 = new Label("Pat ID ");
	
		this.label3 = new Label("Diagnose");
		this.label4 = new Label("Treatment");
		this.label5 = new Label("Medication");
	
		this.caseNumber = new TextField();
		this.patId= new TextField();
		this.diagnose = new TextField();
		this.treatment = new TextField();
		this.medication = new TextField();
	
		this.space = new Label("");
		
		//Set all Textfields as required
		this.caseNumber.setRequired(true);
		this.patId.setRequired(true);
		this.diagnose.setRequired(true);
		this.treatment.setRequired(true);
		this.medication.setRequired(true);
		

		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		//vertlayout.addComponent(this.label);
		//vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.label1);
		vertlayout.setComponentAlignment(this.label1, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.caseNumber);
		vertlayout.addComponent(this.label2);
		//vertlayout.setComponentAlignment(this.patId,Alignment.MIDDLE_CENTER);

		vertlayout.addComponent(this.patId);
		vertlayout.addComponent(this.label3);
		vertlayout.addComponent(this.diagnose);
	
		vertlayout.addComponent(this.label4);
		vertlayout.addComponent(this.treatment);
		vertlayout.addComponent(this.label5);
		vertlayout.addComponent(this.medication);
	
	
	
	
		
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
  
	
	
	

	private Button createReadyButton() {
		IndexButton4 = new Button("Save");
		IndexButton4.addStyleName("big");
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
		HomeLayout.tableFlag="2";
		MyVaadinUI.setHomeView(new HomeView());
	}

	@Override
	public void State2() {

		CASENUMBER = caseNumber.getValue();
		PATID = patId.getValue();
		DIAGNOSE = diagnose.getValue();
		TREATMENT = treatment.getValue();
		MEDICATION = medication.getValue();
		
		

		Diagnose newdiagnose = new Diagnose(CASENUMBER, PATID,DIAGNOSE,TREATMENT);
		try {
			Alldiagnosis.makeSerial(newdiagnose);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification.show("Done");

	}

	@Override
	public void State3() {
	
	}

	@Override
	public void State4() {
		MyVaadinUI.setFindCaseView(new FindCaseView());
	}

}