package com.oozeander.dao.collection_enum_map;

import java.util.List;

import com.oozeander.model.collection_enum_map.User;

public interface UserDao {
	List<User> get();

	void save(User user);
}