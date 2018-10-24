package com.day.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月18日 下午3:15:19
* 类说明
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestRemove {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");

		ArrayList newList = getSingle(list);
		
		System.out.println(newList);
	}
	
	
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();
		Iterator iterator  = list.iterator();
		
		while (iterator.hasNext()) {
			Object object =  iterator.next();
			
			if (!newList.contains(object)) {
				newList.add(object);
			}
		}
		return newList;
	}
}
