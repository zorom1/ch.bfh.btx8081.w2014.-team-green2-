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
	private String PatNb=null;
	private String CaseNb=null;
	private String DoctorNb=null;
	private String StartDate=null;
	private String EndDate= null;
	private String Description =null;
	
public CaseLayout() {
		this.label = new Label("Cases of Patients");
		this.label.setWidth(null);
		this.doctorUID = new TextField();
		this.patNb = new TextField();
		this.startDate = new TextField();
		this.description = new TextField();
		this.space = new Label("");
		
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.label);
		vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.patNb);
		vertlayout.setComponentAlignment(this.patNb, Alignment.MIDDLE_CENTER);
		patNb.setValue("PID");
		//vertlayout.addComponent(this.caseNb);
		//vertlayout.setComponentAlignment(this.caseNb, Alignment.BOTTOM_CENTER);
		//caseNb.setValue("Number of case");
		//vertlayout.addComponent(this.doctorUID);
		//vertlayout.addComponent(this.startDate);
		//vertlayout.addComponent(this.endDate);
		//vertlayout.addComponent(this.description);
		//vertlayout.addComponent(this.space);
		//vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createHomeViewButton());
		//vertlayout.setComponentAlignment(IndexButton, Alignment.BOTTOM_CENTER);
		
	//	vertlayout.addComponent(createNewCaseButton());
	//	vertlayout.setComponentAlignment(IndexButton2, Alignment.BOTTOM_CENTER);
	//	vertlayout.addComponent(createLookForCaseButton());
	//	vertlayout.setComponentAlignment(IndexButton3, Alignment.BOTTOM_CENTER);

		
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

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
		}
	@Override
	public void State3(){
	
	}
	@Override
	public void State4(){
	
	}
}
