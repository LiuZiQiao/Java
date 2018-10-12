package day10_3;
/**
* @author 作者  小小刘
* @version 创建时间：2018年10月3日 下午12:55:15
* 类说明
*/
public class ReplaceSpace {

	public static void main(String[] args) {
		String str = "We Are Happy";
		System.out.println(str);
		replaceSpace(str);
		System.out.println(str);
	}

	public static void replaceSpace(String str) {
		if (str == null) {
			return;	
		}
		int len = str.length();
		while(str != null)
		{
			if (str == " ") {
				str.replace(" ", "%");
				str.replace(" ", "2");
				str.replace(" ", "0");
				len++;
			}
		}
	}
	
	
}
