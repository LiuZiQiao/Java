package list_test;

import javax.lang.model.element.Element;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月10日 下午4:07:19
* 类说明
*/
public class Node<E> {
	private E element;
	private int index;
	private Node<E> next;
	
	public Node(E element, int size) {
		super();
		this.element = element;
		this.index = size;
		this.next = null;
	}
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}
