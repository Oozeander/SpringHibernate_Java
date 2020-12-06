package com.oozeander.service.mapping;

import java.util.List;

import com.oozeander.model.mapping.Professor;

public interface ProfessorService {
	List<Professor> get();

	void save(Professor professor);
}