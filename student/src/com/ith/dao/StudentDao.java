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
	 * 根据id查询单个学生对象
	 */
	Student findStudentById(int id) throws SQLException;
	
	/*
	 * 修改学生数据
	 */
	void update(Student student) throws SQLException;
	
	/*
	 * 添加学生数据
	 */
	void insert(Student student) throws SQLException;
	
	/*
	 * 删除学生数据
	 */
	void delete(int id) throws SQLException;
}
