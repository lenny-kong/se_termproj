package button_model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import data_model.GUI_data_model;

class Find_buttonTest {

	@Test
	void testMake_chooser() {
		GUI_data_model gui_data_model = new GUI_data_model();
		JTextArea area = new JTextArea();

		Find_button find_button = new Find_button(gui_data_model,area);
		find_button.make_chooser();
		assertTrue("ok", find_button.getText_area().getText().length()!=0);

	}

}
