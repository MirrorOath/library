package infoClasses;

import java.util.Date;

public class CartInfo {
	private Integer id;
	private Integer userId;
	private Integer bookId;
	private Integer bookCount;
	private Date	date;
	private BookInfo bookInfo;

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CartInfo [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", bookCount=" + bookCount
				+ ", date=" + date + "]";
	}

}
