package com.ith.dao;

import java.sql.SQLException;
import java.util.List;

import com.ith.domain.Student;

public interface StudentDao {
	
	int pageSize = 2;//分页每页显示条数
	
	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 查血数据总数量
	 * @return
	 * @throws SQLException
	 */
	int findCount() throws SQLException;
	
	/**
	 * 分页显示学生数据
	 * @param page
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * 根据姓名、性别查询
	 * @param name
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String name, String gender) throws SQLException;

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
