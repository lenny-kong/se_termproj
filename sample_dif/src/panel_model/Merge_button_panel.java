package panel_model;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import button_model.*;
import data_model.GUI_data_model;

public class Merge_button_panel extends JPanel{
	private LRmerge_button lr_merge_button;
	private RLmerge_button rl_merge_button;
	
	public static final int height = 150;
	public static final int width = 70;
	
	public Merge_button_panel(GUI_data_model gui_data_model) {
		super();
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
		//this.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		
		lr_merge_button = new LRmerge_button(gui_data_model);
		rl_merge_button = new RLmerge_button(gui_data_model);
		
		this.add(lr_merge_button);
		this.add(rl_merge_button);
	}
}
