package russia.util;

import java.awt.Dimension;

public class RussiaShapeUtil {
	/**
	 * 计算主窗口大小
	 */
	public static Dimension getSize(){
		int width = (Constant.COL+4+1+2)*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+5;
		int height = (Constant.ROW+2)*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+25;
		
		Dimension dsion = new Dimension(width,height);
		
		return dsion;
	}
	
	/**
	 * 计算指定行列的面板方块面板大小
	 */
	public static Dimension getSize(int row,int col){
		int width = col*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+Constant.BLOCK_BORDER_WIDTH;
		int height = row*(Constant.BLOCK_WIDTH+Constant.BLOCK_BORDER_WIDTH)+Constant.BLOCK_BORDER_WIDTH;
		
		Dimension dsion = new Dimension(width,height);
		
		return dsion;
	}

}
