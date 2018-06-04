package button_model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import compare_algorithm.String_object;
import data_model.GUI_data_model;

class Load_ok_buttonTest {

	
	@Test
	void testDisplay_list_to_textarea(){
		ArrayList<String_object> left_list = new ArrayList<String_object>();
		ArrayList<String_object> right_list = new ArrayList<String_object>();
		left_list.add(new String_object("1"));
		right_list.add(new String_object("1"));

		GUI_data_model gui_data_model = new GUI_data_model();
		gui_data_model.setLeft_list(left_list);
		gui_data_model.setRight_list(right_list);
		Load_ok_button load_ok_button = new Load_ok_button(gui_data_model, null, null, null);
		load_ok_button.display_list_to_textarea();
		
		assertNotNull("ok", gui_data_model.getLeft_text_area());
		assertNotNull("ok", gui_data_model.getRight_text_area());



	}

}
