<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>欢迎注册iread账号</title>
<c:import url="common/viewport.jsp"></c:import>
<c:import url="common/content_type.jsp"></c:import>
<c:import url="common/common.jsp"></c:import>
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
.point_hide{
display: none;
}
.point_show{
display: block;
color: red;
font-size: 12px;
line-height: 20px;
}
</style>
<script type="text/javascript">
var isExEmail = false;//是否存在邮箱
var isExName = false;//是否存在名称
//验证邮箱
function isEmail(email){
	var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	return reg.test(email);
}
function isPhone(phone){
	var reg = /^1[3|5][0-9]\d{4,8}$/;
	return reg.test(phone);
}
function isName(name){
	var reg = /^[a-z0-9A-Z\u4e00-\u9fa5]+$/;
	return reg.test(name);
}
//密码格式
function isPassword(p){
	var reg = /^[a-zA-Z0-9]{6,20}$/;
	return reg.test(p);
}
function isCode(code){
	var reg = /^[0-9]{6}$/;
	return reg.test(code);
}

//除去字符串空格
function trimString(s){
	var result = s.replace(/\s+/g, "");
	return result;
}



$(document).ready(function(){
	$("#register_sub").click(function(){
		var rname = document.getElementById("reg_user").value;
		var remail = document.getElementById("reg_email").value;
		var rpassword = document.getElementById("reg_password").value;
		var rcode = document.getElementById("reg_code").value;
		
		
		
		if(isEmail(remail) && isName(rname) && isPassword(rpassword) && isCode(rcode)){	
			if(isExName == true || isExEmail == true){
				alert("名称或邮箱已经存在");
			}else{	
			/* $.ajax({url:"${ctp}/postUser",
					data:{name:rname,email:remail,password:rpassword,code:rcode},
					type:"POST"}
			);  */
			$.post("${ctp}/postUser",{name:rname,email:remail,password:rpassword,code:rcode},function(data){
				$(location).prop('href', data);
			});
			}
		}else{
		alert("填写信息格式有误！");
		}
	});
	
	
	
	
	
});



