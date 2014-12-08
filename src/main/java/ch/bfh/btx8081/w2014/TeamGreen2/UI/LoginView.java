package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.servlet.annotation.WebServlet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View
{        
	private static final long SerialVersionUID = 1L;
	
	public LoginView(){
		setMargin(true);
		
		
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();

		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath +
				"/META-INF/logoteamgreen.png"));

		// Show the image in the application
		Image image = new Image("", resource);
		addComponent(image);
		
	
	}
///*method of the interface View
// */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		//Notification.show("");
		}

}
