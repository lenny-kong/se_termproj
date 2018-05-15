package button_model;

import java.awt.Color;
import java.awt.Dimension;

import button_controller.Refresh_button_actionlistener;
import data_model.GUI_data_model;
import data_model.Pastel_color;
import panel_model.Background_line_graphics_panel;
import panel_model.Left_overview_panel;
import panel_model.Text_panel;
import window_view.Icon_image_load;

public class Refresh_button extends Button_model{

	private final String default_image_path = "icon_image/refresh/refresh.png";
	private final String pushed_image_path = "icon_image/refresh/refresh_push.png";
	private final String mouseover_image_path = "icon_image/refresh/refresh_mouseover.png";
	
	private Left_overview_panel left_overview_panel;
	private Background_line_graphics_panel left_background_graphics_panel;
	private Background_line_graphics_panel right_background_graphics_panel;
	
	public Refresh_button(GUI_data_model gui_data_model) {
		//construct and set default image.
				super(Icon_image_load.load_image("icon_image/refresh/refresh.png"));
				
				//load image.
				this.default_icon = Icon_image_load.load_image(default_image_path);
				this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
				this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);
				
				//Set tooltip String.
				this.tooltip_text = "Refresh";
			
				//set current icon image default.
				this.current_icon = default_icon;	
				
				//make buttons transparent.
				this.setContentAreaFilled(false);
				//delete borderline.
				this.setBorderPainted(false);
				//set button size.
				this.setPreferredSize(new Dimension(24,24));
				
				//Test implements.
				this.left_overview_panel = gui_data_model.getLeft_overview_panel();
				this.left_background_graphics_panel= gui_data_model.getLeft_background_graphics_panel();
				this.right_background_graphics_panel = gui_data_model.getRight_background_graphics_panel();
				
				//Add its own ActionListener.
				this.addActionListener(new Refresh_button_actionlistener());
	}
	
	//Called when Refresh button is pushed. for TEST.
	public void refresh() {
		//repaint left overview panel.
		this.left_overview_panel.item_num++;
		this.left_overview_panel.repaint();
		
		//repaint left text panel.
		this.left_background_graphics_panel.repaint();
	}
}
