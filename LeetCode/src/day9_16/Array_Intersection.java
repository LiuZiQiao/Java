package day9_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月16日 下午9:47:42
* 类说明
* 给定两个数组，编写一个函数来计算它们的交集。
*/
public class Array_Intersection {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,3,4};
		
		int[] ret = intersection(nums1, nums2);
		System.out.println(ret);
	}
	   public static int[] intersection(int[] nums1, int[] nums2) {
		   Arrays.sort(nums1);
		   Arrays.sort(nums2);
		   
		   List<Integer> tmp = new ArrayList<Integer>();
		   
		   int i = 0,j = 0;
		   while(i<nums1.length && j <nums2.length)
		   {
			   if (nums1[i] < nums2[j]) {
				i++;
			   }
			   else if (nums1[i] > nums2[j]) {
				j++;
			   }
			   else {
				tmp.add(nums1[i]);
			   }
		   }
		   
		   int[] result = new int[tmp.size()];
		   for (int k = 0; k < result.length; k++) {
			result[k] = tmp.get(k);
		}
		return result;
	        
	    }
	   

}
