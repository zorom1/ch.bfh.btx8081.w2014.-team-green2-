package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.HeaderClickEvent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * Following class provides the CV View
 * 
 */

public class CVLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Label addevent;
	private PopupDateField datefield;
	private TextArea textinput;
	private Panel panel;
	private Label space;
	private Label space1;
	private Label space2;
	private Label space3;
	private Button savebutton;
	private Button exitbutton;
	
	public CVLayout() {

		this.title = new Label("Curriculum Vitae");
		this.title.setWidth(null);
		this.space = new Label("");
		this.space1 = new Label("");
		this.space2 = new Label("");
		this.space3 = new Label("");
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		this.addevent = new Label("Add an event to the CV");

		// Datefield
		this.datefield = new PopupDateField();
		datefield.setValue(new Date());
		datefield.setSizeFull();
		datefield.setImmediate(true);
		datefield.setTimeZone(TimeZone.getTimeZone("UTC"));
		datefield.setLocale(Locale.GERMANY);
		// Display only year and month in ISO format
		datefield.setDateFormat("yyyy-MM");

		// RichTextArea
		this.textinput = new TextArea();
		//textinput.setValue("Type here the life event of the Patient you want to add.");
		textinput.setInputPrompt("Type here the life event of the Patient you want to add.");
		textinput.setSizeFull();
		textinput.setRows(2);
		textinput.setImmediate(true);

		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.title);
		vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.addevent);
		vertlayout.addComponent(this.datefield);
		vertlayout.setComponentAlignment(this.datefield, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.textinput);
		vertlayout.setComponentAlignment(this.textinput, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space1);
		vertlayout.addComponent(createSaveButton());
		vertlayout.addComponent(this.space2);
		vertlayout.addComponent(CVTable());
		vertlayout.addComponent(this.space3);
		vertlayout.addComponent(createHomeViewButton());
		

		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}

	/**
	 * Creates the "Save" Button to enter the application.
	 * 
	 * @return Button
	 */

	public Button createHomeViewButton() {
		exitbutton = new Button("Exit");
		exitbutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setHomeView(new HomeView());
			}
		});
		return exitbutton;
	}

	/**
	 * Creates the "Exit" Button to exit the application.
	 * 
	 * @return Button
	 */

	public Button createSaveButton() {
		savebutton = new Button("Save");
		savebutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				datefield.addValueChangeListener(new Property.ValueChangeListener() {
					
					@Override
					public void valueChange(ValueChangeEvent event) {
						String date = (String) event.getProperty()
								.getValue();
						
						
						// HOW TO ADD DATE IN DB?
					
					}
		
				});
				
				textinput
						.addValueChangeListener(new Property.ValueChangeListener() {
							public void valueChange(ValueChangeEvent event) {
								String value = (String) event.getProperty()
										.getValue();

								// HOW TO ADD EVENT IN DB?

							}

						});
			}

		});
		return savebutton;
	}
	
	public Table CVTable() {
		Table cvtable = new Table("CV of the Patient - Jane Smith - PID 123-456-789");

		// Define two columns for the built-in container
		cvtable.addContainerProperty("Date", String.class, null);
		cvtable.addContainerProperty("Event",  String.class, null);

		// Add a few other rows using shorthand addItem()
		cvtable.addItem(new Object[]{"1991-05", "Death of Mother"}, 1);
		cvtable.addItem(new Object[]{"1995-03", "Brother jumped from Bridge, survived"}, 2);
		cvtable.addItem(new Object[]{"2000-12", "Married John Smith, police sergeant"}, 3);
		cvtable.addItem(new Object[]{"2012-09", "Death of husband, John Smith, local shooting"}, 4);
		cvtable.sort();
		
		// Handle the header clicks
		cvtable.addHeaderClickListener(new Table.HeaderClickListener() {
		    public void headerClick(HeaderClickEvent event) {
		    	cvtable.setSortAscending(true);
		    }
		});
		
		// Show exactly the currently contained rows (items)
		cvtable.setPageLength(cvtable.size());
		cvtable.setSizeFull();
		
		return cvtable;
		
	}
	
}