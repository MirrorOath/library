package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import infoClasses.RgUserInfo;
import oracleDao.util.ResultInfo;


@Controller
@RequestMapping(value="/admin/")
public class EasyUITest {
	@Autowired
	private oracleDao.Rg_lg rgImpl;
	
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(
				Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyyƒÍMM‘¬dd»’"),true));
	}
	@RequestMapping(value="get_users")
	public @ResponseBody List<RgUserInfo> get_users() throws Exception{
		List<RgUserInfo> users = rgImpl.users();
		return users;
	}
	
	@RequestMapping(value="new_user")
	public @ResponseBody ResultInfo new_users(RgUserInfo userInfo) throws Exception{
		ResultInfo result = new ResultInfo();
		if(userInfo!=null){
			rgImpl.register(userInfo);
			result.setSuccess(true);
			result.setMsg("success");
		}else{
			result.setSuccess(false);
			result.setMsg("failed");
		}
		return result;
	}
	@RequestMapping(value="del_user")
	public @ResponseBody ResultInfo del_user(Integer id) throws Exception{
		ResultInfo result = new ResultInfo();
		if(id!=null){
			rgImpl.delUser(id);
			result.setSuccess(true);
			result.setMsg("success");
		}else{
			result.setSuccess(false);
			result.setMsg("failed");
		}
		return result;
	}
	@RequestMapping(value="update_user")
	public @ResponseBody ResultInfo update_user(RgUserInfo userInfo) throws Exception{
		ResultInfo result = new ResultInfo();
		if(userInfo != null){
			System.out.println(userInfo);
			rgImpl.update(userInfo.getId(), userInfo);
			result.setSuccess(true);
			result.setMsg("success");
		}else{
			result.setSuccess(false);
			result.setMsg("failed");
		}
		return result;
	}
}