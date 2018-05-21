package panel_model;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import button_model.*;
import data_model.GUI_data_model;

public class Top_menu_panel extends JPanel{

	private Edit_button edit_button;
	private Save_button save_button;
	private Find_button find_button;
	private Load_button load_button;
	private Refresh_button refresh_button;
	private Undo_button undo_button;
	private LRmerge_button lr_merge_button;
	private RLmerge_button rl_merge_button;
	
	//Own size.
	public static final int width = 500;
	public static final int height = 68;
	
	public Top_menu_panel(GUI_data_model gui_data_model) 
	{
		super();
		
		//Use FlowLayout.
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 15));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		edit_button = new Edit_button(gui_data_model);
		load_button = new Load_button(gui_data_model);
		save_button = new Save_button(gui_data_model);
		refresh_button = new Refresh_button(gui_data_model);
		undo_button = new Undo_button(gui_data_model);
		lr_merge_button = new LRmerge_button(gui_data_model);
		rl_merge_button = new RLmerge_button(gui_data_model);
	
		this.add(edit_button);
		this.add(load_button);
		this.add(save_button);
		this.add(refresh_button);
		this.add(undo_button);
		this.add(lr_merge_button);
		this.add(rl_merge_button);
	}
}
