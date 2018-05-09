package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button_model.Edit_button;

public class Edit_button_actionlistener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get source of event and Typecast to Edit_button
		Edit_button edit_button = (Edit_button)e.getSource();
		
		// Call toggle function of button_model.
		edit_button.button_toggle();
		
		//Change icon image to clicked image.
		//Not yet implemented.
	}

}
