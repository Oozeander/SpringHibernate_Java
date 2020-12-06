package com.oozeander.service.mapping.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.mapping.StudentDao;
import com.oozeander.model.mapping.Student;
import com.oozeander.service.mapping.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> get() {
		return studentDao.get();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
	}
}