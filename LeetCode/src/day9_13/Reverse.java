package day9_13;

/**
 * @author 作者 小小刘
 * @version 创建时间：2018年9月13日 上午10:40:25 类说明
 */
public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverse2(1245678993));
	}

	public static int reverse(int x) {
		int temp = 0;
		while (x != 0) {
			if (temp < Integer.MIN_VALUE / 10 || temp > Integer.MAX_VALUE / 10) {
				return 0;
			}
			temp = temp * 10 + x % 10;
			x /= 10;
		}
		return temp;
	}

	public static int reverse2(int x) {
		int temp = 0;
		while (x != 0) {

			temp = temp * 10 + x % 10;
			x /= 10;
		}
		if (temp < Integer.MIN_VALUE|| temp > Integer.MAX_VALUE) {
			return 0;
		}
		return temp;
	}

}
