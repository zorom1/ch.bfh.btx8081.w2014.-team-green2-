package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.io.File;

import ch.bfh.btx8081.w2014.TeamGreen2.Controller.StatePatternInterface;
import ch.bfh.btx8081.w2014.TeamGreen2.Controller.LogAuthor;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.BorderPanel;
import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.MyVaadinUI;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * The following class provides the Layout of a Login View. It displays an input
 * for username and password. The information of the username and password is
 * sent to another class to check correctness of the data.
 * 
 * @author JD
 *
 */

public class LoginLayout extends BorderPanel implements StatePatternInterface {

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
	private String MyResult = null;

	public LoginLayout() {

		this.label = new Label("MHC-PMS Doctor");
		this.label.setWidth(null);
		this.loginicon = new Image();
		// Find the application directory for the logo
		String basepath = VaadinService.getCurrent().getBaseDirectory()
				.getAbsolutePath();

		this.loginicon.setIcon(new FileResource(new File(basepath
				+ "/META-INF/logomhcsmall.png")));
		this.userid = new Label("User ID");
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
		vertlayout.setComponentAlignment(this.loginicon,Alignment.MIDDLE_CENTER);
		vertlayout.addComponent(this.userid);
		vertlayout.addComponent(this.user);
		vertlayout.addComponent(this.pw);
		vertlayout.addComponent(this.password);
		vertlayout.addComponent(this.space);
		vertlayout.addComponent(createHomeViewButton());
		vertlayout.setComponentAlignment(this.IndexButton,Alignment.MIDDLE_CENTER);

		forlayout.addComponent(vertlayout);
		forlayout.setSizeFull();
		this.panel.setContent(forlayout);
		setContent(panel);
	}

	/**
	 * This method creates the "Login" Button to enter the application.
	 * 
	 * @return Button
	 */

	public Button createHomeViewButton() {
		IndexButton = new Button("Login");
		IndexButton.addStyleName("big");
		IndexButton.setClickShortcut(KeyCode.ENTER);
		IndexButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {

				final String MyLog = user.getValue();
				final String MyPass = password.getValue();
				LogAuthor logAuthor = new LogAuthor();
				logAuthor.CheckAcces(MyLog, MyPass);

				MyResult = logAuthor.getResult();

				if (MyResult == "true") {
					// MyVaadinUI.setHomeView(new HomeView());
					State1();
				} else {
					// MyVaadinUI.setLoginView(new LoginView());
					Notification.show("Login is not correct.");
				}

			}
		});

		return IndexButton;
	}

	@Override
	public void State1() {
		MyVaadinUI.setHomeView(new HomeView());
		// MyVaadinUI.setCaseView(new CaseView());
	}

	@Override
	public void State2() {

	}

	@Override
	public void State3() {

	}

	@Override
	public void State4() {

	}
}