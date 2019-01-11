package com.ith.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.ith.domain.Student;
import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("UpdateStudentServlet running...");
		//获取表单提交的数据
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String birthday = req.getParameter("birthday");
		//String hobby = req.getParameter("hobby");
		
		String[] h = req.getParameterValues("hobby");
		String hobby = Arrays.toString(h);
		hobby = hobby.substring(1, hobby.length()-1);
		
		String info = req.getParameter("info");
		
		Student student = new Student(id, name, gender, phone, birthday, hobby, info);
		StudentService service = new StudentServiceImpl();
		try {
			service.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("studentListServlet");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}






