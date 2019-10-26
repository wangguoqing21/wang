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
    ,url:'itemsqueryAll'
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      /* {type:'radio'} */
      {field:'itemName', width:200,align:'center', title: '商品名称'}
      ,{field:'image', width:200,align:'center', title: '商品图片',align: "center", templet:function (d) { return '<div><img src='+d.image+'></div>'}}
      ,{field:'remark', width:200,align:'center', title: '商品描述'}
      ,{field:'cname', width:200,align:'center', title: '商品类别',templet: function(d){

		  return d.item_cat.cname;
		  
	      }},
      ,{field:'price', width:200,align:'center', title: '商品价格',templet: function(d){

		  return d.item_cat.price;
		  
	      }},
	      {
				field : 'pic',
				title : '管理操作',
				width : 200,
				align:'center',
				templet : '<div class="layui-btn-group"> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" lay-event="del" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a><div>'
			}
    ]]
    ,page: true
  });

//监听行工具事件
table.on('tool(test)', function(obj){
           var data = obj.data;
           if(obj.event === 'del'){
             layer.confirm('真的删除行么', function(index){
               obj.del();
               layer.close(index);
             });
           } 
         });
});
</script>

<style type="text/css"> 
.layui-table-cell{
	height:auto!important;
	white-space:normal;
}
 
</style>
</body>
</html> 