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
		int flag = 0; // return value (empty file comfirm dialog)
		File file;

		Object[] options = { "Save Left", "Save Right", "Cancel"};
		Save_button save_button = (Save_button) e.getSource();
		this.gui_data_model = save_button.getGui_data_model();

		// text to list;
		result = JOptionPane.showOptionDialog(null, "Which file do you want to save?", "Save Files",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (result == JOptionPane.YES_OPTION) {
			//file = save_button.getSaveFile(gui_data_model.getLeft_name());
			if(gui_data_model.getLeft_text_area().getText().length() == 0) {
				flag = JOptionPane.showConfirmDialog(null, "Text area is empty\nAre you really want to save?","Empty File",
						JOptionPane.YES_NO_OPTION);
				if(flag == JOptionPane.YES_OPTION) {
					file = save_button.getSaveFile("");
					try {
						save_button.text_to_list(1);
						if (file != null) {
							System.out.println(file.getName());
							gui_data_model.setLeft_file_path(file.getAbsolutePath());
							gui_data_model.getLeft_path_label().setText(" File name : "+file.getName());
							save_button.savefile(file, gui_data_model.getLeft_list());
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			else {
				file = save_button.getSaveFile(gui_data_model.getLeft_name());
			try {
				save_button.text_to_list(1);
				if (file != null) {
					gui_data_model.setLeft_name(file.getName());
					gui_data_model.getLeft_path_area().setText("File name : " + gui_data_model.getLeft_name());
					save_button.savefile(file, gui_data_model.getLeft_list());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		if (result == JOptionPane.NO_OPTION) {
			if(gui_data_model.getRight_text_area().getText().length() == 0) {
				flag = JOptionPane.showConfirmDialog(null, "Text area is empty\nAre you really want to save?","Empty File",
						JOptionPane.YES_NO_OPTION);
				if(flag == JOptionPane.YES_OPTION) {
					file = save_button.getSaveFile("");
					try {
						save_button.text_to_list(1);
						if (file != null) {
							System.out.println(file.getName());
							gui_data_model.setRight_file_path(file.getAbsolutePath());
							gui_data_model.getRight_path_label().setText(" File name : "+file.getName());
							save_button.savefile(file, gui_data_model.getRight_list());
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			else {
				file = save_button.getSaveFile(gui_data_model.getRight_name());
			try {
				save_button.text_to_list(1);
				if (file != null) {
					gui_data_model.setRight_name(file.getName());
					gui_data_model.getRight_path_area().setText("File name : " + gui_data_model.getRight_name());
					save_button.savefile(file, gui_data_model.getRight_list());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	}
}