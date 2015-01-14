package ch.bfh.btx8081.w2014.TeamGreen2.UI; 

import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.PatientsRecordView;



import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * The following Class provides the Layout of the HomeView. It shows a Table
 * with all Patients where their meta-data (name, first name, birthdate, patient
 * ID, etc.) can be viewed
 * 
 * @author JD
 *
 */

public class PatientsRecordLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Panel panel;
	private Label space;
	private Label space1;
	private Button addnewpatientbutton;
	private Button addnewdiagnosisbutton; 
	private Button findpatientbutton;

	public static String tableFlag = "0";

	public PatientsRecordLayout() {

		this.title = new Label("Patients record");
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

	
		vertlayout.addComponent(createNewPatientButton());
		vertlayout.addComponent(createFindButton());
		
		
		

		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}

	/**
	 * This method provides the Table where the patient data is displayed.
	 * 
	 * @return Table
	 */

	

	public Button createNewPatientButton() {
		addnewpatientbutton = new Button("Add new Patient");
		addnewpatientbutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// MyVaadinUI.setTimelineView(new TimelineView());
				MyVaadinUI.setAddNewPatientView(new AddNewPatientView());
			}

		});
		return addnewpatientbutton;
	}
	
	public Button createFindButton() {
		findpatientbutton = new Button("Find");
		findpatientbutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// MyVaadinUI.setTimelineView(new TimelineView());
				MyVaadinUI.setFindPatientView(new FindPatientView());
			}

		});
		return findpatientbutton;
	}


}
