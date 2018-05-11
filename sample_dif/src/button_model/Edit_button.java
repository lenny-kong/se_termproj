package button_model;

import java.awt.Dimension;

import javax.swing.*;

import button_controller.*;
import common_util_lib.Utility;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

@SuppressWarnings("serial")
public class Edit_button extends Button_model{
	
	//derived properties
	private ImageIcon pushed_icon;
	
	//Own properties
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	
	private boolean is_pushed = false;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(GUI_data_model gui_data_model) 
	{
		//construct and set default image.
		super(Icon_image_load.load_image("icon_image/edit.png"));
		
		//load image.
		this.default_icon = Icon_image_load.load_image("icon_image/edit.png");
		this.pushed_icon = Icon_image_load.load_image("icon_image/edit_push.png");
		this.mouseover_icon = Icon_image_load.load_image("icon_image/edit_mouseover.png");
	
		this.current_icon = default_icon;	
		
		//make buttons transparent.
		this.setContentAreaFilled(false);
		//delete borderline.
		this.setBorderPainted(false);
		//set button size.
		this.setPreferredSize(new Dimension(24,24));
		
		//get each textarea.
		this.left_text_area = gui_data_model.getLeft_text_area();
		this.right_text_area = gui_data_model.getRight_text_area();
		
		//add actionlistener.
		Edit_button_actionlistener actionlistener = new Edit_button_actionlistener();
		Button_mouselistener mouselistener = new Button_mouselistener();
		this.addActionListener(actionlistener);
		this.addMouseListener(mouselistener);
	}
	
	/*
	 * Change is_pushed state.
	 */
	public void button_toggle() 
	{
		this.is_pushed = Utility.bool_reverse(is_pushed);
		set_edit_mode(is_pushed);
		change_image();
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
	 * Change images.
	 */
	private void change_image() 
	{
		if(!this.is_pushed) 
		{
			this.current_icon = this.default_icon;
			this.setIcon(this.current_icon);
		}
		else 
		{
			this.current_icon = this.pushed_icon;
			this.setIcon(this.current_icon);
		}
	}
}
