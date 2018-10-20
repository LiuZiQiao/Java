package day10_20;

import java.net.Socket;
import java.util.Scanner;

/**
* @author 作者  小小刘
* @version 创建时间：2018年10月20日 上午10:43:30
* 类说明
*/
class score_demo {

	static final int number = 2;

	int score[] = new int[number];

	Scanner in = new Scanner(System.in);

	public boolean Verify_score(int score) throws Score_Exception
	{
		if(score<0 ||score>= 100) {
			return false;
		}
		else {
			return true;
		}
	}

	public void input_score() throws Score_Exception {
		System.out.println("请输入" + number + "个学生的成绩");
		Scanner sc = new Scanner(System.in);
		String message;
		for(int i=0;i<number;i++){
			// 代码段4
			score[i] = sc.nextInt();
			if (Verify_score(score[i])) {
				continue;
			}
			else {
				message = "输入错误";
				throw new Score_Exception(message);
			}
		}
	}

	public void show_score() {
		System.out.println("输出" + number + "个学生的成绩的成绩是： 	");

		for (int t : score) {
			System.out.println(t);
		}

	}

}
