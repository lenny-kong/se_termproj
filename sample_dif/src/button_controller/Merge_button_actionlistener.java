package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import button_model.Merge_button;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
public class Merge_button_actionlistener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get source of event and Typecast to Merge_button
		Merge_button merge_button = (Merge_button)e.getSource();
		merge_button.mergeLtoR();
		//merge_button.mergeLtoR(merge_button.getGui_data_model().getLeft_text_area(), merge_button.getGui_data_model().getRight_text_area());
	
		
	}
}
