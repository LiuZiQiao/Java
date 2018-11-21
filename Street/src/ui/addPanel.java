package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bean.Street;
import service.StreetService;
import service.impl.StreetServiceImpl;


public class addPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 增加信息面板按钮
	private JLabel addNumLabel;
	private JLabel addNameLabel;
	private JLabel addTypeLabel;
	private JLabel addLengthLabel;
	private JLabel addManageLabel;
	private JLabel addLocationLabel;
	private JTextField addNumText;
	private JTextField addNameText;
	private JTextField addTypeText;
	private JTextField addLengthText;
	private JTextField addManageText;
	private JTextField addLocationText;
	private JButton addSubmitBt;
	private JLabel messageLabel;
	
	public addPanel() {
		
		init();
		
		// 增加按钮事件
		addSubmitBt.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if(addNumText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道号不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addNameText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道名不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addTypeText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道类型不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addLengthText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道长度不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addManageText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道负责人不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addLocationText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道所在地不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!addNumText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "街道号必须为纯数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!addLengthText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "街道长度必须为数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(addManageText.getText().matches(".*\\d.*")){
					JOptionPane.showMessageDialog(null, "请填写正确姓名！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					StreetService sp = new StreetServiceImpl();
					Street insertStreet = new Street(addNumText.getText(), addNameText.getText(),
							addTypeText.getText(), Integer.parseInt(addLengthText.getText()), addManageText.getText(), 
							addLocationText.getText());
					if(sp.Insert(insertStreet)) {
						JOptionPane.showMessageDialog(null, "添加成功！", "Success", JOptionPane.PLAIN_MESSAGE);
						addNumText.setText("");
						addNameText.setText("");
						addTypeText.setText("");
						addLengthText.setText("");
						addManageText.setText("");
						addLocationText.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "添加失败！", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
		    }
		});
		
	}
	
	private void init() {
		// 设置增加信息组件
		addNumLabel=new JLabel("街道号:");
		addNumLabel.setSize(100, 100);
		addNumLabel.setLocation(50,70);
		addNumLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		addNameLabel=new JLabel("街道名称:");
		addNameLabel.setSize(100, 100);
		addNameLabel.setLocation(50,150);
		addNameLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		addTypeLabel=new JLabel("街道类型:");
		addTypeLabel.setSize(100, 100);
		addTypeLabel.setLocation(50,230);
		addTypeLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		addLengthLabel=new JLabel("街道长度:");
		addLengthLabel.setSize(100, 100);
		addLengthLabel.setLocation(50,310);
		addLengthLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		addManageLabel=new JLabel("街道负责人:");
		addManageLabel.setSize(100, 100);
		addManageLabel.setLocation(50,390);
		addManageLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		addLocationLabel=new JLabel("街道所在区:");
		addLocationLabel.setSize(100, 100);
		addLocationLabel.setLocation(50,470);
		addLocationLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		messageLabel=new JLabel("增加街道信息");
		messageLabel.setSize(600, 80);
		messageLabel.setLocation(580,30);
		messageLabel.setFont(new Font("楷体", Font.BOLD,32));
		
		addNumText=new JTextField();
		addNumText.setSize(100, 30);
		addNumText.setLocation(50,70);
		
		addNameText=new JTextField();
		addNameText.setSize(100, 30);
		addNameText.setLocation(50,120);
		
		addTypeText=new JTextField();
		addTypeText.setSize(100, 30);
		addTypeText.setLocation(50,170);
		
		addLengthText=new JTextField();
		addLengthText.setSize(100, 30);
		addLengthText.setLocation(50,220);
		
		addManageText=new JTextField();
		addManageText.setSize(100, 30);
		addManageText.setLocation(50,270);
		
		addLocationText=new JTextField();
		addLocationText.setSize(100, 320);
		addLocationText.setLocation(50,530);

		addSubmitBt=new JButton("增加");
		addSubmitBt.setSize(100, 40);
		addSubmitBt.setLocation(600,590);
		
		// 设置增加信息面板
		this.setLayout(null);
		this.add(addNumLabel);
		this.add(addNameLabel);
		this.add(addTypeLabel);
		this.add(addLengthLabel);
		this.add(addManageLabel);
		this.add(addLocationLabel);
		this.add(messageLabel);
		this.add(addNumText);
		this.add(addNameText);
		this.add(addTypeText);
		this.add(addLengthText);
		this.add(addManageText);
		this.add(addLocationText);
		this.add(addSubmitBt);
		this.setBounds(0, 160, 1200, 740);
		this.setVisible(false);
	}
	
}
