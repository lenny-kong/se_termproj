package compare_algorithm;

import java.util.*;

import common_util_lib.*;

public class Compare_util_string {

	protected enum arrayDirection {
		LEFT, UP, CROSS,
	};

	protected enum parsing_option {
		LINE, SYNTAX, LEXICAL,
	};

	/*
	 * Use only for Syntax method. Return Longest Common Sequences string. Import
	 * Algorithm from Wikipedia.
	 */
	static public String get_LCS_string(String target, String source) {
		int arr[][] = new int[target.length() + 1][];
		arrayDirection arr_s[][] = new arrayDirection[target.length() + 1][];
		for (int i = 0; i < target.length() + 1; i++) {
			arr[i] = new int[source.length() + 1];
			arr_s[i] = new arrayDirection[source.length() + 1];
		}

		for (int i = 1; i <= target.length(); i++) {
			for (int j = 1; j <= source.length(); j++) {
				if (target.charAt(i - 1) == source.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
					arr_s[i][j] = arrayDirection.CROSS;
				} else {
					arr[i][j] = Utility.max_num(arr[i - 1][j], arr[i][j - 1]);
					if (arr[i][j] == arr[i - 1][j])
						arr_s[i][j] = arrayDirection.LEFT;
					else
						arr_s[i][j] = arrayDirection.UP;
				}
			}
		}
		int k = target.length();
		int l = source.length();
		String answer = "";
		while (arr[k][l] != 0) {
			switch (arr_s[k][l]) {
			case LEFT: {
				k--;
				break;
			}
			case UP: {
				l--;
				break;
			}
			case CROSS: {
				answer = target.charAt(k - 1) + answer;
				k--;
				l--;
				break;
			}
			}
		}
		return answer;
	}

	/*
	 * Return different word in target and source array.
	 */
	static public List<String> syntax_Analysis_diff(String target, String source) {
		List<String> diff_list = new ArrayList<String>();
		List<String> target_list = new ArrayList<String>();

		String diff = get_LCS_string(target, source);
		String target_array[] = target.split(" ");
		String diff_array[] = diff.split(" ");

		Collections.addAll(diff_list, diff_array);
		Collections.addAll(target_list, target_array);

		target_list.removeAll(diff_list);

		return target_list;
	}

	/*
	 * Return identical word in target and source String. When function may use for
	 * source String, just switch two parameters.
	 */
	static public List<String> syntax_Analysis_identical(String target, String source) {
		List<String> diff_list = new ArrayList<String>();
		List<String> target_list = new ArrayList<String>();

		diff_list = syntax_Analysis_diff(target, source);
		String target_array[] = target.split(" ");
		Collections.addAll(target_list, target_array);

		target_list.removeAll(diff_list);

		return target_list;
	}

	/*
	 * Get Similarity by Syntax Analysis.
	 */
	static private float get_similarity_syntax(String target, String source) {
		float similarity;

		List<String> target_list = new ArrayList<String>();
		List<String> source_list = new ArrayList<String>();

		List<String> identical_string_list = new ArrayList<String>();

		Collections.addAll(target_list, target.split(" "));
		Collections.addAll(source_list, source.split(" "));

		identical_string_list = syntax_Analysis_identical(target, source);

		target_list = (target_list.size() >= source_list.size()) ? target_list : source_list;

		similarity = (float) identical_string_list.size() / (float) target_list.size();

		return similarity;
	}

	/*
	 * Get Similarity by Lexical Analysis.
	 */
	static private float get_similarity_lexical(String target, String source) {
		float similarity;

		String lcs_string = get_LCS_string(target, source);
		lcs_string = lcs_string.replaceAll(" ", "");

		target = (target.length() >= source.length()) ? target : source;
		target = target.replaceAll(" ", "");

		similarity = (float) lcs_string.length() / (float) target.length();

		return similarity;
	}

	/*
	 * Getter for similarity by option
	 */
	static public float get_similarity(String target, String source, parsing_option option) {
		float similarity;

		switch (option) {
		case LINE:
			similarity = (target.equals(source)) ? 1 : 0;
			break;
		case SYNTAX:
			similarity = get_similarity_syntax(target, source);
			break;
		case LEXICAL:
			similarity = get_similarity_lexical(target, source);
			break;
		default:
			similarity = 0;
			break;
		}

		return similarity;
	}

}
