package cn.jbit.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.daoImpl.TopicDaoImpl;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.serviceImpl.TopicServiceImpl;

public class ToAddNews extends HttpServlet{
	private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		//判断用户是否登录
		if(req.getSession().getAttribute("user")==null || (String)req.getSession().getAttribute("user") == "") {//如果没有登录返回主页
			resp.sendRedirect(contextPath);
		}else {
			List<Topic> topics = topicService.queryAllTopic();
			req.setAttribute("topics", topics);
			req.getRequestDispatcher("/topic/news_add.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
