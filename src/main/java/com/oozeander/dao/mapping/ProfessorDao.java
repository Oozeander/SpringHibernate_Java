package com.oozeander.dao.mapping;

import java.util.List;

import com.oozeander.model.mapping.Professor;

public interface ProfessorDao {
	List<Professor> get();

	void save(Professor professor);
}