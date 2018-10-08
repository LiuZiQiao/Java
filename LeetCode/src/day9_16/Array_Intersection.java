package day9_16;

import java.util.HashSet;
import java.util.Set;

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
		for (int i = 0; i < ret.length; i++) {
			
			System.out.println(ret[i]);
		}
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet();
		Set<Integer> set2 = new HashSet();
		for (int i = 0; i < nums2.length; i++) {
			set1.add(nums1[i]);
		}
		
		for (int j = 0; j < nums1.length; j++) {
			if (set1.contains(nums2[j])) {
				set2.add(nums2[j]);
			}
		}
		int[] num = new int[set2.size()];
		int i = 0;
		for (Integer n : set2) {
			num[i] = n;
			i++;
		}
		
		return num;
	}

}
