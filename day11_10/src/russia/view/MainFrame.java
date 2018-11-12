package russia.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import russia.controller.ButtonListener;
import russia.controller.MoveBolckListener;
import russia.controller.TimerThread;
import russia.model.RussionShape;
import russia.util.Constant;
import russia.util.RussiaShapeUtil;

public class MainFrame extends JFrame{
	//方块面板
	private BlockPanel runPanel;
	//下一个形状面板
	private BlockPanel nextPanel;
	//运行控制面板
	private JPanel viewLablPanel;
	//得分标签
	private JLabel scoreLabl;
	//所消层数标签
	private JLabel layLabel;
	//速度
	private JLabel levLabel;
	//开始暂停按钮
	private JButton startBut;
	//重新开始标签
	private JButton reStartBut;
	
	//第一次开始标记
	private boolean firstStartFlag = true;
	//记录消除层数和得分、等级（速度）标记
	private int score=0;
	private int layCount=0;
	private int level=0;
	//速度
	private int speed = Constant.INIT_SPEED;
	//定义线程
	private TimerThread t;
	
	public MainFrame(){
		super("方块");
		this.setSize(RussiaShapeUtil.getSize());
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		//设定窗口大小不可变
		this.setResizable(false);
		
		//添加运行面板
		addRunPanel();
		//添加下一个面板
		addNextPanel();
		//添加运行控制面板
		addviewLablPanel();
		//添加按钮
		addButton();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加按钮监听器
		addButtonListener();
		//添加键盘事件
		addKeyListener();
		//让窗口得到焦点
		this.requestFocus();
		//运行线程
		t = new TimerThread(this.runPanel);
		//设置守护线程
		t.setDaemon(true);
		t.start();
	}

	/**
	 * 添加键盘事件
	 */
	private void addKeyListener() {
		MoveBolckListener keyListener = new MoveBolckListener(this);
		this.addKeyListener(keyListener);
	}

	private void addButtonListener() {
		ButtonListener butListener = new ButtonListener(this);
		this.startBut.addActionListener(butListener);
		this.reStartBut.addActionListener(butListener);
	}

	/**
	 * 添加按钮
	 */
	private void addButton() {
		this.startBut = new JButton("开始");
		this.startBut.setBounds(
				this.nextPanel.getX(),
				this.viewLablPanel.getY()+this.viewLablPanel.getHeight()+Constant.BLOCK_WIDTH,
				this.viewLablPanel.getWidth(),
				25);
		
		this.add(this.startBut);
		
		this.reStartBut = new JButton("重置");
		//初始时此按钮不可用
		this.reStartBut.setEnabled(false);
		
		this.reStartBut.setBounds(
				this.startBut.getX(),
				this.startBut.getY()+this.startBut.getHeight()+Constant.BLOCK_WIDTH,
				this.startBut.getWidth(),
				25);
		
		this.add(this.reStartBut);
	}

	/**
	 * 添加运行控制面板
	 */
	private void addviewLablPanel() {
		viewLablPanel = new JPanel(null);
		viewLablPanel.setBounds(nextPanel.getX(),
				nextPanel.getY()+nextPanel.getHeight()+Constant.BLOCK_WIDTH,
				nextPanel.getWidth(),
				6*(25+5));
		viewLablPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(viewLablPanel);
		//添加得分
		scoreLabl = new JLabel("0");
		addViewLabel("得分：",0,scoreLabl);
		//添加层数标签
		layLabel = new JLabel("0");
		addViewLabel("层数：",1,this.layLabel);
		//添加等级标签
		levLabel = new JLabel("0");
		addViewLabel("速度：",2,this.levLabel);
		
	}

	private void addViewLabel(String labStr,int index,JLabel lab) {
		JLabel lab1 = new JLabel(labStr);
		lab1.setBounds(5,index*(25*2+5)+5,viewLablPanel.getWidth()-10,25);
		viewLablPanel.add(lab1);
		lab.setBounds(5,25+index*(25*2+5)+5,viewLablPanel.getWidth()-10,25);
		lab.setBorder(new LineBorder(Color.LIGHT_GRAY));//BorderFactory.createBevelBorder(1));
		viewLablPanel.add(lab);
	}

