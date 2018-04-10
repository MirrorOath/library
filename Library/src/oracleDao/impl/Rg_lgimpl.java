package oracleDao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import infoClasses.RgUserInfo;
import oracleDao.Rg_lg;
import oracleDao.util.UtilFactory;

@Repository
public class Rg_lgimpl implements Rg_lg {

	@Override
	public void register(RgUserInfo ui) {
		Session session = UtilFactory.getSession();
		ui.setDate(new Date());
		Transaction tx = session.beginTransaction();
		session.save(ui);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Integer ui_id, RgUserInfo userInfo) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		RgUserInfo ui = (RgUserInfo)session.get(RgUserInfo.class, ui_id);
		ui.setUsername(userInfo.getUsername());
		ui.setPwd(userInfo.getPwd());
		ui.setAge(userInfo.getAge());
		
		tx.commit();
		session.close();
	}


	@Override
	public RgUserInfo findById(Integer ui_id) {
		 Session session = UtilFactory.getSession();
		 Transaction tx=session.beginTransaction();
		 RgUserInfo ui = (RgUserInfo)session.get(RgUserInfo.class, ui_id);
		 tx.commit();
		 session.close();
		return ui;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RgUserInfo> getAllEmps(String ui_name) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from Employee where empName like ?");
		 query.setString(0, "%"+ui_name+"%");
		 List<RgUserInfo> uis = (List<RgUserInfo>) query.list();
		 tx.commit();
		 session.close();
		 return uis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RgUserInfo> getPageRows(int start_index, int count) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from Employee");
		 query.setFirstResult(start_index);
		 query.setMaxResults(count);
		 List<RgUserInfo> uis = (List<RgUserInfo>) query.list();
		 tx.commit();
		 session.close();
		 return uis;
	}

	@Override
	public void delete(int ui_id) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 RgUserInfo em=new RgUserInfo();
		 em.setId(ui_id);
		 session.delete(em);
		 tx.commit();
		 session.close();
	}

	@Override
	public RgUserInfo findByName(String ui_name) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from RgUserInfo where user_name like ?");
		 query.setString(0, ui_name);
		 RgUserInfo ui = (RgUserInfo) query.uniqueResult();
		 tx.commit();
		 session.close();
		 return ui;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RgUserInfo> users() {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("from RgUserInfo");
		List<RgUserInfo> uis = (List<RgUserInfo>) query.list();
		tx.commit();
		session.close();
		return uis;
	}

	@Override
	public void delUser(Integer ui_id) {
		 Session session = UtilFactory.getSession();
		 Transaction tx = session.beginTransaction();
		 RgUserInfo ui = new RgUserInfo();
		 ui.setId(ui_id);
		 session.delete(ui);
		 tx.commit();
		 session.close();
	}

	@Override
	public void rePwd(Integer ui_id, String pwd) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		RgUserInfo ui = (RgUserInfo)session.get(RgUserInfo.class, ui_id);
		ui.setPwd(pwd);
		tx.commit();
		session.close();
	}

	@Override
	public RgUserInfo getUserById(Integer ui_id) {
		Session session = UtilFactory.getSession();
		
		RgUserInfo ui = (RgUserInfo)session.get(RgUserInfo.class, ui_id);
		
		session.close();
		return ui;
	}

	@Override
	public void update(RgUserInfo ui) {
		Session session = UtilFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		RgUserInfo userInfo = (RgUserInfo)session.get(RgUserInfo.class, ui.getId());
		userInfo.setUsername(ui.getUsername());
		userInfo.setPwd(ui.getPwd());
		userInfo.setAge(ui.getAge());
		
		tx.commit();
		session.close();
	}


}
