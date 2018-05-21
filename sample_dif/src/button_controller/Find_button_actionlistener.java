package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import button_model.Find_button;

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

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "select File!", "warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		find_button.getText_area().setText(chooser.getSelectedFile().getPath());

	}

}
