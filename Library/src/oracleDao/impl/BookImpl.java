package oracleDao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import infoClasses.BookInfo;
import oracleDao.Book_go;
import oracleDao.util.UtilFactory;

@Repository
public class BookImpl implements Book_go {

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> getBooksByName(String bookName) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from BookInfo where book_name like ?");
		 query.setString(0, "%"+bookName+"%");
		 List<BookInfo> books = (List<BookInfo>) query.list();
		 tx.commit();
		 session.close();
		 return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> getBooksByPress(String bookPress) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from BookInfo where book_press like ?");
		 query.setString(0, "%"+bookPress+"%");
		 List<BookInfo> books = (List<BookInfo>) query.list();
		 tx.commit();
		 session.close();
		 return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> getBooksByAuthor(String bookAuthor) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from BookInfo where book_author like ?");
		 query.setString(0, "%"+bookAuthor+"%");
		 List<BookInfo> books = (List<BookInfo>) query.list();
		 tx.commit();
		 session.close();
		 return books;
	}

	@Override
	public void addBook(BookInfo book) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
		
	}

	@Override
	public BookInfo getBookByName(String bookName) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from BookInfo where book_name like ?");
		 query.setString(0, bookName);
		 BookInfo book = (BookInfo) query.uniqueResult();
		 tx.commit();
		 session.close();
		 return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getPageBooks(oracleDao.util.PageBean<BookInfo> bookPage) {
		Session session = UtilFactory.getSession();
		Query query=session.createQuery("from BookInfo");
		//统计总记录数
		ScrollableResults scroll= query.scroll();//得到滚动结果集
		scroll.last();//滚动到最后记录的位置
		int totalCount= scroll.getRowNumber()+1;//scroll.getRowNumber()从0开始计数的
		bookPage.setTotalCount(totalCount);
		//设置分页参数
		query.setFirstResult((bookPage.getCurrentPage()-1)*bookPage.getPageCount());//从第几条记录开始取数据
		query.setMaxResults(bookPage.getPageCount());//每次取几条记录
		List<BookInfo> books=(List<BookInfo>) query.list();
		bookPage.setPageData(books);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getPageBooksByName(oracleDao.util.PageBean<BookInfo> bookPage, String bookName) {
		Session session = UtilFactory.getSession();
		Query query = session.createQuery("from BookInfo where book_name like ?");
		query.setString(0, "%"+bookName+"%");
		//统计总记录数
		ScrollableResults scroll= query.scroll();//得到滚动结果集
		scroll.last();//滚动到最后记录的位置
		int totalCount= scroll.getRowNumber()+1;//scroll.getRowNumber()从0开始计数的
		bookPage.setTotalCount(totalCount);
		//设置分页参数
		query.setFirstResult((bookPage.getCurrentPage()-1)*bookPage.getPageCount());//从第几条记录开始取数据
		query.setMaxResults(bookPage.getPageCount());//每次取几条记录
		List<BookInfo> books=(List<BookInfo>) query.list();
		bookPage.setPageData(books);		
	}

	@Override
	public BookInfo getBookById(Integer bookId) {
		Session session = UtilFactory.getSession();
		Transaction tx=session.beginTransaction();
		BookInfo book = (BookInfo)session.get(BookInfo.class, bookId);
		tx.commit();
		session.close();
		return book;
	}
}
