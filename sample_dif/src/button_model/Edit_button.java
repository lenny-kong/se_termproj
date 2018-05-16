package button_model;

import javax.swing.*;

import button_controller.*;
import common_util_lib.Utility;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

@SuppressWarnings("serial")
public class Edit_button extends Button_model{
	
	//Own properties
	private boolean is_pushed = false;
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	
	//Image file path(Essential Part).
	private final String default_image_path = "icon_image/edit/edit.png";
	private final String pushed_image_path = "icon_image/edit/edit_push.png";
	private final String mouseover_image_path = "icon_image/edit/edit_mouseover.png";

	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(GUI_data_model gui_data_model) 
	{
		//Essential Part.
		//construct and set default image.
		super(Icon_image_load.load_image("icon_image/edit/edit.png"));
		
		//load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);
		
		//Set tooltip String.
		this.tooltip_text = "Edit";
	
		//set current icon image default.
		this.current_icon = default_icon;	
		
		//Selective Part.
		//get each textarea to control.
		this.left_text_area = gui_data_model.getLeft_text_area();
		this.right_text_area = gui_data_model.getRight_text_area();
		
		//add its own actionlistener.
		Edit_button_actionlistener actionlistener = new Edit_button_actionlistener();
		this.addActionListener(actionlistener);
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
