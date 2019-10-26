<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店房间管理</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" width="200" height="28">房间号</td>
			<td align="left" width="200" height="28">房间类别</td>
			<td align="left" width="200" height="28">用户名</td>
			<td align="left" width="200" height="28">是否需要打扫卫生</td>
			<td align="left" width="200" height="28">备注</td>
		</tr>
		<c:forEach items="${pagers}" var="page">

			<tr>
				<td height="28">${page.room.roomName}</td>
				<td height="28">${page.room.room_cat.roomCatName}</td>
				<td height="28">${page.user.userName}</td>
				<td height="28"><c:if test="${page.room.isClean eq '0'}" >不需要打扫</c:if> 
				<c:if test="${page.room.isClean eq '1'}" >需要打扫</c:if> 
						</td>
				<td height="25"></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>