/**
 * 
 */
package cn.jbit.news.utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class DBManagerTest {

	@Test
	public void test() {
		try {
			Connection conn = DBManager.getInstance().getConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
