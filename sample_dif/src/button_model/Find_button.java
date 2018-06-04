package button_model;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import button_controller.Find_button_actionlistener;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

public class Find_button extends Button_model {

	private final String default_image_path = "icon_image/find/find.png";
	private final String pushed_image_path = "icon_image/find/find_push.png";
	private final String mouseover_image_path = "icon_image/find/find_mouseover.png";
	private JTextArea text_area;

	public Find_button(GUI_data_model gui_data_model, JTextArea text_area) {
		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/find/find.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Find";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));

		this.setText_area(text_area);
		Find_button_actionlistener actionlistener = new Find_button_actionlistener();
		this.addActionListener(actionlistener);
		// set action listener , gui data model
	}

	public JTextArea getText_area() {
		return text_area;
	}

	public void setText_area(JTextArea text_area) {
		this.text_area = text_area;
	}
	public boolean disableTF(Container c) {
	    Component[] cmps = c.getComponents();
	    for (Component cmp : cmps) {
	        if (cmp instanceof JTextField) {
	            ((JTextField)cmp).setEnabled(false);
	            return true;
	        }
	        if (cmp instanceof Container) {
	            if(disableTF((Container) cmp)) return true;
	        }
	    }
	    return false;
	}
}
