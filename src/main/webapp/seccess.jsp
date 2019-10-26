<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/echarts.js"></script>
<script type="text/javascript" src="../js/bar.js"></script>
<script type="text/javascript" src="../js/line.js"></script>  
<div id="main1" style="height:400px"></div>
<button type="button" id="button1">显示/隐藏</button>
<script type="text/javascript">
$(function() {
$("#button1").click(function() {
$("#main1").slideToggle(999);
});
});

var a1=eval(${json});

        // 路径配置  
        require.config({  
        
            paths : {  
                'echarts' : '../js',  
                'echarts/chart/bar' : '../js' ,
                'echarts/chart/line' : '../js'  
            }  
        });  
  
        // 使用  
        require([ 'echarts', 'echarts/chart/bar', 'echarts/chart/line' // 使用柱状图就加载bar模块和折线图，按需加载  
        ], function(ec) {  
            // 基于准备好的dom，初始化echarts图表  
            var myChart = ec.init(document.getElementById('main1'));  
  
            var option = {  
                title : {  
                    text : '统计图表',  
                    subtext : '选择总数'  
                },  
                tooltip : {  
                    trigger : 'axis'  
                },  
                  
                toolbox : {  
                    show : true,  
                    feature : {  
                        mark : {  
                            show : true  
                        },  
                        dataView : {  
                            show : true,  
                            readOnly : false  
                        },  
                        magicType : {  
                            show : true,  
                            type : [ 'line', 'bar' ]  
                        },  
                        restore : {  
                            show : true  
                        },  
                        saveAsImage : {  
                            show : true  
                        }  
                    }  
                },  
                calculable : true,  
                xAxis : [ {  
                    type : 'category',  
                    data :function (){
var arr=[]; 
for(var i=0;i<a1.length;i++){
console.log(a1[i].context);
arr.push(a1[i].optionName);
} 
return arr;
}()
}], 


                yAxis : [ {  
                    type : 'value'  
                } ],  
                series : [ {  
                    
                    type : 'line',  
                    data : function (){
var arr=[]; 
for(var i=0;i<a1.length;i++){
console.log(a1[i].context);
arr.push(a1[i].opcount);
} 
return arr;
}()
}], 
                     
                   
               
            };  
  
            // 为echarts对象加载数据   
          myChart.setOption(option); 
        });        
</script>
</body>
</html>