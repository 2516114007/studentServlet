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

public class SearchStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SearchStudentServlet running...");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		StudentService service = new StudentServiceImpl();
		List<Student> list = null;
		try {
			list = service.searchStudent(name, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("/WEB-INF/studentList.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}