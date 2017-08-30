package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.daoImpl.TopicDaoImpl;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.serviceImpl.TopicServiceImpl;

public class ToTopic extends HttpServlet{
	private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		if(req.getSession().getAttribute("user")==null || (String)req.getSession().getAttribute("user") == "") {//如果没有登录返回主页
			resp.sendRedirect(contextPath);
		}else {//登录情况下准备数据
			//准备数据
			req.setAttribute("topicList", topicService.queryAllTopic());
			req.getRequestDispatcher("/topic/admin.jsp").forward(req, resp);;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
