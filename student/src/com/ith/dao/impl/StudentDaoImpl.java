package com.ith.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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

}
