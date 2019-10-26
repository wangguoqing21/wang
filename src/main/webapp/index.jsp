<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
    <link href="layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="layui/layui.js" ></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">欢迎来 到管理员界面</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item">
        <dl class="layui-nav-child">
          <dd><a href="" target="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          admin
        </a>
        <dl class="layui-nav-child">
      
        </dl>
      </li>
      <li class="layui-nav-item"><a href="malogin.jsp">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;"><i class="layui-icon layui-icon-home">系统管理</i></a>
          <dl class="layui-nav-child">
            <dd><a href="index" target="mainFrame">用户管理</a></dd>
            <dd><a href="Log.jsp" target="mainFrame">日志管理</a></dd>
            <dd><a href="index3" target="mainFrame">酒店人员权限</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon layui-icon-table">房客管理</i></a>
          <dl class="layui-nav-child">
          <dd><a href="fkydglb.jsp" target="mainFrame">房客预定管理</a></dd>
            <dd><a href="ruzhub.jsp" target="mainFrame">预定转入住管理</a></dd>
            <dd><a href="huanfb.jsp" target="mainFrame">换房管理</a></dd>
            <dd><a href="jiezhb.jsp" target="mainFrame">结账管理</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="NewFile.jsp" target="mainFrame"><i class="layui-icon layui-icon-date">客房管理</i></a></li>
    
                <li class="layui-nav-item">

          <a href="javascript:;"><i class="layui-icon layui-icon-friends">基础信息管理</i></a>
          <dl class="layui-nav-child">
            <dd><a href="queryAll1"      target="mainFrame">客房类型管理</a></dd>
            <dd><a href="itemqueryAll1"  target="mainFrame">商品类型管理</a></dd>
            <dd><a href="itemsqueryAll1" target="mainFrame">商品管理</a></dd>
            <dd><a href="sugqueryAll1"   target="mainFrame">建议管理</a></dd>
          </dl>
        </li>
                <li class="layui-nav-item">

          <a href="javascript:;"><i class="layui-icon layui-icon-group">PA(公共区域)管理</i></a>
          <dl class="layui-nav-child">
          
            <dd><a href="abnormal" target="mainFrame">异常情况管理  </a></dd>
            <dd><a href="findNeed" target="mainFrame">客户需求管理  </a></dd>
            <dd><a href="findBuy" target="mainFrame">酒店物品采购</a></dd>
            <dd><a href="abnormal" target="mainFrame">维修管理  </a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
   
    <iframe name="mainFrame" id="mainFrame" 
    	frameborder="0" scrolling="no" style="width: 100%; height: 90%;"></iframe>
  </div>
  
  <div class="layui-footer">
   
  </div>
</div>
<script src="../src/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>
