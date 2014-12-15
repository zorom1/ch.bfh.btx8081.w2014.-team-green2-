package ch.bfh.btx8081.w2014.TeamGreen2.UI;

/*Class HomeView shows a view which the user get after successful authorisation;
 * on the screen are 5 buttons
@author team green  */


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.BaseTheme;


public class HomeView1 extends VerticalLayout implements View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GridLayout gridLayout;

/*Buttons which user can use for change to other views
  */
	private Button patientButton;
    private Button caseButton;
    private Button medicationsButton;
    private Button diagnosisButton;
    private Button exitButton;
  
public HomeView1()
{
   VerticalLayout layout= new VerticalLayout();
   	layout.setSizeFull();
   	
   	buildVertGridLayout();
   	}
 private GridLayout buildVertGridLayout() {
	
	gridLayout = new GridLayout(1, 5);
	gridLayout.addStyleName("Buttons");
	gridLayout.setWidth("600px");
	gridLayout.setHeight("600px");
	
	 patientButton= new Button("Patient");
	 patientButton.setStyleName(BaseTheme.BUTTON_LINK);
	 patientButton.setWidth("100%");
	 patientButton.setHeight("100%");
	 
	gridLayout.addComponent(patientButton);
	/*change from HomeView to PatientView 
	 */
	patientButton.addClickListener(new Button.ClickListener() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

				
		public void buttonClick(ClickEvent event) {
		//	navigator.navigateTo(PATIENTVIEW);
		//must make Navigator	
		}
	});
	caseButton= new Button("Case");
	caseButton.setStyleName(BaseTheme.BUTTON_LINK);
	caseButton.setWidth("100%");
	caseButton.setHeight("100%");
	gridLayout.addComponent(caseButton);
	caseButton.addClickListener(new Button.ClickListener() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			//navigator.navigateTo(CASEVIEW);
		}
	}); 
	medicationsButton= new Button("Medications");
	/*The button looks like a hyperlink 
	 */
	medicationsButton.setStyleName(BaseTheme.BUTTON_LINK);
	medicationsButton.setWidth("100%");
	medicationsButton.setHeight("100%");
	gridLayout.addComponent(medicationsButton);
	medicationsButton.addClickListener(new Button.ClickListener() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			//navigator.navigateTo(MEDICATIONSVIEW);
		}
	}); 
	diagnosisButton= new Button("Diagnosis");
	diagnosisButton.setStyleName(BaseTheme.BUTTON_LINK);
	diagnosisButton.setWidth("100%");
	diagnosisButton.setHeight("100%");
	gridLayout.addComponent(diagnosisButton);
	diagnosisButton.addClickListener(new Button.ClickListener() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			//navigator.navigateTo(DIAGNOSISVIEW);
		}
	});
	/*button "Exit is for termination of program"
	 * 
	 */
	
	exitButton= new Button("Exit");
	exitButton.setStyleName(BaseTheme.BUTTON_LINK);
	exitButton.setWidth("100%");
	exitButton.setHeight("100%");
	gridLayout.addComponent(exitButton);
	exitButton.addClickListener(new Button.ClickListener() {
		
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			//where to navigate to terminate?:)
			
			 //close(); 
						

		}
	}); 
	return gridLayout;
}
/*method of the interface View
  */
@Override
public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	//Notification.show("Welcome");
	}

}
