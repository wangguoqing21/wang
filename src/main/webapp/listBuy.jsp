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
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>


	<script>
		layui
				.use(
						'table',
						function() {
							var table = layui.table;

							table
									.render({
										elem : '#test',
										url : 'toFindBuy',
										toolbar : '#toolbarDemo',
										cols : [ [
												/* {type:'radio'} */
												{
													field : 'id',
													width : 80,
													title : 'ID',
													sort : true
												},
												{
													field : 'name',
													width : 180,
													title : '物品名称'
												},
												{
													field : 'price',
													width : 180,
													title : '物品价格',
												},
												{
													field : 'num',
													width : 180,
													title : '物品数量'
												},
												{
													field : 'remark',
													width : 180,
													title : '备注'
												},
												{
													field : 'pic',
													title : '管理操作',
													width : 80,
													style : 'height:100%;max-width:100%;',
													templet : '<div><a href="dropBuyById?id={{d.id}}" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a></div>'
												} ] ],
										page : true
									});

							//头工具栏事件
							/*  table.on('toolbar(test)', function(obj){
							   var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
							   switch(obj.event){
							     case 'getCheckData':
							       var data = checkStatus.data;  //获取选中行数据
							       layer.alert(JSON.stringify(data));
							     break;
							   };
							 }); */
						});
	</script>

</body>
</html>