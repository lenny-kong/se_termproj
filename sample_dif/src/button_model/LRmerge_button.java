package button_model;

import java.awt.Dimension;
import java.io.*;
import java.util.*;

import javax.swing.*;

import button_controller.LRmerge_button_actionlistener;
import compare_algorithm.Compare_util_string;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import window_view.Icon_image_load;
import panel_model.Text_panel;
import compare_algorithm.String_object;


public class LRmerge_button extends Button_model{
 
	private final String default_image_path = "icon_image/LRmerge/LRmerge.png"; 
	private final String pushed_image_path = "icon_image/LRmerge/LRmerge_push.png";
	private final String mouseover_image_path = "icon_image/LRmerge/LRmerge_mouseover.png";

	
	private GUI_data_model gui_data_model;

	
	public LRmerge_button(GUI_data_model gui_data_model) {
		//Essential Part.
				//construct and set default image.
				super(Icon_image_load.load_image("icon_image/LRmerge/LRmerge.png"));
				
				//load image.
				this.default_icon = Icon_image_load.load_image(default_image_path);
				this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
				this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);
				
				//Set tooltip String.
				
				//this.tooltip_text = "Merge";
				this.tooltip_text = "Left to Right Merge";
				//set current icon image default.
				this.current_icon = default_icon;	
			
				//set gui_data_model
				this.gui_data_model = gui_data_model;
				//add its own actionlistener.
				LRmerge_button_actionlistener actionlistener = new LRmerge_button_actionlistener();
				this.addActionListener(actionlistener);
	}
				
	public GUI_data_model getGui_data_model()
	{
		return gui_data_model;
	}	

	/*
	 * merge Left to Right
	 * */
	public void merge(JTextArea source,JTextArea target)  {
			
		String tmp; // to read a line in txt file
		String_object input_line; // to convert string to string_object
		
		//to contain textArea contents
		List<String_object> l_list = new ArrayList<String_object>();
		List<String_object> r_list = new ArrayList<String_object>();
		
		//read Left_TextArea and put text in l_list
		try {
			StringReader sr = new StringReader(source.getText());
			BufferedReader br = new BufferedReader(sr);
			while((tmp=br.readLine())!=null) {
				
		
				input_line = new String_object(tmp);
				l_list.add(input_line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//read Right_TextArea and put text in R_list
		try {
			StringReader sr = new StringReader(target.getText());
			BufferedReader br= new BufferedReader(sr);
			
			while ((tmp=br.readLine())!=null)
			{
		
				input_line = new String_object(tmp);
				r_list.add(input_line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		
		//set Right_text_area to null
		target.setText(null);
		
		//merge Left to Right
		
		for(int i =0;i<r_list.size();i++)
		{	
			if(r_list.get(i).get_string().length()!=0)
			{
				target.append(r_list.get(i).get_string());
				target.append("\n");
			}
		
			else {
				
				target.append(l_list.get(i).get_string());
				target.append("\n");

			}
		}
		
		if(l_list.size()>r_list.size())
		{
			for(int i=r_list.size();i<l_list.size();i++)
			{
				target.append(l_list.get(i).get_string());
				target.append("\n");
			}
		}
		//change background color.
		gui_data_model.getLeft_background_graphics_panel().setRefresh_button_false();
		gui_data_model.getRight_background_graphics_panel().setRefresh_button_false();
		gui_data_model.getLeft_background_graphics_panel().repaint();
		gui_data_model.getRight_background_graphics_panel().repaint();		
		
				
		
		
		
	}

}
