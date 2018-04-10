package oracleDao;

import java.util.List;

import infoClasses.BookInfo;
import infoClasses.CartInfo;


public interface Cart_go {
	void addBook(Integer user_id, Integer book_id);
	void saveCart(CartInfo cart);
	List<BookInfo> getBooksByUserId(Integer user_id);
	void delBook(Integer user_id, Integer book_id);
	void delCart(CartInfo cart);
	CartInfo getCart(Integer user_id, Integer book_id);
	List<CartInfo> getCartsByUserId(Integer user_id);
	List<CartInfo> getCartsByBookId(Integer book_id);
}
