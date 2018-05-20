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
//除去字符串空格
function trimString(s){
	var result = s.replace(/\s+/g, "");
	return result;
}

var inc = document.getElementById("inck").innerText;
var ge = document.getElementById("gen").innerText;
var ab = document.getElementById("me").innerText; 
function changeMyInfo(){
	var uid = ${user.id};
	var inck = trimString(document.getElementById("inck").innerText);
	var gen = trimString(document.getElementById("gen").innerText);
	var about = trimString(document.getElementById("me").innerText); 
	if((inck != inc || gen != ge || about != ab) && (inck != ""&& gen != "" && about != "")){
		if(inck == "输入昵称(6字内)"){
			inck = "";
		}
		var g = "可选词:男/女/男生/女生/帅哥/美女/靓仔/靓女";
		//alert("g:" + g + "gen:" + gen + "; g==gen:" + (gen == g));
		if(gen == g){
			gen = "";
		}
		if(about == "点击此处，一句话介绍你自己(30字内)"){
			about = "";
		}
		//alert("uid:" + uid + "; inck:" + inck + "; gen:" + gen + "; about:" + about);
		 /* alert(about.length);
		alert(inck.length);  */
		if(about.length <= 30 && inck.length <= 6){
			$.post("${ctp}/reset",{id:uid,nickName:inck,gender:gen,aboutMe:about});
			window.location.href="${ctp}/my";
		}else{
			alert("长度超出允许范围");
		}
		
	}
	
	//alert("inc:" + inc + ";ab:" + ab + "; ge: " + ge);
	//if(inck != inc || gen != ge || about != ab){
		//alert("uid:" + uid + "; inck:" + inck + "; gen:" + gen + "; about:" + about);
		//$.post("${ctp}/reset",{id:uid,nickName:inck,gender:gen,aboutMe:about});
		//window.location.href="${ctp}/my";
	//}
	
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
    <c:if test="${empty in.nickName }"><span style="color:red;">输入昵称(6字内)</span></c:if>
    </td>
    </tr>
    <tr>
    <td style="font-weight: bold;">性别</td>
    <td class="input" contenteditable="true" id="gen" onblur="changeMyInfo();">
    <c:if test="${not empty in.gender }">${in.gender }</c:if>
    <c:if test="${empty in.gender }"><span style="color:red;">可选词:男/女/男生/女生/帅哥/美女/靓仔/靓女</span></c:if>
    </td>
    <td style="font-weight: bold;">注册邮箱</td><td>${user.email }</td>
    </tr>
    <tr>
    <td style="font-weight: bold;">about me：</td>
    <td class="input" contenteditable="true" id="me" onblur="changeMyInfo();">
    <c:if test="${not empty in.aboutMe }">${in.aboutMe }</c:if>   
    <c:if test="${empty in.aboutMe }"><span style="color:red;">点击此处，一句话介绍你自己(30字内)</span></c:if>   
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
				<img width="150" alt="" src="http://localhost:8080/iAdmin/images/book/${book.cover}" >
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