package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.News;
import cn.jbit.news.daoImpl.NewsDaoImpl;
import cn.jbit.news.daoImpl.TopicDaoImpl;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.serviceImpl.NewsServiceImpl;
import cn.jbit.news.serviceImpl.TopicServiceImpl;

public class ToNewsUpdate extends HttpServlet{
	private NewsService newsService = new NewsServiceImpl(new NewsDaoImpl());
	private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//判断用户是否登录
		if(req.getSession().getAttribute("user")==null || (String)req.getSession().getAttribute("user") == "") {//如果没有登录返回主页
			resp.sendRedirect(contextPath);
		}else {
			int nid = Integer.valueOf(req.getParameter("id"));
			News news = newsService.queryNewsById(nid);
			req.setAttribute("news",news);
			req.setAttribute("topicName", topicService.queryTopicNameByid(news.getNtid()));
			req.getRequestDispatcher("news_update.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
