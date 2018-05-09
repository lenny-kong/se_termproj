package button_model;

import javax.swing.*;

import button_controller.*;
import data_model.GUI_data_model;

@SuppressWarnings("serial")
public class Edit_button extends JButton{
	
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	private boolean is_pushed = false;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(String name, Icon image, GUI_data_model gui_data_model) 
	{
		super(name, image);
		
		this.left_text_area = gui_data_model.getLeft_text_area();
		this.right_text_area = gui_data_model.getRight_text_area();
		
		Edit_button_actionlistener actionlistener = new Edit_button_actionlistener();
		this.addActionListener(actionlistener);
	}
	
	/*
	 * Default Constructor
	 */
	public Edit_button(String name) 
	{
		super(name);
	}
	
	/*
	 * set mode.
	 */
	public void set_edit_mode() 
	{
		left_text_area.setEditable(!get_is_pushed()); 
		right_text_area.setEditable(!get_is_pushed());
	}
	
	/*
	 * Set name.(For test)
	 */
	public void set_name(String name) 
	{
		this.setName(name);
	}

	public JTextArea getRight_text_area() {
		return right_text_area;
	}
	
	public JTextArea getLeft_text_area() {
		return left_text_area;
	}

	public boolean get_is_pushed() {
		return is_pushed;
	}

	public void set_is_pushed(boolean is_pushed) {
		this.is_pushed = is_pushed;
	}
}
