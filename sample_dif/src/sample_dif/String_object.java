/*
 * Basic Construct for diff, merge or other method. 
 */
package sample_dif;

import java.util.List;

public class String_object {
	
	String string; //파일에서 읽은 String을 List로 저장.
	Modified_status status; //비교하여 삽입(INSERT), 삭제(DELETE), 무변화(NOCHANGE)를 해당하는 String과 연관
	
	public enum Modified_status
	{
		NOCHANGE,
		INSERT,
		DELETE,
	};
	
	/*
	 * Constructor
	 */
	public String_object(String string, Modified_status status)
	{
		this.string = string;
		this.status = status;
	}
	public String_object(String string)
	{
		this.string = string;
		this.status = Modified_status.NOCHANGE;
	}
	
	/*
	 * Generic method used in Diff_string
	 */
	public static <T> List<T> reverse(List<T> list) {
		int index = 0;
		int mid = list.size()/2;
		int size = list.size();
		T temp;
		while(index != mid) 
		{
			temp = list.get(index);
			list.set(index, list.get(size - index -1));
			list.set(size - index -1, temp);
			index++;
		}
		return list;
	}
}
