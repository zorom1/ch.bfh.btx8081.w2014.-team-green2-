package ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS;



import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CVView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.LoginView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.TimelineView;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.ui.UI;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.VaadinServletConfiguration;


@Theme("mytheme")
@SuppressWarnings("serial")
@Push(PushMode.MANUAL)
public class MyVaadinUI extends UI
{
	private static Navigator navigator; 
	
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {   	
    	getPage().setTitle("MHCPMSGreen");    	
    	navigator = new Navigator(this, this);    	
    	LoginView loginview = new LoginView();
    	navigator.addView("Login", loginview);
    	navigator.navigateTo("Login"); 	
    }
    
    public static void setHomeView(HomeView homeview) {
		homeview.setImmediate(true);
		navigator.addView("HomeView", homeview);
    	navigator.navigateTo("HomeView");
	}
    
    public static void setCVView(CVView cvview) {
		cvview.setImmediate(true);
		navigator.addView("CVView", cvview);
    	navigator.navigateTo("CVView");
	}
    
    public static void setTimelineView(TimelineView timelineview) {
		timelineview.setImmediate(true);
		navigator.addView("TimelineView", timelineview);
    	navigator.navigateTo("TimelineView");
	}
}

//@Override
//protected void init(VaadinRequest request) {   	
//	getPage().setTitle("MHCPMSGreen");    	
//	navigator = new Navigator(this, this);    	
//	TimelineView timelineview = new TimelineView();
//	navigator.addView("Timeline", timelineview);
//	navigator.navigateTo("Timeline"); 	
//}

//@Override
//protected void init(VaadinRequest request) {   	
//	getPage().setTitle("MHCPMSGreen");    	
//	navigator = new Navigator(this, this);    	
//	CVView CVview = new CVView();
//	navigator.addView("CV", CVview);
//	navigator.navigateTo("CV"); 	
//}

//@Theme("mytheme")
//@SuppressWarnings("serial")
//
//public class MyVaadinUI extends UI {
//	@WebServlet(value = "/*", asyncSupported = true)
//  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS.AppWidgetSet")
//  public static class Servlet extends VaadinServlet {
//  }
//	
//  private static Navigator navigator;
//	protected static final String HOMEVIEW="HomeView";
//	protected static final String PATIENTVIEW="PatientView";
//	protected static final String CASEVIEW="CaseView";
//	protected static final String MEDICATIONSVIEW="MedicationsView";
//	protected static final String DAGNOSISVIEW="DiagnosisView";
//	protected static final String LOGINVIEW ="LoginView";
//	
//	@Override
//	protected void init(VaadinRequest request){
//		getPage().setTitle("Information System");    
//		 navigator= new Navigator(this,this);
//		 
//		 LoginView myLoginView= new LoginView();
//			navigator.addView("LoginView",myLoginView);
//			navigator.navigateTo(LOGINVIEW);
//		 
//	//	 HomeView myHomeView= new HomeView();
//	//	navigator.addView("HomeView",myHomeView);
//	//	navigator.addView(HOMEVIEW, myHomeView);
//	//	navigator.navigateTo(HOMEVIEW);
//	}
//
//	//public static void navigateTo(String view)
// // {
//   //   navigator.navigateTo(view);
// // }
//
//
//
//}
