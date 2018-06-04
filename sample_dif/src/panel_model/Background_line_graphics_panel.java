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

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int total_line = this.text_area.getLineCount();
		
		//before refresh_button is pressed or after merge button is pressed
		if(!this.refresh_button_click)
			for (int i = 0; i < total_line; i++) {
				if(i%2==0)
				g.setColor(this.highlight_color);
				else
					g.setColor(Color.LIGHT_GRAY);

				// 2 for top Gap.
				g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
				g.setColor(Color.black);
			}
		//after refresh_button is pressed
		else
		{ 
			int compare;
			compare = gui_data_model.getLeft_list().size()<gui_data_model.getRight_list().size()?gui_data_model.getRight_list().size():gui_data_model.getLeft_list().size();

			for(int i=0;i<compare;i++)
			{
				//NOCHANGE=O, DIFFER=1, SIMILAR=2
				if(gui_data_model.getLeft_list().get(i).get_status().ordinal()==0) {
					g.setColor(Pastel_color.pastel_red);
					g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
					g.setColor(Color.black);

				
				else if(gui_data_model.getLeft_list().get(i).get_status().ordinal()==1){
					g.setColor(Pastel_color.pastel_yellow);
					g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
					g.setColor(Color.red);

				else if(gui_data_model.getLeft_list().get(i).get_status().ordinal()==2) {
					g.setColor(Pastel_color.pastel_green);
					g.fillRect(2, height_per_line * i+5, this.getSize().width-4, height_per_line+1);
					g.setColor(Color.green);

		
		}
			
		
	}
		

	

	public void setRefresh_button(boolean refresh_button_click)
	{
		this.refresh_button_click =refresh_button_click; 
	}
	public boolean getRefresh_button()
	{
		return this.refresh_button_click;
	}
	public void setGui_data_model(GUI_data_model gui_data_model) {
		this.gui_data_model = gui_data_model;
		
	}
	
}