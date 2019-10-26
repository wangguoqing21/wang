<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <link href="layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="layui/layui.js" ></script>
</head>
<body>
 <div class="layui-progress">
  <div class="layui-progress-bar" lay-percent="100%"></div>
</div>
 
<script>
//注意进度条依赖 element 模块，否则无法进行正常渲染和功能性操作
layui.use('element', function(){
  var element = layui.element;
});
</script>
<div style="height: 100px;text-align: center;font-size: 30px; color: #4476A7">
	<span>管理员修改页面</span>
</div>
<form class="layui-form" action="updatemarage1" style="margin-left: 500px;">

<div class="layui-form-item">
    <label class="layui-form-label">编号：</label>
    <div class="layui-input-inline">
      <input type="text" name="id" class="layui-input" value="${marage.id}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名：</label>
    <div class="layui-input-inline">
      <input type="text" name="name" class="layui-input" value="${marage.name}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">性别：</label>
    <div class="layui-input-block">
      <input name="sex" title="男" type="radio" checked="checked" value="1">
      <input name="sex" title="女" type="radio" value="2">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">手机号：</label>
    <div class="layui-input-inline">
      <input type="text" name="phone" class="layui-input" value="${marage.phone}">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label">证件号码：</label>
    <div class="layui-input-inline">
      <input type="text" name="idCard" class="layui-input" value="${marage.idCard}">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label">角色：</label>
    <div class="layui-input-inline">
      <select name="isDelete" lay-filter="aihao">
        <option value="0">超级管理员</option>
        <option value="1" selected="">普通管理员</option>
      </select>
    </div>
  </div>
      <div class="layui-form-item">
    <label class="layui-form-label">状态：</label>
    <div class="layui-input-inline">
      <select name="type" lay-filter="aihao">
        <option value="0">删除</option>
        <option value="1" selected="selected">未删除</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>

</body>
</html> 