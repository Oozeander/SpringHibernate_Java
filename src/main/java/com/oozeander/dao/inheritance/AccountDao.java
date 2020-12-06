package com.oozeander.dao.inheritance;

import java.util.List;

import com.oozeander.model.inheritance.Account;

public interface AccountDao {
	List<Account> get();

	void save(Account account);
}