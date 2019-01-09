package com.ith.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password= null;
	
	static{
		try {
			//1. 创建�?个属性配置对�?
			Properties properties = new Properties();
			InputStream is = new FileInputStream("jdbc.properties");
			
			//使用类加载器，去读取src底下的资源文件�?? 后面在servlet
//			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//导入输入流�??
			properties.load(is);
			
			//读取属�??
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);
			//静�?�代码块 ---> 类加载了，就执行�? java.sql.DriverManager.registerDriver(new Driver());
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			//2. 建立连接 参数�?�? 协议 + 访问的数据库 �? 参数二： 用户�? �? 参数三： 密码�?
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , Statement st){
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
