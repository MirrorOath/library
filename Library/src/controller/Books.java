package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import infoClasses.BookInfo;
import oracleDao.Book_go;
import oracleDao.impl.BookImpl;
import oracleDao.util.PageBean;

@Controller
@RequestMapping(value="/search/")
public class Books {
	@Autowired
	private Book_go bookImpl;
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="changePage")
	private String changePage(Model model, HttpSession session, Integer page){
	    System.out.println("changePage");
		PageBean<BookInfo> bookBean = (PageBean<BookInfo>)session.getAttribute("pageBean");
		if(bookBean == null)
			return "redirect:index.jsp";
		bookBean.setCurrentPage(page > 0 && page <= bookBean.getTotalCount() ?page :bookBean.getCurrentPage());
		bookImpl.getPageBooksByName(bookBean, bookBean.getBookName());
		List<BookInfo> books = bookBean.getPageData();
		session.setAttribute("pageBean", bookBean);
		model.addAttribute("books", books);
		return "search";
	}
	
	@RequestMapping(value="byName")
	public String searchByName(Model model, String bookName, HttpSession session){
		session.removeAttribute("lastPage");
		session.removeAttribute("nextPage");
		if("".equals(bookName))
			return "search";
		PageBean<BookInfo> bookBean = new PageBean<BookInfo>();
		bookBean.setBookName(bookName);
		bookBean.setPageCount(12);

		bookImpl.getPageBooksByName(bookBean, bookName);
		session.setAttribute("pageBean", bookBean);
		return "redirect:changePage.action?page=1";
	}
	@RequestMapping(value="bookInfo")
	public String bookInfo(Model model, Integer bookId){
		
		/*String s = null;
		try {
			byte[] data = bookName.getBytes("iso8859-1");
			s=new String(data,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/

		BookInfo book = new BookImpl().getBookById(bookId);
		model.addAttribute("book", book);
		return "bookInfo";
	}
}
