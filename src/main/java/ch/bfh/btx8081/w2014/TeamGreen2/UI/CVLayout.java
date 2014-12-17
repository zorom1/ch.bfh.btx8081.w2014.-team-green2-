package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * Following class provides the CV View
 * 
 */

public class CVLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private PopupDateField datefield;
	private TextArea textinput;
	private Panel panel;
	private Label space;
	private Label space1;
	private Label space2;
	private Button savebutton;
	private Button exitbutton;

	public CVLayout() {

		this.title = new Label("Curriculum Vitae");
		this.title.setWidth(null);
		this.space = new Label("");
		this.space1 = new Label("");
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();

		// Datefield
		this.datefield = new PopupDateField();
		datefield.setValue(new Date());
		datefield.setWidth("450px");
		datefield.setImmediate(true);
		datefield.setTimeZone(TimeZone.getTimeZone("UTC"));
		datefield.setLocale(Locale.GERMANY);

		// RichTextArea
		this.textinput = new TextArea();
		textinput.setValue("Type here the life event of the Patient");
		textinput.setWidth("450px");
		textinput.setRows(4);
		textinput.setImmediate(true);

		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.title);
		vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space);
		vertlayout.setComponentAlignment(this.space, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.datefield);
		vertlayout.setComponentAlignment(this.datefield, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.textinput);
		vertlayout.setComponentAlignment(this.textinput, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space1);
		vertlayout.addComponent(createSaveButton());
		vertlayout.addComponent(createHomeViewButton());
		vertlayout.addComponent(createTable());

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
						
						// HOW ADD DATE?
						// HOW WRITE NEW LINE IN TXT FIELD EVERYTIME?
					
					}
		
				});
				textinput.addValueChangeListener(new Property.ValueChangeListener() {
							public void valueChange(ValueChangeEvent event) {
								String value = (String) event.getProperty()
										.getValue();
								
								Writer writer = null;
								String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
								try {
								    writer = new BufferedWriter(new OutputStreamWriter(
								          new FileOutputStream(new File(basepath + "/META-INF/Patient1.txt"))));
								    writer.write("Text:" + value);
								} catch (IOException ex) {
								  // report
								} finally {
								   try {writer.close();} catch (Exception ex) {}
								}
							}

						});
				
				//------------------
//				datefield.addValueChangeListener(new Property.ValueChangeListener() {
//					public void valueChange(ValueChangeEvent event) {
//						String date = (String) event.getProperty()
//								.getValue();
//
//						Label not = new Label("Date is: " + date);
//						
//					}
//
//				});
				//------------------
				
				
			}
			
		});

		return savebutton;

	}
	
	public Table createTable() {
		Table table = new Table("");

		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Mag",  Float.class, null);

		// Add a row the hard way
		Object newItemId = table.addItem();
		Item row1 = table.getItem(newItemId);
		row1.getItemProperty("Name").setValue("Sirius");
		row1.getItemProperty("Mag").setValue(-1.46f);

		// Add a few other rows using shorthand addItem()
		table.addItem(new Object[]{"Canopus",        -0.72f}, 2);
		table.addItem(new Object[]{"Arcturus",       -0.04f}, 3);
		table.addItem(new Object[]{"Alpha Centauri", -0.01f}, 4);


		// Show exactly the currently contained rows (items)
		table.setPageLength(table.size());
		
		return table;
		
	}
	
}