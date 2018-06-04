package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import button_model.Find_button;

public class Find_button_actionlistener implements ActionListener {
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	public Find_button_actionlistener() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		filter = new FileNameExtensionFilter("*.txt", "txt");
		chooser.setFileFilter(filter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Find_button find_button = (Find_button) e.getSource();
		find_button.disableTF(chooser);
		chooser.showOpenDialog(null);
		if(chooser.getSelectedFile()!=null)
			find_button.getText_area().setText(chooser.getSelectedFile().getPath());

	}
	

}
