package com.oozeander.service.embedded_attributeOverrides.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.embedded_attributeOverrides.GamerDao;
import com.oozeander.model.embedded_attributeOverrides.Gamer;
import com.oozeander.model.embedded_attributeOverrides.GamerId;
import com.oozeander.service.embedded_attributeOverrides.GamerService;

@Service("gamerService")
@Transactional
public class GamerServiceImpl implements GamerService {
	@Autowired
	private GamerDao gamerDao;

	@Override
	public Gamer get(GamerId gamerId) {
		return gamerDao.get(gamerId);
	}

	@Override
	public void save(Gamer gamer) {
		gamerDao.save(gamer);
	}
}