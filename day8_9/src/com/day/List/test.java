package com.day.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月9日 下午1:21:02
* 类说明
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class test {
	public static void main(String[] args) {
//		demo();
//		demo2();
		demo3();
	}
	public static void demo3() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("world");
		list.add("d");
		list.add("e");
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String str = (String)it.next();
			if(str.equals("world")) {
				list.add("javaee");			//这里会抛出ConcurrentModificationException并发修改异常
			}
		}
	}
	
	public static void demo2() {
		List list = new ArrayList();
		list.add(new Student("张三",23));
		list.add(new Student("李四",24));
		list.add(new Student("王五",25));
		list.add(new Student("赵六",26));
		
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Student s = (Student) iterator.next();
			System.out.println(s);
		}
	}
	public static void demo() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Iterator iterator  = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
