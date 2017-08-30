package cn.jbit.news.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.dao.TopicDao;
import cn.jbit.news.service.TopicService;
import cn.jbit.news.utils.DBManager;
/**
 * 业务层
 * @author Administrator
 *
 */
public class TopicServiceImpl implements TopicService{
	private TopicDao topicDao;
	private DBManager dbManager;
	public TopicServiceImpl(TopicDao topicDao) {
		super();
		this.topicDao = topicDao;
		this.dbManager = DBManager.getInstance();
	}
	@Override
	public List<Topic> queryAllTopic() {
		Connection conn = null;
		List<Topic> list = null;
		try {
			conn = dbManager.getConn();
			list = topicDao.queryAllTopic(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public int addTopic(Topic topic) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			result = topicDao.addTopic(topic, conn);
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
	public int deleteTopic(int id) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			result = topicDao.delete(id, conn);
			conn.commit();
		} catch (SQLException e) {
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
	public int updateTopic(Topic topic) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			result = topicDao.update(topic, conn);
			conn.commit();
		} catch (SQLException e) {
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
	public String queryTopicNameByid(int id) {
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			return topicDao.queryTopicNameByid(id, conn);
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
		return null;
	}

}
