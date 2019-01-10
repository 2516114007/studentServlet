package com.ith.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ith.domain.Student;
import com.ith.service.StudentService;
import com.ith.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取表单提交的数据
		String name = req.getParameter("gender");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String birthday = req.getParameter("birthday");
		String hobby = req.getParameter("hobby");
		String info = req.getParameter("info");
		
		//添加到数据库
		//Date date;
		StudentService service;
		try {
			//date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(name, gender, phone, birthday, hobby, info);
			service = new StudentServiceImpl();
			service.insert(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("studentListServlet");
		//req.getRequestDispatcher("studentListServlet").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}















