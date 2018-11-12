package list_test;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月10日 下午4:14:37
* 类说明
*/
public class Test {

	public static void main(String[] args) {
		MyList<Integer> list1 = new MyList<>();
		MyList<Integer> list2 = new MyList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		
		list2.addAll(list1);
	
	}

}
