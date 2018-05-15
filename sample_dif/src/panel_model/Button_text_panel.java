package panel_model;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import data_model.GUI_data_model;

public class Button_text_panel extends JPanel{
	
	//Own size.
	public static final int width = 400;
	public static final int height = 700;
	
	//Own panels contains.
	private Button_panel button_panel;
	private Text_panel text_panel;
	
	//Location.
	public GUI_data_model.location location;

	public Button_text_panel(GUI_data_model.location location, GUI_data_model gui_data_model) 
	{
		super();
		
		this.location = location;
		this.text_panel = new Text_panel(location, gui_data_model);
		this.button_panel = new Button_panel(gui_data_model);

		
		//Use borderLayout.
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(this.button_panel, "North");
		this.add(this.text_panel, "Center");
		
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}
}
