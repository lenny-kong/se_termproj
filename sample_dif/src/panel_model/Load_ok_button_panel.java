package panel_model;

import data_model.GUI_data_model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import button_model.Load_ok_button;

public class Load_ok_button_panel extends JPanel {
	
	private Load_ok_button load_ok_button;
	private GUI_data_model gui_data_model;
	String name;
	JTextField leftpath = new JTextField("", 30);
	JTextField rightpath = new JTextField("", 30);
	
	public Load_ok_button_panel (GUI_data_model gui_data_model, String name, JTextField leftpath, JTextField rightpath) {
		super();
		
		this.load_ok_button = new Load_ok_button(gui_data_model, name, leftpath, rightpath);
		this.gui_data_model = gui_data_model;
		this.name = name;
		this.leftpath = leftpath;
		this.rightpath = rightpath;
		this.setSize(600,50);
		this.setLayout(new FlowLayout());
		this.add(load_ok_button,"Center");
		this.setVisible(true);		
	}
}