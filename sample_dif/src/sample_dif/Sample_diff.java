package sample_dif;

import java.util.*;

public class Sample_diff {

	public static void main(String[] args) {
		//List<String> sample = new ArrayList<String>();
		
		String[] text_left = new String[] 
				{
					"0","1","2","3","50","4","5","6","9"
				};
		String[] text_right = new String[] 
				{
					"3","30","4","5","6","7","8","9","10"
				};
		
		List<String_object> sample_l = new ArrayList<String_object>();
		List<String_object> sample_r = new ArrayList<String_object>();

		for(int i = 0; i < 9; i++) {
			sample_l.add(new String_object(text_left[i]));
			sample_r.add(new String_object(text_right[i]));
		}
		Diff_string differ = new Diff_string(sample_l, sample_r);
		differ.print_List();
	}
}
