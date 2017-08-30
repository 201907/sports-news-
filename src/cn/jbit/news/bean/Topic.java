package cn.jbit.news.bean;

import java.io.Serializable;

/**
 * 新闻主题
 * @author Administrator
 *
 */
public class Topic implements Serializable {
	private Integer tid;
	//主题名称
	private String tname;
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Topic(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
}
