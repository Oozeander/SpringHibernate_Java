package com.oozeander.dao.mapping.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.mapping.IdentityDao;
import com.oozeander.model.mapping.Identity;

@Repository("identityDao")
public class IdentityDaoImpl implements IdentityDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Identity> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Identity i ORDER BY i.id").list();
	}

	@Override
	public void save(Identity identity) {
		sessionFactory.getCurrentSession().saveOrUpdate(identity);
	}
}