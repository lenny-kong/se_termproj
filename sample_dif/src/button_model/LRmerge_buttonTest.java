package button_model;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import data_model.GUI_data_model;
import junit.framework.Assert;

class LRmerge_buttonTest {
	GUI_data_model gui_data_model = new GUI_data_model();
	private LRmerge_button lr = new LRmerge_button(gui_data_model);
	@Test
	void testLRmerge_button() {
		Assert.assertNotNull(lr.tooltip_text);
		Assert.assertNotNull(lr.current_icon);
		Assert.assertNotNull(lr.default_icon);
		Assert.assertNotNull(lr.mouseover_icon);
		Assert.assertNotNull(lr.pushed_icon);
	
		
	}	

	

	@Test
	void testMerge() {
		JTextArea a = new JTextArea();
		JTextArea b = new JTextArea();
		a.setText("a \n b");
		a.append("a \n b");
		b.setText("a \n b \n c");
		b.append("a \n b \n c");

		lr.merge(a, b);
		Assert.assertNotNull(lr.getGui_data_model().getRight_text_area());
		
		
		
		
		
	}

}
