package ch.bfh.btx8081.w2014.TeamGreen2.UI;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class CVView extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;

	public CVView() {
		setMargin(true);
		CVLayout CVPanel = new CVLayout();
		addComponent(CVPanel); 
		
		// create the "login" panel and add it to the login view.
		this.setComponentAlignment(CVPanel, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
