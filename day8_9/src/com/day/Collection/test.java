package com.day.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月9日 下午1:04:28
* 类说明
*/
@SuppressWarnings({ "unchecked", "rawtypes" })
public class test {

	public static void main(String[] args) {		
//		demo1();
		demo2();
	}

	public static void demo2() {
		Collection collection = new ArrayList();
		collection.add(new Student("张三",23));
		collection.add(new Student("张三",23));
		collection.add(new Student("张三",23));
		collection.add(new Student("张三",23));
		
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			Student student = (Student) it.next();		//向下转型
			System.out.println(student.getName()+student.getAge());
		}
	} 

	public static void demo1() {
		Collection collection  = new ArrayList();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		
		System.out.println(collection);
	}

}
