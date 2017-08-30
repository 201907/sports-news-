package cn.jbit.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jbit.news.bean.Login;

public interface LoginDao {
	/**
	 * 通过用户名密码查询
	 * @param username
	 * @param password
	 * @param conn 为了让业务层处理事务回滚，需要从业务层传入connection
	 * @return
	 * @throws SQLException
	 */
	Login queryByUnameAndPwd(String username,String password,Connection conn) throws SQLException;
}
