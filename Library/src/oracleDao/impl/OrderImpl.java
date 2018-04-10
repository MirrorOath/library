package oracleDao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import infoClasses.CartInfo;
import infoClasses.OrderDetail;
import infoClasses.OrderForm;
import infoClasses.RgUserInfo;
import oracleDao.Cart_go;
import oracleDao.Order_go;
import oracleDao.Rg_lg;
import oracleDao.util.UtilFactory;

@Repository
public class OrderImpl implements Order_go {
	@Resource
	private Cart_go cImpl;
	@Resource
	private Rg_lg rgImpl;

	@Override
	public OrderForm returnOrderForm(RgUserInfo userInfo, Session session) {
		OrderForm orderForm = new OrderForm();
		orderForm.setUserInfo(userInfo);
		orderForm.setAddress("Gallifrey星，Kasterborous星群，坐标（10-0-11-0-0，0-2）");
		orderForm.setInfo("未付账");
		orderForm.setDate(new Date());
		orderForm.setTotalPrice(1991.0919F);
		session.save(orderForm);
		return orderForm;
	}

	@Override
	public void saveOrderDetail(OrderForm orderForm, List<CartInfo> carts, Session session) {
		
		for(CartInfo cart:carts){
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setFormInfo(orderForm);
			orderDetail.setBookCount(cart.getBookCount());
			orderDetail.setBookInfo(cart.getBookInfo());
			orderDetail.setPrice(0F);
			session.save(orderDetail);
			cImpl.delCart(cart);
		}
		
	}

	@Override
	public List<OrderDetail> getDetailsByForm(OrderForm orderForm) {
		Session session = UtilFactory.getSession();
	
		Criteria cia = session.createCriteria(OrderDetail.class);
		
		cia.add(Restrictions.eq("formInfo", orderForm));
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = (List<OrderDetail>)cia.list();
		session.close();
		return list;
	}
	@Override
	public List<OrderForm> getFormByUser(RgUserInfo userInfo) {
		Session session = UtilFactory.getSession();
	
		Criteria cia = session.createCriteria(OrderForm.class);
		
		cia.add(Restrictions.eq("userInfo", userInfo));
		@SuppressWarnings("unchecked")
		List<OrderForm> list = (List<OrderForm>)cia.list();
		session.close();
		return list;
	}

	@Override
	public void delOrderForm(Integer formId, Session session) {
		OrderForm orderForm = (OrderForm)session.get(OrderForm.class, formId);
		delDetailsByForm(orderForm, session);
		session.delete(orderForm);
	}

	public void delDetailsByForm(OrderForm orderForm, Session session) {
		 List<OrderDetail> details = getDetailsByForm(orderForm);
		 for(OrderDetail detail:details){
			 session.delete(detail);
		 }
	}

	@Override
	public OrderForm getFormById(Integer formId) {
		Session session = UtilFactory.getSession();
		OrderForm form = (OrderForm)session.get(OrderForm.class, formId);
		session.close();
		return form;
	}

	@Override
	public void delAllUserForm(Integer userId, Session session) {
		List<OrderForm> forms = getFormByUser(rgImpl.getUserById(userId));
		for(OrderForm form:forms)
			delOrderForm(form.getId(), session);
	}

	@Override
	public List<OrderDetail> getAllDetails() {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("from OrderDetail");
		@SuppressWarnings("unchecked")
		List<OrderDetail> details = (List<OrderDetail>) query.list();
		tx.commit();
		session.close();
		return details;
	}

}
