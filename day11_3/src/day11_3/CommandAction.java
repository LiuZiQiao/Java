package day11_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import day11_3.CalForm;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月3日 下午9:35:44
* 类说明
*/
public class CommandAction extends CalForm implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
					String nowButton = (String)e.getActionCommand();
					
					if (nowButton != "BackSace" && nowButton != "=") {
						//如果是回退和=就不打印这个了
						text1.setText(text1.getText() + nowButton);
					}
					
					if (nowButton.equals("=")) {
						//如果是等于号，就计算结果
						text1.setText(text1.getText());
					}
					
					if (nowButton.equals("BackSace")) {
						//回退一个字符
						StringBuffer sb = new StringBuffer(text1.getText());
						text1.setText(sb.substring(0, sb.length()-1));
					}
					if (nowButton.equals("C")) {
						//清空
						text1.setText("");
					}
				}

	}
