package chapter;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月10日 上午9:30:43
* 类说明
*/
public class TestRussiaShape {
		public static void main(String[] args) {
			int[][] posi = getRandomPosi();
			
//			for (int i = 0; i < posi.length; i++) {
//				for (int j = 0; j < posi[i].length; j++) {
//					System.out.print(posi[i][j]+",");
//				}
//				System.out.println();
//			}
			
			//■□
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					//标记，假设当前准备输出的 第 i行 j列没有被占据
					boolean flag = false;
					//比较的循环，用来比较当前准备输出的i行j列是否被二位数组posi占据
					for (int[] grid : posi) {
						if(i == grid[0] && j == grid[1]){
							//当前输出的i行j列被当前的grid数组占据,则修标记为true
							flag = true;
							break;
						}
					}
					if(flag){
						System.out.print("■ ");
					}else{
						System.out.print("□ ");
					}
				}
				System.out.println();
			}
			
		}
		
		public static int[][] getRandomPosi(){
			//0：方块；1-长条；2-Z；3-反Z；4-L；5-反L；6-T
			int shape = (int)(Math.random()*7);
			//随机取角度
			int angle = (int)(Math.random()*4);
			
			int[][] posi = null;
			switch(shape){
			case 0:
				posi = new int[][]{
					{0,0},
					{0,1},
					{1,0},
					{1,1}
				};
				break;
			case 1:
				if(angle == 0 || angle == 2){
					posi = new int[][]{
						{0,0},
						{2,0},
						{1,0},
						{3,0}
					};
				}else{
					posi = new int[][]{
						{0,0},
						{0,1},
						{0,2},
						{0,3}
					};
				}
				break;
			case 2:
				if(angle == 0 || angle == 2){
					posi = new int[][]{
						{0,0},
						{0,1},
						{1,1},
						{1,2}
					};
				}else{
					posi = new int[][]{
						{1,0},
						{0,1},
						{2,0},
						{1,1}
					};
				}
				break;
			case 3:
				if(angle == 0 || angle == 2){
					posi = new int[][]{
						{0,2},
						{0,1},
						{1,1},
						{1,0}
					};
				}else{
					posi = new int[][]{
						{0,0},
						{0,1},
						{2,1},
						{1,1}
					};
				}
				break;
			case 4:
				if(angle == 0){  // L
					posi = new int[][]{
						{0,0},
						{2,0},
						{2,1},
						{1,0}
					};
				}else if(angle == 1){
					posi = new int[][]{
						{0,0},
						{0,1},
						{0,2},
						{1,0}
					};
				}else if(angle == 2){ //7
					posi = new int[][]{
						{0,0},
						{0,1},
						{1,1},
						{2,1}
					};
				}else{
					posi = new int[][]{
						{0,2},
						{1,0},
						{1,1},
						{1,2}
					};
				}
				break;
			case 5: 
				if(angle == 0){  // 反L
					posi = new int[][]{
						{0,1},
						{2,0},
						{2,1},
						{1,1}
					};
				}else if(angle == 1){
					posi = new int[][]{
						{0,0},
						{1,1},
						{1,2},
						{1,0}
					};
				}else if(angle == 2){ //反7
					posi = new int[][]{
						{0,0},
						{0,1},
						{1,0},
						{2,0}
					};
				}else{
					posi = new int[][]{
						{0,2},
						{1,2},
						{0,1},
						{0,0}
					};
				}
				break;
			default: 
				if(angle == 0){  // T
					posi = new int[][]{
						{0,1},
						{0,0},
						{0,2},
						{1,1}
					};
				}else if(angle == 1){
					posi = new int[][]{
						{0,1},
						{1,1},
						{2,1},
						{1,0}
					};
				}else if(angle == 2){ //上
					posi = new int[][]{
						{1,1},
						{0,1},
						{1,0},
						{1,2}
					};
				}else{
					posi = new int[][]{
						{2,0},
						{1,1},
						{1,0},
						{0,0}
					};
				}
				break;
			}
			
			return posi;
		}

	}
