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
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
 <div style="margin-top:0px"> 
 <script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
<script src="js/jquery-2.0.1.js"></script>
<script type="text/javascript"></script>
<input type="button" onclick="test()" value="添加" />
<table class="layui-hide" id="test" lay-filter="test"></table>
	
	
	<script >
function test(){
 var url = "roomadds.jsp";
 window.location.href= url;
}

</script> 
	<script type="text/html" id="titleTpl"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#test'
    ,url:'list.action'
    ,limits: [3,5,10]
    ,limit: 5 //每页默认显示的数量
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,cols: [[
     	   //{type: 'checkbox', fixed: 'left'},
	       {field:'id', title:'类型序号', width:200,align:'center', fixed: 'left',unresize: true, sort: true}
	      ,{field:'roomCatName', title:'类型名称', width:200,align:'center'}
	      ,{field:'upload', title:'客房图片', width:200,align:'center', templet:function (d) { return '<div><img src='+d.upload+'></div>' 
	      }}
	      ,{field:'price', title:'客房价格', width:200,align:'center'}
	      ,{field:'num', title:'剩余数量', width:200,align:'center'}
	      ,{
				field : 'pic',
				title : '管理操作',
				width : 200,
				align:'center',
				style : 'height:100%;max-width:100%;',
				
				templet : '<div class="layui-btn-group"> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" lay-event="del" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a><div>'
			}
    ]]
    ,page: true
    , done: function (res) {
        //如果是异步请求数据方式，res即为你接口返回的信息。
        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        console.log(res);
    }

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
function openDetial(title, area, path, sucFunName, callBack) {
    layer.open({
        type: 2,
        title: title, //不显示标题栏
        closeBtn: 2,
        area: area,
        shade: 0.8,
        id: (new Date()).valueOf(), //设定一个id，防止重复弹出 时间戳1280977330748
        btn: ['保存', '取消'],
        btnAlign: 'r',
        moveType: 1, //拖拽模式，0或者1
        content: path,
        yes: function (index, layero) {
            var btn = layero.find('.layui-layer-btn').find('.layui-layer-btn0');
            alert("-----");
            try {
                var _ifr = btn[0].parentNode.parentNode.getElementsByClassName("layui-layer-content")[0].children[0].contentWindow ||
                     btn[0].parentNode.parentNode.getElementsByClassName("layui-layer-content")[0].children[0].children[0].contentWindow;
                var func = new Function('_ifr', "return _ifr." + sucFunName + "();");
                var flg = func(_ifr);
                if (flg == false) {
                    return false;
                } else {
                    if (callBack != null) callBack();
                    window.location.reload();
                }
            } catch (ex) {
 
            }
        },
        btn2: function (index, layero) {
        }
    });
}

</script>

<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  
</script>
<style type="text/css"> 
.layui-table-cell{
	height:auto!important;
	white-space:normal;
}
 
</style>
  </div> 


</body>
</html>