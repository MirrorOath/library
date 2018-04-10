package infoClasses;

public class OrderDetail {
	private Integer id;
	private OrderForm formInfo;
	private BookInfo bookInfo;
	private Float price;
	private Integer bookCount;

	public OrderForm getFormInfo() {
		return formInfo;
	}
	public void setFormInfo(OrderForm formInfo) {
		this.formInfo = formInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", price=" + price + ", bookCount=" + bookCount + "]";
	}
	
}
