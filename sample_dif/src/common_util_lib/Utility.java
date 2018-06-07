package common_util_lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.swing.JTextArea;

import compare_algorithm.String_object;
import data_model.GUI_data_model;

public class Utility {

	/*
	 * Reverse generic type T list.
	 */
	public static <T> List<T> reverse(List<T> list) {
		int index = 0;
		int mid = list.size() / 2;
		int size = list.size();
		T temp;
		while (index != mid) {
			temp = list.get(index);
			list.set(index, list.get(size - index - 1));
			list.set(size - index - 1, temp);
			index++;
		}
		return list;
	}

	/*
	 * Get bigger number within two integer type value.
	 */
	static public int max_num(int left, int right) {
		int max = ((left > right) ? left : right);
		return max;
	}

	/*
	 * Overload for type float.
	 */
	static public float max_num(float left, float right) {
		float max = ((left > right) ? left : right);
		return max;
	}

	/*
	 * 3 parameter.
	 */
	static public float max_num(float left, float mid, float right) {
		float max = Math.max(Math.max(left, mid), right);
		return max;
	}

	/*
	 * Get index maximum.
	 */
	static public int max_num_index(float left, float mid, float right) {
		float max = max_num(left, mid, right);
		if (max == mid)
			return 1;
		else if (max == left)
			return 0;
		else
			return 2;
	}

	/*
	 * If input is true, return false. Otherwise, true.
	 */
	static public boolean bool_reverse(boolean input) {
		return Boolean.logicalXor(input, true);
	}
	/*
	 * Get the JTextArea and put it in the list.
	 * */
	static public void textarea_to_list(JTextArea target,List<String_object> list) 
	{	list.clear();
		String tmp;
		String_object input_line;
		try {
			StringReader sr = new StringReader(target.getText());
			BufferedReader br = new BufferedReader(sr);
			while ((tmp = br.readLine()) != null) {

				input_line = new String_object(tmp);
					list.add(input_line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * display list in text area
	 */
	
}
