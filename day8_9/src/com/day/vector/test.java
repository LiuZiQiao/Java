package com.day.vector;

import java.util.Iterator;
import java.util.Vector;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月10日 上午8:42:59
* 类说明
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class test {

	public static void main(String[] args) {
//		demo();
		demo1();
	}
	public static void demo1() {
		Vector v = new Vector();
		v.add(new Student("张三", 23));
		v.add(new Student("李四", 24));
		v.add(new Student("王五", 25));
		
		Iterator it = v.iterator();
		while (it.hasNext()) {
			Object s = (Student) it.next();
			System.out.println(s);
		}
	}
	public static void demo() {
		Vector v = new Vector();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		
		System.out.println(v);
		System.out.println(v.capacity());
		System.out.println(v.size());
		System.out.println(v.contains("a"));
	}
}
