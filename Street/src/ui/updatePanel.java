package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Street;
import service.StreetService;
import service.impl.StreetServiceImpl;

public class updatePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel updateNumLabel;
	private JLabel updateNameLabel;
	private JLabel updateTypeLabel;
	private JLabel updateLengthLabel;
	private JLabel updateManageLabel;
	private JLabel updateLocationLabel;
	private JTextField updateNumText;
	private JTextField updateNameText;
	private JTextField updateTypeText;
	private JTextField updateLengthText;
	private JTextField updateManageText;
	private JTextField updateLocationText;
	private JButton updateSubmitBt;
	private JLabel messageLabel;
	
	public updatePanel() {
		init();
		
		// 修改按钮事件
		updateSubmitBt.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if(updateNumText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道号不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateNameText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道名不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateTypeText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道类型不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateLengthText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道长度不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateManageText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道负责人不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateLocationText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "街道所在地不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!updateNumText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "街道号必须为纯数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!updateLengthText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "街道长度必须为数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateManageText.getText().matches(".*\\d.*")){
					JOptionPane.showMessageDialog(null, "请填写正确姓名！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					StreetService sp = new StreetServiceImpl();
					Street updateStreet = new Street(updateNumText.getText(), updateNameText.getText(),
							updateTypeText.getText(), Integer.parseInt(updateLengthText.getText()), updateManageText.getText(), 
							updateLocationText.getText());
					if(sp.modfiy(updateStreet)) {
						JOptionPane.showMessageDialog(null, "修改成功！", "Success", JOptionPane.PLAIN_MESSAGE);
						updateNumText.setText("");
						updateNameText.setText("");
						updateTypeText.setText("");
						updateLengthText.setText("");
						updateManageText.setText("");
						updateLocationText.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败！", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
		    }
		});
	}
	
	private void init() {
		updateNumLabel=new JLabel("街道号:");
		updateNumLabel.setSize(100, 100);
		updateNumLabel.setLocation(50,70);
		updateNumLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateNameLabel=new JLabel("街道名称:");
		updateNameLabel.setSize(100, 100);
		updateNameLabel.setLocation(50,150);
		updateNameLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateTypeLabel=new JLabel("街道类型:");
		updateTypeLabel.setSize(100, 100);
		updateTypeLabel.setLocation(50,230);
		updateTypeLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateLengthLabel=new JLabel("街道长度:");
		updateLengthLabel.setSize(100, 100);
		updateLengthLabel.setLocation(50,310);
		updateLengthLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateManageLabel=new JLabel("街道负责人:");
		updateManageLabel.setSize(100, 100);
		updateManageLabel.setLocation(50,390);
		updateManageLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateLocationLabel=new JLabel("街道所在区:");
		updateLocationLabel.setSize(100, 100);
		updateLocationLabel.setLocation(50,470);
		updateLocationLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		messageLabel=new JLabel("修改街道信息(by id only)");
		messageLabel.setSize(600, 80);
		messageLabel.setLocation(580,30);
		messageLabel.setFont(new Font("楷体", Font.BOLD,32));
		
		updateNumText=new JTextField();
		updateNumText.setSize(1300, 30);
		updateNumText.setLocation(50,130);
		
		updateNameText=new JTextField();
		updateNameText.setSize(1300, 30);
		updateNameText.setLocation(50,210);
		
		updateTypeText=new JTextField();
		updateTypeText.setSize(1300, 30);
		updateTypeText.setLocation(50,290);
		
		updateLengthText=new JTextField();
		updateLengthText.setSize(1300, 30);
		updateLengthText.setLocation(50,370);
		
		updateManageText=new JTextField();
		updateManageText.setSize(1300, 30);
		updateManageText.setLocation(50,450);
		
		updateLocationText=new JTextField();
		updateLocationText.setSize(1300, 30);
		updateLocationText.setLocation(50,530);

		updateSubmitBt=new JButton("修改");
		updateSubmitBt.setSize(100, 40);
		updateSubmitBt.setLocation(600,590);
		
		// 设置增加信息面板
		this.setLayout(null);
		this.add(updateNumLabel);
		this.add(updateNameLabel);
		this.add(updateTypeLabel);
		this.add(updateLengthLabel);
		this.add(updateManageLabel);
		this.add(updateLocationLabel);
		this.add(messageLabel);
		this.add(updateNumText);
		this.add(updateNameText);
		this.add(updateTypeText);
		this.add(updateLengthText);
		this.add(updateManageText);
		this.add(updateLocationText);
		this.add(updateSubmitBt);
		this.setBounds(0, 160, 1440, 740);
		this.setVisible(false);
	}
}
