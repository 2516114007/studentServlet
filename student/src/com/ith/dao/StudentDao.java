package com.ith.dao;

import java.sql.SQLException;
import java.util.List;

import com.ith.domain.Student;

public interface StudentDao {
	
	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> findAll() throws SQLException;

	/*
	 * 添加学生数据
	 */
	void insert(Student student) throws SQLException;
}
