package sample_dif;

import java.io.*;
import java.util.*;

public class Diff_string extends Diff{
	
	/*
	 * String_object list. left, right has all string and modified condition thorough set_LCS_string_list
	 */
	private List<String_object> left_String_object_list;
	private List<String_object> right_String_object_list;
	private int left_list_size; // Left file list(Total String) size
	private int right_list_size; // Right file list(Total String) size
	private int list_size; // 
	
	/*
	 * Constructor
	 */
	public Diff_string(String filepath_left, String filepath_right)
	{
		
        List<String_object> left_list = new ArrayList<String_object>();
        List<String_object> right_list = new ArrayList<String_object>();
        String tmp; // to read a line in txt file
        String_object input_line; // to convert string to string_object 
        
        try {
        	BufferedReader left_in_file = new BufferedReader(new FileReader(filepath_left));
        	while((tmp=left_in_file.readLine())!=null) {
        		input_line = new String_object(tmp); // convert string to string_object
        		left_list.add(input_line); // add list
        	}
        	left_in_file.close();
        }
        catch (IOException e) {
            System.err.println(e); // if it occur error, print.
            System.exit(1);
        }
        
        try {
        	BufferedReader right_in_file = new BufferedReader(new FileReader(filepath_right));
        	while((tmp=right_in_file.readLine())!=null) {
        		input_line = new String_object(tmp);
        		right_list.add(input_line);
        	}
        	right_in_file.close();
        }
        catch (IOException e) {
            System.err.println(e); // if it occur error, print.
            System.exit(1);
        }
        set_LCS_string_list(left_list,right_list);
        
		//**********************
		//NOT YET IMPLEMENTED!!
		//
		//**********************
		
		/*
		 * ///////////////////////
		 * Guide for implementation.
		 * 1. According to filepath, create new file object and read each line.
		 * 2. Save each line for <String_object> format, and add it into List<String_object>
		 * 3. Call set_LCS_string_list(List<String_object> left list, List<String_object> right list)
		 */
	}
	
	/*
	 * ONLY USE FOR TEST!!!
	 */
	public Diff_string(List<String_object> left, List<String_object> right)
	{
		set_LCS_string_list(left, right);
	}
	
	/*
	 * Method for Constructor.
	 * Same with LCS algorithm for 1 String, compared unit is not Character but String.
	 * Please check comments in source code.
	 */
	private void set_LCS_string_list(List<String_object> left, List<String_object> right) 
	{
		//Get left, right list size.
		this.left_list_size = left.size();
		this.right_list_size = right.size();
		
		//Initialize all Array.
		int arr[][] = new int[this.left_list_size + 1][];
		arrayDirection arr_s[][] = new arrayDirection[this.left_list_size + 1][];
		for(int i = 0; i < this.left_list_size + 1; i++) 
		{
			arr[i] = new int[this.right_list_size + 1];
			arr_s[i] = new arrayDirection[this.right_list_size + 1];
		}
		
		//Set value of Array upon LCS algorithm.
		for(int i=1;i<=this.left_list_size;i++)
		{
			for(int j=1;j<=this.right_list_size;j++)
			{
				if(left.get(i-1).string.compareTo(right.get(j-1).string) == 0)
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
		
		//Temporary variable for indexing.
		int k = this.left_list_size;
	    int l = this.right_list_size;
	    
	    //Temporary List for reverse.
	    List<String_object> left_temp = new ArrayList<String_object>();
	    List<String_object> right_temp = new ArrayList<String_object>();
	    
	    //Backtracking to get LCS String list, and set all strings and Modified_status of String_object.
	    while(arr[k][l]!=0){
	        switch(arr_s[k][l]){
	        case LEFT:
            	{
            		left_temp.add(new String_object(left.get(k-1).string, String_object.Modified_status.INSERT));
            		right_temp.add(new String_object("", String_object.Modified_status.DELETE));
            		k--;
            		break;
            	}
	        case UP:
	            {
	            	left_temp.add(new String_object("", String_object.Modified_status.DELETE));
	            	right_temp.add(new String_object(right.get(l-1).string, String_object.Modified_status.INSERT));
	                l--;
	                break;
	            }
	        case CROSS:
	            {
	            	left_temp.add(new String_object(left.get(k-1).string));
	            	right_temp.add(new String_object(right.get(l-1).string));
	                k--; l--;
	                break;
	            }
	        }
	    }
	    
	    //Set Empty spaces.
	    for(int i = k-1; i >= 0; i--) {
	    	left_temp.add(new String_object(left.get(i).string, String_object.Modified_status.INSERT));
    		right_temp.add(new String_object("", String_object.Modified_status.DELETE));
	    }
	    for(int i = l-1; i >= 0; i--) {
	    	left_temp.add(new String_object("", String_object.Modified_status.DELETE));
        	right_temp.add(new String_object(right.get(i).string, String_object.Modified_status.INSERT));
	    }
	    
	    //Reverse list.
		left_temp = String_object.<String_object> reverse(left_temp);
		right_temp = String_object.<String_object> reverse(right_temp);
		
		//Get reversed list and set total list size.
		this.left_String_object_list = left_temp;
		this.right_String_object_list = right_temp;
		this.list_size = this.left_String_object_list.size();
	}
	
	/*
	 * Print method
	 * ONLY USE FOR TEST!!!!
	 */
	public void print_List() {
		System.out.println("Left size = " + this.left_list_size + " Right size = " + this.right_list_size+ " Total size = " + this.list_size);
		for(int i = 0; i < this.list_size; i++) 
		{
			System.out.print(this.left_String_object_list.get(i).string);
			for(int j = 0; j < 50 - this.left_String_object_list.get(i).string.length() ; j++) System.out.print(" ");
			System.out.println(this.right_String_object_list.get(i).string);
		}
	}
}
