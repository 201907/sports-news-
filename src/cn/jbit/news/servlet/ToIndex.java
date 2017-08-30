package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.daoImpl.NewsDaoImpl;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.serviceImpl.NewsServiceImpl;

public class ToIndex extends HttpServlet{
	private NewsService newsService = new NewsServiceImpl(new NewsDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//准备数据
		req.setAttribute("internal", newsService.queryNewsByTopicName("国内"));
		req.setAttribute("international", newsService.queryNewsByTopicName("国际"));
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
