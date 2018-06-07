package window_view;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.UIManager;

import panel_model.*;
import data_model.*;

class MainFrame extends JFrame {
	private Button_text_panel left_button_text_panel;
	private Button_text_panel right_button_text_panel;
	private Top_menu_panel top_menu_panel;
	private Merge_button_panel merge_button_panel;
	private GUI_data_model gui_data_model;
	
	public static final int width = 1390;
	public static final int height = 900;


	public MainFrame() {

		// Init gui data model.
		gui_data_model = new GUI_data_model();

		// Basic setting for Mainframe.
		this.setLayout(null);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Test Window");

		// Construct. Order is important!!!!!
		left_button_text_panel = new Button_text_panel(GUI_data_model.location.LEFT, gui_data_model);
		right_button_text_panel = new Button_text_panel(GUI_data_model.location.RIGHT, gui_data_model);
		top_menu_panel = new Top_menu_panel(gui_data_model);
		merge_button_panel = new Merge_button_panel(gui_data_model);

		this.gui_data_model.setMain_frame(this);

		// Set location each panels.
		left_button_text_panel.setBounds(30, 120, Button_text_panel.width, Button_text_panel.height);
		right_button_text_panel.setBounds(Button_text_panel.width + 190, 120, Button_text_panel.width,
				Button_text_panel.height);
		top_menu_panel.setBounds(1100, 20, Top_menu_panel.width, Top_menu_panel.height);
		merge_button_panel.setBounds(655,400,merge_button_panel.width,merge_button_panel.height);
		
		// Add to frame.
		this.add(left_button_text_panel);
		this.add(right_button_text_panel);
		this.add(top_menu_panel);
		this.add(merge_button_panel);
		this.setLocation(200,100);

		this.gui_data_model.setMain_frame(this);

	}

}

public class MakeFrame {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e) {}
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}