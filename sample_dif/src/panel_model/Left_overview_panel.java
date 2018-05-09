package panel_model;

import java.awt.Color;

import javax.swing.JPanel;

import data_model.GUI_data_model;

public class Left_overview_panel extends JPanel{

	//Own size.
	public static final int width = 100;
	public static final int height = 700;
	
	public Left_overview_panel(GUI_data_model gui_data_model) 
	{
		super();
		
		this.setBackground(Color.cyan);
	}
}
