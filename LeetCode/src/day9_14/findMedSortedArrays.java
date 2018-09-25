package day9_14;

import java.util.Arrays;

import javax.lang.model.element.Element;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月14日 下午6:43:26
* 类说明
* 	给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
	请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
	你可以假设 nums1 和 nums2 不同时为空。
*/
public class findMedSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		int[] arr = {1,2,3,4,5,1,2,3,4,5};
		my_print(arr);
		double ret = findMedianSortedArrays(arr1,arr2);
		System.out.println(ret);
	}
	
	public static double findMedianSortedArrays(int[] nums1,int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int left = (len1+len2+1)/2;
		int right = (len1+len2+2)/2;
		return (findKey(nums1,nums2,left) + findKey(nums1, nums2, right)) / 2.0;	
	}
	static int findKey(int[] nums1, int[] nums2, int k) {
		if (nums1.length > nums2.length) {
			return findKey(nums1, nums2, k);
		}
		if (nums1.length == 0) {
			return nums2[k-1];
		}
		if (k == 1) {
			return Math.min(nums1[0], nums2[0]);
		}
		
		int i = Math.min(nums1.length, k/2);
		int j = Math.min(nums2.length, k/2);
		if (nums1[i-1] > nums2[j-1]) {
			return findKey(nums1, Arrays.copyOfRange(nums2, j, nums2.length), k-j);
		}
		else
		{
			return findKey(nums2, Arrays.copyOfRange(nums1, i, nums1.length), k-i);
		}
	}

	public static void my_print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" "  );
		}
	}
}
