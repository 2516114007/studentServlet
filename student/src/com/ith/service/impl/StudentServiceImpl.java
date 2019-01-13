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
		
		int pageSize = StudentDao.pageSize;//每页显示条数
		pageBean.setCurrentPage(currentPage);//设置当前页
		pageBean.setPageSize(pageSize);//设置每页显示多少条数据
		
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);//设置这一页的学生数据
		
		//总的记录数，总的页数
		int count = dao.findCount();
		pageBean.setTotalSize(count);//设置总的记录数
		pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : count /pageSize + 1);
		
		return pageBean;
	}
}
