package cn.jbit.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.daoImpl.NewsDaoImpl;
import cn.jbit.news.daoImpl.TopicDaoImpl;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.serviceImpl.NewsServiceImpl;
import cn.jbit.news.serviceImpl.TopicServiceImpl;

public class TopicController extends HttpServlet{
	private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
	private NewsService newsService = new NewsServiceImpl(new NewsDaoImpl());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		if(req.getSession().getAttribute("user")==null || (String)req.getSession().getAttribute("user") == "") {//如果没有登录返回主页
			resp.sendRedirect(contextPath);
		}else {
			resp.setContentType("text/html;charset=utf-8");
			String type = req.getParameter("type");
			req.setCharacterEncoding("utf-8");
			switch(type) {
			case "insert":
				Topic topic = new Topic();
				String tName = new String(req.getParameter("tname").getBytes("iso-8859-1"),"utf-8");
				topic.setTname(tName);
				if(0!=topicService.addTopic(topic)) {
					resp.getWriter().println("<script language='JavaScript'>alert('添加成功');location.href='"+contextPath+"/topic/do_topic';</script>");
				}else {
					resp.getWriter().println("<script language='JavaScript'>alert('添加失败');location.href='"+contextPath+"/topic/do_topic';</script>");
				}
				break;
			case "update":
				int tid = Integer.valueOf(req.getParameter("tid"));
				String tname = new String(req.getParameter("tname").getBytes("iso-8859-1"),"utf-8");
				Topic topic2 = new Topic();
				topic2.setTid(tid);
				topic2.setTname(tname);
				if(0!=topicService.updateTopic(topic2)) {
					resp.getWriter().println("<script language='JavaScript'>alert('更新成功');location.href='"+contextPath+"/topic/do_topic';</script>");
				}else {
					resp.getWriter().println("<script language='JavaScript'>alert('更新失败');location.href='"+contextPath+"/topic/do_topic';</script>");
				}
				break;
			case "delete":
				int id =  Integer.valueOf(req.getParameter("id"));
				if(newsService.newsIsExistByTid(id)) {
					resp.getWriter().println("<script language='JavaScript'>alert('该主题有新闻不能删除');location.href='"+contextPath+"/topic/do_topic';</script>");
					
				}else {
					if(0!=topicService.deleteTopic(id)) {
						resp.getWriter().println("<script language='JavaScript'>alert('删除成功');location.href='"+contextPath+"/topic/do_topic';</script>");
					}else {
						resp.getWriter().println("<script language='JavaScript'>alert('删除失败');location.href='"+contextPath+"/topic/do_topic';</script>");
					}
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
