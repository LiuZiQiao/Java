package com.day.Link;

import java.util.LinkedList;

/**
* @author 作者  小小刘
* @version 创建时间：2018年8月18日 下午8:32:54
* 类说明
*/
public class Test_LinkList {

	public static void main(String[] args) {
//		demo1();
		/*
		 * Linkedlist模拟实现Stack
		 */
		Stack s = new Stack();
		s.in("a");
		s.in("b");
		s.in("c");
		s.in("d");
		
		while (!s.isEmpty()) {
			System.out.println(s.out());
		}
		
	}

	public static void demo1() {
		LinkedList link = new LinkedList();
		link.addFirst("a");
		link.addFirst("b");
		link.addFirst("c");
		link.addFirst("d");
		link.addLast("e");
		
		while ( !link.isEmpty()) {			
			System.out.println(link.removeFirst());
		}
	}

}
