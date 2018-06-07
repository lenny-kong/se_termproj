package button_model;
import common_util_lib.*;

import java.util.*;

import javax.swing.*;

import button_controller.LRmerge_button_actionlistener;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

public class LRmerge_button extends Button_model {

	private final String default_image_path = "icon_image/LRmerge/LRmerge.png";
	private final String pushed_image_path = "icon_image/LRmerge/LRmerge_push.png";
	private final String mouseover_image_path = "icon_image/LRmerge/LRmerge_mouseover.png";

	private GUI_data_model gui_data_model;

	public LRmerge_button(GUI_data_model gui_data_model) {
		// Essential Part.
		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/LRmerge/LRmerge.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.

		// this.tooltip_text = "Merge";
		this.tooltip_text = "Left to Right Merge";
		// set current icon image default.
		this.current_icon = default_icon;

		// set gui_data_model
		this.gui_data_model = gui_data_model;
		// add its own actionlistener.
		LRmerge_button_actionlistener actionlistener = new LRmerge_button_actionlistener();
		this.addActionListener(actionlistener);
	}

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	}

	/*
	 * merge Left to Right
	 */
	public void merge(JTextArea source, JTextArea target) {

		if (source != null) {
			

			// to contain textArea contents
			List<String_object> source_list = new ArrayList<String_object>();
			List<String_object> target_list = new ArrayList<String_object>();

			// read TextArea and put text in list
			Utility.textarea_to_list(source, source_list);
			Utility.textarea_to_list(target, target_list);

			// set Right_text_area to null
			target.setText(null);

			// merge Left to Right
			for (int i = 0; i < target_list.size(); i++) {
				if (target_list.get(i).get_string().equals("")) {
					target.append(source_list.get(i).get_string());
					target.append("\n");
				}

				else {
					target.append(target_list.get(i).get_string());
					target.append("\n");

				}
			}

			if (source_list.size() > target_list.size()) {
				for (int i = target_list.size(); i < target_list.size(); i++) {
					target.append(source_list.get(i).get_string());
					target.append("\n");
				}
			}
			
		
			
			// after merge, read TextArea and put text in target_list
			Utility.textarea_to_list(target, target_list);
			
			//put target_list in gui_data_model's Right_list
			gui_data_model.setRight_list(target_list);
		
			// change background color.
			gui_data_model.setRefresh_status(false);
			if (gui_data_model.getLeft_background_graphics_panel() != null
					&& gui_data_model.getRight_background_graphics_panel() != null) {
				gui_data_model.getLeft_background_graphics_panel().repaint();
				gui_data_model.getRight_background_graphics_panel().repaint();
			}

		} else {
			if (gui_data_model.getLeft_text_area() != null && gui_data_model.getLeft_text_area() != null) {
				gui_data_model.getLeft_text_area().setText(null);
				gui_data_model.getRight_text_area().setText(null);
			}

		}

	}

}
