package compare_algorithm;

import java.io.*;
import java.util.*;
import common_util_lib.*;

public class Compare_util_string_list extends Compare_util_string {

	protected enum arrayDirection {
		LEFT, UP, CROSS, SIM_CROSS,
	};

	/*
	 * String_object list. left, right has all string and modified condition
	 * thorough set_LCS_string_list
	 */
	private List<String_object> left_String_object_list;
	private List<String_object> right_String_object_list;
	private int left_list_size; // Left file list(Total String) size
	private int right_list_size; // Right file list(Total String) size
	private int list_size; //

	/*
	 * Constructor with Parsing option, threshold.
	 */
	public Compare_util_string_list(String filepath_left, String filepath_right, parsing_option option,
			float threshold) {
		List<String_object> left_list = new ArrayList<String_object>();
		List<String_object> right_list = new ArrayList<String_object>();
		String tmp; // to read a line in txt file
		String_object input_line; // to convert string to string_object

		try {
			BufferedReader left_in_file = new BufferedReader(new FileReader(filepath_left));
			while ((tmp = left_in_file.readLine()) != null) {
				input_line = new String_object(tmp); // convert string to string_object
				left_list.add(input_line); // add list
			}
			left_in_file.close();
		} catch (IOException e) {
			System.err.println(e); // if it occur error, print.
			System.exit(1);
		}

		try {
			BufferedReader right_in_file = new BufferedReader(new FileReader(filepath_right));
			while ((tmp = right_in_file.readLine()) != null) {
				input_line = new String_object(tmp);
				right_list.add(input_line);
			}
			right_in_file.close();
		} catch (IOException e) {
			System.err.println(e); // if it occur error, print.
			System.exit(1);
		}
		set_LCS_string_list(left_list, right_list, option, threshold);
	}

	/*
	 * Basic Constructor with only filepaths. Default option is Line, threshold with
	 * 1.0f.
	 */
	public Compare_util_string_list(String filepath_left, String filepath_right) {
		List<String_object> left_list = new ArrayList<String_object>();
		List<String_object> right_list = new ArrayList<String_object>();
		String tmp; // to read a line in txt file
		String_object input_line; // to convert string to string_object

		try {
			BufferedReader left_in_file = new BufferedReader(new FileReader(filepath_left));
			while ((tmp = left_in_file.readLine()) != null) {
				input_line = new String_object(tmp); // convert string to string_object
				left_list.add(input_line); // add list
			}
			left_in_file.close();
		} catch (IOException e) {

		}

		try {
			BufferedReader right_in_file = new BufferedReader(new FileReader(filepath_right));
			while ((tmp = right_in_file.readLine()) != null) {
				input_line = new String_object(tmp);
				right_list.add(input_line);
			}
			right_in_file.close();
		} catch (IOException e) {

		}
		set_LCS_string_list(left_list, right_list, parsing_option.LINE, 1.0f);
	}

	/*
	 * Constructor with 2 string list.
	 */
	public Compare_util_string_list(List<String_object> left, List<String_object> right) {
		set_LCS_string_list(left, right, parsing_option.LINE, 1.0f);
	}

	/*
	 * Static Function for GUI using.
	 */
	static public List<String_object> compare(List<String_object> target, List<String_object> source,
			parsing_option option, float threshold) {
		float similarity;

		// Get target, source list size.
		int target_list_size = target.size();
		int source_list_size = source.size();

		// Initialize all Array.
		float arr[][] = new float[target_list_size + 1][];
		arrayDirection arr_s[][] = new arrayDirection[target_list_size + 1][];
		for (int i = 0; i < target_list_size + 1; i++) {
			arr[i] = new float[source_list_size + 1];
			arr_s[i] = new arrayDirection[source_list_size + 1];
		}

		// Set value of Array upon LCS algorithm.
		for (int i = 1; i <= target_list_size; i++) {
			for (int j = 1; j <= source_list_size; j++) {
				similarity = get_similarity(target.get(i - 1).get_string(), target.get(j - 1).get_string(), option);
				if (similarity == (float) 1) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
					arr_s[i][j] = arrayDirection.CROSS;
				} else if (similarity >= threshold) {
					arr[i][j] = arr[i - 1][j - 1] + similarity;
					arr_s[i][j] = arrayDirection.SIM_CROSS;
				} else {
					arr[i][j] = Utility.max_num(arr[i - 1][j], arr[i][j - 1]);
					if (arr[i][j] == arr[i - 1][j])
						arr_s[i][j] = arrayDirection.LEFT;
					else
						arr_s[i][j] = arrayDirection.UP;
				}
			}
		}

