package infoClasses;

import java.util.Date;


public class RgUserInfo {
	private Integer id;
	private String username;
	private String pwd;
	private Integer age;
	private Date date;

	public RgUserInfo(){
		super();
	}
	
	public RgUserInfo(String username, String pwd, Integer age, Date date){
		super();
		this.username = username;
		this.pwd = pwd;
		this.age = age;
		this.date = date;
	}
	
	public RgUserInfo(RgUserInfo userInfo){
		super();
		this.username = userInfo.getUsername();
		this.pwd = userInfo.getPwd();
		this.age = userInfo.getAge();
		this.date = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "RgUserInfo [id=" + id + ", username=" + username + ", pwd=" + pwd + ", age=" + age + ", date=" + date
				+ "]";
	}
	
	
}
