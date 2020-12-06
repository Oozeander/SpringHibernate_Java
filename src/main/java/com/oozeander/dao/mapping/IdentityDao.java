package com.oozeander.dao.mapping;

import java.util.List;

import com.oozeander.model.mapping.Identity;

public interface IdentityDao {
	List<Identity> get();

	void save(Identity identity);
}