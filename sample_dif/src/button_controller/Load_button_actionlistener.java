package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import window_view.*;
import button_model.Load_button;

public class Load_button_actionlistener implements ActionListener {

	Load_Frame load;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Load_button load_button = (Load_button) e.getSource();

		load = new Load_Frame(load_button.getGui_data_model());
		load.setVisible(true);

	}

}
