package com.oozeander.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.crud.PersonDao;
import com.oozeander.model.crud.Person;
import com.oozeander.service.crud.PersonService;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public List<Person> get() {
		return personDao.get();
	}

	@Override
	public Person get(Long id) {
		return personDao.get(id);
	}

	@Override
	public void save(Person person) {
		personDao.save(person);
	}

	@Override
	public void update(Long id, Person person) {
		personDao.update(id, person);
	}

	@Override
	public void delete(Long id) {
		personDao.delete(id);
	}
}