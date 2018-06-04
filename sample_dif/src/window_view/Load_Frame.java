package window_view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import button_model.Find_button;
import button_model.Load_ok_button;
import data_model.GUI_data_model;
import panel_model.Load_file_panel;
import panel_model.Load_ok_button_panel;

public class Load_Frame extends JFrame {
	private Panel OK_button_panel = new Panel();
	private Load_file_panel left_load_panel;
	private Load_file_panel right_load_panel;
	private Load_ok_button_panel load_ok_button_panel;
	private JTextField leftpath = new JTextField("",40);
	private JTextField rightpath = new JTextField("",40);

	private Load_ok_button ok_set_path_gui_data_model;
	private GUI_data_model gui_data_model = new GUI_data_model();
	int width = 600, height = 180;

	public Load_Frame(GUI_data_model gui_data_model) {
		this.gui_data_model = gui_data_model;
		// for dispose this frame in load okay button
		
		this.setSize(width, height);
		this.setTitle("File Load");
		this.setVisible(true);
		this.setLayout(null);
		this.setLocation(400, 200);

		load_ok_button_panel = new Load_ok_button_panel(gui_data_model , "OK", leftpath, rightpath);
		left_load_panel = new Load_file_panel(GUI_data_model.location.LEFT , gui_data_model, leftpath);
		right_load_panel = new Load_file_panel(GUI_data_model.location.RIGHT , gui_data_model, rightpath);
				
		left_load_panel.setLocation(0, 0);
		right_load_panel.setLocation(0, 50);
		load_ok_button_panel.setLocation(0,100);
		
		this.add(left_load_panel);
		this.add(right_load_panel);
		this.add(load_ok_button_panel);
		
		this.gui_data_model.setLoad_frame(this);
	}
}