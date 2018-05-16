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
		String_object string_object;
		// Get source of event and Typecast to Edit_button
		Refresh_button refresh_button = (Refresh_button) e.getSource();

		// Call toggle function of button_model.
		this.gui_data_model = refresh_button.getGui_data_model();

		Compare_util_string_list compare;
		System.out.println(gui_data_model.getLeft_text_area().getText());
		StringTokenizer left_token = new StringTokenizer(gui_data_model.getLeft_text_area().getText(), "\n");
		StringTokenizer right_token = new StringTokenizer(gui_data_model.getRight_text_area().getText(), "\n");
		gui_data_model.getLeft_list().clear();
		gui_data_model.getRight_list().clear();
		for (cnt = 0; cnt < left_token.countTokens(); cnt++) {
			gui_data_model.getLeft_list().add(new String_object(left_token.nextToken()));
		}
		for (cnt = 0; cnt < right_token.countTokens(); cnt++) {
			gui_data_model.getRight_list().add(new String_object(right_token.nextToken()));
		}
		compare = new Compare_util_string_list(gui_data_model.getLeft_list(), gui_data_model.getRight_list());
		gui_data_model.setLeft_list(compare.get_left_String_object_list());
		gui_data_model.setRight_list(compare.get_right_String_object_list());

		gui_data_model.getLeft_text_area().setText(null);
		gui_data_model.getRight_text_area().setText(null);

		for (cnt = 0; cnt < gui_data_model.getLeft_list().size(); cnt++) {
			gui_data_model.getLeft_text_area().append(gui_data_model.getLeft_list().get(cnt).get_string());
			gui_data_model.getLeft_text_area().append("\n");
		}
		for (cnt = 0; cnt < gui_data_model.getRight_list().size(); cnt++) {
			gui_data_model.getRight_text_area().append(gui_data_model.getRight_list().get(cnt).get_string());
			gui_data_model.getRight_text_area().append("\n");
		}
		gui_data_model.getLeft_overview_panel().repaint();

		gui_data_model.getLeft_background_graphics_panel().repaint();

	}
}
