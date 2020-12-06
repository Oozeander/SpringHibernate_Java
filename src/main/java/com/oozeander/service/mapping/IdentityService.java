package com.oozeander.service.mapping;

import java.util.List;

import com.oozeander.model.mapping.Identity;

public interface IdentityService {
	List<Identity> get();

	void save(Identity identity);
}