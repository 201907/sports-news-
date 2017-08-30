package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.News;
import cn.jbit.news.daoImpl.NewsDaoImpl;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.serviceImpl.NewsServiceImpl;

public class NewsController extends HttpServlet{
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
			switch(req.getParameter("type")) {
			case "insert":
				News news = new News();
				news.setNtid(Integer.valueOf(req.getParameter("ntid")));
				news.setNtitle(req.getParameter("ntitle"));
				news.setNauthor(req.getParameter("nauthor"));
				news.setNsummary(req.getParameter("nsummary"));
				news.setNcontent(req.getParameter("ncontent"));
				news.setNpicpath(req.getParameter("file"));
				if(newsService.insertNews(news)!=0) {
					resp.getWriter().println("<script language='JavaScript'>alert('添加成功');location.href='"+contextPath+"/topic/do_topic';</script>");
				}else {
					resp.getWriter().println("<script language='JavaScript'>alert('添加失败');location.href='"+contextPath+"/topic/do_topic';</script>");
				}
				break;
			case "update":
				News news2 = new News();
				news2.setNtitle(req.getParameter("ntitle"));
				news2.setNauthor(req.getParameter("nauthor"));
				news2.setNsummary(req.getParameter("nsummary"));
				news2.setNcontent(req.getParameter("ncontent"));
				news2.setNpicpath(req.getParameter("file"));
				int id = Integer.valueOf(req.getParameter("nid"));
				if(newsService.updateNews(news2, id)!=0) {
					resp.getWriter().println("<script language='JavaScript'>alert('更新成功');location.href='"+contextPath+"/topic/do_topic';</script>");
				}else {
					resp.getWriter().println("<script language='JavaScript'>alert('更新失败');location.href='"+contextPath+"/topic/do_topic';</script>");
				}				
				break;
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
