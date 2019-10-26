  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="layui/layui.js" ></script>
     <script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
</script>
              
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
	  
    elem: '#test'
    ,url:'sugqueryAll'
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      /* {type:'radio'} */
      {field:'id', width:80, title: '序号'}
      ,{field:'content', width:180, title: '建议内容'}
      ,{field:'createTime', width:180, title: '时间',
    	  templet:function(d){
              var date =new Date(d.createTime);
                  return dateFmt("yyyy-MM-dd",date);
                   	  }}
      ,{field:'userName', width:180, title: '建议人',templet: function(s){

		  return s.userId.userName;
		  
	      }},
      
    ]]
    ,page: true
  });
});
</script>
</body>
</html> 