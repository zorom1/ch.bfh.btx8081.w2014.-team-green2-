package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * Following class provides the Layout for the View of the Curriculum Vitae of a
 * Patient. Here the doctor can choose a date and type in the information that
 * is relevant according to his sessions with the patient. The data is saved in
 * a database and displayed in a table.
 * 
 */

public class CVLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Label addevent;
	private Label findpid;
	private TextField date;
	private TextArea event;
	private Panel panel;
	private Label space;
	private Label space1;
	private Label space2;
	private Label space3;
	private Label space4;
	private Button savebutton;
	private Button homebutton;
	private TextField pid;
	private Button findPID;
	private String myPID = null;
	private Button switchLayout;

	public CVLayout() {

		this.title = new Label("Curriculum Vitae");
		this.title.setWidth(null);
		this.findpid = new Label ("Type the PID to view the CV");
		this.space = new Label("");
		this.space1 = new Label("");
		this.space2 = new Label("");
		this.space3 = new Label("");
		this.space4 = new Label("");
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		this.addevent = new Label("Add an event to the CV");

		// Datefield

		this.date = new TextField();
		date.setInputPrompt("1991-05");

		// RichTextArea
		this.event = new TextArea();
		event.setInputPrompt("Type here the life event of the Patient you want to add.");
		event.setSizeFull();
		event.setRows(2);
		event.setImmediate(true);

		// PID Field
		this.pid = new TextField();
		pid.setInputPrompt("p035");
		pid.setRequired(true);
		pid.setRequiredError("Type a valid PID");

		// Add Components to the Layout
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.title);
		vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(this.findpid);
		vertlayout.addComponent(this.pid);
		vertlayout.addComponent(findPID());
		vertlayout.addComponent(this.space4);
		vertlayout.addComponent(this.addevent);
		vertlayout.addComponent(this.date);
		vertlayout.addComponent(this.event);
		vertlayout.setComponentAlignment(this.event, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space1);

		HorizontalLayout horizlayout = new HorizontalLayout();
		horizlayout.setSizeFull();
		horizlayout.addComponent(createSaveButton());
		horizlayout.addComponent(this.space3);
		horizlayout.addComponent(switchLayout());
		horizlayout.addComponent(this.space2);
		horizlayout.addComponent(createHomeViewButton());

		forlayout.addComponent(vertlayout);
		forlayout.addComponent(horizlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);

	}

	/**
	 * Creates the "Find" Button to find the patients CV in the database.
	 * 
	 * @return Button
	 */

	public Button findPID() {
		findPID = new Button("Find Patient");
		findPID.setClickShortcut(KeyCode.ENTER);
		findPID.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				myPID = pid.getValue();

				CVReadWr cvreadwr = new CVReadWr();
				cvreadwr.cvread(myPID);
				Notification.show("Patient found");

			}
		});
		return findPID;
	}

	/**
	 * Creates the "Switch" Button to exit the View and see the CV of the
	 * Patient.
	 * 
	 * @return Button
	 */

	public Button switchLayout() {
		switchLayout = new Button("View CV");
		switchLayout.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setCVSwitchView(new CVSwitchView());

			}
		});
		return switchLayout;
	}

	/**
	 * Creates the "Home" Button to exit the View and return to the Home View.
	 * 
	 * @return Button
	 */

	public Button createHomeViewButton() {
		homebutton = new Button("Home");
		homebutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setHomeView(new HomeView());
			}
		});
		return homebutton;
	}

	/**
	 * This method creates the "Save" Button to save the data from the date and
	 * text field to the database of the application.
	 * 
	 * @return Button
	 */

	public Button createSaveButton() {
		savebutton = new Button("Save");
		savebutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event1) {
				myPID = pid.getValue();

				CVReadWr cvreadwr = new CVReadWr();
				cvreadwr.cvwrite(myPID, date.getValue(), event.getValue());

			}
		});
		return savebutton;
	}

}