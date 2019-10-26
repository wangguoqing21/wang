<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.js" ></script>
<script src="js/jquery-2.0.1.js"></script>
<script type="text/javascript">
			$(function(){
				$('#roomName').change(function(){
					var roomName = $('#roomName').val();
					 $.ajax({
						type : 'POST',
						url : 'chackhf',
						data : {
							'roomName' : roomName,							
						},					
						dataType : 'JSON',
						success : function(data){
							if(data=='success'){
								$('#span').text('该房间已有房客,请更换房间');
								$('#roomName').val('');
							}else{
								$('#span').text('');
							}
						}
					}); 
				});
				$('#roomName').focus(function(){
					$('#sp').text('请输入1001~1030房间号');
				});
				$('#roomName').blur(function(){
					$('#sp').text('');
				});
			})
			
	</script>
</head>
<body>
<form action="updatehf" method="post" style="width: 700px;height: 500px;">
<p style="margin-left: 100px;font-size: 25px;">客户换房</p>
<input type="hidden" name="book.id" value="${book.id }">
<input type="hidden" name="book.status" value="${book.status }">
<label style="margin-top: 10px;margin-left: 10px;">客户姓名:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;" type="text" name="book.bookUser.userName" value="${book.bookUser.userName }"><br/>
<label style="margin-top: 10px;margin-left: 10px;">联系电话:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;"  type="text" name="book.bookUser.phone" value="${book.bookUser.phone }"><br/>
<label style="margin-top: 10px;margin-left: 10px;">证件号码:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;"  type="text" name="book.bookUser.idCard" value="${book.bookUser.idCard }"><br/>
<label style="margin-top: 10px;margin-left: 10px;">房间号码:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;"  type="text" id="roomName" name="book.room.roomName" value="${book.room.roomName }"><span id="sp" style="color: green;margin-left: 15px;font-size: 17px;"></span><br/>
<span id="span" style="color: red;margin-left: 100px;"></span><br/>
<label style="margin-top: 10px;margin-left: 10px;">入住时间:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;"  type="text" name="book.bookTime" value="${book.bookTime }"><br/>
<label style="margin-top: 10px;margin-left: 10px;">离店时间:</label>
<input style="margin-top: 20px;width: 200px;height: 30px;margin-left: 15px;"  type="text" name="book.leaveTime" value="${book.leaveTime }"><br/>
<input style="margin-top: 10px;margin-left: 100px;" type="submit" value="确认换房" class="layui-btn"><br/>
</form>
</body>
</html>