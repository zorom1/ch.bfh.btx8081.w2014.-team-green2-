package ch.bfh.btx8081.w2014.TeamGreen2.Gui;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Panel;


@Theme("mytheme.scss")
public class BorderPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private static final String WIDTH = "500px";
	private static final String HEIGHT = "800px";

	public BorderPanel(){
		addStyleName("v-panel-borderpanel");
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
	}
	

}
