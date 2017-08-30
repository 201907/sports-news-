package cn.jbit.news.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;



import cn.jbit.news.bean.Login;
import cn.jbit.news.dao.LoginDao;
import cn.jbit.news.service.LoginService;
import cn.jbit.news.utils.DBManager;

/**
 * 业务实现层
 * @author Administrator
 *
 */
public class LoginServiceImpl implements LoginService{
	private LoginDao loginDao;
	private DBManager dbManager;
	public LoginServiceImpl(LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
		this.dbManager = DBManager.getInstance();
	}

	@Override
	public Login queryByNameAndPwd(String username, String password) {
		Connection conn = null;
		Login login = null;
		try {
			conn = dbManager.getConn();
			login = loginDao.queryByUnameAndPwd(username, password, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}
	
}
