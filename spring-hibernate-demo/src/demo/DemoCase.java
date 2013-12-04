package demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Friend;
import dao.FriendDao;

public class DemoCase {
	
	private FriendDao friendDao;
	
	public void insert(String name) {
		Friend f = new Friend();
		f.setName(name);
		
		friendDao.add(f);
	}
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoCase dc = (DemoCase) beanFactory.getBean("demoCase");
		dc.insert("a");
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

}
