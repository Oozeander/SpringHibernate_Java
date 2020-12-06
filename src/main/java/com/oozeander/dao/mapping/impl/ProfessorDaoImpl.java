package com.oozeander.dao.mapping.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.mapping.ProfessorDao;
import com.oozeander.model.mapping.Professor;

@Repository("professorDao")
public class ProfessorDaoImpl implements ProfessorDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Professor p ORDER BY p.id").list();
	}

	@Override
	public void save(Professor professor) {
		sessionFactory.getCurrentSession().saveOrUpdate(professor);
	}
}