package panel_model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import data_model.GUI_data_model;

public class Text_panel extends JPanel {

	private JTextArea text_area;
	private JScrollPane scroll_pane;
	private Background_line_graphics_panel background_line_graphics_panel;

	public static final int width = 400;
	public static final int height = 700;
	
	public Text_panel(GUI_data_model.location location, GUI_data_model gui_data_model) {
		super();

		// set text area's properties.
		
		this.text_area = new JTextArea();
		this.text_area.setEditable(false);
		this.text_area.setOpaque(false);
		this.text_area.setBackground(new Color(0,0,0,0));
		this.text_area.setFont(new Font("Arial", 0, 17));

		// set background line panel's properties.
		this.background_line_graphics_panel = new Background_line_graphics_panel(this.text_area, gui_data_model);
		this.background_line_graphics_panel.setLayout(new BorderLayout());
		this.background_line_graphics_panel.setSize(400,700);
		this.background_line_graphics_panel.add(this.text_area, "Center");
		
		
		// set scroll pane's properties.
		this.scroll_pane = new JScrollPane(this.background_line_graphics_panel);
		//this.scroll_pane.setOpaque(false);
		this.scroll_pane.getViewport().setOpaque(false);

		// Set each text_area, text_panel of GUI data model.
		if (location == GUI_data_model.location.LEFT) {
			gui_data_model.setLeft_text_area(this.text_area);
			gui_data_model.setLeft_background_graphics_panel(this.background_line_graphics_panel);
		} else if (location == GUI_data_model.location.RIGHT) {
			gui_data_model.setRight_text_area(this.text_area);
			gui_data_model.setRight_background_graphics_panel(this.background_line_graphics_panel);
		}

		// Use BorderLayout.
		this.setLayout(new BorderLayout(2,0));
		this.setSize(400,700);
		this.scroll_pane.setLocation(100,0);
		this.add(this.scroll_pane, "Center");
		// This color may not be shown cause of BorderLayout.
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}
}
