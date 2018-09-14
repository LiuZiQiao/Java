package day9_14;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月14日 下午1:03:01
* 类说明
*/
public class Biology {
	public String name;
	public String death; //死亡
	public String fecundity; // 繁殖
	
	public void live()
	{
		System.out.println(name+"是活着的");
	}
	
	public void fecundity() {
		System.out.println(name+"能繁殖的");
	}
	public Biology(String name,String death, String fecundity) {
		this.name = name;
		this.death = death;
		this.fecundity = fecundity;
	}

}
