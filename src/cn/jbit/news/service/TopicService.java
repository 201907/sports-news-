package cn.jbit.news.service;

import java.util.List;

import cn.jbit.news.bean.Topic;

public interface TopicService {
	List<Topic> queryAllTopic();
	int addTopic(Topic topic);
	int deleteTopic(int id);
	int updateTopic(Topic topic);
	String queryTopicNameByid(int id);
}
