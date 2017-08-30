package cn.jbit.news.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shenyang.commDao.daoImpl.commDaoImpl;

import cn.jbit.news.bean.Login;
import cn.jbit.news.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {
	/**
	 * 通过用户名密码查询
	 * @param username
	 * @param password
	 * @param conn 为了让业务层处理事务回滚，需要从业务层传入connection
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Login queryByUnameAndPwd(String username, String password,Connection conn) throws SQLException {
		String sql = "select * from user where uname = ? and upwd = ?";
		Login login = null;
		//try with resource代替finally及时释放资源
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, username);
			ps.setString(2, password);
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					if(login==null)login = new Login();
					login.setUname(rs.getString("uname"));
					login.setUpwd(rs.getString("upwd"));
				}
			}
		}
		return login;
	}
	
}
