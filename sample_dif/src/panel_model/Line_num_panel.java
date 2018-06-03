package panel_model;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Line_num_panel extends JPanel{

	public static final int height = 700;
	public static final int width = 10;
	
	public void line_num_panel() {
		
		//this.setVisible(false);
		//this.setOpaque(true);
		this.setSize(height, width);
		this.setBackground(Color.red);
	}	
}