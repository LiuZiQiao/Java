package day10_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author 作者  小小刘
* @version 创建时间：2018年10月6日 下午4:33:09
* 类说明
*/
public class permute {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
//		List<List<Integer>> ret = permute(arr);
//		for (List<Integer> list : ret) {
//			System.out.println(list.size());
//		}
		
		allSort(arr, 0, 2);
	}  
	
	/*
	 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
	 */
	static int count = 0;
	static void allSort(int[] array,int begin,int end){
//	    打印数组的内容
	    if(begin==end){
	        System.out.println(Arrays.toString(array));
	        System.out.println(count);
	        return;
	    }
//	    把子数组的第一个元素依次和第二个、第三个元素交换位置
	    for(int i=begin;i<=end;i++){
	        swap(array,begin,i );
	        count++;
	        allSort(array, begin+1, end);
//	    交换回来
	        swap(array,begin,i );
	    }
	}

	static void swap(int[] array,int a,int b){
	    int tem=array[a];
	    array[a]=array[b];
	    array[b]=tem;
	}

//	public static List<List<Integer>> permute(int[] nums) {
//		
//		ArrayList<List<Integer>> list1 = new ArrayList<>();
//		ArrayList<Integer> list2 = new ArrayList<>();
//
//		if (nums.length == 0) {
//			return null;
//		}
//		for (int j = 0; j < nums.length; j++) {
//			list2.add(nums[j]);
//			for(int i=0;i<nums.length;i++)
//			{
//				if (list2.contains(nums[i])) {
//					i++;
//				}
//		//		list2.add(nums[i]);
//			}
//			list1.add(list2);
//		}
//		return list1;
//	}
}
