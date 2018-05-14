package panel_model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import data_model.GUI_data_model;
import data_model.Pastel_color;

public class Text_panel extends JPanel{
		
	private JTextArea text_area;
	private JScrollPane scroll_pane;
	public static final int font_size = 18;
	public static final int maximum_line_in_window = 36;
	public Color highlight_color = Color.WHITE;
	
	public Text_panel(GUI_data_model.location location, GUI_data_model gui_data_model) 
	{
		super();
		
		//set text area's properties.
		this.text_area = new JTextArea();
		this.text_area.setEditable(false);
		this.text_area.setOpaque(false);
		
		//set scroll pane's properties.
		this.scroll_pane = new JScrollPane(this.text_area);
		this.scroll_pane.setOpaque(false);
		this.scroll_pane.getViewport().setOpaque(false);
		
		//Set each text_area, text_panel of GUI data model.
		if(location == GUI_data_model.location.LEFT) 
		{
			gui_data_model.setLeft_text_area(this.text_area);
			gui_data_model.setLeft_text_panel(this);
		}
		else if(location == GUI_data_model.location.RIGHT)
		{
			gui_data_model.setRight_text_area(this.text_area);
			gui_data_model.setRight_text_panel(this);
		}
		
		//Use BorderLayout.
		this.setLayout(new BorderLayout());
		this.add(this.scroll_pane);
		
		//This color may not be shown cause of BorderLayout.
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < maximum_line_in_window; i++)
        {
        	if( i%2 == 0) g.setColor(Pastel_color.pastel_green);
        	else g.setColor(this.highlight_color);
        	//2 for top Gap.
        	g.fillRect(0, font_size*i + 2, this.getSize().width, font_size);
        }
	}
}
