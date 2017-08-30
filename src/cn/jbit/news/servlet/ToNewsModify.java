package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.News;
import cn.jbit.news.bean.PageInfo;
import cn.jbit.news.daoImpl.NewsDaoImpl;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.serviceImpl.NewsServiceImpl;

public class ToNewsModify extends HttpServlet{
	private NewsService newsService = new NewsServiceImpl(new NewsDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//判断用户是否登录
		if(req.getSession().getAttribute("user")==null || (String)req.getSession().getAttribute("user") == "") {//如果没有登录返回主页
			resp.sendRedirect(contextPath);
		}else {
			//新闻的总数
			int newsCount = newsService.queryNewsCount();
			//总共有几页
			int pageCount = (newsCount+5-1)/5;
			//当前的页码
			int index = 1;
			if(req.getParameter("index")!=null&&req.getParameter("index")!="")index=Integer.valueOf(req.getParameter("index"));
			PageInfo info = PageInfo.valueOf(index, pageCount);
			req.setAttribute("newsList", newsService.queryNewsByPageNum(index, 5));
			req.setAttribute("pageInfo", info);
			req.getRequestDispatcher("news_modify.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
