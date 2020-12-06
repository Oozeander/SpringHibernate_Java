package com.oozeander.dao.mapping;

import java.util.List;

import com.oozeander.model.mapping.Student;

public interface StudentDao {
	List<Student> get();

	void save(Student student);
}