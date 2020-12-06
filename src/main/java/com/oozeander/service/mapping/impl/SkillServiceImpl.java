package com.oozeander.service.mapping.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.mapping.SkillDao;
import com.oozeander.model.mapping.Skill;
import com.oozeander.service.mapping.SkillService;

@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillDao skillDao;

	@Override
	public List<Skill> get() {
		return skillDao.get();
	}

	@Override
	public void save(Skill skill) {
		skillDao.save(skill);
	}
}