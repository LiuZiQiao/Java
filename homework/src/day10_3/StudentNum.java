package day10_3;

import java.util.Scanner;

import javax.xml.transform.Result;

/**
* @author 作者  小小刘
* @version 创建时间：2018年10月3日 下午2:18:06
* 类说明
*/
public class StudentNum {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		System.out.println("请输入12位学号：");
//		Scanner sc = new Scanner(System.in);
//		String string = sc.next();
		NumAndColl("201606060624");
	}
	public static void NumAndColl(String str) {
		String yuan;
		String cla;
		if (str.length() != 12) {
			System.out.println("输入错误");
			return;
		}
		
		if (str.substring(0, 4) != null) {
			System.out.println(str.substring(0, 4)+"级" );
		}
		
		if (str.charAt(4) =='0') {
			yuan = str.substring(5,6);
			System.out.println(choses(yuan));
		}
		else {
			yuan = str.substring(4,6);
			System.out.println(choses(yuan));
			}
	}
	
	public static String choses(String str) {
		String result;
		switch (str) {
		case "1":
			result = "轻工科学与工程学院";
			break;
		case "2":
			result = "材料科学与工程学院";
			break;
		case "3":	
			result = "环境科学与工程学院";
			break;
		case "4":	
			result = "食品与生物工程学院";
			break;
		case "5":
			result = "机电工程学院";
			break;
		case "6":
			result = "电气与信息工程学院";
			break;
		case "7":	
			result = "经济与管理学院";
			break;
		case "8":
			result = "化学与化工学院";
			break;
		case "9":
			result = "设计与艺术学院";
			break;
		case "10":
			result = "文理学院";
			break;
		case "11":
			result = "职业教育师范学院";
		default:
			result = "没有对应学院";
			break;
		}
		return result;
	}
}
