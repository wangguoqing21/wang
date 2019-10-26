<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<title>Single</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="text/javascript">
	if('${error }'!='') {
		alert('${error }');
	}
</script>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- //for-mobile-apps -->
<link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="assets/fonts/law-icons/font/flaticon.css">
<link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/slick-theme.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/landing-2.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"> 
	/* 获取楼层 */
    var roomInfo = new Array();
    <c:forEach items="${rooms }"  var="room">
	<c:if test="${room.isClean==0}">
	roomInfo.push(['${room.id }','${room.room_cat.roomCatName }','${room.room_cat.price }','${room.floor }','${room.roomName }']);
	</c:if>
	</c:forEach>
	info(document.getElementById("roomCatName"));
	function info(obj) {
		if(obj.value == -1) {
            return
        }
		var id = obj.value;
		var index = -1;
		for (var i = 0; i < roomInfo.length; i++) {
			if (roomInfo[i][0] == id) {
				index = i;
				break;
			}
		}
		document.getElementById("roomCatName").innerHTML = roomInfo[index][1];
		document.getElementById("price").innerHTML = roomInfo[index][2]+'元';
		document.getElementById("floor").innerHTML = roomInfo[index][3]+'层';
		document.getElementById("roomName").innerHTML = roomInfo[index][4]+'号';
	}
</script>
</head>
<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

<section class="pb_cover_v3 overflow-hidden cover-bg-indigo cover-bg-opacity text-left pb_gradient_v1 pb_slant-light" id="section-home">
  <div class="container">
	<div class="row align-items-center justify-content-center">
	  <div class="col-md-5 relative align-self-center">
		
		<form class="bg-white rounded pb_form_v1" 
		action='
		<c:if test="${userInfo == null }">login.html</c:if>
		<c:if test="${userInfo != null }">BookSuccess.jsp</c:if>
		'>
		  <h2 class="mb-4 mt-0 text-center">预订房间</h2>
		  <div class="form-group form-inline">
		  	<label for="name" class="">请选择房间类型：</label>
			 <select class="form-control pb_height-50 reverse" name="id" onchange="info(this)">
				<option value="" selected>请选择房间类型</option>
				<!-- 筛选出清理过的房间，并将房间显示出了 -->
				<c:forEach items="${rooms }"  var="room">
				<c:if test="${room.isClean==0}">
				<option value="${room.id }">${room.room_cat.price }元,${room.room_cat.roomCatName }</option>
				</c:if>
				</c:forEach>
			  </select>
		  </div>
		  <div class="form-group form-inline">
		  	<label for="roomCatName" class="">房型：</label>
		  	<label id="roomCatName">请选择房间类型</label>
		  </div>
		  <div class="form-group form-inline">
		  	<label for="price" class="">价格：</label>
		  	<label id="price" class="">请选择房间类型</label>
		  </div>
		  <div class="form-group form-inline">
		  	<label for="floor" class="">楼层：</label>
		  	<label id="floor" class="">请选择房间类型</label>
		  </div>
		  <div class="form-group form-inline">
		  	<label for="roomName" class="">房号：</label>
		  	<label id="roomName">请选择房间类型</label>
		  </div>
		  <div class="form-group form-inline">
		  	<label for="name" class="">预约天数：</label>
		  	<select name="bookDays" class="form-control pb_height-50 reverse">
						<c:forEach begin="1" end="31" var="i">
						<option value="${i }">${i }天</option>
						</c:forEach>
			</select>
		  </div>
		  <div class="form-group form-inline" >
		  	<label for="name" class="">预约到达时间：</label>
		  	<input type="date" class="form-control pb_height-50 reverse" placeholder="Email" name="reachTime" value="${date }">
		  </div>
		  <div class="form-group">
				<input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="预约">
		  </div>
		</form>

	  </div> 
	</div>
  </div>
</section>
<script>
		$(document).ready(function() {
			$(".dropdown").hover(function() {
				$('.dropdown-menu', this).stop(true, true).slideDown("fast");
				$(this).toggleClass('open');
			}, function() {
				$('.dropdown-menu', this).stop(true, true).slideUp("fast");
				$(this).toggleClass('open');
			});
		});
</script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>