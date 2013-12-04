package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import pojo.Friend;


public class FriendDaoImpl implements FriendDao {

	private SessionFactory sessionFactory;

	@Transactional
	public void add(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.save(friend);
	}
	
	public void insert(Friend friend) {
		Session session = sessionFactory.getCurrentSession(); // 开启Session
		Transaction tx = session.beginTransaction(); // 开启事务

		session.save(friend); // 保存数据

		tx.commit(); // 提交事务
		session.close(); //关闭Session
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
