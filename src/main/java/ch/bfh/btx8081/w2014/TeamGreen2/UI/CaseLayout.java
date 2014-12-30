package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;


import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Case;
import ch.bfh.btx8081.w2014.TeamGreen2.Database_XML.Allcases;

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
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

public class CaseLayout extends BorderPanel implements StatePatternInterface{

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
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createHomeViewButton());
		
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createNewCaseButton());
		
		vertlayout.addComponent(createReadyButton());
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createLookForCaseButton());
		vertlayout.setComponentAlignment(IndexButton3, Alignment.BOTTOM_CENTER);

		
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}	

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
private Button createReadyButton(){
	IndexButton4 = new Button("Ready");
	IndexButton4.addStyleName("big");
	IndexButton4.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID =1L;
		public void buttonClick(ClickEvent event) {
			State2();
		}
	});
	return IndexButton4;
}

private Button createNewCaseButton() {
	IndexButton2 = new Button("NewCase");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				State3();
			}
		});
											
		return IndexButton2;
		
}

	@Override
	public void State1(){
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
		Case mycase = new Case(CaseNb,PatNb,DoctorNb,StartDate,EndDate,Description); 
		try {
			Allcases.makeSerial(mycase);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification.show("Done");
		}
	@Override
	public void State3(){
		Notification.show("Give in text filds data, when finished, press Ready Button");
	}
	@Override
	public void State4(){
		MyVaadinUI.setFindCaseView(new FindCaseView());
	}
}
