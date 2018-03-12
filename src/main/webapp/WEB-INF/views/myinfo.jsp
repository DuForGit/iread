<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
    <c:set var="user" value="${info.user}"/>
    <c:set var="in" value="${info.user.infos}"/>
    <c:set var="books" value="${info.books }"/>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的信息</title>
<style>
#user,#read{
background-color: #34495e;
color:#fff;
}
</style>
<script type="text/javascript">
function changeMyInfo(){
	var uid = ${user.id};
	var inck = document.getElementById("inck").innerText;
	var gen = document.getElementById("gen").innerText;
	var about = document.getElementById("me").innerText; 
	$.post("${ctp}/reset",{id:uid,nickName:inck,gender:gen,aboutMe:about});
}


/* $(document).ready(function(){
	$("#")
}); */
</script>
</head>
<body>
<div class="panel panel-default">
   <div class="panel-heading" id="user">
     <h3 class="panel-title" style="font-weight: bold;">基本信息</h3>
   </div>
	<%-- <div class="panel-body" style="text-align: center;">
    <img width="150" alt="" src="${ctp}/resources/imgs/user/${in.imageUri}" >
   </div> --%>
  <table class="table">
<!--    <th>产品</th><th>价格 </th> -->
    <tr>
    <td style="font-weight: bold;">用户名</td><td>${user.name}</td>
    <td style="font-weight: bold;">昵称</td>
    <td class="input" contenteditable="true"  id="inck" onblur="changeMyInfo();">
    <c:if test="${not empty in.nickName }">${in.nickName }</c:if>
    <c:if test="${empty in.nickName }">昵称</c:if>
    </td>
    </tr>
    <tr>
    <td style="font-weight: bold;">性别</td>
    <td class="input" contenteditable="true" id="gen" onblur="changeMyInfo();">
    <c:if test="${not empty in.gender }">${in.gender }</c:if>
    <c:if test="${empty in.gender }">性別</c:if>
    </td>
    <td style="font-weight: bold;">注册邮箱</td><td>${user.email }</td>
    </tr>
    <tr>
    <td style="font-weight: bold;">about me：</td>
    <td class="input" contenteditable="true" id="me" onblur="changeMyInfo();">
    <c:if test="${not empty in.aboutMe }">${in.aboutMe }</c:if>   
    <c:if test="${empty in.aboutMe }">点击此处，一句话介绍你自己</c:if>   
    </td>
    <td></td>
    <td></td>
    </tr>
  </table>
</div>
<!-- <div class="input" contenteditable placeholder="请输入文字">${in.aboutMe }</div> -->
<c:if test="${not empty books}">
<div class="panel panel-default">
   <div class="panel-heading" id="read">
     <h3 class="panel-title" style="font-weight: bold;">最近阅读</h3>
   </div>
	<div class="panel-body" style="text-align: center;">
		<div class="row">
		<c:forEach items="${books}" var="book">
			<a href="${ctp}/ebook?id=${book.id}" target="_blank">
			<div class="col-lg-4 col-md-4" style="cursor:pointer">
				<img width="150" alt="" src="${ctp}/resources/imgs/books/${book.cover}" >
				<ul class='list-unstyled'><li class='book_name' style="margin-top: 5px;font-family:SimHei;">${book.title }</li></ul>
			</div>
			</a>
		</c:forEach>
		</div>
    	
   </div>
</div>
</c:if>

</body>
</html>