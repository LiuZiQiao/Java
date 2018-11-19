package bean;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:31:47
* 类说明
*/
public class Manager {

	private String name;
	private String passwd;
	
	
	public Manager(String name, String passwd) {
		this.name = name;
		this.passwd = passwd;
	}
	public Manager() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Manage [name=" + name + ", passwd=" + passwd + "]";
	}
	
	
}
