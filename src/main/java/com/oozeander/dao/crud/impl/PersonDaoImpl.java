package com.oozeander.dao.crud.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oozeander.dao.crud.PersonDao;
import com.oozeander.model.crud.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> get() {
		return sessionFactory.getCurrentSession().createQuery("FROM Person p ORDER BY p.id").list();
	}

	@Override
	public Person get(Long id) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
	}

	@Override
	public void save(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	@Override
	public void update(Long id, Person person) {
		Person personToUpdate = get(id);
		if (personToUpdate != null && person != null) {
			personToUpdate.setFirstname(person.getFirstname());
			personToUpdate.setLastname(person.getLastname());
			personToUpdate.setAge(person.getAge());
			sessionFactory.getCurrentSession().update(personToUpdate);
		}
	}

	@Override
	public void delete(Long id) {
		if (get(id) != null)
			sessionFactory.getCurrentSession().delete(get(id));
	}
}