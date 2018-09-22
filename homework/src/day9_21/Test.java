package day9_21;


/**
* @author 作者  小小刘
* @version 创建时间：2018年9月21日 下午1:14:32
* 类说明
*/
public class Test {

	public static void main(String[] args) {
		Book book = new JiaoCai("java",20,"java课程设计");
		Book book1 = new JiaoCai("java",20,"java");
		System.out.println(book.equals(book1));
		System.out.println(book.toString());

//		JiaoCai jc = new JiaoCai("java",20,"java课程设计");
//		JiaoCai jc1 = new JiaoCai("java",20,"java课程设计");
//		System.out.println(jc.equals(jc1));
//		System.out.println(jc.toString());
	}

}
