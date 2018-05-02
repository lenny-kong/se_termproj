package sample_dif;

import java.util.*;

public class Sample_diff {

	public static void main(String[] args) {
		
		String[] text_left = new String[] 
				{
						"int main(String args[])",
						"{",
						"int i = 0;",
						"int j = 0;",
						"i = i + j;",
						"printf(i + j);",
						"return 0;",
						"}"
				};
		String[] text_right = new String[] 
				{
						"package tweeter;",
						"class instagram",
						"{",
						"int main(String args[])",
						"{",
						"int i = 0;",
						"int k = 0;",
						"int j = 0;",
						"k = i + j;",
						"printf(i + j);",
						"return 0;",
						"}",
						"}"
				};
		
		List<String_object> sample_l = new ArrayList<String_object>();
		List<String_object> sample_r = new ArrayList<String_object>();

		for(int i = 0; i < text_left.length; i++) {
			sample_l.add(new String_object(text_left[i]));
			
		}
		for(int i = 0; i < text_right.length; i++) {
			sample_r.add(new String_object(text_right[i]));
		}
		Diff_string differ = new Diff_string(sample_l, sample_r);
		differ.print_List();
	}
}
