package panel_model;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import data_model.GUI_data_model;

public class Button_text_panel extends JPanel{
	
	public Button_panel button_panel;
	public Text_panel text_panel;
	public GUI_data_model.location location;
	
	//Own size.
	public static final int width = 400;
	public static final int height = 700;
	
	public Button_text_panel(GUI_data_model.location location, GUI_data_model gui_data_model) 
	{
		super();
		
		this.location = location;
		text_panel = new Text_panel(location, gui_data_model);
		button_panel = new Button_panel(gui_data_model);
		
		//Use borderLayout.
		this.setLayout(new BorderLayout());
		
		this.add(button_panel, "North");
		this.add(text_panel, "Center");
		
		this.setBackground(Color.gray);
	}
}
