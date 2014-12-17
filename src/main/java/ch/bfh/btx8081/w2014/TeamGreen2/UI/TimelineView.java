package ch.bfh.btx8081.w2014.TeamGreen2.UI;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class TimelineView extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;

	public TimelineView() {
		setMargin(true);
		TimelineLayout TimelinePanel = new TimelineLayout();
		addComponent(TimelinePanel); 
		
		// create the "login" panel and add it to the login view.
		this.setComponentAlignment(TimelinePanel, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
