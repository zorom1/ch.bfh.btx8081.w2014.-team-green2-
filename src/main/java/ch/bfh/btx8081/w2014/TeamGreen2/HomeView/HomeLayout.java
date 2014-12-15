package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;



import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI; 

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class HomeLayout extends BorderPanel {
	
	private static final long serialVersionUID = 1L;
	private Label label;
	private Panel panel; 
	
	


public HomeLayout() {
	
	

	this.label = new Label("Patients");
	this.label.setWidth(null);

	this.panel = new Panel();
	this.panel.addStyleName(getPrimaryStyleName());
	this.panel.setSizeFull();
	
	VerticalLayout vertlayout1 = new VerticalLayout();
	FormLayout forlayout1 = new FormLayout();
	vertlayout1.addComponent(this.label);
	vertlayout1.setComponentAlignment(this.label, Alignment.TOP_CENTER);
	
	forlayout1.addComponent(vertlayout1);
	forlayout1.setSizeFull();
	this.panel.setContent(forlayout1);
	setContent(panel);
	
}
}
