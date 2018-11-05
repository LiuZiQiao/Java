package bitmap;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月4日 下午5:48:57
* 类说明
*/
public class Test {
	
	public static Set<Integer> test(int[] arr)
	{
		int j = 0;
		Set<Integer> output = new HashSet<>();
		
		BitSet bitSet = new  BitSet(Integer.MAX_VALUE);
		
		int i = 0;
		while(i<arr.length)
		{
			int value = arr[i];
			
			if (bitSet.get(value)) {
				output.add(value);
			}
			else
			{
				bitSet.set(value,true);
			}
			i++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,1,2,6};
		Set<Integer> t = test(arr);
		System.out.println(t);
	}

}
