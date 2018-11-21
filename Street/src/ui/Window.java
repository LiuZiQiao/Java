package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bean.Manager;
import service.ManagerService;
import service.impl.ManagerServiceImpl;


public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private addPanel aPanel = new addPanel();
	private searchPanel sPanel = new searchPanel();
	private deletePanel dPanel = new deletePanel();
	private updatePanel uPanel = new updatePanel();
	private mainPanel mPanel = new mainPanel();
	private JPanel lPanel;
	
	private String current_panel;
	
	
	// 定义工具栏
	private JToolBar bar = new JToolBar("操作");
	
	// 定义工具栏按钮
	private JButton mainBt;
	private JButton addBt;
	private JButton deleteBt;
	private JButton updateBt;
	private JButton searchBt;
	private JButton exitBt;
	
	// 登录面板按钮
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JButton LoginBt;
	private JButton ExitBt;

	public Window(){
		
		init();
		
		// 窗口设置
		this.add(aPanel);
		this.add(sPanel);
		this.add(dPanel);
		this.add(uPanel);
		this.add(lPanel);
		this.add(mPanel);
		this.setSize(900, 700);
		this.setTitle("街道信息管理系统");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// 退出按钮事件
		exitBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 增加按钮事件
		addBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disappear();
				aPanel.setVisible(true);
				current_panel = "a";
			}
		});
		
		// 查询按钮事件
		searchBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disappear();
				sPanel.setVisible(true);
				current_panel = "s";
			}
		});
		
		// 删除按钮事件
		deleteBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disappear();
				dPanel.setVisible(true);
				current_panel = "d";
			}
		});
		
		// 修改按钮事件
		updateBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disappear();
				uPanel.setVisible(true);
				current_panel = "u";
			}
		});
		
		// 登录按钮事件
		LoginBt.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				Manager admin = new Manager(usernameText.getText().trim(), String.valueOf(passwordText.getPassword()).trim());
				ManagerService ms = new ManagerServiceImpl();
				if(ms.login(admin)) {
					lPanel.setVisible(false);
					remove(lPanel);
					add(bar, BorderLayout.NORTH);
				}
				else if(usernameText.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "用户名不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(String.valueOf(passwordText.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空！", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 登录界面退出按钮事件
		ExitBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	// 设置当前面板为不可见
	private void disappear() {
		if(current_panel == "d") {
			dPanel.setVisible(false);
		}
		else if(current_panel == "u") {
			uPanel.setVisible(false);
		}
		else if(current_panel == "a") {
			aPanel.setVisible(false);
		}
		else if(current_panel == "s") {
			sPanel.setVisible(false);
		}
	}
	
	// 初始化
	private void init() {
		
		//设置主面板按钮
		mainBt = new JButton("主面板", new ImageIcon("img/main.png"));// 创建按钮对象
		mainBt.setVerticalTextPosition(JButton.BOTTOM);
		mainBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(mainBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符

		//设置增加按钮
		addBt = new JButton("增加信息", new ImageIcon("img/add.png"));// 创建按钮对象
		addBt.setVerticalTextPosition(JButton.BOTTOM);
		addBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(addBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符
				
		//设置删除按钮
		deleteBt = new JButton("删除信息", new ImageIcon("img/delete.png"));// 创建按钮对象
		deleteBt.setVerticalTextPosition(JButton.BOTTOM);
		deleteBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(deleteBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符
				
		//设置修改按钮
		updateBt = new JButton("修改信息", new ImageIcon("img/update.png"));// 创建按钮对象
		updateBt.setVerticalTextPosition(JButton.BOTTOM);
		updateBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(updateBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符
				
		//设置查询按钮
		searchBt = new JButton("查询信息", new ImageIcon("img/search.png"));// 创建按钮对象
		searchBt.setVerticalTextPosition(JButton.BOTTOM);
		searchBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(searchBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符
				
		//设置退出按钮
		exitBt = new JButton("退出", new ImageIcon("img/exit.png"));// 创建按钮对象
		exitBt.setVerticalTextPosition(JButton.BOTTOM);
		exitBt.setHorizontalTextPosition(JButton.CENTER);
		bar.add(exitBt);// 添加到工具栏中
		bar.addSeparator(new Dimension(5, 0));// 添加指定大小的分隔符

				
		// 设置工具栏不允许拖动
		bar.setFloatable(false);
				
		init_login();
	}
	
	private void init_login() {
    	// 设置登录面板组件
    	usernameLabel=new JLabel("用户名");
		usernameLabel.setSize(80, 30);
		usernameLabel.setLocation(300,200);
		
		passwordLabel=new JLabel("密    码");
		passwordLabel.setSize(80, 30);
		passwordLabel.setLocation(300,260);
		
		usernameText=new JTextField();
		usernameText.setSize(170, 30);
		usernameText.setLocation(350,200);
				
		passwordText=new JPasswordField();
		passwordText.setSize(170, 30);
		passwordText.setLocation(350,260);
		
		LoginBt=new JButton("登录");
		LoginBt.setSize(70, 30);
		LoginBt.setLocation(350,310);
		
		ExitBt=new JButton("退出");
		ExitBt.setSize(70, 30);
		ExitBt.setLocation(450,310);
		
		// 设置登录面板
		lPanel = new JPanel();
    	lPanel.setLayout(null);
    	lPanel.add(usernameLabel);
    	lPanel.add(passwordLabel);
    	lPanel.add(usernameText);
    	lPanel.add(passwordText);
    	lPanel.add(LoginBt);
    	lPanel.add(ExitBt);
    	lPanel.setBounds(0, 0, 800, 600);
    	lPanel.setVisible(true);
	}
}
