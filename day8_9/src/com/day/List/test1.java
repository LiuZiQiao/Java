package com.day.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月9日 下午1:27:23
* 类说明
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class test1 {

	public static void main(String[] args) {
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

}
