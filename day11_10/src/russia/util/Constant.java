package russia.util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public interface Constant {
	//方块行列
	public static final int ROW = 20;
	public static final int COL = 9;
	//方块大小
	public static final int BLOCK_WIDTH = 20;
	//方块间距
	public static final int BLOCK_BORDER_WIDTH = 1;
	//定义方块空白颜色
	public static final Color COLOR_BACKGROUND = Color.BLACK;//Color.WHITE;
	//定义方块标记颜色
	public static final Color COLOR_BACKGROUND_BLOCK = Color.YELLOW;//Color.BLACK;
	//方块间距颜色
	public static final Color COLOR_GRID_BLOCK = Color.BLACK;//Color.LIGHT_GRAY;
	//方块边线
	public static final Border BORDER_BLOCK = BorderFactory.createBevelBorder(0);
	//得分
	public static final int SCORE_FULL_1 = 10;
	public static final int SCORE_FULL_2 = 25;
	public static final int SCORE_FULL_3 = 40;
	public static final int SCORE_FULL_4 = 60;
	//提升等级层数
	public static final int LEVEL_LAY = 3;
	//速度,毫秒
	public static final int INIT_SPEED = 1000;
	
	

}
