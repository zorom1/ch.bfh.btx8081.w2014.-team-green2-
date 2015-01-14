package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table.HeaderClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * The following class provides the methods to switch the layout, so the CV of
 * the Patient can be viewed.
 * 
 * @author JD
 *
 */

public class CVSwitchLayout extends BorderPanel {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Button back;
	private Panel panel;
	private Label space;

	/**
	 * The following method provides the components for the Layout.
	 */

	public CVSwitchLayout() {

		this.title = new Label("Curriculum Vitae");
		this.title.setWidth(null);
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		this.space = new Label("");

		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.title);
		vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
		vertlayout.addComponent(CVTable());
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(back());

		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}

	/**
	 * Creates the "Back" Button to exit the Curriculum Vitae of the patient and
	 * return to the CVLayout again where a new life event can be added if
	 * wished.
	 * 
	 * @return Button
	 */

	public Button back() {
		back = new Button("Back");
		back.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setCVView(new CVView());

			}
		});
		return back;
	}

	/**
	 * The following method shows the current table of the events in the
	 * database or the events that were recently added by the doctor.
	 * 
	 * @return Table
	 */

	public Table CVTable() {
		Table cvtable = new Table("");

		// Define two columns for the built-in container
		cvtable.addContainerProperty("Date", String.class, null);
		cvtable.addContainerProperty("Event", String.class, null);

		String[] temp_element = new String[2];
		int i = 0;
		int line = 1;

		while (i < CVReadWr.myResult.size() - 1) {
			for (int j = 0; j < 2; j++) {
				String myArray = CVReadWr.myResult.get(i);
				temp_element[j] = myArray;
				i++;
			}
			int j = 0;

			cvtable.addItem(
					new Object[] { temp_element[j], temp_element[j + 1] }, line);

			line++;
		}

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