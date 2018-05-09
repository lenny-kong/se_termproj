package button_text_generator;

import javax.swing.JTextArea;
import button_model.Edit_button;
import javax.swing.JButton;

public class Button_generator {
//	private Load_button edit_button;
	private Edit_button edit_button;
//	private Save_button save_button;
	
	public Button_generator(String button_name,JTextArea text_area,String file_path) {
		//save_button = new Save_button(button_name,file_path);
		edit_button = new Edit_button(button_name,null,null);
		//load_button = new Load_button(button name,file_path) // only loads one file per one click
	}
	public Button_generator(String button_name) {
		edit_button = new Edit_button(button_name);
	}
}