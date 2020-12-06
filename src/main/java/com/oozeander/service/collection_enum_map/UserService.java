package com.oozeander.service.collection_enum_map;

import java.util.List;

import com.oozeander.model.collection_enum_map.User;

public interface UserService {
	List<User> get();

	void save(User user);
}