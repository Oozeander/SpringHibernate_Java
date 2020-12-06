package com.oozeander.service.mapping;

import java.util.List;

import com.oozeander.model.mapping.Student;

public interface StudentService {
	List<Student> get();

	void save(Student student);
}