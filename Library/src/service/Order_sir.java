package service;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import infoClasses.CartInfo;
import infoClasses.OrderForm;
import oracleDao.Order_go;
import oracleDao.Rg_lg;
import oracleDao.util.UtilFactory;

@Service
public class Order_sir {
	@Resource
	private Rg_lg uImpl;
	@Resource
	private Order_go oImpl;
	
	public OrderForm plaseOrder(List<CartInfo> carts){
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		OrderForm oForm = oImpl.returnOrderForm(uImpl.getUserById(carts.get(0).getUserId()), session);
		oImpl.saveOrderDetail(oForm, carts, session);
		
		tx.commit();
		session.close();
		return oForm;
	}
	public void delOrderForm(Integer formId){
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		oImpl.delOrderForm(formId, session);

		tx.commit();
		session.close();
	}
	public void delOrderFormsByUserId(Integer userId){
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		oImpl.delAllUserForm(userId, session);

		tx.commit();
		session.close();
	}
}