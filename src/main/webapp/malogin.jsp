<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<script src="js/jquery-2.0.1.js"></script>
<script type="text/javascript">
		$(function(){
			$('#name').change(function(){
				var name = $('#name').val();
				 $.ajax({
					type : 'POST',
					url : 'checkname',
					data : {
						'name' : name,							
					},					
					dataType : 'JSON',
					success : function(data){
						if(data=='success'){
							$('span').text('该管理员不存在');
							
						}else{
							$('span').text('');
						}
					}
				}); 
			});
			
		});
</script>

</head>
<body style="background: #00FFFF;">
<div style="width: 330px;height: 370px;background: black;margin: 150px auto;">
<p style="padding-top: 70px;padding-left: 20px;color: white;">管理员登录</p>
<form class="layui-form"  method="post" style="margin-top:20px;background:; ">
  <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">用户名</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.name" id="name" required  lay-verify="required" placeholder="请输入管理员名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="manage.passWord" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>

    </div>
        <span style="color: red;margin-left: 100px;"></span>
    <a href="index.jsp" class="layui-btn layui-btn-radius layui-btn-normal" style="margin:15px 30px;width: 270px">登录</a>
    <a href="zhucema.jsp" class="layui-btn layui-btn-radius layui-btn-normal" style="margin:15px 30px;width: 270px">注册</a>
    </form>
    </div> 
</body>
</html>