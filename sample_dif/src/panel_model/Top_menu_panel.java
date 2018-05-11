package panel_model;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import button_model.*;
import data_model.GUI_data_model;

public class Top_menu_panel extends JPanel{

	public Edit_button edit_button;
	
	//Sample button. This will be replaced other functional buttons.
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton button6;
	public JButton button7;
	public JButton button8;
	
	//Own size.
	public static final int width = 1000;
	public static final int height = 50;
	
	public Top_menu_panel(GUI_data_model gui_data_model) 
	{
		super();
		
		//Use FlowLayout.
		this.setLayout(new FlowLayout());
		
		edit_button = new Edit_button(gui_data_model);
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		
		this.add(edit_button);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		this.add(button7);
		this.add(button8);
		
		this.setBackground(Color.yellow);
	}
}
