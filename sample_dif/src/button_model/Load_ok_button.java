package button_model;

import javax.swing.JButton;
import javax.swing.JTextArea;

import button_controller.Load_ok_button_actionlistener;
import data_model.GUI_data_model;

public class Load_ok_button extends JButton {
	private GUI_data_model gui_data_model;
	private JTextArea leftpath;
	private JTextArea rightpath;

	public Load_ok_button(GUI_data_model gui_data_model, String name, JTextArea leftpath, JTextArea rightpath) {

		super(name);
		this.gui_data_model = gui_data_model;
		this.leftpath = leftpath;
		this.rightpath = rightpath;

		Load_ok_button_actionlistener actionlistener = new Load_ok_button_actionlistener();
		this.addActionListener(actionlistener);
	}

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	} // get gui data model

	public String getLeftpath() {
		return leftpath.getText();
	}

	public String getRightpath() {
		return rightpath.getText();
	}

}
