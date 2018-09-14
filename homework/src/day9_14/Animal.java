package day9_14;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月14日 下午2:35:45
* 类说明
*/
public class Animal extends Biology {
	

	public int Age;
	
	public Animal(String name,int age,String death, String fecundity) {
		super(name, death, fecundity);
		this.Age = age;
	}
	public void sleep()
	{
		System.out.println(name+"睡觉");
	}
	
	public void eat()
	{
		System.out.println(name+"吃东西");
	}
}
