package day9_14;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月14日 下午2:50:38
* 类说明
*/
public class Test {

	public static void main(String[] args) {
//		demo();
		Dog dog = new Dog("黃狗", 10,"黃色", "alive", "可以繁殖的");
		dog.eat();
		dog.fecundity();
		dog.live();
		dog.LookDoor();
		dog.sleep();
	}

	public static void demo() {
		Animal animal = new Animal("黃狗", 10, "alive", "可以繁殖的");
		animal.sleep();
		animal.fecundity();
		animal.eat();
		animal.live();
	}

}
