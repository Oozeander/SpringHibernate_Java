package com.oozeander.dao.inheritance.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.inheritance.AccountDao;
import com.oozeander.model.inheritance.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Account a ORDER BY a.id").list();
	}

	@Override
	public void save(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
	}
}