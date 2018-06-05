package panel_model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import button_model.*;
import data_model.GUI_data_model;

public class Filepath_panel extends JPanel {

	// Other button would be implemented.
	private JLabel file_name_area;
	public static final int width = 400;
	public static final int height = 30;
	
	public Filepath_panel(GUI_data_model.location location, GUI_data_model gui_data_model) {
		super();
		
		// Use FlowLayout.
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setPreferredSize(new Dimension(width,height));
		
		file_name_area = new JLabel("");
		file_name_area.setText(" File Not Selected.");
		this.add(file_name_area);
		this.file_name_area.setFont(new Font("Arial",Font.BOLD,15));
		
		if(location == GUI_data_model.location.LEFT) {
			gui_data_model.setLeft_filepath_label(this.file_name_area);
		}else if(location == GUI_data_model.location.RIGHT) {
			gui_data_model.setRight_filepath_label(this.file_name_area);
		}		
		// Load 되었을때 파일 이름이 보이게끔.
		
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}
}