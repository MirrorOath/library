package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import infoClasses.CartInfo;
import infoClasses.OrderDetail;
import infoClasses.OrderForm;
import infoClasses.RgUserInfo;
import oracleDao.Cart_go;
import oracleDao.Order_go;
import service.Order_sir;

@Controller
@RequestMapping(value="/order/")
public class Order {
	@Autowired
	private Cart_go cartImpl;
	@Autowired
	private Order_sir osir;
	@Autowired
	private Order_go oImpl;
	@Autowired
	private oracleDao.Rg_lg uImpl;
	
	@RequestMapping(value="placeOrder")
	public String addBook(Model model, HttpSession session, Integer[] cartBook){
		if(cartBook == null)
			return "redirect:../cart/seeCart.action";
		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		List<CartInfo> carts = new ArrayList<CartInfo>();
		for(Integer bookId:cartBook){
			carts.add(cartImpl.getCart(userId, bookId));
		}
		OrderForm orderForm = osir.plaseOrder(carts);
		return "redirect:seeDetail.action?formId="+orderForm.getId();
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="runPlaceOrder")
	public String runPlaceOrder(Model model, HttpSession session){
		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		List<Integer> bookIds = (List<Integer>)session.getAttribute("runCheckBookIds");
		List<CartInfo> cartInfo = (List<CartInfo>)session.getAttribute("runCarts");
		for(CartInfo cart:cartInfo){
			cart.setDate(new Date());
			cart.setUserId(userId);
			cartImpl.saveCart(cart);
		}
		List<CartInfo> carts = new ArrayList<CartInfo>();
		for(Integer bookId:bookIds){
			carts.add(cartImpl.getCart(userId, bookId));
		}
		OrderForm orderForm = osir.plaseOrder(carts);
		session.removeAttribute("runCheckBookIds");
		session.removeAttribute("runCarts");
		return "redirect:seeDetail.action?formId="+orderForm.getId();
	}
	@RequestMapping(value="seeOrder")
	public String seeCart(Model model, HttpSession session){

		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		RgUserInfo userInfo = uImpl.getUserById(userId);
		List<OrderForm> forms = oImpl.getFormByUser(userInfo);
		model.addAttribute("orders", forms);
		List<OrderDetail> details = oImpl.getAllDetails();
		model.addAttribute("details", details);
		return "userarea";
	}
	@RequestMapping(value="seeDetail")
	public String seeDetail(Model model, Integer formId, HttpSession session){

		OrderForm form = oImpl.getFormById(formId);
		model.addAttribute("form", form);
		List<OrderDetail> details = oImpl.getDetailsByForm(form);
		model.addAttribute("details", details);
		return "oFormInfo";
	}
	@RequestMapping(value="delForm")
	public String delForm(Integer formId){
		osir.delOrderForm(formId);
		return "redirect:seeOrder.action";
	}

}
