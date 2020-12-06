package com.oozeander.service.collection_enum_map.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.collection_enum_map.UserDao;
import com.oozeander.model.collection_enum_map.User;
import com.oozeander.service.collection_enum_map.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> get() {
		return userDao.get();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}
}