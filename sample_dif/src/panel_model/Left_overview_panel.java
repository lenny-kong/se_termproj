package panel_model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import data_model.GUI_data_model;

public class Left_overview_panel extends JPanel{
	
	//Own size.
	public static final int width = 100;
	public static final int height = 700;
	
	public int item_num = 20;
	public int height_per_item;
	public int width_per_item;
	
	public Left_overview_panel(GUI_data_model gui_data_model) 
	{
		super();
		gui_data_model.left_overview_panel = this;
		
		this.setBorder(null);
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        this.width_per_item = 100;
        this.height_per_item = this.height / this.item_num;
        
        for(int i = 0; i< this.item_num; i++) 
        {
        	g.fillRect(0, i*this.height_per_item, this.width_per_item, this.height_per_item);
        	if(i%2 == 0)g.setColor(Color.BLUE);
        	else g.setColor(Color.black);
        }
	}
}
