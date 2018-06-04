package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import window_view.*;
import button_model.Load_button;

public class Load_button_actionlistener implements ActionListener {

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Load_button load_button = (Load_button) e.getSource();
		load_button.load_warning();


	}
}