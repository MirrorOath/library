package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import infoClasses.BookInfo;
import infoClasses.RgUserInfo;
import oracleDao.Book_go;
import service.Order_sir;



@Controller
@RequestMapping(value="/admin/")
public class Admin {
	@Autowired
	private Book_go bookImpl;
	@Autowired
	private oracleDao.Rg_lg rgImpl;
	@Autowired
	private Order_sir sirImpl;
	
	@RequestMapping(value="login")
	public String register(Model model, String name, String password){
		if("admin".equals(name) && "admin".equals(password))
			return "redirect:../admin/control.jsp";
		else
			return "../index";
	}
	@RequestMapping(value="addBook")
	public String addBook(Model model, BookInfo bookInfo){
		bookInfo.setImageSrc("image/book.jpg");
		BookInfo selInfo = bookImpl.getBookByName(bookInfo.getBookName());
		if(selInfo == null){
			bookImpl.addBook(bookInfo);
			String str = bookInfo.getBookName();
			for(int i = 1; i<=100; i++){
				bookInfo.setBookName(str+i);
				bookImpl.addBook(bookInfo);
			}
			return "../admin/control";
		}
		else{
			model.addAttribute("msg", "书已存在");
			return "../admin/control";
		}
	}
	@RequestMapping(value="queryUsers")
	public String addBook(Model model){
		List<RgUserInfo> users = rgImpl.users();
		model.addAttribute("users", users);
		return "../admin/userInfo";
	}
	@RequestMapping(value="delUser")
	public String delUser(Integer userId){
		sirImpl.delOrderFormsByUserId(userId);
		rgImpl.delete(userId);
		return "redirect:queryUsers.action";
	}
	@RequestMapping(value="rePwd")
	public String rePwd(Integer userId, String repwd){
		rgImpl.rePwd(userId, repwd);
		return "redirect:../user/rg_lg_do.action?rorl=register";
	}

}