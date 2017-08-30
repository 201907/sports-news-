package cn.jbit.news.service;

import cn.jbit.news.bean.Login;

public interface LoginService {
	Login queryByNameAndPwd(String username,String password);
}
