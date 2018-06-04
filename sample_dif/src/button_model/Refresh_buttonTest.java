package button_model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import compare_algorithm.String_object;
import data_model.GUI_data_model;

class Refresh_buttonTest {

	@Test
	void testTokenize_compare_list() {
		GUI_data_model gui_data_model = new GUI_data_model();
		gui_data_model.getLeft_text_area().setText("haha \n haha");
		gui_data_model.getRight_text_area().setText("haha \n haha");
		Refresh_button refresh_button = new Refresh_button(gui_data_model);
		refresh_button.tokenize_compare_list();
		assertTrue("ok", gui_data_model.getLeft_list().size()!=0);
		assertTrue("ok", gui_data_model.getRight_list().size()!=0);
	
	}

	@Test
	void testPrint_list_text_area() {
		GUI_data_model gui_data_model = new GUI_data_model();
		ArrayList<String_object> left_list = new ArrayList<String_object>();
		ArrayList<String_object> right_list = new ArrayList<String_object>();
		left_list.add(new String_object("1"));
		right_list.add(new String_object("1"));

		gui_data_model.setLeft_list(left_list);
		gui_data_model.setRight_list(right_list);

		Refresh_button refresh_button = new Refresh_button(gui_data_model);
		
		refresh_button.print_list_text_area();
		assertTrue("ok", gui_data_model.getLeft_text_area().getText().length()!=0);
		assertTrue("ok", gui_data_model.getRight_text_area().getText().length()!=0);

	}

}
