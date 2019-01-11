package com.ith.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DeleteServlet running...");
		int id = Integer.parseInt(req.getParameter("id"));
		StudentService service = new StudentServiceImpl();
		try {
			service.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("studentListServlet");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}