package cn.jbit.news.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import cn.jbit.news.bean.News;
import cn.jbit.news.dao.NewsDao;

public class NewsDaoImpl implements NewsDao{


	@Override
	public boolean newsIsExistByTid(int tid, Connection conn) throws SQLException {
		//try with resources自动释放资源
		try(PreparedStatement ps = conn.prepareStatement("select nid,ntid,ntame,comments,ntitle,nauthor,ncreatedate,npicpath,ncontent,nmodifydate,nsummary from news where ntid = ?")){
			ps.setInt(1, tid);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int addNews(News news, Connection conn) throws SQLException {
		int result = 0;
		String sql = "insert into news(ntid,ntitle,nauthor,nsummary,ncontent,npicpath,ncreatedate) values(?,?,?,?,?,?,now())";
		//try with resources自动释放资源
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, news.getNtid());
			ps.setString(2, news.getNtitle());
			ps.setString(3, news.getNauthor());
			ps.setString(4, news.getNsummary());
			ps.setString(5, news.getNcontent());
			ps.setString(6, news.getNpicpath());
			result = ps.executeUpdate();
		}
		return result;
	}
	/**
	 * 连表查询
	 * 根据主题名查询新闻名
	 */
	@Override
	public List<String> queryNewsByTopicName(String topicName, Connection conn) throws SQLException {
		List newsTitles = null;
		String sql ="select ntitle from news n inner join topic t on n.ntid = t.tid where t.tname = ?";
		//try with resouces自动释放资源
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, topicName);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					if(newsTitles==null)newsTitles = Lists.newArrayList();
					newsTitles.add(rs.getString(1));
				}
			}
		}
		return newsTitles;
	}

	@Override
	public List<News> queryAllNews(Connection conn) throws SQLException {
		List<News> newsList = null;
		//try with resouces自动释放资源
		try(PreparedStatement ps = conn.prepareStatement("select ntitle,nid from news")){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					if(newsList==null)newsList = Lists.newArrayList();
					News news = new News();
					news.setNid(rs.getInt("nid"));
					news.setNtitle(rs.getString("ntitle"));
					newsList.add(news);
				}
			}
		}
		return newsList;
	}

	@Override
	public int queryNewsCount(Connection conn) throws SQLException {
		int count = 0;
		String sql = "select count(*) from news";
		//try with resouces自动释放资源
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					count = rs.getInt(1);
				}
			}
		}
		return count;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<News> queryNewsByPageNum(Connection conn, int index, int pageRow) throws SQLException {
		List<News> newsList = null;
		//try with resouces自动释放资源
		try(PreparedStatement ps = conn.prepareStatement("select ntitle,nid from news limit ?,?")){
			ps.setInt(1, (index-1)*pageRow);
			ps.setInt(2, pageRow);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					if(newsList==null)newsList = Lists.newArrayList();
					News news = new News();
					news.setNid(rs.getInt("nid"));
					news.setNtitle(rs.getString("ntitle"));
					newsList.add(news);
				}
			}
		}
		return newsList;
	}
	/**
	 * 根据ID查询结果
	 */
	@Override
	public News queryNewsById(int id, Connection conn) throws SQLException {
		News news = null;
		String sql = "select ntid,nid,ntitle,nauthor,nsummary,ncontent,npicpath from news where nid = ?";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					news = new News();
					news.setNid(rs.getInt("nid"));
					news.setNtid(rs.getInt("ntid"));
					news.setNtitle(rs.getString("ntitle"));
					news.setNauthor(rs.getString("nauthor"));
					news.setNsummary(rs.getString("nsummary"));
					news.setNcontent(rs.getString("ncontent"));
					news.setNpicpath(rs.getString("npicpath"));
				}
			}
		}
		return news;
	}

	@Override
	public int updateNews(int id, News news, Connection conn) throws SQLException {
		String sql = "update news set ntitle=?,nauthor=?,nsummary=?,ncontent=?,npicpath=? where nid=?";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, news.getNtitle());
			ps.setString(2, news.getNauthor());
			ps.setString(3, news.getNsummary());
			ps.setString(4, news.getNcontent());
			ps.setString(5, news.getNpicpath());
			ps.setInt(6, id);
			return ps.executeUpdate();
		}
	}

}
