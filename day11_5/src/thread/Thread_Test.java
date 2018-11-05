package thread;

import javax.xml.ws.soap.MTOM;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月5日 下午4:13:41
* 类说明
*/
public class Thread_Test {

	public static void main(String[] args) {
		Mythread mt = new Mythread();
		mt.start();
		for(int i=0;i<3000;i++)
			System.out.println("aaaaaaaaaaaaaaaaaaa");
		}
}


class Mythread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<3000;i++)
			System.out.println("bbbbbbbbbbb");
	}
}