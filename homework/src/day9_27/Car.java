package day9_27;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月27日 下午1:49:50
* 类说明一．定义一个汽车类，要求该类中至少包含5个私有的属性（为每个属性定义设置和获取方法）,
* 该类中至少包含两个构造方法（一个无参，一个有参），
* 以及包含5~6个方法来描述汽车对象的行为（其中一个方法要能打印输出汽车对象的所有属性值）。
*/
public class Car {
	private String name;		//车名
	private int price;			//价格
	private String brand; 		//牌子
	private String CarNumber;   //车牌号
	private String color; 		//车的颜色
	
	public Car() {}
	
	public Car(String name, int price, String brand, String carNumber, String color) {
//		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
		CarNumber = carNumber;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", brand=" + brand + ", CarNumber=" + CarNumber + ", color="
				+ color + "]";
	}
	
	public void run() {
		System.out.println("Car is running");
	}
	
}