		// Temporary variable for indexing.
		int k = target_list_size;
		int l = source_list_size;

		// Temporary List for reverse.
		List<String_object> target_temp = new ArrayList<String_object>();

		// Backtracking to get LCS String list, and set all strings and Modified_status
		// of String_object.
		while (arr[k][l] != 0) {
			switch (arr_s[k][l]) {
			case LEFT: {
				target_temp
						.add(new String_object(target.get(k - 1).get_string(), String_object.Modified_status.DIFFER));
				k--;
				break;
			}
			case UP: {
				target_temp.add(new String_object("", String_object.Modified_status.DIFFER));
				l--;
				break;
			}
			case CROSS: {
				target_temp.add(new String_object(target.get(k - 1).get_string()));
				k--;
				l--;
				break;
			}
			case SIM_CROSS: {
				if (get_if_other_cross(arr_s, k, l) == arrayDirection.LEFT) {
					target_temp.add(
							new String_object(target.get(k - 1).get_string(), String_object.Modified_status.DIFFER));
					k--;
					break;
				} else if (get_if_other_cross(arr_s, k, l) == arrayDirection.UP) {
					target_temp.add(new String_object("", String_object.Modified_status.DIFFER));
					l--;
					break;
				} else {
					target_temp.add(new String_object(target.get(k - 1).get_string(), source.get(l - 1)));
					k--;
					l--;
					break;
				}
			}
			}
		}

		// Set Empty spaces.
		for (int i = k - 1; i >= 0; i--) {
			target_temp.add(new String_object(target.get(i).get_string(), String_object.Modified_status.DIFFER));
		}
		for (int i = l - 1; i >= 0; i--) {
			target_temp.add(new String_object("", String_object.Modified_status.DIFFER));
		}

		// Reverse list.
		target_temp = Utility.<String_object>reverse(target_temp);

