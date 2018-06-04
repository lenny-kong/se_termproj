 package button_model;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import data_model.GUI_data_model;
import junit.framework.Assert;

class RLmerge_buttonTest {

	
	private GUI_data_model gui_data_model= new GUI_data_model();
	private RLmerge_button rl = new RLmerge_button(gui_data_model);
	@Test
	void testRLmerge_button() {
	Assert.assertNotNull(rl.tooltip_text);
	Assert.assertNotNull(rl.current_icon);
	Assert.assertNotNull(rl.default_icon);
	Assert.assertNotNull(rl.mouseover_icon);
	Assert.assertNotNull(rl.pushed_icon);
	
	}

	

	@Test
	void testMerge() {
		
		
		JTextArea a = new JTextArea();
		JTextArea b = new JTextArea();
		a.setText("a \n b");
		b.setText("a \n b \n c");

		rl.merge(a, b);
		Assert.assertNotNull(rl.getGui_data_model().getLeft_text_area());
	}

}
