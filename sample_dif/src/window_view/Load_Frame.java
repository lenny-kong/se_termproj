package window_view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import button_model.Find_button;
import button_model.Load_ok_button;
import data_model.GUI_data_model;

public class Load_Frame extends JFrame {
	private Panel L_path_view = new Panel();
	private Panel R_path_view = new Panel();
	private JTextArea leftpath = new JTextArea("", 1, 30);
	private JTextArea rightpath = new JTextArea("", 1, 30);
	private Find_button left_find;
	private Find_button right_find;
	private Load_ok_button ok_set_path_gui_data_model;
	private GUI_data_model gui_data_model;
	int width = 400, height = 150;

	public Load_Frame(GUI_data_model gui_data_model) {
		this.gui_data_model = gui_data_model;
		this.gui_data_model.setLoad_frame(this);
		// for dispose this frame in load okay button

		left_find = new Find_button(gui_data_model, leftpath);
		right_find = new Find_button(gui_data_model, rightpath);
		ok_set_path_gui_data_model = new Load_ok_button(gui_data_model, "OK", leftpath, rightpath);

		setLayout(null);
		setSize(width, height);
		setTitle("File load");
		setVisible(true);
		this.setLayout(new GridLayout(3, 1));

		leftpath.setEditable(false);
		rightpath.setEditable(false);

		L_path_view.add(leftpath);
		L_path_view.add(left_find);
		R_path_view.add(rightpath);
		R_path_view.add(right_find);
		add(L_path_view);
		add(R_path_view);
		add(ok_set_path_gui_data_model);
	}
}