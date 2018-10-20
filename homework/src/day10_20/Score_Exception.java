package day10_20;
/**
* @author 作者  小小刘
* @version 创建时间：2018年10月20日 上午10:42:40
* 类说明
*/
class Score_Exception extends Exception
{
	int i;
	
	public Score_Exception(String message) {
		show_error();
	}
	public void show_error() {
		System.out.println("成绩为：" + i + "  不合理，成绩必须在0-100");
	}
		
	

}