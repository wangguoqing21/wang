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
<div class="demoTable">
            <div class="layui-inline">
                <input class="layui-input" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>
<table class="layui-hide" id="test" lay-filter="test">
</table>

<script type="text/html" id="titleTpl">
$('table.layui-table thead tr th:eq(0)').addClass('layui-hide');

</script>
<script>

layui.use(
'table',
function() {
var table = layui.table;

table
.render({
elem : '#test',
url : 'index1',
limits: [3,5,10],
limit: 5,//每页默认显示的数量
toolbar : '#toolbarDemo',
cols : [ [

{
field : 'userName',
width : 80,
title : '姓名',


},
{
field : 'sex',
width : 180,
title : '性别',
templet: function(d){
    	  if(d.sex == '1'){ 
    	  return '男'
    	  } else { return '女'}
    	  }},
{
field : 'phone',
width : 180,
title : '手机号'
},
{
field : 'cardType',
width : 180,
title : '证件类型',
templet: function(d){
    	  if(d.cardType == '0'){ 
    	  return '二代身份证'
    	  } else { return '护照'}
    	  }},
    	  {
field : 'isDelete',
width : 80,
title : '状态',
templet: function(d){
    	  if(d.isDelete == '2'){ 
    	  return '未删除'
    	  } else { return '删除'}
    	  }},
{
field : 'pic',
title : '管理操作',
width : 120,
style : 'height:100%;max-width:100%;',
templet : '<div class="layui-btn-group"> <a href="userupdate?id={{d.id}}" class="layui-table-link"><i class="layui-icon layui-icon-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" lay-event="del" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a><div>'
} ] ],
page : true,
done: function (res) {
    //如果是异步请求数据方式，res即为你接口返回的信息。
    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    console.log(res);
}
});
        layui.use(['table', 'layer', 'form'], function ()
        {
            var table = layui.table;
            layer = layui.layer;
            form = layui.form;
            var $ = layui.$, active =
              {
                  reload: function () {
                      var demoReload = $('#demoReload').val();//获取输入框的值
                      //执行重载
                      table.reload('test',
                          {
                              page:
                                  {
                                      curr: 1 //重新从第 1 页开始
                                  }
                        , where: { name: demoReload}//这里传参  向后台
                        , url: 'index1'//后台做模糊搜索接口路径
                        , method: 'post'
                          });
                  }
              };
            //这个是用于创建点击事件的实例
            $('.demoTable .layui-btn').on('click', function ()
            {
                var type = $(this).data('type');
                alert("dgdgdnn");
               layer.alert("121515");
                active[type] ? active[type].call(this) : '';
            });
//监听行工具事件
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
//时间戳的处理
layui.laytpl.toDateString = function(d, format){
  var date = new Date(d || new Date())
  ,ymd = [
    this.digit(date.getFullYear(), 4)
    ,this.digit(date.getMonth() + 1)
    ,this.digit(date.getDate())
  ]
  ,hms = [
    this.digit(date.getHours())
    ,this.digit(date.getMinutes())
    ,this.digit(date.getSeconds())
  ];

  format = format || 'yyyy-MM-dd HH:mm:ss';

  return format.replace(/yyyy/g, ymd[0])
  .replace(/MM/g, ymd[1])
  .replace(/dd/g, ymd[2])
  .replace(/HH/g, hms[0])
  .replace(/mm/g, hms[1])
  .replace(/ss/g, hms[2]);
};
 
//数字前置补零
layui.laytpl.digit = function(num, length, end){
  var str = '';
  num = String(num);
  length = length || 2;
  for(var i = num.length; i < length; i++){
    str += '0';
  }
  return num < Math.pow(10, length) ? str + (num|0) : num;
};
});
});
</script>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">

</script>


</body>
</html>