package com.oozeander.dao.embedded_attributeOverrides.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.embedded_attributeOverrides.GamerDao;
import com.oozeander.model.embedded_attributeOverrides.Gamer;
import com.oozeander.model.embedded_attributeOverrides.GamerId;

@Repository("gamerDao")
public class GamerDaoImpl implements GamerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Gamer get(GamerId gamerId) {
		return (Gamer) sessionFactory.getCurrentSession().get(Gamer.class, gamerId);
	}

	@Override
	public void save(Gamer gamer) {
		sessionFactory.getCurrentSession().saveOrUpdate(gamer);
	}
}