<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<span>房屋修改页面</span>
</div>
<form class="layui-form" action="updateRoom" style="margin-left: 500px;"method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">房间ID：</label>
    <div class="layui-input-inline">
      <input type="text" name="id" class="layui-input" value="${room.id}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">房间号：</label>
    <div class="layui-input-inline">
      <input type="text" name="roomName" class="layui-input" value="${room.roomName}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">房间描述	：</label>
    <div class="layui-input-inline">
      <input type="text" name="remark" class="layui-input" value="${room.remark}">
    </div>
  </div>
<%--       <div class="layui-form-item">
    <label class="layui-form-label">房间状态：</label>
    <div class="layui-input-inline">
      <input type="text" name="isLive" class="layui-input" value="${room.isLive}">
    </div>
  </div> --%>
     <div class="layui-form-item">
    <label class="layui-form-label">房间状态：</label>
    <div class="layui-input-inline">
      <select name="isLive" lay-filter="aihao">
        <option value="1">无人预定（空房）</option>
        <option value="2" selected="">已预定</option>
                <option value="3">已入住</option>
                        <option value="4">故障</option>
         <option value="5">已结账</option>
      </select>
    </div>
  </div>
<%--     <div class="layui-form-item">
    <label class="layui-form-label">是否需要打扫：</label>
    <div class="layui-input-inline">
      <input type="text" name="isClean" class="layui-input"value="${room.isClean}">
    </div>
  </div> --%>
   <div class="layui-form-item">
    <label class="layui-form-label">是否需要打扫</label>
    <div class="layui-input-inline">
      <select name="isClean" lay-filter="aihao">
        <option value="0">不需要</option>
        <option value="1" selected="">需要</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" onclick="submitSex()" >立即提交</button>
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