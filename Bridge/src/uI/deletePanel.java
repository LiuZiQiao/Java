package uI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import service.BridgeService;
import service.impl.BridgeServiceImpl;

public class deletePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel deleteLabel;
	private JLabel dLabel;
	private JTextField daleteText;
	private JButton deleteBt;
	
	public deletePanel() {
		
		init();
	}
	
	private void init() {
		
		deleteLabel=new JLabel("删除桥梁信息");
		deleteLabel.setSize(200, 20);
		deleteLabel.setLocation(340,20);
		deleteLabel.setFont(new Font("楷体", Font.BOLD,24));
		
		dLabel=new JLabel("请输入桥梁的编号id");
		dLabel.setSize(230, 150);
		dLabel.setLocation(340,80);
		dLabel.setFont(new Font("宋体", Font.BOLD,24));
		
		daleteText=new JTextField();
		daleteText.setSize(200, 50);
		daleteText.setLocation(340,210);
		
		deleteBt=new JButton("删除");
		deleteBt.setSize(100, 40);
		deleteBt.setLocation(340,300);
		
		this.setLayout(null);
		this.add(daleteText);
		this.add(deleteLabel);
		this.add(dLabel);
		this.add(deleteBt);
		this.setBounds(0, 160, 1320, 740);
		this.setVisible(false);
		
		// 删除按钮事件
		deleteBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BridgeService bs = new BridgeServiceImpl();
            	if (daleteText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "请输入编号！", "Error", JOptionPane.ERROR_MESSAGE);
				}
            	else if (!bs.IdIsExist(daleteText.getText())) {
					JOptionPane.showMessageDialog(null, "编号不存在！", "Success", JOptionPane.PLAIN_MESSAGE);
				} else if( bs.deleteById(daleteText.getText())) {
					JOptionPane.showMessageDialog(null, "删除成功！", "Success", JOptionPane.PLAIN_MESSAGE);
            		}
            		else {
            			JOptionPane.showMessageDialog(null, "删除失败！", "Error", JOptionPane.ERROR_MESSAGE);
            		}
            	}
        });
	}
}
