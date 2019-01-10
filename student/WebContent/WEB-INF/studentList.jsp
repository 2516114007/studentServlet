<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生列表页面</title>
	<style>
		*{padding: 0; margin: 0;}
		table{border-collapse: collapse; margin: 30px 30px;}
		table th{width: 120px; line-height: 30px;}
		table td{width: 120px; line-height: 30px; text-align: center;}
		table caption{border: 1px solid black; border-bottom: none; line-height: 30px;}
	</style>
</head>
<body>
	<table border="1">
		<caption><a href="add.jsp">添加</a></caption>
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电话</th>
				<th>生日</th>
				<th>爱好</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="stu">
				<tr>
					<td>${stu.id }</td>
					<td>${stu.name }</td>
					<td>${stu.gender }</td>
					<td>${stu.phone }</td>
					<td>${stu.birthday }</td>
					<td>${stu.hobby }</td>
					<td>${stu.info }</td>
					<td><a href="#">更新</a> <a href="#">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>