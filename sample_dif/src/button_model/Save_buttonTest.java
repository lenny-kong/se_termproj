//SAVE BUTTON TEST

package button_model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import compare_algorithm.String_object;
import data_model.GUI_data_model;
import junit.framework.Assert;

class Save_buttonTest {
	GUI_data_model gui_data_model = new GUI_data_model();
	private Save_button save = new Save_button(gui_data_model);
	@Test
	void testSave_button() {
		Assert.assertNotNull(save.tooltip_text);
		Assert.assertNotNull(save.current_icon);
		Assert.assertNotNull(save.default_icon);
		Assert.assertNotNull(save.mouseover_icon);
		Assert.assertNotNull(save.pushed_icon);
	}

	@Test
	void testGetSaveFile() {
		File file = new File("1.txt");
		Assert.assertNotNull(save.getSaveFile(file.getName()));
		
	}

	@Test
	void testSavefile() throws IOException {
		List<String_object> list =new ArrayList<>();
		list.clear();
		String tmp="12";
		String_object temp = new String_object(tmp);
		File file = new File("1.txt");
		
	
		list.add(temp);
		save.savefile(file, list);
		Assert.assertNotNull(file);
		
	}


	

}
