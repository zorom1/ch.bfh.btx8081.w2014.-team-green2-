package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;



import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class HomeView  extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;

	public HomeView() {
		setMargin(true);
		HomeLayout homeLayout = new HomeLayout();
		addComponent(homeLayout); 
		this.setComponentAlignment(homeLayout, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}}