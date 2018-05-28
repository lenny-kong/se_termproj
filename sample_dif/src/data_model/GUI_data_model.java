package data_model;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import compare_algorithm.*;
import panel_model.Background_line_graphics_panel;
import panel_model.Left_overview_panel;
import panel_model.Text_panel;

public class GUI_data_model {

	/*
	 * Enum for Button_text_panel.
	 */
	public static enum location {
		LEFT, RIGHT,
	}

	/*
	 * Data members.
	 */
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	private String left_file_path;
	private String right_file_path;
	private List<String_object> left_list;
	private List<String_object> right_list;
	private JFrame load_frame;
	private JFrame main_frame;
	private JLabel left_filepath_area;
	private JLabel right_filepath_area;
	private String left_name;
	private String right_name;

	private Left_overview_panel left_overview_panel;
	private Background_line_graphics_panel left_background_graphics_panel;
	private Background_line_graphics_panel right_background_graphics_panel;

	/*
	 * Constructor
	 */
	public GUI_data_model() {
		left_list = new ArrayList<String_object>();
		right_list = new ArrayList<String_object>();
		left_file_path = "";
		right_file_path = "";
		left_name = "";
		right_name = "";
	}

	/*
	 * Getter & Setter.
	 */
	public JTextArea getLeft_text_area() {
		return left_text_area;
	}
	
	public void setLeft_text_area(JTextArea left_text_area) {
		this.left_text_area = left_text_area;
	}
	
	public JTextArea getRight_text_area() {
		return right_text_area;
	}
	
	public void setRight_text_area(JTextArea right_text_area) {
		this.right_text_area = right_text_area;
	}
	
	public String getRight_file_path() {
		return right_file_path;
	}
	
	public void setRight_file_path(String right_file_path) {
		this.right_file_path = right_file_path;
	}
	
	public String getLeft_file_path() {
		return left_file_path;
	}
	
	public void setLeft_file_path(String left_file_path) {
		this.left_file_path = left_file_path;
	}
	
	public JLabel getLeft_path_area() {
		return left_filepath_area;
	}
	
	public void setLeft_filepath_area(JLabel left_filepath_area) {
		this.left_filepath_area = left_filepath_area;
	}
	
	public JLabel getRight_path_area() {
		return right_filepath_area;
	}
	
	public void setRight_filepath_area(JLabel right_filepath_area) {
		this.right_filepath_area = right_filepath_area;
	}

	public List<String_object> getLeft_list() {
		return left_list;
	}

	public void setLeft_list(List<String_object> left_list) {
		this.left_list = left_list;
	}

	public List<String_object> getRight_list() {
		return right_list;
	}

	public void setRight_list(List<String_object> right_list) {
		this.right_list = right_list;
	}

	public Left_overview_panel getLeft_overview_panel() {
		return left_overview_panel;
	}

	public void setLeft_overview_panel(Left_overview_panel left_overview_panel) {
		this.left_overview_panel = left_overview_panel;
	}

	public Background_line_graphics_panel getLeft_background_graphics_panel() {
		return left_background_graphics_panel;
	}

	public void setLeft_background_graphics_panel(Background_line_graphics_panel left_background_graphics_panel) {
		this.left_background_graphics_panel = left_background_graphics_panel;
	}

	public Background_line_graphics_panel getRight_background_graphics_panel() {
		return right_background_graphics_panel;
	}

	public void setRight_background_graphics_panel(Background_line_graphics_panel right_background_graphics_panel) {
		this.right_background_graphics_panel = right_background_graphics_panel;
	}

	public GUI_data_model getGui_data_model() {
		return this;
	}

	public JFrame getLoad_frame() {
		return load_frame;
	}

	public void setLoad_frame(JFrame load_frame) {
		this.load_frame = load_frame;
	}

	public JFrame getMain_frame() {
		return main_frame;
	}

	public void setMain_frame(JFrame main_frame) {
		this.main_frame = main_frame;
	}

	public String getRight_name() {
		return right_name;
	}

	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}

	public String getLeft_name() {
		return left_name;
	}

	public void setLeft_name(String left_name) {
		this.left_name = left_name;
	}

}
