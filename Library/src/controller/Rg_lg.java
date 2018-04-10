package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import infoClasses.OrderDetail;
import infoClasses.OrderForm;
import infoClasses.RgUserInfo;
import oracleDao.Order_go;
import oracleDao.impl.Rg_lgimpl;

@Controller
@RequestMapping(value="/user/")
public class Rg_lg {
	@Autowired
	private oracleDao.Rg_lg userImpl;
	@Autowired
	private Order_go oImpl;
	@Autowired
	private oracleDao.Rg_lg uImpl;

	@RequestMapping(value="register")
	public String register(Model model, RgUserInfo userInfo){
		Rg_lgimpl rglg = new Rg_lgimpl();
		RgUserInfo selInfo = rglg.findByName(userInfo.getUsername());
		if(selInfo == null){
			rglg.register(userInfo);
			return "registerSuccess";
		}
		else{
			model.addAttribute("msg", "用户名已存在");
			return "register";
		}
	}
	@RequestMapping(value="update")
	public String update(Model model, RgUserInfo userInfo, HttpSession session){
		Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
		RgUserInfo selInfo = userImpl.findByName(userInfo.getUsername());
		if(selInfo == null){
			userInfo.setId(userId);
			userImpl.update(userInfo);
			session.removeAttribute("userInfo");
			return "redirect:../User/login.jsp";
		}
		else{
			model.addAttribute("msg", "用户名已存在");
			return "redirect:../User/userarea.jsp";
		}
	}
	@RequestMapping(value="login")
	public String login(Model model, RgUserInfo userInfo, HttpSession session){
		Rg_lgimpl rglg = new Rg_lgimpl();
		RgUserInfo selInfo = rglg.findByName(userInfo.getUsername());
		if(selInfo == null){
			model.addAttribute("msg", "用户名不存在或者密码错误");
			return "login";
		}
		if(userInfo.getPwd().equals(selInfo.getPwd())){
			session.setAttribute("userInfo", selInfo);
			session.setAttribute("unameNext", "退出登录");
			return session.getAttribute("lastUrl").toString();
		}
		model.addAttribute("msg", "用户名不存在或者密码错误");
		return "login";
	}
	
	@RequestMapping(value="rg_lg_do")
	public String Rg_lg_do(Model model, HttpSession session, String rorl){
		// 登录状态
		if(session.getAttribute("userInfo") != null){
			session.setAttribute("unameNext", "退出登录");
			// 点击用户名
			if("login".equals(rorl)){
				Integer userId = ((RgUserInfo)session.getAttribute("userInfo")).getId();
				RgUserInfo userInfo = uImpl.getUserById(userId);
				List<OrderForm> forms = oImpl.getFormByUser(userInfo);
				model.addAttribute("orders", forms);
				List<OrderDetail> details = oImpl.getAllDetails();
				model.addAttribute("details", details);
				return "userarea";
			}
			// 点击退出登录
			else if("register".equals(rorl)){
				session.removeAttribute("userInfo");
				if(session.getAttribute("lastUrl") == null)
					session.setAttribute("lastUrl", "redirect:../index.jsp");
				return "redirect:../User/login.jsp";
			}
			else
				return "redirect:../index.jsp";
		}
		// 非登录状态
		else{
			if("register".equals(rorl))
				return "redirect:../User/register.jsp";
			else if("login".equals(rorl)){
				session.setAttribute("lastUrl", "redirect:../index.jsp");
				return "redirect:../User/login.jsp";
			}
			else
				return "redirect:../index.jsp";
		}
	}
	
	
}