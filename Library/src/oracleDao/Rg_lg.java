package oracleDao;

import java.util.List;

import infoClasses.RgUserInfo;


public interface Rg_lg {

	// 返回所有用户
	List<RgUserInfo> users();
	// 返回一个用户
	RgUserInfo getUserById(Integer ui_id);
	// 注册一个普通用户
	void register(RgUserInfo ui);
	void update(RgUserInfo ui);
	// 删除一个用户
	void delUser(Integer ui_id);
	// 基于name id 日期
	void update(Integer ui_id, RgUserInfo userInfo);
	// 基于id修改密码
	void rePwd(Integer ui_id, String pwd);
	// 基于id差寻
	RgUserInfo findById(Integer ui_id);
	// 基于用户名查寻
	RgUserInfo findByName(String ui_name);
	// 基于名字模糊查找  并返回所有符合条件的员工
	List<RgUserInfo> getAllEmps(String ui_name);
	/***
	 * 分页查询
	 * @param start_index 起始下标
	 * @param count 每页的记录数
	 * @return 返回一页记录
	 */
	List<RgUserInfo> getPageRows(int start_index,int count);
	// 基于id删除用户
	void delete(int ui_id);
}
