/**
 * The following class provides the methods that the Layout is added to the View
 * of the application and can be switched to another View.
 * 
 * @author Manuel
 */
package ch.bfh.btx8081.w2014.TeamGreen2.UI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class FindCasePIDView extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;

	public FindCasePIDView() {
		setMargin(true);
		FindCasePIDLayout findPIDPanel = new FindCasePIDLayout();
		addComponent(findPIDPanel); 
		this.setComponentAlignment(findPIDPanel, Alignment.MIDDLE_CENTER);
	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