/* //判断邮箱是否已被注册
function isExist(e){
	$.getJSON("${ctp}/isExistEmail", function(data){
		return data;
	});
	$.post("${ctp}/isExistEmail",{email:e},function(data){
			return data;
		});
} */
</script>
</head>
<body>
<div id="reg_cont" class="container">
	<div id="reg_top" class="row">
		 <div class="col-md-2 col-lg-2 hidden-sm hidden-xs pull-left">
		 <c:import url="common/logo.jsp"/>
		 </div>
		 <div class="col-md-7 col-lg-7 col-sm-8 col-xs-8 pull-left">
		 	<h3><span class="glyphicon glyphicon-user"> </span>注册iread账号</h3>
		 </div>
		 <div class="col-md-3 col-lg-3 col-sm-4 col-xs-4 pull-left">
		 	<span><span class="hidden-sm hidden-xs">我已注册，现在就 </span><a  class="btn btn-success" data-toggle="modal"  data-target="#login">登录</a></span>
		 	
		 	<c:import url="common/login.jsp"/>
		 	
		 </div>
	</div>
		<hr>
	<div id="reg_main" class="row">
		<div class="col-sm-12 col-xs-12 col-lg-9 col-md-9">
			
			<!-- <script type="text/javascript">
				$(document).ready(function(){
					$("input[class='form-control']").mouseleave(function(){
						var info = $(this).value;
						alert(info);
					});
				});
			</script> -->
			
			<!-- 注册表单 -->
				<form class="form-horizontal" role="form" id="register_form" action="/postUser" method="post">
				
					
				   <div class="form-group">
				      <div class="col-sm-6">
				         <input type="text" class="form-control" id="reg_user" 
				            placeholder="请设置用户名   不要包含空格" name="name">
				            
				      </div>
				        <div class="col-sm-3"><span class="point_hide" id="pname">&nbsp;格式错误/不能为空</span></div>
				      <div class="col-sm-3"></div>
				   </div>
				   
				   
				   
				   <div class="form-group">
				   <div class="col-sm-6">
				         <input type="email" class="form-control" id="reg_email"  name="email" 
				            placeholder="请绑定邮箱">
				            
				      </div>
				      <div class="col-sm-3"><span class="point_hide" id="pemail">&nbsp;格式错误/不能为空</span></div>
				      <div class="col-sm-3"></div>
				   </div>
				   
				   
				   <div class="form-group">
				   <div class="col-sm-3 col-xs-6">
				         <input type="text" class="form-control" id="reg_code"  name="code" 
				            placeholder="验证码">
				     </div>
				      
				     <script type="text/javascript">
				     	$(document).ready(function(){
				     		$("#identify_code").click(function(){
				     			var remail =trimString(document.getElementById("reg_email").value);
				     			if(isEmail(remail) == false){
				     				alert("邮箱格式有误");
				     			}else{
				     				
				     				$.post("${ctp}/isExistEmail",{email:remail},function(data){
										var d =data;
				     					if(d == true){
				     						alert("已被注册");
				     						}else{
				     						$.post("${ctp}/code",{email:remail},function(data){
						     					if(data == true){
						     						var time = 60;
						     						var times =document.getElementById("identify_code");
						     						var timer = setInterval(function(){
						     							$("#identify_code").css("opacity","0.2");
						     							$("#identify_code").css("pointer-events","none");
						     							$("#identify_code").html(time--);
						     							if(time <= 0){
							     							$("#identify_code").css("opacity","1");
							     							$("#identify_code").html("获取验证码");
							     							$("#identify_code").css("pointer-events","auto");
							     							clearInterval(timer); 
							     						}
						     						},1000);
						     						
													}else alert("发送失败，请重新发送请求");
						     				});
				     					}

				     					
				     				});
					     			
				     			}
				     			
				     		});
				     	});
				     </script>
				     
				     <div class="col-sm-3"><a id="identify_code" class="btn btn-default identify_code">获取验证码</a></div>
				     <div class="col-sm-3"> <span class="point_hide" id="pcode">&nbsp;格式错误/不能为空</span></div>
				      <div class="col-sm-3 hidden-xs"></div>
				   </div>
				   
				  
				   
				   <div class="form-group">
				      <div class="col-sm-6">
				         <input type="password" class="form-control" id="reg_password"  name = "password" 
				            placeholder="密码 不要包含空格">
				            
				          
				      </div>
				      <div class="col-sm-3">  <span class="point_hide" id="ppass">&nbsp;格式错误/不能为空</span></div>
				       <div class="col-sm-3"></div>
				   </div>
				  
				   
				   <div class="form-group">
				      <div class="col-sm-4 col-xs-12">
				         <span>点击注册表示同意<a class="btn btn-link">用户服务协议</a></span>
				      </div>
				      
				      
				      <div class="col-sm-4 col-xs-12" >
				      	<c:import url="common/loginproblem.jsp"/>
				      </div>
				      <div class="col-sm-4 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group">
				      <div class="col-sm-6">
				         <button id="register_sub" type="button" class="btn btn-block" >注册</button>
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				</form>			
		</div>
		<div class="hidden-col-sm hidden-col-xs col-lg-3 col-md-3"></div>
	</div>
</div>
</body>
<script type="text/javascript">
$("#reg_user").blur(function(){
	var rname = $("#reg_user").val();
	var reg = /^[a-z0-9A-Z\u4e00-\u9fa5]+$/;
	if(reg.test(rname)  == false){
		$("#pname").addClass("point_show");
	}else{
		$.post("${ctp}/isExistName",{name:rname},function(data){
			isExName = data;
			if(isExName == true){	
				$("#pname").addClass("point_show");
				$("#pname").html("该用户名已被注册");
			}else
				$("#pname").removeClass("point_show");
		});
	}
	
});						
						
						
$("#reg_email").blur(function(){
	var remail = $("#reg_email").val();
	var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	if(!reg.test(remail)){
		$("#pemail").addClass("point_show");
	}else{
		$.post("${ctp}/isExistEmail",{email:remail},function(data){
			isExEmail = data;
			if(isExEmail == true){
				$("#pemail").addClass("point_show");
				$("#pemail").html("该邮箱已被注册");
			}else
			$("#pemail").removeClass("point_show");
		});
	}
	
});
$("#reg_password").blur(function(){
	var rpassword = $("#reg_password").val();
	var reg = /^[A-Za-z0-9]{6,20}$/;
	if(reg.test(rpassword)  == false){
		$("#ppass").addClass("point_show");
	}else{
		$("#ppass").removeClass("point_show");
	}
});
$("#reg_code").blur(function(){
	var rcode = $("#reg_code").val();
	var reg = /^[0-9]{6}$/;
	if(reg.test(rcode) == false){
		$("#pcode").addClass("point_show");
	}else{
		$("#pcode").removeClass("point_show");
	}
});
</script>
</html>