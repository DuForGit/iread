<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<title>个人主页</title>
<style>
#mybooks{
margin-top: 5px;
}
#listhead{
background-color: #34495e;
color:#fff;
}
#navlist{
padding-left: 0px;
}
#name{
color:#fff;
}
/* .clazz{
padding: 20px;
} */
</style>
<script type="text/javascript">
function loadPage(page){
	$("#main").load(page);
}
$(document).ready(function(){
	$("#main").load("${ctp}/myinfos");
});

function F_Open_dialog() 
{ 
    document.getElementById("btn_file").click(); 
} 

</script>
</head>
<body>
<c:import url="top.jsp"/>

<div id="mybooks" class="container main">
	
	<div  class="col-lg-2 col-md-2" id="navlist" >
		<a class="list-group-item" id="listhead" href="${ctp}/my">
		<!-- <form action="/upload" enctype="multipart/form-data" method="post"> -->
			<input type="file" id="btn_file" style="display:none">
			<img src="${ctp}/resources/imgs/user/404.png" class="img-circle" style="width: 100px; margin-bottom: 5px;" onclick="F_Open_dialog()">
		<!-- </form> -->
			<li  id="name">${info.user.name}</li>
		</a>
		<!-- <script type="text/javascript">
			$(document).ready(function(){
					$("#main").load("${ctp}");
			});
		</script> -->
		<a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/myinfos');"><b>个人中心</b></a>
		<a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/mybooks');"><b>我的书架</b></a>
		<a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/mycart');"><b >我的购物车</b></a>
		<a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/myorder');"><b>我的订单</b></a>
		<%-- <a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/news');"><b>消息</b></a> --%>
		<%-- <a style='cursor:pointer'  class='list-group-item clazz' onclick="loadPage('${ctp}/set');"><b>设置</b></a> --%>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#main").load("${ctp}/myinfos");
	});
	</script>
	<div class="col-lg-10 col-md-10" id="main">
		
	</div>
	
</div>


<c:import url="bottom.jsp"/>
</body>
</html>