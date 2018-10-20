package day10_5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 作者 小小刘
 * @version 创建时间：2018年10月5日 下午3:16:10 类说明
 */
public class String_test {

	public static void main(String[] args) {
		// demo1();
//		demo2();
		String str1 = "abcdef";
		String str2 = "123465789";
		ReverseStr(str1);
	}
	
	
	
	
	
	/*
	 * 	实现两个字符串数组的逆序排序，输出结果为字符串数组
	 */
	private static void ReverseStr(String str1) {
		if (str1.length() == 0) {
			return;
		}
	}


	public static void demo2() {
		double[] nums1 = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		double[] nums2 = { 1.6, 1.8, 1.7, 1.4, 1.5 };
		double[] ret = floatinterge(nums1, nums2);
		for (int j = 0; j < ret.length; j++) {
			System.out.println(ret[j]);
		}
	}

	/*
	 *  求两个浮点型数组的并集；
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static double[] floatinterge(double[] nums1, double[] nums2) {
		
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		
		for (int i = 0; i < nums2.length; i++) {
			if (!list.contains(nums2[i])) {
				list.add(nums2[i]);
			}
		}

		double[] d = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			d[i] = list.get(i);
		}
		
		return d;

	}

	public static void demo1() {
		int[] nums1 = { 1, 2, 3, 4 };
		int[] nums2 = { 2, 4, 5, 6 };
		int[] ret = intersection(nums1, nums2);
		// System.out.println(ret);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}

	/*
	 * 求两个整形数组的交集
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
