package window_view;

import javax.swing.ImageIcon;

public class Icon_image_load {

	static public ImageIcon load_image(String filepath) {
		ImageIcon icon = new ImageIcon(filepath);
		return icon;
	}
}
