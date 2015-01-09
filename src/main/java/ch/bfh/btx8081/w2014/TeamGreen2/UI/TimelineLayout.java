package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * The Following Class provides a View of the external medical events of the Patient. 
 * The data is written in an Excel-File which is placed on an external timeline-server (here simulated with
 * the website medicaltimeline.jimdo.com. The doctor can download that external Excel-File and see all the
 * medical events of the Patient that have occured.
 * @author JD
 *
 */

public class TimelineLayout extends BorderPanel {
	
	private static final long serialVersionUID = 1L;
	private Label title;
	private Link linkTimeline;
	private Image timelinepreview;
	private Panel panel;
	private Label space;
	private Label space1;
	private Button homebutton;

	/**
	 * This method implements the layout and the link of the timeline, with a preview of the timeline,
	 * here simulated with a screenshot.
	 */
	
	public TimelineLayout() {
		
		this.title = new Label("Timeline");
		this.title.setWidth(null);
		this.timelinepreview = new Image();
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		this.timelinepreview.setIcon(new FileResource(new File(basepath + "/META-INF/ExampleTimeLine.png")));
		this.linkTimeline = new Link("Download & View Timeline", new ExternalResource("http://medicaltimeline.jimdo.com/app/download/10998507525/Example%20Timeline%20Jane%20Smith.xlsx?t=1420731065"));
		
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
		vertlayout.addComponent(this.timelinepreview);
		vertlayout.addComponent(this.linkTimeline);
		vertlayout.addComponent(this.space1);
		vertlayout.addComponent(createHomeViewButton());
		
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
		
	}
	
	/**
	 * Creates the "Home" Button to exit the application and return to the HomeView.
	 * 
	 * @return Button
	 */
	
	public Button createHomeViewButton() {
		homebutton = new Button("Home");
		homebutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setHomeView(new HomeView());
			}
		});
		return homebutton;
	}
}