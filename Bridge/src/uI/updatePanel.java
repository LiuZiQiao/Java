package uI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Bridge;
import service.BridgeService;
import service.impl.BridgeServiceImpl;

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
					JOptionPane.showMessageDialog(null, "桥梁编号不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateNameText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁名称不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateTypeText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁类型不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateLengthText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁长度不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateManageText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁负责人不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateLocationText.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "桥梁所在区域不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!updateNumText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "桥梁编号必须为纯数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!updateLengthText.getText().matches("^\\d+")){
					JOptionPane.showMessageDialog(null, "桥梁长度必须为数字！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(updateManageText.getText().matches(".*\\d.*")){
					JOptionPane.showMessageDialog(null, "请填写正确名称！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					BridgeService sp = new BridgeServiceImpl();
					Bridge updateBridge = new Bridge(updateNumText.getText(), updateNameText.getText(),
							updateTypeText.getText(), Integer.parseInt(updateLengthText.getText()), updateManageText.getText(), 
							updateLocationText.getText());
					if(sp.modfiy(updateBridge)) {
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
		updateNumLabel=new JLabel("桥梁编号:");
		updateNumLabel.setSize(100, 100);
		updateNumLabel.setLocation(50,20);
		updateNumLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateNameLabel=new JLabel("桥梁名称:");
		updateNameLabel.setSize(100, 100);
		updateNameLabel.setLocation(50,90);
		updateNameLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateTypeLabel=new JLabel("桥梁类型:");
		updateTypeLabel.setSize(100, 100);
		updateTypeLabel.setLocation(50,180);
		updateTypeLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateLengthLabel=new JLabel("桥梁长度:");
		updateLengthLabel.setSize(100, 100);
		updateLengthLabel.setLocation(50,260);
		updateLengthLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateManageLabel=new JLabel("桥梁负责人:");
		updateManageLabel.setSize(100, 100);
		updateManageLabel.setLocation(50,340);
		updateManageLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		updateLocationLabel=new JLabel("桥梁所在区:");
		updateLocationLabel.setSize(100, 100);
		updateLocationLabel.setLocation(50,420);
		updateLocationLabel.setFont(new Font("宋体", Font.BOLD,16));
		
		messageLabel=new JLabel("修改桥梁信息");
		messageLabel.setSize(320, 20);
		messageLabel.setLocation(300,0);
		messageLabel.setFont(new Font("楷体", Font.BOLD,24));
		
		updateNumText=new JTextField();
		updateNumText.setSize(200, 30);
		updateNumText.setLocation(50,80);
		
		updateNameText=new JTextField();
		updateNameText.setSize(200, 30);
		updateNameText.setLocation(50,160);
		
		updateTypeText=new JTextField();
		updateTypeText.setSize(200, 30);
		updateTypeText.setLocation(50,240);
		
		updateLengthText=new JTextField();
		updateLengthText.setSize(200, 30);
		updateLengthText.setLocation(50,320);
		
		updateManageText=new JTextField();
		updateManageText.setSize(200, 30);
		updateManageText.setLocation(50,400);
		
		updateLocationText=new JTextField();
		updateLocationText.setSize(200, 30);
		updateLocationText.setLocation(50,480);

		updateSubmitBt=new JButton("确认修改");
		updateSubmitBt.setSize(100, 40);
		updateSubmitBt.setLocation(500,400);
		
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
