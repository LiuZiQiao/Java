package day9_15;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月15日 下午11:05:04
* 类说明
* 
	实现 int sqrt(int x) 函数。
	计算并返回 x 的平方根，其中 x 是非负整数。
	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
*/
public class Sqrt {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int ret = solution.mySqrt(4);
		System.out.println(ret);
	}
	
}


class Solution {
    public int mySqrt(int x) {
    	if (x < 0) {
			return 0;
		}
    	int res = x;
		while (res*res > x) {
			res = (res+ x/res)/2;
		}
    	return (int) res;

    }
}