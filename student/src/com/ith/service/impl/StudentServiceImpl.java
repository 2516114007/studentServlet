package com.ith.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ith.dao.StudentDao;
import com.ith.dao.impl.StudentDaoImpl;
import com.ith.domain.PageBean;
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

	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(name, gender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		//封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(StudentDao.pageSize);
		
		List<Student> list = dao.findStudentByPage(currentPage);
		return null;
	}
}
