package infoClasses;

import java.util.Date;

public class OrderForm {
	private Integer id;
	private RgUserInfo userInfo;
	private Float totalPrice;
	private String address;
	private Date date;
	private String Info;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RgUserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(RgUserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", totalPrice=" + totalPrice + ", address=" + address + ", date=" + date
				+ ", Info=" + Info + "]";
	}

}
