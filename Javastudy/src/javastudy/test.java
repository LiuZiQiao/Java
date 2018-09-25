package javastudy;

import study.Child;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person z=new Person("zhang",175);
		z.show();
		
		Person wPerson=new Person();
		wPerson.show();
		
		Student s=new Student();
		s.show();
		
		Student t=new Student("wang",170,80);
		t.show();
		
		Child C=new Child();
		C.show();
	}
}
