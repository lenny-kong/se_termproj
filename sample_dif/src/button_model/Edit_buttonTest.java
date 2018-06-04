package button_model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data_model.GUI_data_model;

class Edit_buttonTest {

	@Test
	void testButton_toggle() {
		GUI_data_model gui_data_model = new GUI_data_model();
		Edit_button edit_button = new Edit_button(gui_data_model);
		edit_button.button_toggle();
		assertTrue("true",gui_data_model.getLeft_text_area().isEditable() );
		assertTrue("true",gui_data_model.getRight_text_area().isEditable() );
	}
	

}
