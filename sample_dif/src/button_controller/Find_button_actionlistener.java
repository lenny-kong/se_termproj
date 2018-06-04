package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import window_view.*;
import button_model.Find_button;
import button_model.Load_ok_button;
import compare_algorithm.Compare_util_string_list;
import data_model.GUI_data_model;

public class Find_button_actionlistener implements ActionListener {
	private JFileChooser chooser;

	public Find_button_actionlistener() {
		chooser = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Find_button find_button = (Find_button) e.getSource();
		find_button.make_chooser();
	}
}