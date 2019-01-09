package com.ith.service;

import java.sql.SQLException;
import java.util.List;

import com.ith.domain.Student;

/*
 * 这是学生的业务处理规范
 */

public interface StudentService {
	/*
	 * 查询所有学生
	 */
	List<Student> findAll() throws SQLException;
}
