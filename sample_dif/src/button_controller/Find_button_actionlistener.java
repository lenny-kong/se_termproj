package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import button_model.Find_button;

public class Find_button_actionlistener implements ActionListener {

	public Find_button_actionlistener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Find_button find_button = (Find_button) e.getSource();
		find_button.make_chooser();
		
	}
	

}
