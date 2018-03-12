<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
    <%-- <c:import url="common/common.jsp"></c:import> --%>
    <style>
    #login{
background: rgba(0,152,50,0.3);
}
#login_content{
background-color:#4CAF50;
color:#fff;
}

#loginTitle{
font-size: 20px;
}
#login_sub{
background-color: #000; 
color:#fff;
border-color: #000; 
font-size: 24px;
}
.glyphicon{
color: #000;
}
#login_form input{
background-color: #fff;
border-color: #000;
}
#login_problem{
color:maroon;
}
#other_login{
font-size: 10px;
float: left;
}
.other_login_a{
float:left;
}
.point_hide{
display: none;
}
.point_show{
display: block;
color: red;
font-size: 12px;
}
    </style>
 <div id="login" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="loginTitle" aria-hidden="true">
 	<div class="modal-dialog" id="login_dialog">
 		<div class="modal-content" id="login_content">
 			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="loginTitle">
				<span class="glyphicon glyphicon-user"></span>
					登录iread账号
				</h4>
 		</div>
 		<div class="modal-body">
				<!-- <script type="text/javascript">
					
					function nameRegex(info){
						var email = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
						var phone = /^((17[0-9])|(14[0-9])|(13[0-9])|(15[/^4,\\D])|(18[0,5-9]))\\d{8}$;
						var name = /^[a-z0-9A-Z\u4e00-\u9fa5]+$;
						if(email.test(info) || name.test(info) || phone.test(info)){
							return true;
						}
						return false;
					}
					function passRegex(p){
						var pass = /^[a-zA-Z0-9]{6,20}$;
						if(pass.test(p)){
							return true;
						}
						return false;
					}
				
				
					$(document).ready(function(){
						$("input[class='form-control']").blur(function(){
							var info = $(this).value;
							alert(info);
						});
					});
				</script> -->
				<!-- 表单 -->
				<form class="form-horizontal" role="form" id="login_form" method="post" action="${ctp}/login">
				   <div class="form-group">
				      <div class="col-sm-12">
				         <input type="text" class="form-control" id="user"  name="name"
				            placeholder="邮箱/用户名">
				            <span class="point_hide">&nbsp;格式错误/不能为空</span>
				      </div>
				   </div>
				   <div class="form-group">
				      <div class="col-sm-12">
				         <input type="password" class="form-control" id="password"  name="pass"
				            placeholder="密码">
				            <span class="point_hide">&nbsp;格式错误/不能为空</span>
				      </div>
				   </div>
				   <div class="form-group">
				      <div class="col-sm-8 col-xs-6">
				         <!-- <div class="checkbox">
				            <label>
				               <input id="login_remember" type="checkbox"> 下次自动登录
				            </label>
				         </div> -->
				      </div>
				      <div class="col-sm-4 col-xs-6">
<%-- 				      <c:import url="loginproblem.jsp"/> --%>
				      	<%@include file="loginproblem.jsp" %> 
				      </div>
				   </div>
				   <div class="form-group">
				      <div class="col-sm-12">
				         <button id="login_sub" type="submit" class="btn btn-block">登录</button>
				      </div>
				   </div>
				</form>
				
				
				<!-- 表单 -->
				
		</div>
		<div class="modal-footer" >
				<!-- <span id="other_login">可以使用以下方式登录</span> --><br>
				<div class="row">
				<%-- <div class="col-sm-8 col-xs-8 col-lg-8 col-md-8">
					<a type="button" class="btn btn-link other_login_a" >
						 <img src="${ctp }/resources/imgs/qq.png" class="img-responsive" alt="QQ登录">
					</a>

					<a type="button" class="btn btn-link other_login_a" >
						 <img src="${ctp }/resources/imgs/weibo.png" class="img-responsive" alt="微博登录">
					</a>
					</div> --%>
					<div class="col-sm-4 col-xs-4 col-lg-4 col-md-4">
						<a type="button" class="btn btn-link other_login_a" style="color:#fff;" href="<%=request.getContextPath()%>/reg" target="_blank">未注册</a>
					</div>
				</div>
		</div>
 	</div>
 </div>
 </div>