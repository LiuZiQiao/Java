package com.day.Collection;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月10日 下午10:32:36
* 类说明
*/
public class test1 {

	public static void main(String[] args) {
		
		Student[] arr = new Student[5];

		arr[0] = new Student("1",23);
		arr[1] = new Student("2",23);
		arr[2] = new Student("3",23);
		arr[3] = new Student("4",23);
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.println(arr[i]);
		}
}

}
