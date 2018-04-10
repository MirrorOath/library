package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import infoClasses.CartInfo;
import infoClasses.RgUserInfo;
import oracleDao.Cart_go;

@Controller
@RequestMapping(value="/cart/")
public class Cart {
	@Autowired
	private Cart_go cartImpl;
	@RequestMapping(value="addBook")
	public String addBook(Model model, Integer bookId, HttpSession session){
		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		cartImpl.addBook(userId, bookId);
		return "redirect:../search/bookInfo.action?bookId="+bookId;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="seeCart")
	public String seeCart(Model model, HttpSession session){
		List<CartInfo> cartInfo = session.getAttribute("userInfo") != null
				?cartImpl.getCartsByUserId(((RgUserInfo)session.getAttribute("userInfo")).getId())
						:(List<CartInfo>)session.getAttribute("runCarts");

		model.addAttribute("cartInfo", cartInfo);
		return "Cart";
	}

	@RequestMapping(value="delectCart")
	public String delectCart(Model model, Integer bookId, HttpSession session){
		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		cartImpl.delBook(userId, bookId);
		return "redirect:seeCart.action";
	}
}
