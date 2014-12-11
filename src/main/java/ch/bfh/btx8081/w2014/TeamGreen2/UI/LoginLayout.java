package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;

import ch.bfh.btx8081.w2014.TeamGreen2.Gui.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
* Following class provides the Login View 
* 
*/

public class LoginLayout extends BorderPanel {
	
	private static final long serialVersionUID = 1L;
	private Button IndexButton;
	private Label label;
	private Image loginicon;
	private Panel panel;
	private Label userid; 
	private Label pw;
	private TextField user;
	private PasswordField password; 
	private Label space;
	
	
	
	public LoginLayout() {
		
		this.label = new Label("MHC-PMS Doctor");
		this.label.setWidth(null);
		this.loginicon = new Image();
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

		this.loginicon.setIcon(new FileResource(new File(basepath + "/META-INF/logomhcsmall.png")));
		this.userid = new Label ("User ID");
		this.user = new TextField();
		this.pw = new Label("Password");
		this.password = new PasswordField();
		this.space = new Label("");
		
		
		
		


		this.panel = new Panel();
		this.panel.setStyleName("borderless");
		this.panel.setSizeFull();
		
		VerticalLayout vertlayout = new VerticalLayout();
		FormLayout forlayout = new FormLayout();
		vertlayout.addComponent(this.label);
		vertlayout.setComponentAlignment(this.label, Alignment.TOP_CENTER);
		vertlayout.addComponent(this.loginicon);
		vertlayout.setComponentAlignment(this.loginicon, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.userid);
//		vertlayout.setComponentAlignment(this.userid, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.user);
//		vertlayout.setComponentAlignment(this.user, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.pw);
//		vertlayout.setComponentAlignment(this.pw, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.password);
//		vertlayout.setComponentAlignment(this.password, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.space);
//		vertlayout.setComponentAlignment(this.space, Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(createHomeViewButton());
		vertlayout.setComponentAlignment(IndexButton, Alignment.BOTTOM_CENTER);
		
		
		
		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}
	
	/**
	 * Creates the user input field
	 * 
	 * @return username 
	 */

	
	
	
	/**
	 * Creates the "Enter" Button to enter the application.
	 * 
	 * @return Button
	 */
	
	public Button createHomeViewButton() {
		IndexButton = new Button("Login");
		IndexButton.addStyleName("big");
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID =1L;
			public void buttonClick(ClickEvent event) {
				MyVaadinUI.setHomeView(new HomeView());
			}
		});
		return IndexButton;
	}
}