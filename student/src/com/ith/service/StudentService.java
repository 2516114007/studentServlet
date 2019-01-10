package com.ith.service;

import java.sql.SQLException;
import java.util.List;

import com.ith.domain.Student;

/*
 * ����ѧ����ҵ����淶
 */

public interface StudentService {
	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> findAll() throws SQLException;

	/*
	 * 添加
	 */
	void insert(Student student) throws SQLException;
}
