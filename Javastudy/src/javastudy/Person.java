package javastudy;

public class Person {
	protected String name; 
	public int height; 
	public Person()
	{
		this.name="liu";
		this.height=0;
	}
	public Person(String name,int height) {
		this.name=name;
		this.height=height;
	}
	public String getName() {
		return name;
	}
	public int getHight() {
		return height;
	}
	public void show() {
	System.out.println("姓名:"+name+"身高:"+height);
	}
}

