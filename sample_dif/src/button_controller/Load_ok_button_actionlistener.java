package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button_model.Load_ok_button;
import compare_algorithm.Compare_util_string_list;
import common_util_lib.*;

public class Load_ok_button_actionlistener implements ActionListener {
	private Compare_util_string_list compare;

	public void actionPerformed(ActionEvent e) {
		Load_ok_button load_ok_button = (Load_ok_button) e.getSource();
		load_ok_button.getGui_data_model().setLeft_file_path(load_ok_button.getLeftpath());
		load_ok_button.getGui_data_model().setRight_file_path(load_ok_button.getRightpath());
		
		compare = new Compare_util_string_list(load_ok_button.getGui_data_model().getLeft_file_path(),
				load_ok_button.getGui_data_model().getRight_file_path());
		load_ok_button.getGui_data_model().setLeft_list(compare.get_left_String_object_list());
		load_ok_button.getGui_data_model().setRight_list(compare.get_right_String_object_list());
		//set gui model
		load_ok_button.display_list_to_textarea();
		//update modified data
		load_ok_button.display_path_to_patharea();
		//update filepath

		load_ok_button.getGui_data_model().getLoad_frame().dispose();
		//close load frame
	}
}
