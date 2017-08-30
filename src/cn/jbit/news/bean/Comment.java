package cn.jbit.news.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 *
 */
public class Comment implements Serializable {
	private int cid;
	private String cnid;
	private String cconent;
	private Date cdate;
	private String cip;
	private String cauth;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCnid() {
		return cnid;
	}
	public void setCnid(String cnid) {
		this.cnid = cnid;
	}
	public String getCconent() {
		return cconent;
	}
	public void setCconent(String cconent) {
		this.cconent = cconent;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauth() {
		return cauth;
	}
	public void setCauth(String cauth) {
		this.cauth = cauth;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int cid, String cnid, String cconent, Date cdate, String cip, String cauth) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cconent = cconent;
		this.cdate = cdate;
		this.cip = cip;
		this.cauth = cauth;
	}
	
}
