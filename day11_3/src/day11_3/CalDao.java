package day11_3;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月3日 下午7:55:36
* 类说明  jissuan 
*/

public class CalDao implements ActionListener{

	//用来计算的方法
		public String ActionJiS(String string) {
			StringBuffer sb = new StringBuffer(string);
			int commandCount = 0;//符号数量
			
			int j = 0;//计数器
			//计算有多少个运算符，就有n+1个数字
			for (j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) <= '9' && sb.charAt(j) >= '0' || sb.charAt(j) == '.') {
					continue;
				}else {
					commandCount++;
				}
			}
			
			//初始化符号数组
			char[] command = new char[commandCount];
			//初始化数字数组（用字符串表示）
			String[] num = new String[commandCount+1];
			for (j = 0; j < num.length; j++) {
				num[j] = "";
			}
	 
			//遍历一遍，吧每个数字存进数字数组，每个符号存进符号数组
			int k = 0;
			for (j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) <= '9' && sb.charAt(j) >= '0' || sb.charAt(j) == '.') {
					num[k] += sb.charAt(j);
					continue;
				}else {
					command[k] = sb.charAt(j);
					k++;
				}
			}
			
			//计算结果
			double result = 0;
			for (int i = 0; i < commandCount; i++) {
				
				//取前两个数，和第一个操作符，运算
				double num1 = Double.parseDouble(num[i]);
				double num2 = Double.parseDouble(num[i+1]);
				char cc = command[i];
				
				//计算
				switch (cc) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					break;
				}
				num[i+1] = String.valueOf(result);
			}
			
			return String.valueOf(result);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
}