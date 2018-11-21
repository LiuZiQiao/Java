package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import service.StreetService;
import service.impl.StreetServiceImpl;

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
		
		deleteLabel=new JLabel("删除街道信息");
		deleteLabel.setSize(240, 60);
		deleteLabel.setLocation(240,60);
		deleteLabel.setFont(new Font("楷体", Font.BOLD,32));
		
		dLabel=new JLabel("id");
		dLabel.setSize(150, 50);
		dLabel.setLocation(150,210);
		dLabel.setFont(new Font("宋体", Font.BOLD,32));
		
		daleteText=new JTextField();
		daleteText.setSize(1000, 50);
		daleteText.setLocation(220,210);
		
		deleteBt=new JButton("删除");
		deleteBt.setSize(100, 40);
		deleteBt.setLocation(630,400);
		
		this.setLayout(null);
		this.add(daleteText);
		this.add(deleteLabel);
		this.add(dLabel);
		this.add(deleteBt);
		this.setBounds(0, 160, 1440, 740);
		this.setVisible(false);
		
		// 删除按钮事件
		deleteBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	StreetService sp = new StreetServiceImpl();
            	if(sp.deleteById(daleteText.getText())) {
					JOptionPane.showMessageDialog(null, "删除成功！", "Success", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败！", "Error", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
	}
}
