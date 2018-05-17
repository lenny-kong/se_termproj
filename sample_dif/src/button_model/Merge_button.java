//new merge button


package button_model;

import java.awt.Dimension;
import java.io.*;
import java.util.*;

import javax.swing.JTextArea;

import button_controller.Merge_button_actionlistener;
import compare_algorithm.Compare_util_string;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import window_view.Icon_image_load;
import panel_model.Text_panel;
import compare_algorithm.String_object;


public class Merge_button extends Button_model{

	private final String default_image_path = "icon_image/merge/merge.png"; 
	private final String pushed_image_path = "icon_image/merge/merge_push.png";
	private final String mouseover_image_path = "icon_image/merge/merge_mouseover.png";

	
	private GUI_data_model gui_data_model;

	
	public Merge_button(GUI_data_model gui_data_model) {
		//Essential Part.
				//construct and set default image.
				super(Icon_image_load.load_image("icon_image/merge/merge.png"));
				
				//load image.
				this.default_icon = Icon_image_load.load_image(default_image_path);
				this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
				this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);
				
				//Set tooltip String.
				this.tooltip_text = "Merge";
			
				//set current icon image default.
				this.current_icon = default_icon;	
			
				//set gui_data_model
				this.gui_data_model = gui_data_model;
				//add its own actionlistener.
				Merge_button_actionlistener actionlistener = new Merge_button_actionlistener();
				this.addActionListener(actionlistener);
	}
				

	@SuppressWarnings("null")
	public void mergeLtoR( )  {
			
		String tmp; // to read a line in txt file
		String_object input_line; // to convert string to string_object
		
		List<String_object> l_list = new ArrayList<String_object>();
		List<String_object> r_list = new ArrayList<String_object>();
		
		try {
			StringReader sr_l = new StringReader(gui_data_model.getLeft_text_area().getText());
			BufferedReader br_l = new BufferedReader(sr_l);
			while((tmp=br_l.readLine())!=null) {
				
		
				input_line = new String_object(tmp);
				l_list.add(input_line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		try {
			StringReader sr_r = new StringReader(gui_data_model.getRight_text_area().getText());
			BufferedReader br_r = new BufferedReader(sr_r);
			
			while ((tmp=br_r.readLine())!=null)
			{
		
				input_line = new String_object(tmp);
				r_list.add(input_line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("오류");
			}
		
		
		gui_data_model.getRight_text_area().setText(null);
		
		for(int i =0;i<r_list.size();i++)
		{	
			if(r_list.get(i).get_string().length()!=0)
			{
				gui_data_model.getRight_text_area().append(r_list.get(i).get_string());
				gui_data_model.getRight_text_area().append("\n");
			}
		
			else {
				
				gui_data_model.getRight_text_area().append(l_list.get(i).get_string());
				gui_data_model.getRight_text_area().append("\n");

			}
		
			
		}
		if(l_list.size()>r_list.size())
		{
			for(int i=r_list.size();i<l_list.size();i++)
			{
				gui_data_model.getRight_text_area().append(l_list.get(i).get_string());
				gui_data_model.getRight_text_area().append("\n");
			}
		}
		
				
		
		
		
	}
	public GUI_data_model getGui_data_model() {
		return gui_data_model;}
	}
