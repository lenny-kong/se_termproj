package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import button_model.Save_button;
import data_model.GUI_data_model;

public class Save_button_actionlistener implements ActionListener {
	private GUI_data_model gui_data_model;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int result = 0; // return value (confirm dialog)
		File file;

		Object[] options = { "save left", "save right", "cancel" };
		Save_button save_button = (Save_button) e.getSource();
		this.gui_data_model = save_button.getGui_data_model();

		// text to list;
		result = JOptionPane.showOptionDialog(null, "which one do u wanna save?", "save",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (result == JOptionPane.YES_OPTION) {
			file = save_button.getSaveFile(gui_data_model.getLeft_name());
			try {
				save_button.text_to_list(1);
				if (file != null) {
					save_button.savefile(file, gui_data_model.getLeft_list());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (result == JOptionPane.NO_OPTION) {
			file = save_button.getSaveFile(gui_data_model.getRight_name());
			try {
				save_button.text_to_list(0);
				if (file != null) {
					save_button.savefile(file, gui_data_model.getRight_list());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}