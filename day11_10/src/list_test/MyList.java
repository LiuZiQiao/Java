package list_test;


/**
* @author 作者  小小刘
* @version 创建时间：2018年11月10日 下午4:05:47
* 类说明
*/
public class MyList<E>{
	private Node<E> node;
	private int size;
	
	
	public MyList() {
		size = 0;
		node=null;
	}
	
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(e,size);
		if (size == 0) {
			node = newNode;
		}else {
			
		}
		
		return true;
		
	}
	public boolean addAll(MyList<Integer> e) {
		
		
		return false;
		
	}

	
	private Node<E> getLastNode(){
		//过滤非法
		if(size == 0){
			return null;
		}
//		//获取第一个节点
//		Node<E> tmpNode = first;
//		//循环判断是否到最后一个节点
//		while(tmpNode.getNext() != null){
//			tmpNode = tmpNode.getNext();
//		}
//		return tmpNode;
		
		return getIndexNode(size - 1);
	}
	
}