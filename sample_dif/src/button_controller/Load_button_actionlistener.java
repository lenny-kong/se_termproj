package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import window_view.*;
import button_model.Load_button;

public class Load_button_actionlistener implements ActionListener {

	Load_Frame load;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int result = 0; // return value (confirm dialog)
		Load_button load_button = (Load_button) e.getSource();

		if (load_button.getGui_data_model().getLeft_text_area().getSelectionEnd() != 0
				|| load_button.getGui_data_model().getRight_text_area().getSelectionEnd() != 0) {
			result = JOptionPane.showConfirmDialog(null, "Texts are exist!\nAre you really want to load new files?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				load = new Load_Frame(load_button.getGui_data_model());
				load.setVisible(true);
			}
		} else {
			load = new Load_Frame(load_button.getGui_data_model());
			load.setVisible(true);
		} // warning if there exists work that editing

	}
}