		// Return.
		return target_temp;
	}

	/*
	 * Method for Constructor. Same with LCS algorithm for 1 String, compared unit
	 * is not Character but String. Please check comments in source code.
	 */
	private void set_LCS_string_list(List<String_object> left, List<String_object> right, parsing_option option,
			float threshold) {
		float similarity;

		// Get left, right list size.
		this.left_list_size = left.size();
		this.right_list_size = right.size();

		// Initialize all Array.
		float arr[][] = new float[this.left_list_size + 1][];
		arrayDirection arr_s[][] = new arrayDirection[this.left_list_size + 1][];
		for (int i = 0; i < this.left_list_size + 1; i++) {
			arr[i] = new float[this.right_list_size + 1];
			arr_s[i] = new arrayDirection[this.right_list_size + 1];
		}

		// Set value of Array upon LCS algorithm.
		for (int i = 1; i <= this.left_list_size; i++) {
			for (int j = 1; j <= this.right_list_size; j++) {
				similarity = get_similarity(left.get(i - 1).get_string(), right.get(j - 1).get_string(), option);
				if (similarity == (float) 1) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
					arr_s[i][j] = arrayDirection.CROSS;
				} else if (similarity >= threshold) {
					arr[i][j] = arr[i - 1][j - 1] + similarity;
					arr_s[i][j] = arrayDirection.SIM_CROSS;
				} else {
					arr[i][j] = Utility.max_num(arr[i - 1][j], arr[i][j - 1]);
					if (arr[i][j] == arr[i - 1][j])
						arr_s[i][j] = arrayDirection.LEFT;
					else
						arr_s[i][j] = arrayDirection.UP;
				}
			}
		}

		// Temporary variable for indexing.
		int k = this.left_list_size;
		int l = this.right_list_size;

		// Temporary List for reverse.
		List<String_object> left_temp = new ArrayList<String_object>();
		List<String_object> right_temp = new ArrayList<String_object>();

		// Backtracking to get LCS String list, and set all strings and Modified_status
		// of String_object.
		while (arr[k][l] != 0) {
			switch (arr_s[k][l]) {
			case LEFT: {
				left_temp.add(new String_object(left.get(k - 1).get_string(), String_object.Modified_status.DIFFER));
				right_temp.add(new String_object("", String_object.Modified_status.DIFFER));
				k--;
				break;
			}
			case UP: {
				left_temp.add(new String_object("", String_object.Modified_status.DIFFER));
				right_temp.add(new String_object(right.get(l - 1).get_string(), String_object.Modified_status.DIFFER));
				l--;
				break;
			}
			case CROSS: {
				left_temp.add(new String_object(left.get(k - 1).get_string()));
				right_temp.add(new String_object(right.get(l - 1).get_string()));
				k--;
				l--;
				break;
			}
			case SIM_CROSS: {
				if (get_if_other_cross(arr_s, k, l) == arrayDirection.LEFT) {
					left_temp
							.add(new String_object(left.get(k - 1).get_string(), String_object.Modified_status.DIFFER));
					right_temp.add(new String_object("", String_object.Modified_status.DIFFER));
					k--;
					break;
				} else if (get_if_other_cross(arr_s, k, l) == arrayDirection.UP) {
					left_temp.add(new String_object("", String_object.Modified_status.DIFFER));
					right_temp.add(
							new String_object(right.get(l - 1).get_string(), String_object.Modified_status.DIFFER));
					l--;
					break;
				} else {
					left_temp.add(new String_object(left.get(k - 1).get_string(), right.get(l - 1)));
					right_temp.add(new String_object(right.get(l - 1).get_string(), left.get(k - 1)));
					k--;
					l--;
					break;
				}
			}
			}
		}

		// Set Empty spaces.
		for (int i = k - 1; i >= 0; i--) {
			left_temp.add(new String_object(left.get(i).get_string(), String_object.Modified_status.DIFFER));
			right_temp.add(new String_object("", String_object.Modified_status.DIFFER));
		}
		for (int i = l - 1; i >= 0; i--) {
			left_temp.add(new String_object("", String_object.Modified_status.DIFFER));
			right_temp.add(new String_object(right.get(i).get_string(), String_object.Modified_status.DIFFER));
		}

		// Reverse list.
		left_temp = Utility.<String_object>reverse(left_temp);
		right_temp = Utility.<String_object>reverse(right_temp);

		// Get reversed list and set total list size.
		this.left_String_object_list = left_temp;
		this.right_String_object_list = right_temp;
		this.list_size = this.left_String_object_list.size();
	}

	/*
	 * Get direction where exact same string in row, or column.
	 */
	private static arrayDirection get_if_other_cross(arrayDirection[][] arr_s, int k, int l) {
		arrayDirection direction = arrayDirection.SIM_CROSS;
		for (int i = k; i > 0; i--) {
			if (arr_s[i][l] == arrayDirection.CROSS) {
				direction = arrayDirection.LEFT;
			}
		}
		for (int i = l; i > 0; i--) {
			if (arr_s[k][i] == arrayDirection.CROSS) {
				direction = arrayDirection.UP;
			}
		}
		return direction;
	}

	/*
	 * Getter.
	 */
	public List<String_object> get_left_String_object_list() {
		return this.left_String_object_list;
	}

	public List<String_object> get_right_String_object_list() {
		return this.right_String_object_list;
	}

	public int get_list_size() {
		return this.list_size;
	}

	/*
	 * Print method ONLY USE FOR TEST!!!!
	 */
	public void print_List() {
		for (int i = 0; i < this.list_size; i++) {
			System.out.print(this.left_String_object_list.get(i).get_string());
			for (int j = 0; j < 50 - this.left_String_object_list.get(i).get_string().length(); j++)
				System.out.print(" ");
			System.out.println(this.right_String_object_list.get(i).get_string());
		}
	}

}
