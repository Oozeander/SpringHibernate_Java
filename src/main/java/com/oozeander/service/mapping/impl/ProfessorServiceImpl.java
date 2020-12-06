package com.oozeander.service.mapping.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oozeander.dao.mapping.ProfessorDao;
import com.oozeander.model.mapping.Professor;
import com.oozeander.service.mapping.ProfessorService;

@Service("professorService")
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
	@Autowired
	private ProfessorDao professorDao;

	@Override
	public List<Professor> get() {
		return professorDao.get();
	}

	@Override
	public void save(Professor professor) {
		professorDao.save(professor);
	}
}