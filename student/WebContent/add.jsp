<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加学生</title>
	<style>
		*{padding: 0; margin: 0;}
		table{border-collapse: collapse;}
		table th{line-height: 30px;}
		table td{line-height: 30px;}
		table td input{height: 25px;}
		table td textarea{line-height: 20px; width: 80%;}
		.noText,label{cursor: pointer;}
		.noText{vertical-align: top; margin-top: 3px; margin-left: 10px;}
	</style>
</head>
<body>
	<h2>添加学生</h2>
	<form action="" method="get">
		<table border="1">
			<tr>
				<th width="100px;">姓名</th>
				<td width="300px;"><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>性别</th>
				<td>
					<input type="radio" name="gender" class="noText" id="male" value="男"><label for="male">男</label>
					<input type="radio" name="gender" class="noText" id="female" value="女"><label for="female">女</label>
				</td>
			</tr>
			<tr>
				<th>电话</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>生日</th>
				<td><input type="text" name="birthday"></td>
			</tr>
			<tr>
				<th>爱好</th>
				<td>
					<input type="checkbox" name="hobby" class="noText" id="swimming" value="游泳">
					<label for="swimming">游泳</label>
					<input type="checkbox" name="hobby" class="noText" id="chess" value="下棋">
					<label for="chess">下棋</label>
					<input type="checkbox" name="hobby" class="noText" id="readBook" value="看书">
					<label for="readBook">看书</label>
					<input type="checkbox" name="hobby" class="noText" id="running" value="跑步">
					<label for="running">跑步</label>
				</td>
			</tr>
			<tr>
				<th>简介</th>
				<td><textarea rows="3"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" width="400px" style="text-align: center;">
					<input type="submit" value="提交">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>













