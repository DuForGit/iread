<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			 	
			 	<%@include file="common/accountsetting/getpass.jsp" %>
			 	
			 	
			 </div>
			 <div class="hidden-col-sm hidden-col-xs col-lg-2 col-md-2"></div>
			 
		</div>
		
	</div>
	<%@include file="common/login.jsp" %>
	
</body>
</html>