package chapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月10日 上午9:19:41
* 类说明
*/
public class ShapeFrame extends JFrame{
	private JPanel blockPan[][];
	private JButton shapeBut;
	
	public static final int BLOCK_WIDTH = 20;
	
	private static final int ROW = 200;
	private static final int COL = 500;
	
	private int rx = 3;
	private int ry = 2;
	
	public static final Color COL_NULL_BLOCK= Color.WHITE;
	public static final Color COL_BLOCK= Color.BLACK;
	
	private static final int BLOCK_GRID_WIDTH = 1;

	public  ShapeFrame()
	{
		super("Block shape");
		this.setSize(ROW, COL);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		addComponent();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponent() {
		blockPan = new JPanel[ROW][COL];
		for (int i = 0; i < blockPan.length; i++) {
			for (int j = 0; j < blockPan[i].length; j++) {
				blockPan[i][j] = new JPanel();
				//默认无方块
				blockPan[i][j].setBackground(COL_NULL_BLOCK);
				//设定方块面板位置和大小
				blockPan[i][j].setBounds(BLOCK_GRID_WIDTH+(BLOCK_WIDTH+BLOCK_GRID_WIDTH)*j, BLOCK_GRID_WIDTH+(BLOCK_WIDTH+BLOCK_GRID_WIDTH)*i, BLOCK_WIDTH, BLOCK_WIDTH);
				//添加到窗口
				this.add(blockPan[i][j]);
			}
		}
		//添加按钮
				shapeBut = new JButton("取形状");
				shapeBut.setBounds((this.getWidth()-80)/2 , 
						this.getHeight()-60,
						80,25);
				this.add(shapeBut);
				
				//定义监听器对象
				ButListener blis = new ButListener();
				//捆绑监听器对象到按钮
				shapeBut.addActionListener(blis);
				
	}
	class ButListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int[][] posi = TestRussiaShape.getRandomPosi();
			for (int i = 0; i < blockPan.length; i++) {
				for (int j = 0; j < blockPan[i].length; j++) {
					//恢复所有方块的颜色为空
					blockPan[i][j].setBackground(COL_NULL_BLOCK);
					//循环判断是否占据
					boolean flag = false;
					for (int[] grid : posi) {
						if(i == grid[0] + ry && j == grid[1]+rx){
							flag = true;
							break;
						}
					}
					if(flag){
						blockPan[i][j].setBackground(COL_BLOCK);
					}
				}
			}
		}
		
	/**
	 * 计算窗口大小
	 */
	public Dimension getFrameSize(int row, int col){
		
		int width = (BLOCK_WIDTH + BLOCK_GRID_WIDTH) * col + BLOCK_GRID_WIDTH + 8;
		int height = (BLOCK_WIDTH + BLOCK_GRID_WIDTH) * row + BLOCK_GRID_WIDTH + 8 + 25 + 30;
		Dimension dim = new Dimension(width, height);
		return dim;
		}
	}
	
	
	public static void main(String[] args) {
		new ShapeFrame();
		System.out.println("123");
	}
}
