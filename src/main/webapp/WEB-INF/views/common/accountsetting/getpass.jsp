<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctp" value="${pageContext.request.contextPath}"/>
<style>
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
</style>

<script type="text/javascript">
//验证邮箱
function isEmail(email){
	var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	return reg.test(email);
}
//验证验证码
function isCode(code){
	var reg = /^[0-9]{6}$/;
	return reg.test(code);
}
//除去字符串空格
function trimString(s){
	var result = s.replace(/\s+/g, "");
	return result;
}



var isemail = false;
var iscode = false;
$(document).ready(function(){
	$("#changepass_user").blur(function(){
		var em = $("#changepass_user").val();
		if(em == null || em == ""){
			isemail = false;
			$("#emailspan").text("不能为空");
		}else{		
			if(!isEmail(trimString(em))){
				isemail = false;
				$("#emailspan").text("非法邮箱");
			}else{
				$.post("${ctp}/isExistEmail",{email:em},function(date){
					if(date == false){
						isemail = false;
						$("#emailspan").text("不存在该邮箱");
					}else{
						isemail = true;
						$("#emailspan").text("");
					}
				});
			}
		}
	});
	
	$("#changepass_identify").blur(function(){
		var co = $("#changepass_identify").val();
		if(co == null || co == ""){
			iscode = false;
			$("#codespan").text("不能为空");
		}else{
			if(!isCode(trimString(co))){
				iscode = false;
				$("#codespan").text("不合法");
			}else{
				iscode = true;
				$("#codespan").text("");
			}
		}
	});
	
	$("#codebtn").click(function(){
		var em = $("#changepass_user").val();
		if(isEmail(trimString(em))){	
			isemail = true;
			$.post("${ctp}/changecode",{email:em},function(data){
					if(data == true){
						var time = 60;
						var times =document.getElementById("codebtn");
						var timer = setInterval(function(){
							$("#codebtn").css("opacity","0.2");
							$("#codebtn").css("pointer-events","none");
							$("#codebtn").html(time--);
							if(time <= 0){
 							$("#codebtn").css("opacity","1");
 							$("#codebtn").html("获取验证码");
 							$("#codebtn").css("pointer-events","auto");
 							clearInterval(timer); 
 						}
						},1000);
						
					}else alert("发送失败，请重新发送请求");
				});
		}else{
			alert("邮箱或验证码有误");
		}
	});
	
	$("#changepass_next").click(function(){
		var em = $("#changepass_user").val();
		var co = $("#changepass_identify").val();
		if(isEmail(trimString(em)) && isCode(trimString(co))){
			$.post("${ctp}/setpass",{email:em,code:co},function(date){
				if(date == true){
					window.location.href="${ctp}/setmypass";
				}else{alert("验证码错误");}
			});
		}
	});
	
});
</script>

<!-- 找回密码-步骤1 -->
<div id="getpass_1">
<span>请填写您需要找回的帐号</span>
<h3>确认账号：</h3>
<form class="form-horizontal changepassform" role="form" id="changepassform_1">
			 	
			 		<div class="form-group row">
				      <div class="col-sm-6">
				         <input type="text" class="form-control" id="changepass_user" 
				            placeholder="请输入你的所绑定的邮箱" name="email">
				      </div><span id="emailspan" style="color:red;font-size: 12px;"></span>
				      <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-3 col-xs-6">
				         <input type="text" class="form-control" id="changepass_identify" 
				            placeholder="请输入验证码" name="code">
				      </div>
				      <span id="codespan" style="color:red;font-size: 12px;"></span>
				      <div class="col-sm-1 col-xs-2"></div>
				      <div class="col-sm-1 col-xs-4"><a id="codebtn" class="btn btn-primary pull-left" style="background-color: #000;">获取验证码</a></div>
				      <div class="col-sm-1 hidden-xs"></div>
				      <div class="col-sm-6 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-6">
				         <button id="changepass_next"  type="submit" class="btn btn-block changepass_next">下一步</button>
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
			 	</form>
</div>

<!-- 找回密码-步骤2 -->
<!-- <div id="getpass_2">
			 		<span>为了你的帐号安全，请完成身份验证</span>
			 		<h3>验证方式：</h3>
			 		<form class="form-horizontal changepassform" role="form" id="changepassform_2">
			 			<div class="form-group row">
			 				<div class="col-sm-6">
			 				
			 				<select class="form-control ">
						        <option>15*******4@qq.com</option>
						        <option>135******09</option>
						     </select>
				            	
				      		</div>
				      		<div class="col-sm-6"></div>
			 			</div>
			 			
			 			<div class="form-group">
						   <div class="col-sm-4 col-xs-7">
						         <input type="text" class="form-control" id="getpass_code" 
						            placeholder="验证码">
						     </div>
						     <div class="col-xs-5 col-sm-2"><a class="btn btn-default identify_code">发送验证码</a></div>
						      <div class="col-sm-6 hidden-xs"></div>
						 </div>
						 
						 <div class="form-group row">
						      <div class="col-sm-6">
						         <button id="changepass_next" type="submit" class="btn btn-block changepass_next">下一步</button>
						      </div>
						      <div class="col-sm-6"></div>
						   </div>
			 			
			 		</form>
</div> -->

<!-- 找回密码-步骤3 -->
<!-- <div id="getpass_3">
			 		<span>填写你的最新密码，并记住</span>
			 		<h3>输入密码：</h3>
			 		<form class="form-horizontal changepassform" role="form" id="changepassform_3">
			 			<div class="form-group row">
						      <div class="col-sm-6">
						         <input type="password" class="form-control" id="changepass_newpass1" 
						            placeholder="请输入你的新密码" name="newpass">
						      </div>
						      <div class="col-sm-6"></div>
						 </div>
						 
						 <div class="form-group row">
						      <div class="col-sm-6">
						         <input type="password" class="form-control" id="changepass_newpass1" 
						            placeholder="请确认你的新密码" name="newpass2">
						      </div>
						      <div class="col-sm-6"></div>
						 </div>
						 
						 <div class="form-group row">
						      <div class="col-sm-6">
						         <button  type="submit" class="btn btn-block changepass_next">完成</button>
						      </div>
						      <div class="col-sm-6"></div>
						   </div>
						 
			 		</form>
			 	</div> -->