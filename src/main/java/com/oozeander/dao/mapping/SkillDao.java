package com.oozeander.dao.mapping;

import java.util.List;

import com.oozeander.model.mapping.Skill;

public interface SkillDao {
	List<Skill> get();

	void save(Skill skill);
}