package com.oozeander.dao.collection_enum_map.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.collection_enum_map.UserDao;
import com.oozeander.model.collection_enum_map.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM User u ORDER BY u.id").list();
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
}