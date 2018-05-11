package button_model;

import java.awt.BorderLayout;

import javax.swing.*;

import button_controller.*;
import common_util_lib.Utility;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

@SuppressWarnings("serial")
public class Edit_button extends JButton{
	
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	private boolean is_pushed = false;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(GUI_data_model gui_data_model) 
	{
		super(Icon_image_load.load_image("icon_image/edit_unpushed_icon.png"));
	
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setSize(20, 20);
		
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
	 * Change is_pushed state.
	 */
	public void button_toggle() 
	{
		this.is_pushed = Utility.bool_reverse(is_pushed);
		set_edit_mode(is_pushed);
	}
	
	/*
	 * Set name.(For test)
	 */
	public void set_name(String name) 
	{
		this.setName(name);
	}
	
	/*
	 * set mode.
	 */
	private void set_edit_mode(boolean mode) 
	{
		left_text_area.setEditable(mode); 
		right_text_area.setEditable(mode);
	}
	
	/*
	 * Getter & Setter.
	 */
	public JTextArea getRight_text_area() {
		return right_text_area;
	}
	
	public JTextArea getLeft_text_area() {
		return left_text_area;
	}

	public boolean get_is_pushed() {
		return is_pushed;
	}

	
}
