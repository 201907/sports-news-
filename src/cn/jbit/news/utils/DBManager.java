package cn.jbit.news.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 连接池
 * @author Administrator
 *
 */
public class DBManager {
	private ComboPooledDataSource dataSource;
	public Connection getConn() throws SQLException {
		Connection conn = dataSource.getConnection();
		conn.setAutoCommit(false);
		return conn;
	}
	public static DBManager getInstance() {
		return Inner.dbManager;
	}
	public static class Inner{
		public final static DBManager dbManager = new DBManager();
	}
	private DBManager() {
		super();
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("DBconfig.properties"));
			dataSource = new ComboPooledDataSource(true);
			dataSource.setJdbcUrl(properties.getProperty("url"));
			dataSource.setDriverClass(properties.getProperty("driverClassName"));
			dataSource.setUser(properties.getProperty("username"));
			dataSource.setPassword(properties.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
