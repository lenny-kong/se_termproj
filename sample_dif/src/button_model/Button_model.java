package button_model;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolTip;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import button_controller.Button_mouselistener;

public abstract class Button_model extends JButton {

	protected ImageIcon current_icon;
	protected ImageIcon default_icon;
	protected ImageIcon mouseover_icon;
	protected ImageIcon pushed_icon;

	protected Popup tooltip;
	protected String tooltip_text;

	/*
	 * Constructor with name, image, text area.
	 */
	public Button_model(Icon icon) {
		super(icon);

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(28, 28));
		// delete default focus.
		this.setFocusPainted(false);

		// add mouselistener.
		Button_mouselistener mouselistener = new Button_mouselistener();
		this.addMouseListener(mouselistener);
	};

	// Set icon image pushed image.
	public void set_pushed_icon() {
		this.setIcon(this.pushed_icon);
	}

	// Set icon image mouseover image.
	public void set_mouseover_icon() {
		this.setIcon(this.mouseover_icon);
	}

	// Reset to past image before mouseover.
	public void reset_icon() {
		this.setIcon(this.current_icon);
	}

	// show tooltip
	public void show_tooltip(Point p) {
		JToolTip tip = createToolTip();
		tip.setTipText(this.tooltip_text);
		PopupFactory popupFactory = PopupFactory.getSharedInstance();
		this.tooltip = popupFactory.getPopup(this, tip, p.x + 10, p.y + 10);
		this.tooltip.show();
	}

	// close tooltip
	public void hide_tooltip() {
		this.tooltip.hide();
	}

}
