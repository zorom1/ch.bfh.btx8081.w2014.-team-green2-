package ch.bfh.btx8081.w2014.TeamGreen2.UI;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2014.TeamGreen2.Controller.FindFunctionCaseNb;
import ch.bfh.btx8081.w2014.TeamGreen2.Controller.StatePatternInterface;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

public class FindCaseLayout extends BorderPanel implements StatePatternInterface {

	
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
	private Panel panel;
	private Button IndexButton2;
	private Button IndexButton3;
	private Button IndexButton4;
	public FindCaseLayout(){
		this.label = new Label("Looking for patient's cases");
		this.label.setWidth(null);
		this.label1 = new Label("PID");
		this.label2 = new Label("Case Number");
		this.label3 = new Label("Doctor UID");
		this.label4 = new Label("Start Date");
		this.label5 = new Label("End Date");
		this.label6 = new Label("Description");
		this.caseNb = new TextField();
		this.patNb = new TextField();
		this.doctorUID = new TextField();
		this.startDate = new TextField();
		this.endDate = new TextField();
		this.description = new TextField();
		
		//Set all Textfields as required
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
		
vertlayout.addComponent(createHomeViewButton());
		
		
		vertlayout.addComponent(createCaseViewButton());
		
		
		
		vertlayout.addComponent(createFindCaseButton());
		vertlayout.addComponent(createReadyButton());
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}
	
	private Button createCaseViewButton() {
		IndexButton = new Button("Back");
		IndexButton.addStyleName("big");
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
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
				private static final long serialVersionUID =1L;
				public void buttonClick(ClickEvent event) {
					State3();
				}
			});
												
			return IndexButton3;
			
	}
	private Button createHomeViewButton() {
		IndexButton2 = new Button("Home");
		IndexButton2.addStyleName("big");
		IndexButton2.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				State2();
			}
		});
											
		return IndexButton2;
	}	
	private Button createReadyButton(){
		IndexButton4 = new Button("Ready");
		IndexButton4.addStyleName("big");
		IndexButton4.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				doctorUID.setEnabled(true);
				startDate.setEnabled(true);
				endDate.setEnabled(true);
				description.setEnabled(true);
				State4();
			}
		});
		return IndexButton4;
	}
	@Override
	public void State1() {
		MyVaadinUI.setCaseView(new CaseView());
		
	}

	@Override
	public void State2() {
		// TODO Auto-generated method stub
		MyVaadinUI.setHomeView(new HomeView());
	}

	@Override
	public void State3() {
		// TODO Auto-generated method stub
		Notification.show("Give, please, in PID or case number, when finished, press Ready Button");
	}

	@Override
	public void State4() {
		// TODO Auto-generated method stub
		final String MyCaseNb=caseNb.getValue();
		final String MyPID=patNb.getValue();
		FindFunctionCaseNb findFunctionCaseNb= new FindFunctionCaseNb();
		findFunctionCaseNb.CheckFound(MyCaseNb,MyPID);
		caseNb.setValue(findFunctionCaseNb.FoundCaseNb);
		patNb.setValue(findFunctionCaseNb.FoundPatNb);
		doctorUID.setValue(findFunctionCaseNb.FoundDoctorUID);
		startDate.setValue(findFunctionCaseNb.FoundStartDate);
		endDate.setValue(findFunctionCaseNb.FoundEndDate);
		description.setValue(findFunctionCaseNb.FoundDescription);
		Notification.show("Case is found");
		
	}

}
