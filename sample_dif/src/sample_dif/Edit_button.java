package sample_dif;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Edit_button extends JButton implements ActionListener {
	
	private JTextArea text_area;
	
	/*
	 * Constructor with name, image, text area.
	 */
	public Edit_button(String name, Icon image, JTextArea text_area) 
	{
		super(name, image);
		this.text_area = text_area;
		this.addActionListener(this);
	}
	
	/*
	 * Default Constructor
	 */
	public Edit_button(String name) 
	{
		super(name);
	}
	
	/*
	 * Add its own ActionListener.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			this.text_area.setEditable(true);
	}
}
