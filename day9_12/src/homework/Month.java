package homework;

import java.util.Scanner;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月12日 下午4:13:07
* 类说明
*/
public class Month {

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int month = scanner.nextInt();
			
//			Juage(month);
		    demo(month);
		}
	}
	
	public static void demo(int month) {
		int a = (month-1)/3;
		switch (a) {
	
		case 0:
			if (month == 1) {
			System.out.println(month +"月是冬天");
			break;
			}
			System.out.println(month+"月是春天");
			break;
		case 1:
			System.out.println(month+"月是夏天");
			break;
		case 2:
			System.out.println(month+"月是秋天");
			break;
		case 3:
			System.out.println(month +"月是冬天");
			break;
		default:
			break;
		}
	}
	
	public static void Juage(int month)
	{
		if (month<=4&&month>1) {
			System.out.println(month+"月是春天");
		}
		else {
			if (month > 4&& month <=7) {
				System.out.println(month+"月是夏天");
			}
			else {
				if (month>7&&month<=11) {
					System.out.println(month+"月是秋天");
				}
				else {
					if (month >11&&month <12||month == 1) {
						System.out.println(month +"月是冬天");
					}
				}
			}
		}
	}
}
