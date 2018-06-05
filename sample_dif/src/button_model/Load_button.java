package button_model;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import button_controller.Load_button_actionlistener;
import data_model.GUI_data_model;
import window_view.Icon_image_load;
import window_view.Load_Frame;

public class Load_button extends Button_model {

	private final String default_image_path = "icon_image/load/load.png";
	private final String pushed_image_path = "icon_image/load/load_push.png";
	private final String mouseover_image_path = "icon_image/load/load_mouseover.png";
	private Load_Frame load;
	private GUI_data_model gui_data_model;

	public Load_button(GUI_data_model gui_data_model) {
		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/load/load.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Load";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));

		Load_button_actionlistener actionlistener = new Load_button_actionlistener();
		this.addActionListener(actionlistener);
		this.gui_data_model = gui_data_model;
		// set action listener, gui data model

	}
	public void load_warning() {
	      int result = 0; // return value (confirm dialog)
	      if (getGui_data_model().getLeft_text_area().getSelectionEnd() != 0
	            || getGui_data_model().getRight_text_area().getSelectionEnd() != 0) {
	         result = JOptionPane.showConfirmDialog(null, "There is content you were working on before. \n Would you like to load the file?", "Warning",
	               JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	         if (result == JOptionPane.YES_OPTION) {
	            load = new Load_Frame(getGui_data_model());
	            load.setVisible(true);
	         }
	      } else {
	         load = new Load_Frame(getGui_data_model());
	         load.setVisible(true);
	      } // warning if there exists work that editing
	   }

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	} // get gui data model

}
