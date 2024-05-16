package classes;

public class Product {

	/** DTO **/
	private String code;
	private String title;
	private int price;
	private int count;
	
	/** getter&setter **/
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	/** ToString **/
	@Override
	public String toString() {
		return "[code=" + code + ", title=" + title + ", price=" + price + ", count=" + count +"]";
	}
	
	/** Constructor **/
	public Product(String code, String title, int price, int count) {
		super();
		this.code = code;
		this.title = title;
		this.price = price;
		this.count = count;
	}
	
	public Product() {
		
	}
	
	
	

}
