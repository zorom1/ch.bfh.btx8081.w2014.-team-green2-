package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import java.io.FileNotFoundException;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.AddNewPatientView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CVView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CaseView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.TimelineView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.AddNewDiagnosisView; 

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

public class HomeLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Panel panel;
	private Label space;
	private Label space1;
	private Button cvbutton;
	private Button timelinebutton;
	private Button casebutton;
	private Button addnewpatientbutton;
	private Button addnewdiagnosisbutton; 
	public static String tableFlag = "0";

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
		vertlayout.addComponent(createNewPatientButton());
		vertlayout.addComponent(createNewDiagnosisButton());
		

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

	public Table createTable() {
		Table table = new Table("");

		// Define the columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("LastName", String.class, null);
		table.addContainerProperty("Gender", String.class, null);
		table.addContainerProperty("PID", String.class, null);
		table.addContainerProperty("Birthdate", String.class, null);

		// Fill the Table on the HomeView with actual patients data
		String[] temp_elem = new String[5];
		// if(tableFlag=="0"){
		try {

			TableElements telements = new TableElements();
			telements.countElements();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }//for if
		if (tableFlag == "3") {

		}
		int ArraySize = TableElements.myElements.size();
		int i = 0;
		/*
		 * variable k counts the lines in the table
		 */
		int k = 1;
		/*
		 * array from 5 elements is one line of the table
		 */

		while (i < ArraySize - 1) {
			for (int j = 0; j < 5; j++) {
				temp_elem[j] = TableElements.myElements.get(i);

				i++;
			}
			int j = 0;

			// Filling Table with data from patients xml file according to
			// toString
			table.addItem(new Object[] { temp_elem[j], temp_elem[j + 1],
					temp_elem[j + 2], temp_elem[j + 3], temp_elem[j + 4] }, k);
			k++;
		}
		// }

		table.setPageLength(table.size());
		// table.setPageLength(3);
		table.setSizeFull();

		return table;

	}

	/**
	 * This method creates a button where the user can navigate to the Patient
	 * CV.
	 * 
	 * @return CVButton
	 */

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

	/**
	 * This method creates a button where the user can navigate to the Patient
	 * Timeline.
	 * 
	 * @return TimelineButton
	 */

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

	/**
	 * This method creates a button where the user can navigate to the Patient
	 * Case.
	 * 
	 * @return CaseButton
	 */

	public Button createCaseButton() {
		casebutton = new Button("Case");
		casebutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// MyVaadinUI.setTimelineView(new TimelineView());
				MyVaadinUI.setCaseView(new CaseView());
			}

		});
		return casebutton;
	}

	/**
	 * This method creates a button where the user can navigate to the view to
	 * add a new patient to the database.
	 * 
	 * @return AddNewPatientButton
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

	public Button createNewDiagnosisButton() {
		addnewdiagnosisbutton = new Button("Add new Diagnosis");
		addnewdiagnosisbutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// MyVaadinUI.setTimelineView(new TimelineView());
				MyVaadinUI.setAddNewDiagnosisView(new AddNewDiagnosisView());
			}

		});
		return addnewdiagnosisbutton;
	}
}
