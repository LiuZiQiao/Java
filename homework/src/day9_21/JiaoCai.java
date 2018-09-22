package day9_21;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月21日 下午1:12:22
* 类说明
*/
public class JiaoCai extends Book{
	private String courseName;
	
	public JiaoCai(String name, int price,String courseName) {
		super(name, price);
		this.courseName = courseName;
	}
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean equals(JiaoCai jc) {
		if (super.equals(jc)) {
			if (jc.courseName == courseName) {
				System.out.println("Jiaocai");
				return true;
			}
		}
	
		return false;
	}

	@Override
	public String toString() {
		System.out.println("JiaoCai_toString");
		return  "JiaoCai"+super.toString()+"JiaoCai [courseName=" + courseName + "]";
	}

	
	
	
	
}

