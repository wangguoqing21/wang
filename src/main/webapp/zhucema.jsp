<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>

</head>
<body style="background: #00FFFF;">
<div style="width: 330px;height: 590px;background: black;margin: 80px auto;">
<p style="padding-top: 30px;padding-left: 20px;color: white;">管理员注册</p>
<form class="layui-form"  method="post" style="margin-top:20px;background:; ">
  <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">管理员名</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.name" required  lay-verify="required" placeholder="请输入管理员名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">密码</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.passWord" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">性别</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.sex" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
    </div>
  </div>
     <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">联系电话</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.phone" required  lay-verify="required" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">证件号</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.idCard" required  lay-verify="required" placeholder="请输入证件号" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">管理类型</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.type" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    </div>
     <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">是否删除</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.isDelete" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    </div>
     <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.email" required  lay-verify="required" placeholder="请输入邮箱号" autocomplete="off" class="layui-input">
    </div>
    </div>
     <div class="layui-form-item">
    <label class="layui-form-label" style="color: white;">时间</label>
    <div class="layui-input-inline">
      <input type="text" name="manage.createTime" required  lay-verify="required" placeholder="请输入时间" autocomplete="off" class="layui-input">
    </div>
  </div>
   
    <a href="malogin.jsp" class="layui-btn layui-btn-radius layui-btn-normal" style="margin-left: 100px;">注册</a><input type="submit" value="重置" class="layui-btn layui-btn-primary">
    </form>
    </div> 

</body>
</html>