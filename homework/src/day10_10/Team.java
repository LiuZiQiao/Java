package day10_10;
/**
* @author 作者  小小刘
* @version 创建时间：2018年10月10日 下午2:18:31
* 类说明
*/
public class Team {
	Teacher teacher;
	GradStu gradstu;
	UnderGrad undergrad;
	
	public Team(Teacher teacher, GradStu gradstu, UnderGrad undergrad) {
		super();
		this.teacher = teacher;
		this.gradstu = gradstu;
		this.undergrad = undergrad;
	}
	
	//
	public void Study() {
		System.out.println("交流学习");
	}
	
	public void Eat() {
		System.out.println("吃");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
	
}
