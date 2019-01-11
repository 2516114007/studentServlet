package com.ith.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ith.dao.StudentDao;
import com.ith.domain.Student;
import com.ith.utils.JDBCUtil02;

public class StudentDaoImpl implements StudentDao {
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
					student.getName(),
					student.getGender(),
					student.getPhone(),
					student.getBirthday(),
					student.getHobby(),
					student.getInfo()
				);
	}

	@Override
	public void delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where id=?", id);
	}

	@Override
	public Student findStudentById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where id=?", new BeanHandler<Student>(Student.class), id);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set name=?, gender=?, phone=?, birthday=?, hobby=?, info=? where id=?",
				student.getName(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getId()
				);
	}

	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where 1=1";
		List<String> list = new ArrayList<String>();
		
		//判断有没有姓名、性别，如果有，就拼到sql语句里面
		if(name != null && name.length() != 0){
			sql = sql + " and name like? ";
			list.add("%"+ name +"%");
		}
		if(gender != null && gender.length() != 0){
			sql = sql + " and gender=?";
			list.add(gender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}
}













