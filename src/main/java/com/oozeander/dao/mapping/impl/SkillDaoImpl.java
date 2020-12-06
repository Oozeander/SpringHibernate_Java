package com.oozeander.dao.mapping.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.mapping.SkillDao;
import com.oozeander.model.mapping.Skill;

@Repository("skillDao")
public class SkillDaoImpl implements SkillDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Skill s ORDER BY s.id").list();
	}

	@Override
	public void save(Skill skill) {
		sessionFactory.getCurrentSession().saveOrUpdate(skill);
	}
}