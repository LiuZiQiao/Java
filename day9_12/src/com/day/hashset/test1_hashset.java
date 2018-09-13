package com.day.hashset;

import java.time.Period;
import java.util.HashSet;

import com.day.bean.Person;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月12日 下午8:31:53
* 类说明
*/
public class test1_hashset {

	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<>();
		
		hs.add(new Person("张三",23));
		hs.add(new Person("张三",23));
		hs.add(new Person("张三",23));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("王五",25));
		
		System.out.println(hs);
			
 	}
	
}
