package panel_model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import data_model.GUI_data_model;
import data_model.Pastel_color;

public class Background_line_graphics_panel extends JPanel {

	public int height_per_line = 16;
	public int maximum_line_in_window = 50;
	public Color highlight_color = Color.WHITE;
	private JTextArea text_area;

	public Background_line_graphics_panel(JTextArea text_area) {
		this.text_area = text_area;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int total_line = this.text_area.getLineCount();

		for (int i = 0; i < total_line; i++) {
			if (i % 2 == 0)
				g.setColor(Pastel_color.pastel_green);
			else
				g.setColor(this.highlight_color);
			// 2 for top Gap.
			g.fillRect(0, height_per_line * i, this.getSize().width, height_per_line);
		}
	}
}
