package bean;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午2:42:38
* 类说明
*/
public class Bridge {
	
	private String id;  //桥梁编号
	private String name;   //桥梁名称
	private String type;	//桥梁类型
	private int length;		//桥梁长度
	private String ManName;	//桥梁负责人
	private String area;   //所在区
	
	public Bridge() {}
	public Bridge(String id, String name, String type, int length, String manName, String area) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.length = length;
		this.ManName = manName;
		this.area = area;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getManName() {
		return ManName;
	}

	public void setManName(String manName) {
		ManName = manName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", type=" + type + ", length=" + length + ", ManName=" + ManName
				+ ", area=" + area + "]";
	}
	
	
	
}
