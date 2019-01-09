package com.ith.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ith.domain.Student;
import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class StudentListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentListServlet running...");
		StudentService service = new StudentServiceImpl();
		List<Student> list = null;
		try {
			list = service.findAll();
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("/WEB-INF/studentList.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}