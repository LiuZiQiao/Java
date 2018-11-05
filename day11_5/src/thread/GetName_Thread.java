package thread;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月5日 下午4:40:55
* 类说明
*/
public class GetName_Thread {

	public static void main(String[] args) {

//		new Thread("123")
//		{
//			public void run() {
//				for(int i=0;i<10000;i++)
//					System.out.println(this.getName()+"bbbbbbbbbbbbbbbbbb");
//			}
//		}.start();

		Thread t = new Thread("111") {
			public void run() {
				for(int i=0;i<10000;i++)
					System.out.println(this.getName()+"bbbbbbbbbbbbbbbbbb");
			}
		};
		t.setName("1111");
		t.start();
	}

}
