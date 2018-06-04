package button_model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.StringTokenizer;

import button_controller.Refresh_button_actionlistener;
import compare_algorithm.Compare_util_string_list;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import data_model.Pastel_color;
import panel_model.Background_line_graphics_panel;
import panel_model.Text_panel;
import window_view.Icon_image_load;

public class Refresh_button extends Button_model {

	private final String default_image_path = "icon_image/refresh/refresh.png";
	private final String pushed_image_path = "icon_image/refresh/refresh_push.png";
	private final String mouseover_image_path = "icon_image/refresh/refresh_mouseover.png";

	private Background_line_graphics_panel left_background_graphics_panel;
	private Background_line_graphics_panel right_background_graphics_panel;
	private GUI_data_model gui_data_model;

	public Refresh_button(GUI_data_model gui_data_model) {
		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/refresh/refresh.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Refresh";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));

		// Test implements.
		this.left_background_graphics_panel = gui_data_model.getLeft_background_graphics_panel();
		this.right_background_graphics_panel = gui_data_model.getRight_background_graphics_panel();
		// Add its own ActionListener.
		this.addActionListener(new Refresh_button_actionlistener());

		this.gui_data_model = gui_data_model;
	}

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	}
	   public void tokenize_compare_list() {
		      StringTokenizer left_token = new StringTokenizer(gui_data_model.getLeft_text_area().getText(), "\n");
		      StringTokenizer right_token = new StringTokenizer(gui_data_model.getRight_text_area().getText(), "\n");
		      // tokenize for insert that  data in list
		      int cnt;
		      gui_data_model.getLeft_list().clear();
		      gui_data_model.getRight_list().clear();
		      // delete before data in left or right list
		      
		      for (cnt = left_token.countTokens(); cnt > 0; cnt--) {
		         gui_data_model.getLeft_list().add(new String_object(left_token.nextToken()));
		      }
		      for (cnt = right_token.countTokens(); cnt > 0; cnt--) {
		         gui_data_model.getRight_list().add(new String_object(right_token.nextToken()));
		      }
		      //put data in list
		   }

		   public void compare_list() {
		      Compare_util_string_list compare;
		      compare = new Compare_util_string_list(gui_data_model.getLeft_list(), gui_data_model.getRight_list());
		      gui_data_model.setLeft_list(compare.get_left_String_object_list());
		      gui_data_model.setRight_list(compare.get_right_String_object_list());
		      // apply Algorithm to left and right list
		   }
		   public void print_list_text_area() {
		      int cnt = 0;
		      gui_data_model.getLeft_text_area().setText(null);
		      gui_data_model.getRight_text_area().setText(null);
		      // delete all contents in left and right text area to show compare list in gui after algorithm
		      
		      for (cnt = 0; cnt < gui_data_model.getLeft_list().size(); cnt++) {
		         gui_data_model.getLeft_text_area().append(gui_data_model.getLeft_list().get(cnt).get_string());
		         gui_data_model.getLeft_text_area().append("\n");
		      }
		      for (cnt = 0; cnt < gui_data_model.getRight_list().size(); cnt++) {
		         gui_data_model.getRight_text_area().append(gui_data_model.getRight_list().get(cnt).get_string());
		         gui_data_model.getRight_text_area().append("\n");
		      }
		      // put.. data..
		   }

	// Called when Refresh button is pushed. for TEST.

}
