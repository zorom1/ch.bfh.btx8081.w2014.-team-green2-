package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Panel;

/**
 * The following class provides the Panel for the View.
 * The main window is fixed for the size of 620x800px
 * @author JD
 *
 */

@Theme("mytheme.scss")
public class BorderPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private static final String WIDTH = "670px";
	private static final String HEIGHT = "800px";

	public BorderPanel(){
		addStyleName("");
		//this.setSizeFull();
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
	}
	

}
