package common_util_lib;

import java.util.List;

public class Utility {
	
	/*
	 * Reverse generic type T list.
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
	
	/*
	 * Get bigger number within two integer type value.
	 */
	static public int max_num(int left, int right)
	{
		int max = ((left > right) ? left : right);
		return max;
	}
	
	/*
	 * Overload for type float.
	 */
	static public float max_num(float left, float right)
	{
		float max = ((left > right) ? left : right);
		return max;
	}
	
	/*
	 * 3 parameter.
	 */
	static public float max_num(float left, float mid, float right) 
	{
		float max = Math.max(Math.max(left, mid), right);
		return max;
	}
	
	/*
	 * Get index maximum.
	 */
	static public int max_num_index(float left, float mid, float right) 
	{
		float max = max_num(left, mid, right);
		if(max == mid) return 1;
		else if(max == left) return 0;
		else return 2;
	}
}
