package ch.bfh.btx8081.w2014.TeamGreen2.HomeView;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Panel;


@Theme("mytheme.scss")
public class BorderPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private static final String WIDTH = "620px";
	private static final String HEIGHT = "800px";

	public BorderPanel(){
		addStyleName("");
		this.setSizeFull();
		//this.setWidth(WIDTH);
		//this.setHeight(HEIGHT);
	}
	

}
