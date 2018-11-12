package russia.view;

import javax.swing.JPanel;

import russia.model.RussionShape;
import russia.util.Constant;

public class BlockPanel extends JPanel{
	private int row;
	private int col;
	private JPanel[][] pan;
	//形状
	private RussionShape shape;
	//定义相对位置
	private int relRow = 0;
	private int relCol = 3;
	//记录落下方块的位置
	private boolean[][] downFlag;
	//窗口引用
	private MainFrame frame;
	
	public BlockPanel(int row, int col, MainFrame frame) {
		super();
		
		this.frame = frame;
		this.row = row;
		this.col = col;
		//定义面板布局管理器
		this.setLayout(null);
		//设定网格颜色
		this.setBackground(Constant.COLOR_GRID_BLOCK);
		//添加小方块矩阵
		addPan();
		
		downFlag = new boolean[row][col];
	}

	/**
	 * 添加小方块矩阵
	 */
	private void addPan() {
		pan = new JPanel[row][col];
		for (int i = 0; i < pan.length; i++) {
			for (int j = 0; j < pan[i].length; j++) {
				pan[i][j] = new JPanel();
				pan[i][j].setBackground(Constant.COLOR_BACKGROUND);
				pan[i][j].setBounds(
						j*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+Constant.BLOCK_BORDER_WIDTH, 
						i*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+Constant.BLOCK_BORDER_WIDTH,
						Constant.BLOCK_WIDTH, Constant.BLOCK_WIDTH);
				this.add(pan[i][j]);
			}
		}
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public JPanel[][] getPan() {
		return pan;
	}

	public void setPan(JPanel[][] pan) {
		this.pan = pan;
	}

	public RussionShape getShape() {
		return shape;
	}

	public void setShape(RussionShape shape) {
		this.shape = shape;
	}
	
	public void viewShape(){
		if(shape == null){
			return;
		}
		//显示运行形状
		int[][] posi = shape.getPosi();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				//重置方块颜色
				pan[i][j].setBackground(Constant.COLOR_BACKGROUND);
				//重置边线为null
				pan[i][j].setBorder(null);
				for (int k = 0; k < posi.length; k++) {
					if(i == posi[k][0]+relRow && j == posi[k][1]+relCol){
						pan[i][j].setBackground(Constant.COLOR_BACKGROUND_BLOCK);
						pan[i][j].setBorder(Constant.BORDER_BLOCK);
						break;
					}
				}
			}
		}
		//显示已落下的形状
		for (int i = 0; i < downFlag.length; i++) {
			for (int j = 0; j < downFlag[i].length; j++) {
				if(downFlag[i][j]){
					pan[i][j].setBackground(Constant.COLOR_BACKGROUND_BLOCK);
					pan[i][j].setBorder(Constant.BORDER_BLOCK);
				}
			}
		}
	}

	public int getRelRow() {
		return relRow;
	}

	public void setRelRow(int relRow) {
		this.relRow = relRow;
	}

	public int getRelCol() {
		return relCol;
	}

	public void setRelCol(int relCol) {
		this.relCol = relCol;
	}
	
	public void setRelRowCol(int relRow,int relCol){
		this.relRow = relRow;
		this.relCol = relCol;
	}
	
	/**
	 * 向下
	 */
	public void moveDown(){
		this.relRow++;
		int posi[][] = shape.getPosi();
		if(isOutOfBounds()){
			this.relRow--;
			//记录落下的位置
			for (int i = 0; i < downFlag.length; i++) {
				for (int j = 0; j < downFlag[i].length; j++) {
					for (int k = 0; k < posi.length; k++) {
						if(i == posi[k][0]+relRow && j == posi[k][1]+relCol){
							//记录落下的位置
							downFlag[i][j] = true;
							break;
						}
					}
				}
			}
			//消除
			clearFullRow();
			//取新形状
			frame.setNextShape();
		}
	}
	/**
	 * 向左
	 */
	public void moveLeft(){
		this.relCol--;
		if(isOutOfBounds()){
			this.relCol++;
		}
	}
	/**
	 * 向右
	 */
	public void moveRight(){
		this.relCol++;
		if(isOutOfBounds()){
			this.relCol--;
		}
	}
	/**
	 * 旋转
	 */
	public void moveReAngle(){
		this.shape.reAngle();
		if(isOutOfBounds()){
			this.shape.reAngle();
			this.shape.reAngle();
			this.shape.reAngle();
		}
	}
	
	/**
	 * 判断超界
	 */
	public boolean isOutOfBounds(){
		int posi[][] = shape.getPosi();
		for (int i = 0; i < posi.length; i++) {
			//横向超界
			if(posi[i][1]+relCol<0 || posi[i][1]+relCol>=Constant.COL){
				return true;
			}
			//纵向超界
			if(posi[i][0]+relRow>=Constant.ROW){
				return true;
			}
		}
		//与已落下的方块重合
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int k = 0; k < posi.length; k++) {
					if(downFlag[posi[k][0]+relRow][posi[k][1]+relCol]){
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * 消除
	 */
	public void clearFullRow(){
		int clearCount = 0;
		for (int i = downFlag.length-1; i >= 0; i--) {
			boolean flag = true;
			for (int j = 0; j < downFlag[i].length; j++) {
				flag = flag && downFlag[i][j];
			}
			//满行判断
			if(flag){
				//累计消除行数
				clearCount++;
				//消除指定行
				clearRowIndex(i);
				//如果有消除则设定此行消除后再次判断是否满行
				i++;
			}
			
		}
		
		if(clearCount>0){
			frame.setScore(clearCount);
		}
	}
	
	/**
	 * 消除指定行
	 */
	private void clearRowIndex(int rowIndex) {
		//使用上一行覆盖当前行标记
		for (int i = rowIndex; i >0; i--) {
			for (int j = 0; j < downFlag[i].length; j++) {
				downFlag[i][j] = downFlag[i-1][j];
			}
		}
		
	}
	
}
