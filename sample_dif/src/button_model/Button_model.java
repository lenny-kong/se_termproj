package button_model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import button_controller.Button_mouselistener;

public abstract class Button_model extends JButton{
	
	protected ImageIcon current_icon;
	protected ImageIcon default_icon;
	protected ImageIcon mouseover_icon;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Button_model(Icon icon) 
	{
		super(icon);
		
		//add mouselistener.
		Button_mouselistener mouselistener = new Button_mouselistener();
		this.addMouseListener(mouselistener);
	};

	//Set icon image mouseover image.
	public void set_mouseover_icon() {
		this.setIcon(this.mouseover_icon);
	}
	
	//Reset to past image before mouseover.
	public void reset_icon() {
		this.setIcon(this.current_icon);
	}
}
