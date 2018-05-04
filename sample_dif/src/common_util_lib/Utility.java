package common_util_lib;

import java.util.List;

public class Utility {
	
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
	
	static public int max_num(int left, int right)
	{
		int max = ((left > right) ? left : right);
		return max;
	}
	
	static public float max_num(float left, float right)
	{
		float max = ((left > right) ? left : right);
		return max;
	}
}
