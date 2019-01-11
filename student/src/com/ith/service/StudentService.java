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
	 * 根据id查询单个学生对象
	 */
	Student findStudentById(int id) throws SQLException;
	
	/**
	 * 根据姓名、性别查询
	 * @param name
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String name, String gender) throws SQLException;

	/*
	 * 修改学生数据
	 */
	void update(Student student) throws SQLException;
	
	/*
	 * 添加
	 */
	void insert(Student student) throws SQLException;
	
	/*
	 * 删除学生数据
	 */
	void delete(int id) throws SQLException;
}
