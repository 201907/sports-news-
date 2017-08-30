package cn.jbit.news.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.news.bean.News;
import cn.jbit.news.dao.LoginDao;
import cn.jbit.news.dao.NewsDao;
import cn.jbit.news.service.NewsService;
import cn.jbit.news.utils.DBManager;

public class NewsServiceImpl implements NewsService{
	private NewsDao newsDao;
	private DBManager dbManager;
	public NewsServiceImpl(NewsDao newsDao) {
		super();
		this.newsDao = newsDao;
		this.dbManager = DBManager.getInstance();
	}
	/**
	 * 传入tid判断该主题下是否存在新闻
	 */
	@Override
	public boolean newsIsExistByTid(int tid) {
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			return newsDao.newsIsExistByTid(tid, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	/**
	 * 添加新闻
	 */
	@Override
	public int insertNews(News news) {
		int result = 0;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			result = newsDao.addNews(news, conn);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public List<String> queryNewsByTopicName(String topicName) {
		List<String> newsNames = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			newsNames = newsDao.queryNewsByTopicName(topicName, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newsNames;
	}
	/**
	 * 查询所有新闻
	 */
	@Override
	public List<News> queryAllNews() {
		List<News>newsList = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			newsList = newsDao.queryAllNews(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newsList;
	}
	@Override
	public int queryNewsCount() {
		int count = 0;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			count = newsDao.queryNewsCount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	@Override
	public List<News> queryNewsByPageNum(int index,int pageRow) {
		List<News>newsList = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			newsList = newsDao.queryNewsByPageNum(conn, index, pageRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newsList;
	}
	@Override
	public News queryNewsById(int id) {
		News news = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			news = newsDao.queryNewsById(id, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return news;
	}
	@Override
	public int updateNews(News news, int id) {
		int result = 0;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			result = newsDao.updateNews(id, news, conn);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
