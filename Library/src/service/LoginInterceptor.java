package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.hibernate.Transaction;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import infoClasses.CartInfo;
import oracleDao.Book_go;
//import oracleDao.Order_go;
//import oracleDao.impl.BookImpl;

public class LoginInterceptor implements HandlerInterceptor {
	@Resource
	private Book_go bookImpl;
	
	private String getStr(HttpServletRequest request){
		String strs[] = request.getRequestURI().toString().split("/");
		String str = "";
		for(int i = 2; i<strs.length; i++){
			str = str+"/"+strs[i];
		}
		return "redirect:"+str;
	}
	
//	private boolean isAdminAction(HttpServletRequest request){
//		String strs[] = request.getRequestURI().toString().split("/");
//		if("admin".equals(strs[2]))
//			return true;
//		else
//			return false;
//	}
	
	@SuppressWarnings("unchecked")
	private void addRunCart(HttpSession session, Integer bookId){
		List<CartInfo> carts = session.getAttribute("runCarts") != null
						?(List<CartInfo>)session.getAttribute("runCarts") :new ArrayList<CartInfo>();

		do{
			boolean was = false;
			for(CartInfo cart:carts){
				if(cart.getBookId().equals(bookId)){
					cart.setBookCount(cart.getBookCount()+1);
					was = true;
					break;
				}
			}
			if(!was){
				CartInfo cart = new CartInfo();
				cart.setBookCount(1);
				cart.setDate(new Date());
				cart.setUserId(0);
				cart.setBookId(bookId);
				cart.setBookInfo(bookImpl.getBookById(bookId));
				carts.add(cart);
				break;
			}
			break;
		}while(true);
		session.setAttribute("runCarts", carts);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

	    System.out.println("Hello world!!");
	    
		HttpSession session= request.getSession(false);//获取一个已经存在的session
		String str = getStr(request);
		
		// 所有直接通过的请求
		if(request.getRequestURI().contains("login.action")
				|| request.getRequestURI().contains("register.action")
				|| request.getRequestURI().contains("seeCart.action")
				|| request.getRequestURI().contains("bookInfo.action")){
			return true;
		}
		// 当前没有已存在的session
		if(session == null){
			response.sendRedirect("/Library/User/login.jsp");
			return false;
		}// 未登录状态的拦截请求&&登录返回方式
		else{
			if(session.getAttribute("userInfo") != null)
				return true;
			
			else{
				if(request.getRequestURI().contains("seeOrder.action"))
					session.setAttribute("lastUrl", str);
				
				else if(request.getRequestURI().contains("seeDetail.action"))
					session.setAttribute("lastUrl", str+"?formId="+request.getParameter("formId"));

				else if(request.getRequestURI().contains("rg_lg_do.action")){
					if("login".equals(request.getParameter("rorl")))
						session.setAttribute("lastUrl", str+"?rorl="+request.getParameter("rorl"));
					else// 当点击退出登录
						return true;
				}
				
				// 加入购物车时将购物车集合加入session
				else if(request.getRequestURI().contains("addBook.action")){
					Integer bookId = Integer.parseInt(request.getParameter("bookId"));
					addRunCart(session, bookId);
					response.sendRedirect(str+"?bookId="+bookId);
					return false;
				}
				// 删除购物车时
				else if(request.getRequestURI().contains("delectCart.action")){
					List<CartInfo> carts = (List<CartInfo>)session.getAttribute("runCarts");
					for(CartInfo cart:carts)
						if(cart.getBookInfo().getBookId().equals(Integer.parseInt(request.getParameter("bookId")))){
							carts.remove(cart);
							break;
						}
					response.sendRedirect("/Library/cart/seeCart.action");
					return false;
				}
				// 下订单时将复选框加入session并登录并返回订单详细页面
				else if(request.getRequestURI().contains("placeOrder.action")){
					String StrBookIds[] = request.getParameterValues("cartBook");
					if(StrBookIds == null){
						response.sendRedirect("/Library/cart/seeCart.action");
						return false;
					}
					List<Integer> intBookIds= new ArrayList<Integer>();
					for(int i = 0; i<StrBookIds.length; i++){
						intBookIds.add(Integer.parseInt(StrBookIds[i]));
					}
					session.setAttribute("runCheckBookIds", intBookIds);
					session.setAttribute("lastUrl", "redirect:/order/runPlaceOrder.action");
				}
				
				response.sendRedirect("/Library/User/login.jsp");
				return false;
			}
		}
	}

}
