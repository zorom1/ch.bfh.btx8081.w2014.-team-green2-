package ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS;

/*class provides navigation from one view if the application to other
@author team green   
 */
//must be created second view to test navigator
//import ch.bfh.btx8081.w2014.Green.MHCPMS.MyVaadinUI;

import ch.bfh.btx8081.w2014.TeamGreen2.UI.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.LoginView;


import javax.servlet.annotation.WebServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;


@Theme("mytheme")
@SuppressWarnings("serial")

public class MyVaadinUI extends UI {
	@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
	
    private static Navigator navigator;
	protected static final String HOMEVIEW="HomeView";
	protected static final String PATIENTVIEW="PatientView";
	protected static final String CASEVIEW="CaseView";
	protected static final String MEDICATIONSVIEW="MedicationsView";
	protected static final String DAGNOSISVIEW="DiagnosisView";
	protected static final String LOGINVIEW ="LoginView";
	
	@Override
	protected void init(VaadinRequest request){
		getPage().setTitle("Information System");    
		 navigator= new Navigator(this,this);
		 
		 LoginView myLoginView= new LoginView();
			navigator.addView("LoginView",myLoginView);
			navigator.navigateTo(LOGINVIEW);
		 
	//	 HomeView myHomeView= new HomeView();
	//	navigator.addView("HomeView",myHomeView);
	//	navigator.addView(HOMEVIEW, myHomeView);
	//	navigator.navigateTo(HOMEVIEW);
	}

	//public static void navigateTo(String view)
   // {
     //   navigator.navigateTo(view);
   // }



}
