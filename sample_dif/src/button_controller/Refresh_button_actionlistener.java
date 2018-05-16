package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button_model.Refresh_button;

public class Refresh_button_actionlistener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get source of event and Typecast to Edit_button
		Refresh_button refresh_button = (Refresh_button) e.getSource();

		// Call toggle function of button_model.
		refresh_button.refresh();
	}
}
