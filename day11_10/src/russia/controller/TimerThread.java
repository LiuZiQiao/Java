package russia.controller;

import russia.view.BlockPanel;

public class TimerThread extends Thread{
	private long speed;
	private BlockPanel pan;
	private boolean runFlag = false;
	
	public TimerThread(BlockPanel pan) {
		super();
		this.pan = pan;
	}

	@Override
	public void run() {
		while(true){
			if(runFlag){
				pan.moveDown();
				pan.viewShape();
			}
			try {
				Thread.sleep(this.speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public BlockPanel getPan() {
		return pan;
	}

	public void setPan(BlockPanel pan) {
		this.pan = pan;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public boolean isRunFlag() {
		return runFlag;
	}

	public void setRunFlag(boolean runFlag) {
		this.runFlag = runFlag;
	}
	
}
