package day10_20;
/**
* @author 作者  小小刘
* @version 创建时间：2018年10月20日 上午10:37:54
* 类说明
*/
import java.util.Scanner;

public class exe_exep {

public static void main(String args[]) {

	score_demo s=new score_demo();
	
	try {
		s.input_score();
		
	} catch (Score_Exception e) {
		System.out.println(e.getMessage());
	}
	
	s.show_score();
	
	}
	
}
	

	
