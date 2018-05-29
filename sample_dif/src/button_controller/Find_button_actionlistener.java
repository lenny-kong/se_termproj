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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
		chooser.setFileFilter(filter);
		
		find_button.getGui_data_model().set_filepath_field(find_button.getGui_data_model().get_path_Field());
		find_button.getGui_data_model().set_file_path(find_button.getGui_data_model().get_file_path());
		
		
		int ret = chooser.showOpenDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			find_button.getGui_data_model().set_file_path(chooser.getSelectedFile().getAbsolutePath());
			find_button.print_file_path();
		}
		else if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Select File!", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}	
	}
}