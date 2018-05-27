package panel_model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import data_model.GUI_data_model;
import data_model.Pastel_color;


public class Background_line_graphics_panel extends JPanel {

	private GUI_data_model gui_data_model;
	public int height_per_line = 18;
	public int maximum_line_in_window = 50;
	public Color highlight_color = Color.WHITE;
	private JTextArea text_area;
	private boolean refresh_button_click =false;
	
	
	public Background_line_graphics_panel(JTextArea text_area) {
		this.text_area = text_area;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int total_line = this.text_area.getLineCount();
		
		//before refresh_button is pressed or after merge button is pressed
		if(!this.refresh_button_click)
			for (int i = 0; i < total_line; i++) {
					g.setColor(this.highlight_color);
				// 2 for top Gap.
				g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
		
			}
		//after refresh_button is pressed
		else
		{ 
			int compare;
			compare = gui_data_model.getLeft_list().size()<gui_data_model.getRight_list().size()?gui_data_model.getRight_list().size():gui_data_model.getLeft_list().size();

			for(int i=0;i<compare;i++)
			{
				if(gui_data_model.getLeft_list().get(i).get_string().equals(gui_data_model.getRight_list().get(i).get_string()))
				{
					g.setColor(Pastel_color.pastel_red);
				}
				else
					g.setColor(Pastel_color.pastel_yellow);
				g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
			}
			
		
		}
		

	
	}
	public void setRefresh_button_ture()
	{
		this.refresh_button_click = true;
	}
	public void setRefresh_button_false()
	{
		this.refresh_button_click = false;
	}
	public void setGui_data_model(GUI_data_model gui_data_model) {
		this.gui_data_model = gui_data_model;
		
	}

	
}