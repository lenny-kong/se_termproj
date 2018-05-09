package button_model;

import javax.swing.*;

import button_controller.*;

@SuppressWarnings("serial")
public class Edit_button extends JButton{
	
	private JTextArea text_area;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(String name, Icon image, JTextArea text_area) 
	{
		super(name, image);
		this.text_area = text_area;
		Edit_button_actionlistener actionlistener = new Edit_button_actionlistener();
		this.addActionListener(actionlistener);
	}
	
	/*
	 * Default Constructor
	 */
	public Edit_button(String name) 
	{
		super(name);
	}
	
	/*
	 * Return text_area.
	 */
	public JTextArea get_text_area() 
	{
		return this.text_area;
	}
	
	/*
	 * Return true if text_area is editable.
	 */
	public boolean get_iseditable() 
	{
		return text_area.isEditable();
	}
	
}
