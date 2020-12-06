package com.oozeander.service.mapping.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.mapping.IdentityDao;
import com.oozeander.model.mapping.Identity;
import com.oozeander.service.mapping.IdentityService;

@Service("identityService")
@Transactional
public class IdentityServiceImpl implements IdentityService {
	@Autowired
	private IdentityDao identityDao;

	@Override
	public List<Identity> get() {
		return identityDao.get();
	}

	@Override
	public void save(Identity student) {
		identityDao.save(student);
	}
}