package com.oozeander.service.inheritance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.inheritance.AccountDao;
import com.oozeander.model.inheritance.Account;
import com.oozeander.service.inheritance.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> get() {
		return accountDao.get();
	}

	@Override
	public void save(Account account) {
		accountDao.save(account);
	}
}