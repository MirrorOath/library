package oracleDao;

import java.util.List;

import org.hibernate.Session;

import infoClasses.CartInfo;
import infoClasses.OrderDetail;
import infoClasses.OrderForm;
import infoClasses.RgUserInfo;


public interface Order_go {
	// 通过用户信息保存订单信息 sir中调用
	OrderForm returnOrderForm(RgUserInfo userInfo, Session session);
	// 上方方法执行之后sir中接着调用此方法保存详单
	void saveOrderDetail(OrderForm orderForm, List<CartInfo> carts, Session session);
	// 通过订单id删除订单
	void delOrderForm(Integer formId, Session session);
	// 通过用户id删除用户下的所有订单和详单信息
	void delAllUserForm(Integer userId, Session session);
	
	// 通过订单id获得订单对象
	OrderForm getFormById(Integer formId);
	// 通过用户信息获得订单集合
	List<OrderForm> getFormByUser(RgUserInfo userInfo);
	// 通过订单id获得详单集合
	List<OrderDetail> getDetailsByForm(OrderForm orderForm);
	List<OrderDetail> getAllDetails();
}
