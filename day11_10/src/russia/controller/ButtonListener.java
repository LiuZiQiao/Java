package russia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import russia.util.Constant;
import russia.view.MainFrame;

public class ButtonListener implements ActionListener{
	private MainFrame frame;

	public ButtonListener(MainFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("开始")){
			frame.getStartBut().setText("暂停");
			frame.getReStartBut().setEnabled(false);
			//点击开始，让窗口得到焦点，才能触发窗口上的事件
			frame.requestFocus();
			//判断是否一次开始
			if(frame.isFirstStartFlag()){
				//需要取形状
				frame.setNewShape();
				frame.setFirstStartFlag(false);
			}
			frame.getT().setSpeed(Constant.INIT_SPEED);
			frame.getT().setRunFlag(true);
		}else if(e.getActionCommand().equals("暂停")){
			frame.getStartBut().setText("开始");
			frame.getReStartBut().setEnabled(true);
			frame.getT().setRunFlag(false);
		}else if(e.getActionCommand().equals("重置")){
			
		}
	}

}
