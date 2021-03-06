package ch.bfh.btx8081.w2014.TeamGreen2.MHCPMS;



import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2014.TeamGreen2.HomeView.HomeView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.AddNewPatientView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CVSwitchView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CVView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.CaseView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.FindCasePIDView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.FindCaseView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.LoginView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.TimelineView;
import ch.bfh.btx8081.w2014.TeamGreen2.UI.AddNewDiagnosisView; 
import ch.bfh.btx8081.w2014.TeamGreen2.UI.PatientsRecordView; 
import ch.bfh.btx8081.w2014.TeamGreen2.UI.FindPatientView; 

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
    
    public static void setAddNewPatientView(AddNewPatientView addnewpatientview){
    	addnewpatientview.setImmediate(true);
    	navigator.addView("AddNewPatientView", addnewpatientview);
    	navigator.navigateTo("AddNewPatientView");
    }
    
    public static void setCVView(CVView cvview) {
		cvview.setImmediate(true);
		navigator.addView("CVView", cvview);
    	navigator.navigateTo("CVView");
	}
    
    public static void setFindCasePIDView(FindCasePIDView findPIDPanel) {
    	findPIDPanel.setImmediate(true);
		navigator.addView("FindCasePIDView", findPIDPanel);
    	navigator.navigateTo("FindCasePIDView");
	}
    
    public static void setTimelineView(TimelineView timelineview) {
		timelineview.setImmediate(true);
		navigator.addView("TimelineView", timelineview);
    	navigator.navigateTo("TimelineView");
	}
    public static void setCaseView(CaseView caseview){
    	caseview.setImmediate(true);
    	navigator.addView("CaseView", caseview);
    	navigator.navigateTo("CaseView");
    }
    public static void setFindCaseView(FindCaseView findcaseview){
    	findcaseview.setImmediate(true);
    	navigator.addView("FindCaseView", findcaseview);
    	navigator.navigateTo("FindCaseView");
    } 
    public static void setAddNewDiagnosisView (AddNewDiagnosisView addnewdiagnososview){
    	addnewdiagnososview.setImmediate(true);
    	navigator.addView("AddNewDiagnosisView", addnewdiagnososview);
    	navigator.navigateTo("AddNewDiagnosisView");
    } 
    public static void setPatientsRecordView (PatientsRecordView patientsrecordview1){
    	patientsrecordview1.setImmediate(true);
    	navigator.addView("PatientsRecordView", patientsrecordview1);
    	navigator.navigateTo("PatientsRecordView");
    } 
    public static void setFindPatientView (FindPatientView findpatientview){
    	findpatientview.setImmediate(true);
    	navigator.addView("FindPatientView", findpatientview);
    	navigator.navigateTo("FindPatientView");
    } 
    
    public static void setCVSwitchView (CVSwitchView setCVSwitchView){
    	setCVSwitchView.setImmediate(true);
    	navigator.addView("CVSwitchView", setCVSwitchView);
    	navigator.navigateTo("CVSwitchView");
    } 
    
}


