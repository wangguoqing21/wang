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
				width : 120,
				style : 'height:100%;max-width:100%;',
				toolbar: '#barDemo'
				
			}
    ]]
    ,page: true
  });
 table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('确定取消预定吗?', function(index){
    	  $.ajax({
              url:'deletetbook',
              type:'get',
              data:{'id':data.id},//向服务端发送删除的id
              success:function(msg){
                  if(msg!=200){
                      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                      layer.close(index);
                      console.log(index);
                      layer.msg("操作成功",{icon:1});
                  }
                  else{
                      layer.msg("操作失败",{icon:5});
                  }
              }
          });
      });
    } else if(obj.event === 'edit'){
    	 layer.open({  
				type: 2 //此处以iframe举例
					,
				title: '修改信息',
				area: ['600px', '550px'],
				shade: 0,
				maxmin: true,
				content:'ddupdate.jsp',
				success: function(layero, index){
		         var iframe = window['layui-layer-iframe'+index];
		         //调用子页面的全局函数
		         iframe.child(JSON.stringify(data))
		         },
			    end:function(){
			    	layui.table.reload('test');//刷新表格
			    	//location.reload();//弹出层结束后，刷新主页面
			    	layer.msg("修改成功",{icon:1});
	            }
			});
    }
  });

});
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">取消预订</a>
</script>
</body>
</html>