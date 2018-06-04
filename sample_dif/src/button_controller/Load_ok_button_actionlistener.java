package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import button_model.Load_ok_button;

public class Load_ok_button_actionlistener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Load_ok_button load_ok_button = (Load_ok_button) e.getSource();
		load_ok_button.getGui_data_model().setLeft_file_path(load_ok_button.getLeftpath());
		load_ok_button.getGui_data_model().setRight_file_path(load_ok_button.getRightpath());

		if (load_ok_button.getGui_data_model().getLeft_file_path().length() != 0
				&& load_ok_button.getGui_data_model().getRight_file_path().length() != 0) {

			load_ok_button.input_file_data_to_list();

			load_ok_button.display_list_to_textarea();
			// update modified data
			load_ok_button.display_path_to_patharea();
			// update filepath

			load_ok_button.getGui_data_model().getLoad_frame().dispose();
			// close load frame
		} else {
			JOptionPane.showMessageDialog(null, "select File!", "warning", JOptionPane.WARNING_MESSAGE);

		}
	}
}
