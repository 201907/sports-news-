package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.Login;
import cn.jbit.news.daoImpl.LoginDaoImpl;
import cn.jbit.news.daoImpl.TopicDaoImpl;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.serviceImpl.LoginServiceImpl;
import cn.jbit.news.serviceImpl.TopicServiceImpl;

public class ToLogin extends HttpServlet{
	private LoginServiceImpl loginServiceImpl = new LoginServiceImpl(new LoginDaoImpl());
	private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("upwd");
		resp.setContentType("text/html;charset=utf-8");
		Login login = new Login();
		login.setUname(username);
		login.setUpwd(password);
		String contextPath = req.getContextPath();
		if(null==(login=loginServiceImpl.queryByNameAndPwd(username, password))) {//登录失败
			resp.getWriter().println("<script language='JavaScript'>alert('用户名或密码错误');location.href='"+contextPath+"/index.jsp';</script>");
		}else {//登录成功
			req.getSession().setAttribute("user", login.getUname());
			//准备数据
			resp.sendRedirect(contextPath+"/topic/do_topic");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
