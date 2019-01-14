package com.ith.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ith.dao.StudentDao;
import com.ith.domain.Student;
import com.ith.utils.JDBCUtil02;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 查询所有学生数据
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	/**
	 * 添加学生数据
	 */
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

	/**
	 * 删除学生数据
	 */
	@Override
	public void delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where id=?", id);
	}

	/**
	 * 根据id查找学生数据-修改
	 */
	@Override
	public Student findStudentById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where id=?", new BeanHandler<Student>(Student.class), id);
	}

	/**
	 * 修改学生数据-修改
	 */
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

	/**
	 * 模糊查询
	 */
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

	/**
	 * 查询currentPage对应的数据
	 */
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		if(currentPage == 1){
			String sql = "select * from stu limit ?";
			return runner.query(sql, new BeanListHandler<Student>(Student.class), pageSize);
		}else{
			String sql = "select * from stu limit ?,?";
			return runner.query(sql, new BeanListHandler<Student>(Student.class), pageSize, (currentPage-1)*pageSize);
		}
	}

	/**
	 * 查询学生表数据的总数量
	 */
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select count(*) from stu";
//		int count = (int) runner.query(sql, new ScalarHandler());
		Long count = (Long) runner.query(sql, new ScalarHandler());
		return count.intValue();
	}

}