	/**
	 * 添加下一个面板
	 */
	private void addNextPanel() {
		nextPanel = new BlockPanel(4,4,this);
		//获取面板大小  Ctrl+Shift + G
		Dimension size = RussiaShapeUtil.getSize(4,4);
		nextPanel.setBounds(runPanel.getWidth()+runPanel.getX()+Constant.BLOCK_WIDTH, 
				Constant.BLOCK_WIDTH, size.width, size.height);
		//添加到窗口
		this.add(nextPanel);
	}

	/**
	 * 添加运行面板
	 */
	private void addRunPanel() {
		runPanel = new BlockPanel(Constant.ROW,Constant.COL,this);
		//获取面板大小
		Dimension size = RussiaShapeUtil.getSize(Constant.ROW,Constant.COL);
		runPanel.setBounds(Constant.BLOCK_WIDTH, Constant.BLOCK_WIDTH, size.width, size.height);
		//添加到窗口
		this.add(runPanel);
	}

	public BlockPanel getRunPanel() {
		return runPanel;
	}

	public void setRunPanel(BlockPanel runPanel) {
		this.runPanel = runPanel;
	}

	public BlockPanel getNextPanel() {
		return nextPanel;
	}

	public void setNextPanel(BlockPanel nextPanel) {
		this.nextPanel = nextPanel;
	}

	public JPanel getViewLablPanel() {
		return viewLablPanel;
	}

	public void setViewLablPanel(JPanel viewLablPanel) {
		this.viewLablPanel = viewLablPanel;
	}

	public JLabel getScoreLabl() {
		return scoreLabl;
	}

	public void setScoreLabl(JLabel scoreLabl) {
		this.scoreLabl = scoreLabl;
	}

	public JLabel getLayLabel() {
		return layLabel;
	}

	public void setLayLabel(JLabel layLabel) {
		this.layLabel = layLabel;
	}

	public JLabel getLevLabel() {
		return levLabel;
	}

	public void setLevLabel(JLabel levLabel) {
		this.levLabel = levLabel;
	}

	public JButton getStartBut() {
		return startBut;
	}

	public void setStartBut(JButton startBut) {
		this.startBut = startBut;
	}

	public JButton getReStartBut() {
		return reStartBut;
	}

	public void setReStartBut(JButton reStartBut) {
		this.reStartBut = reStartBut;
	}

	public boolean isFirstStartFlag() {
		return firstStartFlag;
	}

	public void setFirstStartFlag(boolean firstStartFlag) {
		this.firstStartFlag = firstStartFlag;
	}

	/**
	 * 取新形状
	 */
	public void setNewShape(){
		this.getRunPanel().setShape(RussionShape.getShape());
		this.getRunPanel().setRelCol(3);
		this.getRunPanel().setRelRow(0);
		this.getRunPanel().viewShape();
		this.getNextPanel().setShape(RussionShape.getShape());
		this.getNextPanel().setRelCol(0);
		this.getNextPanel().viewShape();
	}
	/**
	 * 设置下一个形状
	 */
	public void setNextShape(){
		this.getRunPanel().setShape(this.getNextPanel().getShape());
		this.getRunPanel().setRelCol(3);
		this.getRunPanel().setRelRow(0);
		this.getRunPanel().viewShape();
		this.getNextPanel().setShape(RussionShape.getShape());
		this.getNextPanel().setRelCol(0);
		this.getNextPanel().viewShape();
	}
	/**
	 * 设定得分和层数、速度
	 */
	public void setScore(int layCount){
		this.layCount += layCount;
		this.score += calcScore(layCount);
		//计算等级
		int level = this.layCount/Constant.LEVEL_LAY;
		if(this.level < level){
			addSpeed();
			this.level = level;
		}
		
		this.getLayLabel().setText(String.valueOf(this.layCount));
		this.getScoreLabl().setText(String.valueOf(this.score));
		this.getLevLabel().setText(String.valueOf(this.level));
	}

	/**
	 * 计算得分
	 */
	private int calcScore(int layCount) {
		if(layCount==1){
			return Constant.SCORE_FULL_1;
		}else if(layCount==2){
			return Constant.SCORE_FULL_2;
		}else if(layCount==3){
			return Constant.SCORE_FULL_3;
		}else if(layCount==4){
			return Constant.SCORE_FULL_4;
		}
		return 0;
	}
	/**
	 * 计算速度
	 */
	private void addSpeed(){
		this.speed = (int)(this.speed*(1-0.1));
		System.out.println(this.speed);
		this.t.setSpeed(this.speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public TimerThread getT() {
		return t;
	}

	public void setT(TimerThread t) {
		this.t = t;
	}
	
	
}
