package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import button_model.Load_ok_button;
import compare_algorithm.Compare_util_string_list;
import common_util_lib.*;

public class Load_ok_button_actionlistener implements ActionListener {
	private Compare_util_string_list compare;

	public void actionPerformed(ActionEvent e) {
		Load_ok_button load_ok_button = (Load_ok_button) e.getSource();
		load_ok_button.getGui_data_model().setLeft_file_path(load_ok_button.getLeftpath());
		load_ok_button.getGui_data_model().setRight_file_path(load_ok_button.getRightpath());
		
		if (load_ok_button.getGui_data_model().getLeft_file_path().length() != 0
	            && load_ok_button.getGui_data_model().getRight_file_path().length() != 0) {
		// 파일이 두개가 다 로드되어야 함.	
	         load_ok_button.input_file_data_to_list();

	         load_ok_button.display_list_to_textarea();
	         // update modified data
	         load_ok_button.display_path_to_patharea();
	         // update filepath

	         load_ok_button.getGui_data_model().getLoad_frame().dispose();
	         // close load frame
	      } else {
	         JOptionPane.showMessageDialog(null, "Select File!", "Warning", JOptionPane.WARNING_MESSAGE);

	      }
	}
}
