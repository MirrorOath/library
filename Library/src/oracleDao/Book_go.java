package oracleDao;

import java.util.List;


import infoClasses.BookInfo;
import oracleDao.util.PageBean;


public interface Book_go {

	// 添加一本书
	void addBook(BookInfo book);
	// 按照书名精确查找
	BookInfo getBookByName(String bookName);
	//
	BookInfo getBookById(Integer bookId);
	// 基于书的一项内容模糊查找
	List<BookInfo> getBooksByName(String bookName);
	List<BookInfo> getBooksByPress(String bookPress);
	List<BookInfo> getBooksByAuthor(String bookAuthor);
	void getPageBooks(PageBean<BookInfo> bookPage);
	void getPageBooksByName(PageBean<BookInfo> bookPage, String bookName);
}
