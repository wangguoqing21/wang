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
<table class="layui-hide" id="test" lay-filter="test">
</table>

<script type="text/html" id="titleTpl">
$('table.layui-table thead tr th:eq(0)').addClass('layui-hide');
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
 
  table.render({
	        elem: '#test'
		    ,url:'room'
		    ,limits: [3,5,10]
		    ,limit: 5 //每页默认显示的数量
		    ,toolbar: '#toolbarDemo'
	  ,cols: [[
	  {field:'id', width:80, title: 'ID', sort: true}
      ,{field:'roomName', width:150, title: '房间号'}
      ,{field:'remark', width:150, title: '房间描述'}
      ,{field:'image', width:200,title:'图片',align:'center', templet:function (d) { return '<div><img src='+d.image+'></div>'}}
/*       ,{field:'roomCatName', width:150, title: '房间分类' ,
    	  templet: function(d){

		  return d.room_cat;
		  
	      }}  */
      ,{field:'isLive', width:180, title: '房间状态',templet: function(d){
    	  if(d.isLive == '1'){return '无人预定（空房）'}
    	    else if(d.isLive == '2'){ return '已预定'}
    		    else if(d.isLive == '3'){ return '已入住'}
    		    else if(d.isLive == '4'){ return '故障'}
    		    else if(d.isLive == '5'){ return '已结账'}
    		    else{return '请输入数字1-5'}
    		  }}
      ,{field:'floor', width:150, title: '楼层'}
      ,{field:'isClean', width:150, title: '是否需要打扫',templet: function(d){
    	  if(d.isClean == '0'){ 
        	  return '不需要'
        	  } else { return '需要'}
        	  }}
      ,{
    	  field : 'pic',
    	  title : '管理操作',
    	  width : 120,
    	  style : 'height:100%;max-width:100%;',
    	  templet : '<div class="layui-btn-group"> <a href="findRoomById?id={{d.id}}" class="layui-table-link"><i class="layui-icon layui-icon-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" lay-event="del" class="layui-table-link"><i class="layui-icon layui-icon-delete"></i></a><div>'
    	  } ] ],
    	  page : true,
    	  done: function (res) {
    	      //如果是异步请求数据方式，res即为你接口返回的信息。
    	      //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    	      console.log(res);
    	  }
    	  });
    //头工具栏事件
    table.on('toolbar(test)', function(obj){
      var checkStatus = table.checkStatus(obj.config.id);
      switch(obj.event){
        case 'getCheckData':
          var data = checkStatus.data;
          layer.alert(JSON.stringify(data));
        break;
        case 'getCheckLength':
          var data = checkStatus.data;
          layer.msg('选中了：'+ data.length + ' 个');
        break;
        case 'isAll':
          layer.msg(checkStatus.isAll ? '全选': '未全选');
        break;
      };
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
   </div>
  <table class="layui-hide" id="test" lay-filter="test"></table>
  <script type="text/html" id="toolbarDemo">
    
  </script>
  <style type="text/css"> 
.layui-table-cell{
	height:auto!important;
	white-space:normal;
}
 
</style>
  </body>
  </html>
