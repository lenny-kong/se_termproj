package data_model;

import java.util.List;

import javax.swing.JTextArea;

import compare_algorithm.*;

public class GUI_data_model {
	
	public static enum location
	{
		LEFT,
		RIGHT,
	}
	
	private JTextArea left_text_area;
	private JTextArea right_text_area;
	private String left_file_path;
	private String right_file_path;
	private List<String_object> left_list;
	private List<String_object> right_list;
	private Compare_util_string_list compared_string_object_list;
	
	/*
	 * Constructor
	 */
	public GUI_data_model() 
	{
		
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
	public Compare_util_string_list getCompared_string_object_list() {
		return compared_string_object_list;
	}
	public void setCompared_string_object_list(Compare_util_string_list compared_string_object_list) {
		this.compared_string_object_list = compared_string_object_list;
	}
}
