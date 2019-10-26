<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addmanage" method="post">
用户名:<input type="text" name="manage.name">
密码:<input type="text" name="manage.passWord">
性别:<input type="text" name="manage.sex">
联系电话:<input type="text" name="manage.phone">
证件号:<input type="text" name="manage.idCard">
管理类型<input type="text" name="manage.type">
是否删除<input type="text" name="manage.isDelete">
邮箱:<input type="text" name="manage.email">
时间:<input type="text" name="manage.createTime">
<input type="submit" value="注册">
</form>
</body>
</html>