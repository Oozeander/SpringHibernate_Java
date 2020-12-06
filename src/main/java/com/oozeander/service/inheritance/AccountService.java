package com.oozeander.service.inheritance;

import java.util.List;

import com.oozeander.model.inheritance.Account;

public interface AccountService {
	List<Account> get();

	void save(Account account);
}