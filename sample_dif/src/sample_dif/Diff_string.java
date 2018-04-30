package sample_dif;

import java.util.*;

public class Diff_string extends Diff{
	
	/*
	 * String_object list. left, right has all string and modified condition thorough set_LCS_string_list
	 */
	private List<String_object> left_String_object_list;
	private List<String_object> right_String_object_list;
	
	/*
	 * Constructor
	 */
	public Diff_string(String filepath_left, String filepath_right)
	{
		//������ �޾Ƽ� �� ���� ��� String_object ���·� ���� String_object(String string)
		//�׷� left, right�� List<String_object> �� ���ðŽ�
		//�״㿡 �װ� �Ű������� set_LCS_string_list(left list, right list) ȣ��
		//Profit!
	}
	
	/*
	 * �ּ� ���� ...
	 * ����� �� �ڵ��� �ƴѵ�;;; �� �̰�... LCS �˰��� �´µ� ���� �ȵ����� �˰��� �ñ��ϸ� ����������... by ����
	 */
	public void set_LCS_string_list(List<String_object> left, List<String_object> right) 
	{
		int arr[][] = new int[left.size() + 1][];
		arrayDirection arr_s[][] = new arrayDirection[left.size() + 1][];
		for(int i = 0; i < left.size() + 1; i++) 
		{
			arr[i] = new int[right.size() + 1];
			arr_s[i] = new arrayDirection[right.size() + 1];
		}
		
		for(int i=1;i<=left.size();i++)
		{
			for(int j=1;j<=right.size();j++)
			{
				if(right.get(i-1).string.compareTo(left.get(j-1).string) == 0)
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
		int k = left.size();
	    int l = right.size();
	    List<String_object> left_temp = new ArrayList<String_object>();
	    List<String_object> right_temp = new ArrayList<String_object>();
	    while(arr[k][l]!=0){
	        switch(arr_s[k][l]){
	        case LEFT:
            	{
            		left_temp.add(new String_object(left.get(k-1).string, String_object.Modified_status.DELETE));
            		right_temp.add(new String_object(left.get(k-1).string, String_object.Modified_status.INSERT));
            		k--;
            		break;
            	}
	        case UP:
	            {
	            	left_temp.add(new String_object(left.get(l-1).string, String_object.Modified_status.INSERT));
	            	right_temp.add(new String_object(left.get(l-1).string, String_object.Modified_status.DELETE));
	                l--;
	                break;
	            }
	        case CROSS:
	            {
	            	left_temp.add(new String_object(left.get(k-1).string));
	            	right_temp.add(new String_object(left.get(k-1).string));
	                k--; l--;
	                break;
	            }
	        }
	    }
	    for(int i = k-1; i >= 0; i--) {
	    	left_temp.add(new String_object(left.get(k-1).string, String_object.Modified_status.DELETE));
    		right_temp.add(new String_object(left.get(k-1).string, String_object.Modified_status.INSERT));
	    }
	    for(int i = l-1; i >= 0; i--) {
	    	left_temp.add(new String_object(left.get(l-1).string, String_object.Modified_status.INSERT));
        	right_temp.add(new String_object(left.get(l-1).string, String_object.Modified_status.DELETE));
	    }
		left_temp = String_object.<String_object> reverse(left_temp);
		right_temp = String_object.<String_object> reverse(right_temp);
		this.left_String_object_list = left_temp;
		this.right_String_object_list = right_temp;
	}
}
