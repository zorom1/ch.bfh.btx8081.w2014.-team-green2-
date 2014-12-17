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
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
* Following class provides the Timeline View 
* 
*/

public class TimelineLayout extends BorderPanel {
	
	private static final long serialVersionUID = 1L;
	private Label title;
	private Link linkTimeline;
	private Image timelinepreview;
	private Panel panel;
	private Label space;
	private Button exitbutton;

	
	public TimelineLayout() {
		
		this.title = new Label("Timeline");
		this.title.setWidth(null);
		this.timelinepreview = new Image();
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		this.timelinepreview.setIcon(new FileResource(new File(basepath + "/META-INF/ExampleTimeLine.png")));
		this.timelinepreview.setWidth("500px");
		this.linkTimeline = new Link("Download & View Timeline", new ExternalResource("http://medicaltimeline.jimdo.com/app/download/10876697625/Example+Timeline+Jane+Smith.xlsx?t=1417863942"));
		this.space = new Label("");
		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.title);
		vertlayout.setComponentAlignment(this.title, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(this.timelinepreview);
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(this.linkTimeline);
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(createHomeViewButton());

		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}
	
	/**
	 * Creates the "Exit" Button to enter the application.
	 * 
	 * @return Button
	 */
	
	public Button createHomeViewButton() {
		exitbutton = new Button("Exit");
		exitbutton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setHomeView(new HomeView());
			}
		});
		return exitbutton;
	}
}