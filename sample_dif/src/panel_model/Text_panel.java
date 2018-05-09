package panel_model;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import data_model.GUI_data_model;

public class Text_panel extends JPanel{
		
	public JTextArea text_area;
	
	public Text_panel(GUI_data_model.location location, GUI_data_model gui_data_model) 
	{
		super();
		
		this.text_area = new JTextArea();
		this.text_area.setEditable(false);
		
		//Set each text_area of GUI data model.
		if(location == GUI_data_model.location.LEFT)
			gui_data_model.setLeft_text_area(this.text_area);
		else if(location == GUI_data_model.location.RIGHT)
			gui_data_model.setRight_text_area(this.text_area);
		
		//Use BorderLayout.
		this.setLayout(new BorderLayout());
		
		this.add(text_area, "Center");
		
		//This color may not be shown cause of BorderLayout.
		this.setBackground(Color.green);
	}
}
