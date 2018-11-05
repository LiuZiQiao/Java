package thread;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月5日 下午4:23:47
* 类说明
*/
public class Runnable_Test {

	public static void main(String[] args) {

		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		t.start();
		for(int i=0;i<10000;i++)
			System.out.println("aaaaaaaaaaaa");
	}

}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10000;i++)
			System.out.println("bbbb");
	}

}