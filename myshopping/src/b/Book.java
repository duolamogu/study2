package b;
public class Book {
	private int id;//序号
	private String name;//名字
	private String author;//作者
	private String publishHouse;//出版社
	private float price;//价格
	private int numl;//库存
	private int shoppingNum=1;//购买数量
	public int getShoppingNum() {
		return shoppingNum;
	}
	public void setShoppingNum(int shoppingNum) {
		this.shoppingNum = shoppingNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishHouse() {
		return publishHouse;
	}
	public void setPublishHouse(String publishHouse) {
		this.publishHouse = publishHouse;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNuml() {
		return numl;
	}
	public void setNuml(int numl) {
		this.numl = numl;
	}
}
