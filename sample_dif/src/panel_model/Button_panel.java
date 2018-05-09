package panel_model;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import button_model.*;
import data_model.GUI_data_model;

public class Button_panel extends JPanel{

	//Other button would be implemented.
	public JButton button1;
	public JButton button2;
	public JButton button3;
	
	public Button_panel(GUI_data_model gui_data_model) 
	{
		super();
		
		//Use FlowLayout.
		this.setLayout(new FlowLayout());
		
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
		this.setBackground(Color.red);
	}
}
