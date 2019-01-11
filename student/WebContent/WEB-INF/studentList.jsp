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
		table{border-collapse: collapse; margin: 30px 30px;table-layout:fixed; width: 840px;}
		table th{width: 120px; line-height: 30px;}
		table td{width: 120px; line-height: 30px; text-align: center; overflow: hidden;white-space: nowrap;text-overflow: ellipsis;padding: 0 10px;}
		table caption{border: 1px solid black; border-bottom: none; line-height: 30px;}
		caption input{width: 120px; height: 21px;}
	</style>
</head>
<body>
	<table border="1">
		<caption>
			<form method="post" action="/student/searchStudentServlet">
				<span>按姓名查询：</span>
				<input type="text" name="name" placeholder="请输入姓名">
				<span>按性别查询：</span>
				<select name="gender">
					<option value="" style="display: none;">--请选择性别--</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
				<input type="submit" value="查询">
			</form>
			<a href="add.jsp">添加</a>
		</caption>
		<thead>
			<tr>
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
					<td title="${stu.name }">${stu.name }</td>
					<td title="${stu.gender }">${stu.gender }</td>
					<td title="${stu.phone }">${stu.phone }</td>
					<td title="${stu.birthday }">${stu.birthday }</td>
					<td title="${stu.hobby }">${stu.hobby }</td>
					<td title="${stu.info }">${stu.info }</td>
					<td><a href="/student/editServlet?id=${stu.id }">修改</a> <a href="#" onclick="deleteData(${stu.id })">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function deleteData(id){
			var flag = confirm("是否确定删除？");
			if(flag){
				window.location.href = "/student/deleteServlet?id="+id;
			}
		}
	</script>
</body>
</html>