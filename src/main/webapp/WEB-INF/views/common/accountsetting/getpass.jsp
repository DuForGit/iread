<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- 找回密码-步骤1 -->
<div id="getpass_1">
<span>请填写您需要找回的帐号</span>
<h3>确认账号：</h3>
<form class="form-horizontal changepassform" role="form" id="changepassform_1">
			 	
			 		<div class="form-group row">
				      <div class="col-sm-6">
				         <input type="text" class="form-control" id="changepass_user" 
				            placeholder="请输入你的用户名或邮箱" name="name">
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-3 col-xs-6">
				         <input type="text" class="form-control" id="changepass_identify" 
				            placeholder="请输入验证码" name="code">
				      </div>
				      <div class="col-sm-1 col-xs-2"></div>
				      <div class="col-sm-1 col-xs-4"><a class="btn btn-link pull-left">换一张</a></div>
				      <div class="col-sm-1 hidden-xs"></div>
				      <div class="col-sm-6 hidden-xs"></div>
				   </div>
				   
				   <div class="form-group row">
				      <div class="col-sm-6">
				         <button  type="submit" class="btn btn-block changepass_next">下一步</button>
				      </div>
				      <div class="col-sm-6"></div>
				   </div>
				   
			 	</form>
</div>

<!-- 找回密码-步骤2 -->
<div id="getpass_2">
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
						         <button type="submit" class="btn btn-block changepass_next">下一步</button>
						      </div>
						      <div class="col-sm-6"></div>
						   </div>
			 			
			 		</form>
</div>

<!-- 找回密码-步骤3 -->
<div id="getpass_3">
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
			 	</div>