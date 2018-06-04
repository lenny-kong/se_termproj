package button_model;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import button_controller.Load_ok_button_actionlistener;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

public class Load_ok_button extends Button_model {
	private final String default_image_path = "icon_image/ok/ok.png";
	private final String pushed_image_path = "icon_image/ok/ok_push.png";
	private final String mouseover_image_path = "icon_image/ok/ok_mouseover.png";
	
	private GUI_data_model gui_data_model;
	private JLabel left_path_label;
	private JLabel right_path_label;
	private JTextField leftpath;
	private JTextField rightpath;

	public Load_ok_button(GUI_data_model gui_data_model, String name, JTextField leftpath, JTextField rightpath) {
		super(Icon_image_load.load_image("icon_image/ok/ok.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Load";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));

		this.gui_data_model = gui_data_model;
		this.leftpath = leftpath;
		this.rightpath = rightpath;
		
		Load_ok_button_actionlistener actionlistener = new Load_ok_button_actionlistener();
		this.addActionListener(actionlistener);
	}

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	} // get gui data model

	public String getLeftpath() {
		return leftpath.getText();
	}
	public String getRightpath() {
		return rightpath.getText();
	}
	
	
	public void input_file_data_to_list() {
		gui_data_model.getLeft_list().clear();
		gui_data_model.getRight_list().clear();
		String tmp = ""; // to read a line in txt file
		String_object input_line; // to convert string to string_object
		input_line = new String_object(tmp);
		gui_data_model.getLeft_list().add(input_line);
		gui_data_model.getRight_list().add(input_line);

		try {
			BufferedReader left_in_file = new BufferedReader(new FileReader(gui_data_model.getLeft_file_path()));
			while ((tmp = left_in_file.readLine()) != null) {
				input_line = new String_object(tmp); // convert string to string_object
				gui_data_model.getLeft_list().add(input_line); // add list
				gui_data_model.getLeft_background_graphics_panel().repaint();
			}
			
			left_in_file.close();
		} catch (IOException e) {
		}
		try {
			BufferedReader right_in_file = new BufferedReader(new FileReader(gui_data_model.getRight_file_path()));
			while ((tmp = right_in_file.readLine()) != null) {
				input_line = new String_object(tmp);
				gui_data_model.getRight_list().add(input_line);
			}
			right_in_file.close();
		} catch (IOException e) {
		}
	}
	
	public void display_path_to_patharea() {
		int left_index = gui_data_model.getLeft_file_path().lastIndexOf("\\");
		int right_index = gui_data_model.getRight_file_path().lastIndexOf("\\");
		
		if(left_index == -1){
			gui_data_model.getLeft_path_label().setText(" File Not Selected.");
			}
		if(left_index != -1) {
			gui_data_model.getLeft_path_label().setText(" File name : "+gui_data_model.getLeft_file_path().substring(left_index+1));
			}
		if(right_index == -1) {
			gui_data_model.getRight_path_label().setText(" File Not Selected.");
			}
		if(right_index != -1) {
			gui_data_model.getRight_path_label().setText(" File name : "+gui_data_model.getRight_file_path().substring(right_index+1));
			}	
	}
	// just display filename.txt , using index "\\"
	// if file does not selected -> display "File not Selected."
	
	public void display_list_to_textarea() {
		int cnt;
		gui_data_model.getLeft_text_area().setText(null);
		gui_data_model.getRight_text_area().setText(null);
		for (cnt = 1; cnt < gui_data_model.getLeft_list().size(); cnt++) {
			gui_data_model.getLeft_text_area().append(gui_data_model.getLeft_list().get(cnt).get_string());
			if(gui_data_model.getLeft_list().size() != cnt+1) {
				gui_data_model.getLeft_text_area().append("\n");
			}
			System.out.println("cnt : "+cnt);
			System.out.println("size : "+gui_data_model.getLeft_list().size());
		}
		for (cnt = 0; cnt < gui_data_model.getRight_list().size(); cnt++) {
			gui_data_model.getRight_text_area().append(gui_data_model.getRight_list().get(cnt).get_string());
			if(gui_data_model.getRight_list().size() != cnt+1) {
				gui_data_model.getRight_text_area().append("\n");
			}
		}
		gui_data_model.getLeft_background_graphics_panel().repaint();
	}
}
