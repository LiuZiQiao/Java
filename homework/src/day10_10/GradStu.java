package day10_10;
/**
* @author 作者  小小刘
* @version 创建时间：2018年10月10日 下午2:21:02
* 类说明
* 研究生
*/
public class GradStu {
	private String name;
	private String sex;
	private int age;
	private int num;
	
	
	public GradStu() {
//		super();
	}
	public GradStu(String name, String sex, int age, int num) {
//		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
