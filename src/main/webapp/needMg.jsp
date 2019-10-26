<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="layui/css/layui.css" rel="stylesheet">
<link rel="stylesheet" href="css/animate.css" />
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<div class="animated bounceInRight">

	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="toolbarDemo">
  <div class="">
    <div class="">PA(公共区域)管理>客户需求管理</div>
  </div>
</script>
	<script type="text/html" id="titleTpl">
$('table.layui-table thead tr th:eq(0)').addClass('layui-hide');
</script>
	<script>
		layui
				.use(
						'table',
						function() {
							var table = layui.table;

							table
									.render({
										elem : '#test',
										url : 'toFindNeed',
										toolbar : '#toolbarDemo',
										cols : [ [
												
												{
													field : 'id',
													width : 80,
													title : 'ID',
													
													
												},
												{
													field : 'type',
													width : 180,
													title : '需求类型'
												},
												{
													field : 'detail',
													width : 180,
													title : '具体情况'
												},
												{
													field : 'remark',
													width : 180,
													title : '备注'
												},
												{
													field : 'pic',
													title : '管理操作',
													width : 120,
													style : 'height:100%;max-width:100%;',
													templet : '<div class="layui-btn-group"> <a href="findNeedById?id={{d.id}}" class="layui-table-link"><i class="layui-icon layui-icon-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="dropNeedById?id={{d.id}}" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a><div>'
												} ] ],
										page : true
									});

							//头工具栏事件

							table.on('toolbar(test)', function(obj) {
								var checkStatus = table
										.checkStatus(obj.config.id); //获取选中行状态
								switch (obj.event) {
								case 'getCheckData':
									var data = checkStatus.data; //获取选中行数据
									layer.alert(JSON.stringify(data));
									break;
								
								}
								;
							});
						});
		
		
	</script>
</div>
</body>
</html>