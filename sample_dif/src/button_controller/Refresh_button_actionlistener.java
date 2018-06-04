package button_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import button_model.Refresh_button;
import compare_algorithm.Compare_util_string_list;
import compare_algorithm.String_object;
import data_model.GUI_data_model;

public class Refresh_button_actionlistener implements ActionListener {
	private GUI_data_model gui_data_model;

	public void actionPerformed(ActionEvent e) {
		int cnt;
		// Get source of event and Typecast to Edit_button
		Refresh_button refresh_button = (Refresh_button) e.getSource();

		// Call toggle function of button_model.
		this.gui_data_model = refresh_button.getGui_data_model();
		
		gui_data_model.setRefresh_status(true);
		
		refresh_button.tokenize_compare_list();
		refresh_button.compare_list();
		refresh_button.print_list_text_area();
		
		gui_data_model.getLeft_overview_panel().repaint();
		gui_data_model.getLeft_background_graphics_panel().repaint();
		gui_data_model.getRight_background_graphics_panel().repaint();

		// repaint
		
	}
}
