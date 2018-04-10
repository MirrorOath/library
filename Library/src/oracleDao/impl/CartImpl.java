package oracleDao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import infoClasses.BookInfo;
import infoClasses.CartInfo;
import oracleDao.Cart_go;
import oracleDao.util.UtilFactory;

@Repository
public class CartImpl implements Cart_go {


	@Override
	public void addBook(Integer user_id, Integer book_id) {
		Session session = UtilFactory.getSession();
		CartInfo cart = getCart(user_id, book_id);
		if(cart != null){
			Transaction tx = session.beginTransaction();
			cart.setBookCount(cart.getBookCount()+1);
			session.update(cart);
			tx.commit();
			return;
		}
		cart = new CartInfo();
		cart.setBookCount(1);
		cart.setDate(new Date());
		cart.setUserId(user_id);
		cart.setBookId(book_id);
		cart.setBookInfo(new BookImpl().getBookById(book_id));
		Transaction tx = session.beginTransaction();
		session.save(cart);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartInfo> getCartsByUserId(Integer user_id) {
		Session session = UtilFactory.getSession();
		Query query=session.createQuery("from CartInfo where user_id=?");
		query.setInteger(0, user_id);
		List<CartInfo> list = (List<CartInfo>)query.list();
		session.close();
		return list;
	}

	@Override
	public List<CartInfo> getCartsByBookId(Integer book_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> getBooksByUserId(Integer user_id) {
		Session session = UtilFactory.getSession();
		Query query=session.createQuery("from CartInfo where user_id=?");
		query.setInteger(0, user_id);
		List<CartInfo> carts = (List<CartInfo>)query.list();
		List<BookInfo> books = new ArrayList<BookInfo>();
		BookImpl bimpl = new BookImpl(); 
		for(CartInfo cart:carts){
			books.add(bimpl.getBookById(cart.getBookId()));
		}
		
		session.close();
		return books;
	}
	@Override
	public void delBook(Integer user_id, Integer book_id) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("from CartInfo where user_id=? and book_id=?");
		query.setInteger(0, user_id);
		query.setInteger(1, book_id);
		CartInfo cart = (CartInfo)query.uniqueResult();;
		session.delete(cart);
		tx.commit();
		session.close();
	}
	@Override
	public CartInfo getCart(Integer user_id, Integer book_id) {
		Session session = UtilFactory.getSession();
		Query query=session.createQuery("from CartInfo where user_id=? and book_id=?");
		query.setInteger(0, user_id);
		query.setInteger(1, book_id);
		CartInfo cart = (CartInfo)query.uniqueResult();;
		session.close();
		return cart;
	}

	@Override
	public void delCart(CartInfo cart) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(cart);
		tx.commit();
		session.close();
		
	}

	@Override
	public void saveCart(CartInfo cart) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(cart);
		tx.commit();
		session.close();
	}


}
