package day9_14;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月14日 下午2:48:03
* 类说明
*/
public class Dog extends Animal {
	public String color;
	
	public void eat() {
		System.out.println(color+name+"啃骨头");
	}
	
	public void LookDoor()
	{
		System.out.println(color+name+"看门");
	}
	
	public Dog(String name, int age,String color, String death, String fecundity) {
		super(name, age, death, fecundity);
		this.color = color;
	}

}
