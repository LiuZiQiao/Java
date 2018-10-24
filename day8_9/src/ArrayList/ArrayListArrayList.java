package ArrayList;

import java.util.ArrayList;

import com.day.bean.Student;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月10日 下午4:49:11
* 类说明
*/
public class ArrayListArrayList {

	public static void main(String[] args) {
		ArrayList<ArrayList<Student>> list = new ArrayList<>();
		
		ArrayList<Student> first = new ArrayList<>();

		first.add(new Student("张三",23));
		first.add(new Student("李四",24));
		first.add(new Student("王五",25));
		
		
		ArrayList<Student>  second = new ArrayList<>();

		second.add(new Student("张麻子",26));
		second.add(new Student("李麻子",27));
		second.add(new Student("王麻子",28));
		
		
		list.add(first);
		list.add(second);
		
		
		for (ArrayList<Student> arrayList : list) {
			for (Student s : arrayList) {
				System.out.println(s);
			}
		}
	}
		

}
