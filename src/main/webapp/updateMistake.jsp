<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店房间管理</title>
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
	<form action="updateMistake" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
		<tr>
		<td>
		<input type="hidden" name="id" value="${id}"/>
		</td>
		</tr>
			<tr>
				<td width="130" align="center">异常类型</td>
				<td align="left" width="500" height="28"><input type="text"
					name="type" value="${mistake.type}" /></td>
			</tr>
			<tr>
				<td width="130" align="center">详情描述</td>
				<td align="left" width="500" height="28"><input type="text"
					name="detail" value="${mistake.detail}" /></td>
			</tr>
			<tr>
				<td width="130" align="center">备注</td>
				<td align="left" width="500" height="28"><input type="text"
					name="remark" value="${mistake.remark}" /></td>
			</tr>
			<tr>
				<td align="center" width="200" height="28" colspan="3"><input
					type="submit" value="修改" /></td>
			</tr>

		</table>
	</form>
	
</body>
<script src="../src/layui.js"></script>
<script>
	//JavaScript代码区域
	layui.use('element', function() {
		var element = layui.element;

	});
</script>
</html>