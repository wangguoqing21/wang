<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="layui/css/layui.css"  media="all">
   <script type="text/javascript" src="layui/layui.js"></script>
   <script type="text/javascript" src="js/main.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="js/jquery-2.0.1.js"></script>
     <style type="text/css">
  .layui-table-cell{
      display:table-cell;
      vertical-align: middle;
    }
    </style>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
  </div>
</script>
              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'listfz.action'
    ,limits: [3,5,10]
  	,limit: 5
    ,toolbar: '#toolbarDemo'
    ,title: '用户预定表'
    ,cols: [[
    	{field:'userName', width:80, title: '客户名', edit: 'text',
      	  templet:function(d){
      		  return d.bookUser.userName;
      	  }},
      	{field:'phone', width:150, title: '联系电话', edit: 'text',
        	  templet:function(d){
        		  return d.bookUser.phone;
        	  }},
        {field:'idCard', width:150, title: '证件号码', edit: 'text',
            	  templet:function(d){
            		  return d.bookUser.idCard;
            	  }},
         {field:'roomName', width:150, title: '房间号', edit: 'text',
                	  templet:function(d){
                		  return d.room.roomName;
                	  }},
      ,{field:'bookTime', width:100, title: '入住时间', edit: 'text',
            templet:function(d){
               var date =new Date(d.bookTime);
                   return dateFmt("yyyy-MM-dd",date);
                    	  }}
      ,{field:'leaveTime', width:110, title: '离店时间', edit: 'text',
    	  templet:function(d){
              var date =new Date(d.leaveTime);
                  return dateFmt("yyyy-MM-dd",date);
                   	  }}
      ,{field:'status', width:100, title: '状态', edit: 'text',
    	  templet:function(d){
    		  return '已预定';
    	  }},
    	  {
				field : 'pic',
				title : '管理操作',
				width : 140,
				style : 'height:100%;max-width:100%;',
				templet : '<div class="layui-btn-group"> &nbsp;&nbsp;&nbsp;&nbsp;<a href="updaterz?id={{d.id}}" class="layui-btn">转入住</a><div>'
				
			}
    ]]
    ,page: true
  });

});
</script>

</body>
</html>