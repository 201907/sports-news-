package cn.jbit.news.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.news.bean.Topic;

public interface TopicDao {
	/**
	 * 业务层传入conn保证事务回滚
	 * @param conn
	 * @return
	 */
	List<Topic> queryAllTopic(Connection conn) throws SQLException ;
	int addTopic(Topic topic,Connection conn) throws SQLException;
	int delete(int id,Connection conn) throws SQLException;
	int update(Topic topic,Connection conn) throws SQLException;
	String queryTopicNameByid(int id,Connection conn) throws SQLException;
}
