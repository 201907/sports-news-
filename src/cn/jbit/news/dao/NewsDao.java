package cn.jbit.news.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.news.bean.News;


public interface NewsDao {
	/**
	 * 根据tid判断是否有news存在
	 * @param tid
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	boolean newsIsExistByTid(int tid,Connection conn) throws SQLException;
	/**
	 * 添加新闻
	 * @param news
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	int addNews(News news,Connection conn) throws SQLException;
	/**
	 * 连表查询，根据主题名查询新闻标题
	 * @param topicNmae
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<String>queryNewsByTopicName(String topicName,Connection conn) throws SQLException;
	/**
	 * 查询所有的新闻
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<News>queryAllNews(Connection conn) throws SQLException;
	/**
	 * 查询新闻总数
	 * @return
	 * @throws SQLException
	 */
	int queryNewsCount(Connection conn) throws SQLException;
	/**
	 * 分页查询
	 * @param conn
	 * @param index
	 * @param pageRow
	 * @return
	 * @throws SQLException
	 */
	List<News>queryNewsByPageNum(Connection conn,int index,int pageRow) throws SQLException;
	/**
	 * 根据ID查询
	 * @param id
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	News queryNewsById(int id,Connection conn) throws SQLException;
	/**
	 * 根据ID修改news
	 * @param id
	 * @param news
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	int updateNews(int id,News news,Connection conn)throws SQLException;
	
}
