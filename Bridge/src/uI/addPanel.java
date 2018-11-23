package uI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bean.Bridge;
import service.BridgeService;
import service.impl.BridgeServiceImpl;

public class addPanel extends JPanel {

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
				if (addNumText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁编号不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addNameText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁名不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addTypeText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁类型不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addLengthText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁长度不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addManageText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁负责人不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addLocationText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁所在区不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!addNumText.getText().matches("^\\d+")) {
					JOptionPane.showMessageDialog(null, "桥梁号必须为纯数字！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!addLengthText.getText().matches("^\\d+")) {
					JOptionPane.showMessageDialog(null, "桥梁长度必须为数字！", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (addManageText.getText().matches(".*\\d.*")) {
					JOptionPane.showMessageDialog(null, "请填写正确姓名！", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					BridgeService sp = new BridgeServiceImpl();
					if (addNumText.getText().trim().equals(sp.findById(addNumText.getText().trim()).getId())) {
						JOptionPane.showMessageDialog(null, "该编号已存在！", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					if (!addNumText.getText().trim().equals(sp.findById(addNumText.getText().trim()).getId())) {
						Bridge insertBridge = new Bridge(addNumText.getText(), addNameText.getText(),
								addTypeText.getText(), Integer.parseInt(addLengthText.getText()),
								addManageText.getText(), addLocationText.getText());
						if (sp.Insert(insertBridge)) {
							JOptionPane.showMessageDialog(null, "添加成功！", "Success", JOptionPane.PLAIN_MESSAGE);
							addNumText.setText("");
							addNameText.setText("");
							addTypeText.setText("");
							addLengthText.setText("");
							addManageText.setText("");
							addLocationText.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "添加失败！", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

	}

	private void init() {
		// 设置增加信息组件
		addNumLabel = new JLabel("桥梁编号:");
		addNumLabel.setSize(100, 30);
		addNumLabel.setLocation(50, 20);
		addNumLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addNumText = new JTextField();
		addNumText.setSize(200, 30);
		addNumText.setLocation(150, 20);

		addNameLabel = new JLabel("桥梁名称:");
		addNameLabel.setSize(100, 100);
		addNameLabel.setLocation(50, 40);
		addNameLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addNameText = new JTextField();
		addNameText.setSize(200, 30);
		addNameText.setLocation(150, 80);

		addTypeLabel = new JLabel("桥梁类型:");
		addTypeLabel.setSize(100, 100);
		addTypeLabel.setLocation(50, 100);
		addTypeLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addTypeText = new JTextField();
		addTypeText.setSize(200, 30);
		addTypeText.setLocation(150, 140);

		addLengthLabel = new JLabel("桥梁长度:");
		addLengthLabel.setSize(100, 100);
		addLengthLabel.setLocation(50, 160);
		addLengthLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addLengthText = new JTextField();
		addLengthText.setSize(200, 30);
		addLengthText.setLocation(150, 200);

		addManageLabel = new JLabel("桥梁负责人:");
		addManageLabel.setSize(100, 100);
		addManageLabel.setLocation(50, 220);
		addManageLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addManageText = new JTextField();
		addManageText.setSize(200, 30);
		addManageText.setLocation(150, 260);

		addLocationLabel = new JLabel("桥梁所在区:");
		addLocationLabel.setSize(100, 100);
		addLocationLabel.setLocation(50, 280);
		addLocationLabel.setFont(new Font("宋体", Font.BOLD, 16));

		addLocationText = new JTextField();
		addLocationText.setSize(200, 30);
		addLocationText.setLocation(150, 320);

		messageLabel = new JLabel("增加桥梁信息");
		messageLabel.setSize(180, 20);
		messageLabel.setLocation(300, 0);
		messageLabel.setFont(new Font("楷体", Font.BOLD, 24));

		addSubmitBt = new JButton("增加");
		addSubmitBt.setSize(100, 40);
		addSubmitBt.setLocation(500, 400);

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
		this.setBounds(0, 160, 900, 740);
		this.setVisible(false);
	}

}
