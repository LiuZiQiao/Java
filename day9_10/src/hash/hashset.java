package hash;

import java.util.HashSet;
import java.util.Iterator;

import bean.Person;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月10日 下午6:01:23
* 类说明
*/
@SuppressWarnings("rawtypes")
public class hashset {

	public static void main(String[] args) {
		demo1();
//		demo2();
	}

	public static void demo2() {
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("张三", 23));
		hs.add(new Person("张三", 23));
		hs.add(new Person("张三", 23));
		
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			Person p =  (Person)it.next();
 			System.out.println(p);
		}
	}

	public static void demo1() {
		HashSet<String> hashset = new HashSet<>();
		hashset.add("a");   //存储后返回boolean 类型 ，重复存储返回false
		hashset.add("b");
		hashset.add("c");
		
		System.out.println(hashset);//[a, b, c]
		Iterator it	= hashset.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for (String string : hashset) {
			System.out.println(string);
		}
//		a
//		b
//		c
	}

}
