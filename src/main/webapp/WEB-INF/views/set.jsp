<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号设置</title>
<%@include file="common/viewport.jsp" %>
<%@include file="common/content_type.jsp" %>
<%@include file="common/common.jsp" %>
<style type="text/css">
#chanpass_top{
margin-top: 10px;
}
.changepassform input{
background-color: #fff;
border-color: #000;
}
.changepassform select{
background-color: #fff;
border-color: #000;
}
.changepass_next{
background-color: #000; 
color:#fff;
border-color: #000; 
font-size: 24px;
}
.identify_code{
background-color: #000;
color: #fff;
}

#getpass_2{
display:none;
}
#getpass_3{
display:none;
}
#sub{
background-color: #000; 
color:#fff;
border-color: #000; 
font-size: 24px;
}
</style>
</head>
<body>
	<div id="reg_cont" class="container">
		<div id="chanpass_top" class="row">
			<div class="col-md-2 col-lg-2 hidden-sm hidden-xs pull-left">
		 	<%@include file="common/logo.jsp" %>
		 	</div>
		 	<div class="col-md-8 col-lg-8 col-sm-6 col-xs-6 pull-left">
		 		<h3><span class="glyphicon glyphicon-lock"> </span>账号设置</h3>
		 	</div>
		 	<div class="col-md-2 col-lg-2 col-sm-6 col-xs-6 pull-right" >
		 		 <a type="button" class="btn btn-link"  data-toggle="modal"  data-target="#login" style="color:#000;">登录</a>
		 		 <span> | </span>
		 		  <a href="<%=request.getContextPath() %>/reg" type="button" class="btn btn-link" target="_blank" style="color:#000;">注册</a>
		 	</div>
		</div>
		<hr>
		<h4>找回密码</h4>
		<hr>
		
		<div id="accountchange" class="row">
			 
			 <div class="col-sm-12 col-xs-12 col-lg-9 col-md-9" id="changpassforms">
			 	
<script type="text/javascript">

//除去字符串空格
function trimString(s){
	var result = s.replace(/\s+/g, "");
	return result;
}
//密码格式
function isPassword(p){
	var reg = /^[a-zA-Z0-9]{6,20}$/;
	return reg.test(p);
}

$(document).ready(function(){
	$("#sub").click(function(){
		var newpass1 = $("#newpass").val();
		var newpass2 = $("#pass").val();
		if(newpass1 != newpass2){
			alert("密码不一致");
		}else{
			if(isPassword(trimString(newpass1))){
				$.post("${ctp}/submitnewpass",{pass:newpass1},function(date){
					if(date == true){
						window.location.href="${ctp}";
					}else{
						alert("更改密码出现错误");
					}
				});
			}else{
				alert("密码格式错误，请输入6-20位的数字或字母");
			}
		}
	});
});
</script>


<!-- 找回密码-步骤1 -->
<div id="getpass_1">
<span>请填写您需要找回的帐号</span>
<h3>填写新密码：</h3>
<form class="form-horizontal changepassform" role="form" id="changepassform_1">
			 	
			 		<div class="form-group row">
				      <div class="col-sm-6">
				         <input type="password" class="form-control" id="newpass" 
				            placeholder="新密码" name="pass1">
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-6 col-xs-6">
				         <input type="password" class="form-control" id="pass" 
				            placeholder="确认密码" name="pass2">
				      </div>
				      <div class="col-sm-6 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-6">
				         <button id="sub"  type="button" class="btn btn-block">确认更改</button>
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
			 	</form>
</div>	 	
			 	
			 	
			 </div>
			 <div class="hidden-col-sm hidden-col-xs col-lg-2 col-md-2"></div>
			 
		</div>
		
	</div>
	<%@include file="common/login.jsp" %>
	
</body>
</html>