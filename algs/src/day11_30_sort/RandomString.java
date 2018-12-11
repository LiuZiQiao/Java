package day11_30_sort;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
* @author 作者  小小刘
* @version 创建时间：2018年12月7日 下午5:20:15
* 类说明
*/
public class RandomString {
	public static ArrayList<String> getRandomString(int length) {
		ArrayList<String> list = new ArrayList<>();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(52);// [0,51)

        }
        return list;
    }
	public static void main(String[] args) {
		ArrayList<String> str = getRandomString(100);
	      FileWriter writer;
	        try {
	            writer = new FileWriter("F:\\code\\Java\\algs\\string.txt");
	            
	           for (int i=0;i<str.size();i++) {
	        	   writer.write(str.get(i));
			}
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
