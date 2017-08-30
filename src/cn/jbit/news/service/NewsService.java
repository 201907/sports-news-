package cn.jbit.news.service;

import java.util.List;

import cn.jbit.news.bean.News;

public interface NewsService {
	boolean newsIsExistByTid(int tid);
	int insertNews(News news);
	List<String> queryNewsByTopicName(String topicName);
	List<News>queryAllNews();
	int queryNewsCount();
	List<News>queryNewsByPageNum(int index,int pageRow);
	News queryNewsById(int id);
	int updateNews(News news,int id);
}
