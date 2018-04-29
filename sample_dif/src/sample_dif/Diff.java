package sample_dif;

import java.util.*;

/*
 * Enum for LCS backtracking method.
 */
enum arrayDirection
{
	LEFT,
	UP,
	CROSS,
};
public class Diff {
	
	/*
	 * Simple maximum search method.
	 */
	private int max_num(int left, int right)
	{
		int max = ((left > right) ? left : right);
		return max;
	}
	
	/*
	 * Use only for Syntax method.
	 * Return Longest Common Sequences string.
	 * Import Algorithm from Wikipedia.
	 */
	private String get_LCS_string(String old, String input) 
	{
		int arr[][] = new int[old.length() + 1][];
		arrayDirection arr_s[][] = new arrayDirection[old.length() + 1][];
		for(int i = 0; i < old.length() + 1; i++) 
		{
			arr[i] = new int[input.length() + 1];
			arr_s[i] = new arrayDirection[input.length() + 1];
		}
		
		for(int i=1;i<=old.length();i++)
		{
			for(int j=1;j<=input.length();j++)
			{
				if(old.charAt(i-1) == input.charAt(j-1))
				{
					arr[i][j] = arr[i-1][j-1]+1;
					arr_s[i][j] = arrayDirection.CROSS;
				}
				else
				{
					arr[i][j] = max_num(arr[i-1][j], arr[i][j-1]);
					if(arr[i][j]==arr[i-1][j]) arr_s[i][j] = arrayDirection.LEFT;
					else arr_s[i][j] = arrayDirection.UP;
				}
			}
		}
		int k = old.length();
	    int l = input.length();
	    String answer="";
	    while(arr[k][l]!=0){
	        switch(arr_s[k][l]){
	        case UP:
	            {
	                l--;
	                break;
	            }
	        case CROSS:
	            {
	                answer = old.charAt(k-1)+answer;
	                k--; l--;
	                break;
	            }
	        case LEFT:
	            {
	                k--;
	                break;
	            }
	        }
	    }
		return answer;
	}
	
	/*
	 * Return identical word in target and source array.
	 */
	public List<String> syntax_Analysis_identical(String target, String source) 
	{
		int i = 0;
		List<String> diff_list = new ArrayList<String>();
		List<String> target_list = new ArrayList<String>();
		
		String diff = get_LCS_string(target, source);
		String target_array[] = target.split(" ");
		String diff_array[] = diff.split(" ");
		Collections.addAll(diff_list, diff_array);
		Collections.addAll(target_list, target_array);
		
		for(String syntax : target_list) 
		{
			if(syntax.compareTo(diff_list.get(i)) == 0) i++;
			else 
			{
				diff_list.remove(i);
			}
		}
		return diff_list;
	}
	
	/*
	 * Return different word in target and source String.
	 * When diff function may use for source String, just switch two parameters.
	 */
	public List<String> syntax_Analysis_diff(String target, String source) 
	{
		List<String> identical_list = new ArrayList<String>();
		List<String> target_list = new ArrayList<String>();
		
		identical_list = syntax_Analysis_identical(target, source);
		String target_array[] = target.split(" ");
		Collections.addAll(target_list, target_array);
		
		for(String identical_word : identical_list) 
		{
			target_list.remove(identical_word);
		}
		return target_list;
	}
}
