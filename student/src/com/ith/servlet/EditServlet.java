package com.ith.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ith.domain.Student;
import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class EditServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EditServlet running...");
		int id = Integer.parseInt(req.getParameter("id"));
		StudentService service = new StudentServiceImpl();
		Student studentById = null;
		try {
			studentById = service.findStudentById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("stu", studentById);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}