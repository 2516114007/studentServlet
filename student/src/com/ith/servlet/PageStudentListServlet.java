package com.ith.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ith.domain.PageBean;
import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class PageStudentListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("PageStudentListServlet running...");
		int currentPage = Integer.parseInt(req.getParameter("currentPage"));
		
		StudentService service = new StudentServiceImpl();
		PageBean pagebean = new PageBean<>();
		try {
			pagebean = service.findStudentByPage(currentPage);
		} catch (SQLException e) {
			System.out.println("pageStudentListServlet服务层调用出现异常");
			e.printStackTrace();
		}
		req.setAttribute("pageBean", pagebean);
		req.getRequestDispatcher("").forward(req, resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}