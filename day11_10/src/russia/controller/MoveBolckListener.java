package russia.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import russia.view.MainFrame;

public class MoveBolckListener implements KeyListener{
	private MainFrame frame;

	public MoveBolckListener(MainFrame frame) {
		super();
		this.frame = frame;
	}

	//不含功能键（F11 ...）
	public void keyTyped(KeyEvent e) {}

	//按下按键触发
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case 37://向左
			frame.getRunPanel().moveLeft();
			break;
		case 38://旋转
			frame.getRunPanel().moveReAngle();
			break;
		case 39://向右
			frame.getRunPanel().moveRight();
			break;
		case 40://向下
			frame.getRunPanel().moveDown();
			break;
		}
		frame.getRunPanel().viewShape();
	}

	//释放按键触发
	public void keyReleased(KeyEvent e) {}

}
