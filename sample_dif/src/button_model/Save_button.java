package button_model;

import java.awt.Dimension;

import data_model.GUI_data_model;
import window_view.Icon_image_load;

public class Save_button extends Button_model {

	private final String default_image_path = "icon_image/save/save.png";
	private final String pushed_image_path = "icon_image/save/save_push.png";
	private final String mouseover_image_path = "icon_image/save/save_mouseover.png";

	public Save_button(GUI_data_model gui_data_model) {
		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/save/save.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Save";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));
	}
}
