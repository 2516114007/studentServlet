package com.ith.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ith.dao.StudentDao;
import com.ith.dao.impl.StudentDaoImpl;
import com.ith.domain.Student;
import com.ith.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}
}
