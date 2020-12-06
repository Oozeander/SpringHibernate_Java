package com.oozeander.dao.mapping.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.mapping.StudentDao;
import com.oozeander.model.mapping.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Student s ORDER BY s.id").list();
	}

	@Override
	public void save(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}
}