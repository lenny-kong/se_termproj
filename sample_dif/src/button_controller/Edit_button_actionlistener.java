package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button_model.Edit_button;

public class Edit_button_actionlistener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Edit_button edit_button = (Edit_button)e.getSource();
		edit_button.get_text_area().setEditable(true);
		
		//Change icon image to clicked image.
		//Not yet implemented.
	}

}
