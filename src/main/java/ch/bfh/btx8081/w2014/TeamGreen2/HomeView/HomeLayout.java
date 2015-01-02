package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CVView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CaseView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.TimelineView;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class HomeLayout extends BorderPanel {
	
	private static final long serialVersionUID = 1L;
	private Label title;
	private Panel panel;
	private Label space;
	private Label space1;
	private Button cvbutton;
	private Button timelinebutton;
	private Button casebutton;
	
public HomeLayout() {
	
	this.title = new Label("Home");
	this.title.setWidth(null);
	this.space = new Label("");
	this.space1 = new Label("");
	this.panel = new Panel();
	this.panel.setStyleName("borderless");
	this.panel.setSizeFull();

	VerticalLayout vertlayout = new VerticalLayout();
	FormLayout forlayout = new FormLayout();
	vertlayout.addComponent(this.title);
	vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
	vertlayout.addComponent(this.space);
	vertlayout.setComponentAlignment(this.space, Alignment.TOP_CENTER);
	vertlayout.addComponent(createTable());
	vertlayout.addComponent(createCVViewButton());
	vertlayout.addComponent(createTimelineViewButton());
	vertlayout.addComponent(createCaseButton());

	forlayout.addComponent(vertlayout);
	forlayout.setSizeFull();
	this.panel.setContent(forlayout);
	setContent(panel);
}
	
public Table createTable() {
	Table table = new Table("");

	// Define two columns for the built-in container
	table.addContainerProperty("PID", String.class, null);
	table.addContainerProperty("Name",  String.class, null);
	table.addContainerProperty("Firstname", String.class, null);
	table.addContainerProperty("Sex", String.class, null);
	table.addContainerProperty("Birthdate", String.class, null);

	// Add a row the hard way
	//Object newItemId = table.addItem();
	//Item row1 = table.getItem(newItemId);

	// Add a few other rows using shorthand addItem()
	table.addItem(new Object[]{"12345678","Smith", "Jane", "female", "12.12.2014"}, 1);
	
	// Show exactly the currently contained rows (items)
	table.setPageLength(table.size());
	table.setSizeFull();
	
	return table;
	
}

public Button createCVViewButton() {
	cvbutton = new Button("CV");
	cvbutton.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			MyVaadinUI.setCVView(new CVView());
		}
	});
	return cvbutton;
}

public Button createTimelineViewButton() {
	timelinebutton = new Button("Timeline");
	timelinebutton.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			MyVaadinUI.setTimelineView(new TimelineView());
		}
	});
	return timelinebutton;
}
public Button createCaseButton(){
	casebutton= new Button("Case");
	casebutton.addClickListener(new Button.ClickListener() {
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
		//	MyVaadinUI.setTimelineView(new TimelineView());
			MyVaadinUI.setCaseView(new CaseView());	
		}	
		
	});
	return casebutton;
}
	

//	this.label = new Label("Patients");
//	this.label.setWidth(null);
//
//	this.panel = new Panel();
//	this.panel.addStyleName(getPrimaryStyleName());
//	this.panel.setSizeFull();
//	
//	VerticalLayout vertlayout1 = new VerticalLayout();
//	FormLayout forlayout1 = new FormLayout();
//	vertlayout1.addComponent(this.label);
//	vertlayout1.setComponentAlignment(this.label, Alignment.TOP_CENTER);
//	
//	forlayout1.addComponent(vertlayout1);
//	forlayout1.setSizeFull();
//	this.panel.setContent(forlayout1);
//	setContent(panel);
	
}

