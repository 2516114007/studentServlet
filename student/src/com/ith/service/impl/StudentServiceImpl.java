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

	@Override
	public void delete(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(id);
	}

	@Override
	public Student findStudentById(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(id);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}
}
