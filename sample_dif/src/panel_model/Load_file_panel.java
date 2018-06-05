package panel_model;

import common_util_lib.*;
import data_model.GUI_data_model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import button_model.Find_button;
import button_model.Load_ok_button;

public class Load_file_panel extends JPanel {
	public static final int width = 600;
	public static final int height = 50;
	private JLabel text_location = new JLabel();
	private Find_button find_button;
	private JTextField file_path;	
	private JTextField leftpath = new JTextField("", 30);
	private JTextField rightpath = new JTextField("", 30);
	private Load_ok_button ok_set_path_gui_data_model;

	public GUI_data_model.location location;

	public Load_file_panel(GUI_data_model.location location, GUI_data_model gui_data_model, JTextField file_path) {
		super();
		this.file_path = new JTextField("",30);
		this.setLayout(new FlowLayout());
		this.setSize(width, height);
		this.location = location;
		this.text_location.setFont(new Font("Arial",Font.ITALIC,15));
		this.find_button = new Find_button(gui_data_model, file_path);
		
		if (location == GUI_data_model.location.LEFT) {
			text_location.setText("Left File :    ");
			//file_path.setText(gui_data_model.getLeft_file_path());
			gui_data_model.set_filepath_field(this.file_path);
		} else if (location == GUI_data_model.location.RIGHT) {
			text_location.setText("Right File : ");
			//file_path.setText(gui_data_model.getRight_file_path());
			gui_data_model.set_filepath_field(this.file_path);
		}
		this.add(text_location);
		this.add(file_path);
		this.add(find_button);
	}
}
