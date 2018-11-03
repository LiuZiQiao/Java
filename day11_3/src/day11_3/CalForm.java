package day11_3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.Marshaller.Listener;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月3日 下午6:38:47
* 类说明
*/
public class CalForm extends JFrame{
	
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	
	JPanel panel1;
	JPanel panel2;
	JButton[] bts1;
	JButton[] bts2;
	
	JTextField text1;

		public CalForm() {
		
			this.setSize(355, 347);
			this.setTitle("普通计算器");
			this.setLayout(null);
			
			//文本显示域
			text1 = new JTextField();
			text1.setSize(320, 50);
			text1.setLocation(10, 10);
			this.add(text1);
		
		//监听器操作按钮	
		ActionListener command = new CommandAction();
	
		panel1 = new JPanel();
		panel1.setSize(320,150);
		panel1.setLocation(10, 70);
		
		bts1 = new JButton[20]; 
		String[] str1s= {"MC","MR","MS","M+","M-","←","CE","C","+-","√","7","8","9","/","%","4","5","6","*","1/x"};
		panel1.setLayout(new GridLayout(4, 5, 3, 3));
		
		for (int i = 0; i < str1s.length; i++) {
			bts1[i] = new JButton(str1s[i]);
			panel1.add(bts1[i]);
			addButton1(bts1[i],command);
//			bts1[i].addActionListener(this);
		}
		
		this.add(panel1);
		
		panel2 = new JPanel();
		panel2.setSize(255,33);
		panel2.setLocation(10, 223);
		
		bts2 = new JButton[4];
		String[] strs2 = {"1","2","3","-"};
		panel2.setLayout(new GridLayout(1, 4, 3, 3));
		
		for(int i=0;i<strs2.length;i++)
		{
			bts2[i] = new JButton(strs2[i]);
			panel2.add(bts2[i]);
			addButton2(bts2[i], command);
//			bts2[i].addActionListener(this);
		}
		
		bt1 = new JButton("0");
		bt1.setSize(125,33);
		bt1.setLocation(10,260);
		this.add(bt1);
		addButton2(bt1, command);
//		bt1.addActionListener(this);
		
		bt2 = new JButton(".");
		bt2.setSize(60,33);
		bt2.setLocation(138,260);
		this.add(bt2);
		addButton2(bt2, command);
//		bt2.addActionListener(this);
		
		bt3 = new JButton("+");
		bt3.setSize(60,33);
		bt3.setLocation(203,260);
		this.add(bt3);
		addButton2(bt3, command);
//		bt2.addActionListener(this);
		
		bt4 = new JButton("=");
		bt4.setSize(60,70);
		bt4.setLocation(266,223);
		this.add(bt4);
		addButton2(bt4, command);
//		bt2.addActionListener(this);
		
		this.add(panel2);
		
		this.setVisible(true);
	}



	public void addButton1(JButton jButton, ActionListener command) {
		JButton button = new JButton();
		button.addActionListener(listener);
		panel1.add(button);

		}
	public void addButton2(JButton jButton, ActionListener command) {
		JButton button = new JButton();
//		button.addActionListener(listener);
		panel2.add(button);

		}


//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton button1 = (JButton) e.getSource();
//		text1.setText(text1.getText()+button1.getText());
//	}
	
}
