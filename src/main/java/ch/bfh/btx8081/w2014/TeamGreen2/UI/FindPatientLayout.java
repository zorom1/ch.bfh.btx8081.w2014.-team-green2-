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
import ch.bfh.btx8081.w2014.TeamGreen2.UI.PatientsRecordView; 

public class FindPatientLayout extends BorderPanel implements
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
	private TextField setPid;
	private TextField field1;
	private TextField field2;
	private TextField field3;
	private TextField field4;
	private TextField field5;
	private TextField field6;
	private TextField field7;
	private TextField field8;
	private Label space;
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;

	
	public FindPatientLayout() {
		this.label = new Label("Find Patient");
		this.label.setWidth(null);
		this.label1 = new Label("Please type in PID");
		this.label2 = new Label("Master Data");

		this.setPid = new TextField();
		this.field1 = new TextField();
		this.field2 = new TextField();
		this.field3 = new TextField();
		this.field4= new TextField();
		this.field5 = new TextField();
		this.field6 = new TextField();
		this.field7 = new TextField();
		this.field8= new TextField();
		this.space = new Label("");
		
	
	
		

		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		//vertlayout.addComponent(this.label);
		//vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.label1);
		vertlayout.setComponentAlignment(this.label1, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.setPid);
		vertlayout.addComponent(createReadyButton());
		vertlayout.addComponent(this.label2);
		//vertlayout.setComponentAlignment(this.patId,Alignment.MIDDLE_CENTER);
		
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);

	
		
		vertlayout.addComponent(this.field1);
		vertlayout.addComponent(this.field2);
		vertlayout.addComponent(this.field3);
		vertlayout.addComponent(this.field4);
		vertlayout.addComponent(this.field5);
		vertlayout.addComponent(this.field6);
		vertlayout.addComponent(this.field7);
		vertlayout.addComponent(this.field8);
		
	

		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);

		vertlayout.addComponent(createEditButton());
	

		vertlayout.addComponent(createHomeViewButton());

		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);


		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}
	
	private Button createEditButton() {
		IndexButton2 = new Button("Edit");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State1();
			}
		});

		return IndexButton2;
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
		IndexButton4 = new Button("Search");
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



	}

	@Override
	public void State3() {

	}

	@Override
	public void State4() {


}}