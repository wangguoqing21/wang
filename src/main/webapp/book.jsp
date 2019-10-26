<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户预约</title>
<script type="text/javascript"> 
	/* 获取楼层 */
    var roomInfo = new Array();
    <c:forEach items="${rooms }"  var="room">
	<c:if test="${room.isClean==0}">
	roomInfo.push(['${room.tid }','${room.troomcat.roomCatName }','${room.troomcat.price }','${room.floor }','${room.roomName }']);
	</c:if>
	</c:forEach>
	info(document.getElementById("roomCatName"));
	function info(obj) {
		if(obj.value == -1) {
            return
        }
		var tid = obj.value;
		var index = -1;
		for (var i = 0; i < roomInfo.length; i++) {
			if (roomInfo[i][0] == tid) {
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
<body>
	<div align="center">
		<form action="book" method="post">
		<table>
			<tr>
				<td align="right">请选择房间类型:</td>
				<td>
					<select name="tid" onchange="info(this)">
						<option>请选择房间类型</option>
						<!-- 筛选出清理过的房间，并将房间显示出了 -->
						<c:forEach items="${rooms }"  var="room">
						<c:if test="${room.isClean==0}">
						<option value="${room.tid }">${room.troomcat.price }元,${room.troomcat.roomCatName }</option>
						</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">房型:</td>
				<td id="roomCatName">请选择房间类型</td>
			</tr>
			<tr>
				<td align="right">价钱:</td>
				<td id=price>请选择房间类型</td>
			</tr>
			<tr>
				<td align="right">楼层:</td>
				<td id="floor">请选择房间类型</td>
			</tr>
			<tr>
				<td align="right">房号:</td>
				<td id="roomName">请选择房间类型</td>
			</tr>
			<tr>
				<td align="right">预约到达时间：</td>
				<td>
					<input type="date" name="reachTime" value="${date }" />
				</td>
			</tr>
			<tr>
				<td align="right">预约天数：</td>
				<td>
					<select name="bookDays">
						<c:forEach begin="1" end="31" var="i">
						<option value="${i }">${i }天</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="预约" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>