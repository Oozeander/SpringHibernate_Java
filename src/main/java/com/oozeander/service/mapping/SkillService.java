package com.oozeander.service.mapping;

import java.util.List;

import com.oozeander.model.mapping.Skill;

public interface SkillService {
	List<Skill> get();

	void save(Skill skill);
}