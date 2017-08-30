package cn.jbit.news.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.dao.TopicDao;

public class TopicDaoImpl implements TopicDao{

	@Override
	public List<Topic> queryAllTopic(Connection conn) throws SQLException {
		List<Topic> listTopic = null;
		//try with resources 保证资源正常关闭
		try(	
				PreparedStatement ps = conn.prepareStatement("select * from topic");
				ResultSet rs = ps.executeQuery();
			){
				while(rs.next()) {
					if(listTopic == null)listTopic = Lists.newArrayList();
					Topic topic = new Topic();
					topic.setTid(rs.getInt("tid"));
					topic.setTname(rs.getString("tname"));
					listTopic.add(topic);
				}
		}
		return listTopic;
	}
	/**
	 * 添加主题
	 */
	@Override
	public int addTopic(Topic topic, Connection conn) throws SQLException {
		try(PreparedStatement ps = conn.prepareStatement("insert into topic values (tid,?)")){
			ps.setString(1, topic.getTname());
			return ps.executeUpdate();
		}
	}
	/**
	 * 删除主题
	 */
	@Override
	public int delete(int id, Connection conn) throws SQLException {
		try(PreparedStatement ps = conn.prepareStatement("delete from topic where tid = ?")){
			ps.setInt(1, id);
			return ps.executeUpdate();
		}		
	}
	/**
	 * 修改主题
	 */
	@Override
	public int update(Topic topic, Connection conn) throws SQLException {
		try(PreparedStatement ps = conn.prepareStatement("update topic set tname = ? where tid = ?")){
			ps.setString(1, topic.getTname());
			ps.setInt(2, topic.getTid());
			return ps.executeUpdate();
		}
	}
	/**
	 * 根据ID查询主题名
	 */
	@Override
	public String queryTopicNameByid(int id, Connection conn) throws SQLException {
		try(PreparedStatement ps = conn.prepareStatement("select tname from topic where tid = ?")){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					return rs.getString("tname");
				}
			}
		}
		return null;
	}



}
