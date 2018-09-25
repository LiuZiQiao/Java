package javastudy;

public class Student extends Person {
	private int  score;
	public Student() {
		score=0;
	}
	public Student(String name,int height,int score)
	{
		super(name,height);
		this.score=score;
	}
	public void show() {
	System.out.println("姓名="+getName()+"身高="+getHight()+"成绩="+score);
	}
}
