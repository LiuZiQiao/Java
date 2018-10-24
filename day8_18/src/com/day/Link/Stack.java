package com.day.Link;
/**
* @author 作者  小小刘
* @version 创建时间：2018年8月18日 下午9:19:43
* 类说明
*/

import java.util.LinkedList;

public class Stack {
	private LinkedList list = new LinkedList();
	
	public void in(Object obj) {
		list.addLast(obj);
	}
	
	public Object out()
	{
		return list.removeFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
