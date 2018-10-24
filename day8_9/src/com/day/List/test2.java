package com.day.List;

import java.util.ArrayList;
import java.util.Iterator;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月10日 下午11:08:50
* 类说明
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class test2 {

	public static void main(String[] args) {
		
//		demo();
		demo1();
	}

	public static void demo1() {
		ArrayList arr = new ArrayList();
		arr.add(new Student("张三", 23));
		arr.add(new Student("李四",24));
		
		System.out.println(arr);
		
		Iterator it = arr.iterator();
		while (it.hasNext()) {
			Student student = (Student) it.next();
			System.out.println(student.getName()+"..."+student.getAge());
		}
	}

	public static void demo() {
		ArrayList arr = new ArrayList();
		arr.add("a");
		arr.add("b");
		arr.add("c");
		arr.add("d");
		
		System.out.println(arr);
	}

}
