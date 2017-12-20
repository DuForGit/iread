<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>欢迎注册iread账号</title>
<%@include file="common/viewport.jsp" %>
<%@include file="common/content_type.jsp" %>
<%@include file="common/common.jsp" %>
<style type="text/css">
#reg_cont{
	margin: 10px auto;
}
#register_form input{
background-color: #fff;
border-color: #000;
}
#register_sub{
background-color: #000; 
color:#fff;
border-color: #000; 
font-size: 24px;
}
.identify_code{
background-color: #000;
color: #fff;
}
</style>
</head>
<body>
<div id="reg_cont" class="container">
	<div id="reg_top" class="row">
		 <div class="col-md-2 col-lg-2 hidden-sm hidden-xs pull-left">
		 	<%@include file="common/logo.jsp" %>
		 </div>
		 <div class="col-md-7 col-lg-7 col-sm-8 col-xs-8 pull-left">
		 	<h3><span class="glyphicon glyphicon-user"> </span>注册iread账号</h3>
		 </div>
		 <div class="col-md-3 col-lg-3 col-sm-4 col-xs-4 pull-left">
		 	<span><span class="hidden-sm hidden-xs">我已注册，现在就 </span><a  class="btn btn-success" data-toggle="modal"  data-target="#login">登录</a></span>
		 	
		 	<%@include file="common/login.jsp" %>
		 	
		 </div>
	</div>
		<hr>
	<div id="reg_main" class="row">
		<div class="col-sm-12 col-xs-12 col-lg-9 col-md-9">

			<!-- 注册表单 -->
				<form class="form-horizontal" role="form" id="register_form">
				
				   <div class="form-group">
				      <div class="col-sm-6">
				         <input type="text" class="form-control" id="reg_user" 
				            placeholder="请设置用户名" name="name">
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group">
				   <div class="col-sm-6">
				         <input type="text" class="form-control" id="reg_email" 
				            placeholder="请绑定邮箱">
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group">
				   <div class="col-sm-4 col-xs-7">
				         <input type="text" class="form-control" id="reg_code" 
				            placeholder="验证码">
				     </div>
				     <div class="col-xs-5 col-sm-2"><a id="identify_code" class="btn btn-default identify_code">获取验证码</a></div>
				      <div class="col-sm-6 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group">
				      <div class="col-sm-6">
				         <input type="password" class="form-control" id="password" 
				            placeholder="密码">
				      </div>
				       <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group">
				      <div class="col-sm-4 col-xs-12">
				         <span>点击注册表示同意<a class="btn btn-link">用户服务协议</a></span>
				      </div>
				      
				      
				      <div class="col-sm-4 col-xs-12" >
				      	 <%@include file="common/loginproblem.jsp" %>  
				      </div>
				      <div class="col-sm-4 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group">
				      <div class="col-sm-6">
				         <button id="register_sub" type="submit" class="btn btn-block">注册</button>
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				</form>			
		</div>
		<div class="hidden-col-sm hidden-col-xs col-lg-3 col-md-3"></div>
	</div>
</div>
</body>
</html>