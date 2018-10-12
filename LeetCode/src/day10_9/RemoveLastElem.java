package day10_9;

import java.util.ArrayList;

/**
* @author 作者  小小刘
* @version 创建时间：2018年10月9日 上午8:06:12
* 类说明
*/
public class RemoveLastElem {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int[] ret = removelastelem(arr);
		for (int i=0 ; i<ret.length;i++) {
			System.out.println(ret[i]+" ");
		}	
	//	removelastelem(arr);
	}
	
	public static int[] removelastelem(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		list.remove(arr.length-1);
		
//		System.out.println(list);
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
//		System.out.println(list.size());

		int[] num = new int[list.size()];
//		for (int i : num) {
//			num[i] = list.get(i);
//			i++;
//		}
		for (int i = 0; i < num.length; i++) {
			num[i] = list.get(i);
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+",");
		}
		return num;
	}
}
