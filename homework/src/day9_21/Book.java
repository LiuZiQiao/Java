package day9_21;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月21日 下午1:09:38
* 类说明
*/
public class Book {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	public Book(String name, int price) {
//		super();
		this.name = name;
		this.price = price;
	}
	public boolean equals(Book book) {
		if (name == book.name && book.price == price) {
			System.out.println("Book");
			return true;
			
		}
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		System.out.println("Book_toString");
		return "Book [name=" + name + ", price=" + price + "]";
	}
}
