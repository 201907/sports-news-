package cn.jbit.news.bean;

import java.io.Serializable;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class Login implements Serializable {
	private Integer uid;
	//用户名
	private String uname;
	//密码
	private String upwd;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Login(Integer uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}
	

}
