<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body id="home">

<form action="FileUpload2" enctype="multipart/form-data" method="post" > 
		<table align="center">
			<tr>
				<td>客房类型：</td>
				<td><input type="text" name="roomCatName"  class="form-control" placeholder="客房类型" required autofocus/></td>
			</tr>
			<tr>
				<td>客房价格：</td>
				<td><input type="text" name="price"  class="form-control" placeholder="客房价格" required autofocus/></td>
			</tr>
			<tr>
				<td>剩余数量：</td>
				<td><input type="text" name="num"  class="form-control" placeholder="剩余数量" required autofocus/></td>
			</tr>
			
			<!-- 图片不知道怎么获取 -->
			<tr>
				<td>客房图片：</td>
				<td><input type="file" name="upload" ></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="保存" class="btn btn-lg btn-primary btn-block" width="50px"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>