

import static org.junit.Assert.*;

import org.junit.Test;

import cn.jbit.news.bean.Login;
import cn.jbit.news.daoImpl.LoginDaoImpl;
import cn.jbit.news.serviceImpl.LoginServiceImpl;

public class LoginServiceImplTest {

	@Test
	public void test() {
		LoginServiceImpl impl = new LoginServiceImpl(new LoginDaoImpl());
		Login login = impl.queryByNameAndPwd("benet", "benet");
		System.out.println(login.getUname());
	}

}
