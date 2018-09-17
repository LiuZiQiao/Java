package day9_16;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月16日 下午9:47:42
* 类说明
* 给定两个数组，编写一个函数来计算它们的交集。
*/
public class Array_Intersection {

	public static void main(String[] args) {
		Solution s =  new Solution();
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,3,4};
		
		int[] ret = s.intersection(nums1, nums2);
		System.out.println("123");
		System.out.println(ret.length);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
 	}

}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		int[] res = {0};
		int i = 0;int n = 0;
		do {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					res[n] = nums2[j];
					n++;
				}
			}
		} while (i<nums1.length);
    	return res;
    }
}