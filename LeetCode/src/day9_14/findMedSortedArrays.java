package day9_14;

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
		int total = len1+len2;
		if (total %2 == 0) {
			return findKey(nums1,nums2,total/2);
		}
		else {
			return findKey(nums1,nums2,total/2+1);
		}
	}
	
	private static int findKey(int[] nums1, int[] nums2, int i) {
		int p = 0,q = 0;
		if (p>=nums1.length&&q<nums2.length) {
			q++;
		}
		else if (q>=nums1.length&&p<nums2.length) {
			p++;
		}
		else if (nums1[p]>nums2[q]) {
			q++;
		}
		else {
			p++;
		}
		if (p>=nums1.length) {
			return nums2[q];
		}
		else if(q>=nums2.length){
			return nums1[p];
		}
		else {
			return Math.min(nums1[p],nums2[q]);
		}
	}

	public static void my_print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" "  );
		}
	}
}
