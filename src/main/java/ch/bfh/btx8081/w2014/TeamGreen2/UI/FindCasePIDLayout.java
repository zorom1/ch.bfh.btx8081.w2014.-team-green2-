package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2014.TeamGreen2.Controller.FindFunctionAllCasesPID;
import ch.bfh.btx8081.w2014.TeamGreen2.Controller.StatePatternInterface;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

public class FindCasePIDLayout extends BorderPanel implements
		StatePatternInterface {

	private static final long serialVersionUID = 1L;
	private Button IndexButton;
	private Label label;
	private Panel panel;

	public FindCasePIDLayout() {
		this.label = new Label("Looking for all PID cases");
		this.label.setWidth(null);
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.label);
		vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(createTable());
		vertlayout.addComponent(createBackButton());
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}

	public Table createTable() {
		Table table = new Table("");

		// Define the columns for the built-in container

		table.addContainerProperty("Case Nb ", String.class, null);
		table.addContainerProperty(" Patient ", String.class, null);
		table.addContainerProperty(" PID Doctor ", String.class, null);
		table.addContainerProperty(" Start Date ", String.class, null);
		table.addContainerProperty(" End Date ", String.class, null);
		table.addContainerProperty(" Description ", String.class, null);
		String[] temp_element = new String[6];
		int i = 0;
		int line = 1;

		while (i < FindFunctionAllCasesPID.FindPIDResults.size() - 1) {
			for (int j = 0; j < 6; j++) {
				String myArray = FindFunctionAllCasesPID.FindPIDResults.get(i);
				temp_element[j] = myArray;

				i++;
			}
			int j = 0;

			table.addItem(new Object[] { temp_element[j], temp_element[j + 1],
					temp_element[j + 2], temp_element[j + 3],
					temp_element[j + 4], temp_element[j + 5] }, line);

			line++;
		}
if (FindFunctionAllCasesPID.FindPIDResults.size()==0){
			
	Notification.show("No cases are found!");
		}
		return table;
		
	}

	private Button createBackButton() {
		IndexButton = new Button("Back");
		IndexButton.addStyleName("big");
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				State2();
			}
		});
		return IndexButton;
	}

	@Override
	public void State1() {
		MyVaadinUI.setCaseView(new CaseView());

	}

	@Override
	public void State2() {
		// TODO Auto-generated method stub
		MyVaadinUI.setFindCaseView(new FindCaseView());
	}

	@Override
	public void State3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void State4() {
		// TODO Auto-generated method stub

	}
}