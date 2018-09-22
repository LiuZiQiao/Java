package day9_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import day9_19.Counter;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月19日 下午1:30:10
* 类说明
*/
@SuppressWarnings("resource")
public class Test {
	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int num = s.nextInt();
//		PrintStart(num);
		
//		Test t = new Test();
//		t.Multiplication();
		
//		Scanner s = new Scanner(System.in);
//		int num = s.nextInt();
//		String ret = YearOfAnimal(num);
//		System.out.println(num+"年份属"+ret);
		
		counter();
	}



	public static void counter() {
		boolean flag = true;
		while(flag)
		{
			int a = 0;
			int b = 0;
			int result = 0;
			System.out.println("******************");
			System.out.println("***1.ADD  2.Sub***");
			System.out.println("***3.Div  4.Mul***");
			System.out.println("******************");

			System.out.println("choses:");
			Scanner s = new Scanner(System.in);
			int choses = s.nextInt();
			
			if (choses > 5 || choses <0) {
				System.out.println("input error");
			}
			else
			{
			System.out.println("input:");
			
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			Scanner bc = new Scanner(System.in);
			b = bc.nextInt();
			
			switch (choses) {
			case 1:
				result = Counter.Add(a, b);
				break;
			case 2:
				result = Counter.Sub(a, b);
				break;
			case 3:
				result = Counter.Div(a, b);
				break;
			case 4:
				result = Counter.Mul(a, b);
				break;
			default:
				break;
			}
			
			System.out.println("result："+result);
			}
			System.out.println("是否继续:");
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			 String str = "";
			 do {
			  try {
				str = bf.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  if (str.length() == 0) { 	// 如果输入的字符串为空，则说明只输入了一个回车
			   flag = true;
			  } else {
			   flag = false;
			  }
			 } while (str.length() != 0);
		}
	}
	
	
	
	public static String YearOfAnimal(int number) {
		int num = (number-4) % 12;
		String string = null;
		switch (num) {
		case 0:
			string = "鼠";
			break;
		case 1:
			string = "牛";
			break;	
		case 2:
			string = "虎";
			break;
		case 3:
			string = "兔";
			break;
		case 4:
			string = "龙";
			break;
		case 5:
			string = "蛇";
			break;
		case 6:
			string = "马";
			break;
		case 7:
			string = "羊";
			break;
		case 8:
			string = "猴";
			break;
		case 9:
			string = "鸡";
			break;
		case 10:
			string = "狗";
			break;
		case 11:
			string = "猪";
			break;
		default:
			break;
		}
		
		
		return string;
	}

	public void Multiplication() {
		int i = 1;int j = 1;
		while (i<10) {
			while(j<10)
			{
				System.out.print(i+" * "+j+" = "+i*j+"   ");
				j++;
			}
			System.out.println();
			i++;
			j = 1;
		}
	}
	
	
	public static void PrintStart(int number) {
		int j = 0;int i = 0;
		for (i = 0; i < number-1; i++) {
			for(j = number-i;j > 0;j--)
			{
				System.out.print(" ");
				
			}
			System.out.print("*");
			
			if(i>=0 && i< 9)
			{
				if (i!= 0) {
					
					for(int m = 0;m<2*i-1;m++)
						System.out.print(" ");
					System.out.println("*");
				}
				else
				System.out.println();
			}
//			while(i == 8)
//			{
//				System.out.println("123");
//				for(int m = 0;m<9;m++)
//					System.out.print("*");
//			}
		}
	}
}
