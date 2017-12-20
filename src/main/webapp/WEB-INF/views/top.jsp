<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
#search{
width:100%;
}
#search #inf{
width:55%;
height:39px;
font-size:13px;
border:1px solid #4CAF50;
color:#000;
outline:none;
float:left;
}
form #sub{
width:20%;
height:39px;
font-size:13px;
border:1px solid #4CAF50;
float:left;
background-color: #4CAF50;
color: white;
}
form #types{
width:25%;
height:39px; 
font-size:13px;
border:1px solid #4CAF50;
float:left;
background-color: #4CAF50;
color: white;
}

#cata a{
font-size: 16px;
color:#000;
float:left;
background-color: #fff;
border-color: #fff;
width:10%;
}

#cata > a:first-child{
border-color: #4CAF50;
background-color:#4CAF50;
color:#fff;
}
a{
text-align: center;
}
</style>



<div class="container">

<!-- PC端 -->
<!-- info菜单 -->
 <div class="row">
 
 <!-- 移动端 -->
 <script type="text/javascript">
 $(document).ready(function(){
	 var ps = $("#mobile_info").position();
	 //   $("#info_mobile_list").css("position","absolute");
	    $("#info_mobile_list").css("right",ps.right); 
	    $("#info_mobile_list").css("top",ps.top+15);
	    $("#mobile_info").mouseenter(function(){
	    	 $("#info_mobile_list").show();
	    	// alert(ps.right);
		  });
	    $("#mobile_info").mouseleave(function(){
	    	 $("#info_mobile_list").hide();
		  });
	    
	    var ps_cata = $("#cata_modi").position();
	    $("#cata_list").css("left",ps_cata.left); 
	    $("#cata_list").css("top",ps_cata.top+15); 
	    $("#cata_modi").mouseenter(function(){
	    	 $("#cata_list").show();
		  });
	    
	    $("#cata_modi").mouseleave(function(){
	    	 $("#cata_list").hide();
		  });
	    
 });
 </script>
 <div id="cata_modi" class="col-xs-2 col-sm-2 hidden-lg hidden-md pull-left">
 <span class="glyphicon glyphicon-th-large"></span>
 <div id="cata_list" style="display:none;" class="dropdown-menu">
 
  <li style="text-align: center;"><a href="#" >首页</a></li> 
 <li class="divider"></li>
 <li style="text-align: center;"><a href="#">个性化</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="#">分类</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">推荐</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">作家</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">出版社</a></li>
 
 </div>
 </div>
 <div id="sky" class="col-md-8 col-lg-8 col-xs-8 col-sm-8" >天气预报</div>
 <div id="mobile_info" class="col-xs-2 col-sm-2 hidden-lg hidden-md pull-right">
 <span id="user_info_mob"  class="glyphicon glyphicon-user pull-right"></span>
 
  <div id="info_mobile_list" class="dropdown-menu" style="display:none;">
 <li style="text-align: center;"><a href="#" >个人主页</a></li> 
 <li class="divider"></li>
 <li style="text-align: center;"><a href="#">设置</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="#">购物车</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">收藏</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">书架</a></li>
 </div>
 
 </div>
 <!-- 移动端 -->
 
 <div class="col-md-4 col-lg-4 hidden-sm hidden-xs pull-left">
 <script type="text/javascript">
 $(document).ready(function(){
	 var ps = $("#info").position();
	    $("#info_list").css("position","absolute");
	    $("#info_list").css("left",ps.left+20); 
	    $("#info_list").css("top",ps.top+25);
	  $("#info").mouseenter(function(){
		  $("#sign").html(">");
		  window.setTimeout(function(){
		  $("#info_list").show();
		  $("#sign").html("∧");
		  },80);
	  });
	  $("#info_wrap").mouseleave(function(){
		  $("#sign").html("<");
		  window.setTimeout(function(){
			  $("#info_list").hide();
			  $("#sign").html("∨");
			  },80);
	  });
	});
 </script>
 
 <a type="button" class="btn btn-link"  data-toggle="modal"  data-target="#login" style="color:#000000">登录/注册</a>
 <span>|</span>
 
 
 
 
 
<!--  <font id="info_wrap" >
 <a type="button" class="btn btn-link" id="info" style="color:#000000">
<span id="username">个人信息</span> 
<span id="sign">∨</span> 
 </a>
 <div id="info_list" class="dropdown-menu" style="display:none;">
 <li style="text-align: center;"><a href="#" >个人主页</a></li> 
 <li class="divider"></li>
 <li style="text-align: center;"><a href="#">设置</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="#">购物车</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">收藏</a></li>
 </div>
 </font>
 <span>|</span> -->
 
 
<!-- <a type="button" class="btn btn-link navbar-header">登录/注册</a> -->
<a type="button" class="btn btn-link" style="color:#000000">设置</a>
 <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000">反馈</a>
 <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000">消息</a>
 </div>
 </div>

<!--start--logo、搜索框、推荐信息-->
<div class="row" >
<div class="col-md-2 col-lg-2 col-xs-12 col-sm-12">

<%@include file="common/logo.jsp" %>

</div>
<div class="col-md-5 col-lg-5 col-xs-12 col-sm-12">
<script type="text/javascript">
	$(document).ready(function(){
		$("#sub").click(function(){
			
			var type = $("#types").val();
			var info = $("#inf").val();
			var param = {"types":type,"info":info};
			$.ajax({
				url:"${pageContext.request.contextPath}/search",
				dataType : "json",
				data:param,
				type:"POST",
				success:function(data){	
					$("#home").empty();
						$.each(data,function(i,n){
							alert(data[i].id + " : " + data[i].num + " : " + data[i].summary);
							$("#home").append(
									 "<div>" + data[i].id + "</div>" + 
									 "<div>" + data[i].num + "</div>" + 
									 "<div>" + data[i].summary + "</div>"
							);
						});
				},
				error:function(data,status){
	                alert("为空！");
	         }
				});
		});
	});
</script>
<form id="search">
<select id="types" name="types">
<option>书名</option>
<option>类型</option>
<option>作者</option>
<option>出版社</option>
</select>
<input type="text" id="inf" placeholder="白夜追凶" name="info"/>
<input type="button" id="sub" value="搜索"/>
</form>

<div class="hidden-sm hidden-xs " >
<a  class="text-light" style="color:black;text-decoration:none;cursor:pointer;">三体</a>
<span>&nbsp&nbsp</span>
<a class="text-light" style="color:black;text-decoration:none;cursor:pointer;">互联网</a>
<span>&nbsp&nbsp</span>
<a class="text-light" style="color:black;text-decoration:none;cursor:pointer;">卑鄙的圣人</a>
<span>&nbsp&nbsp</span>
<a class="text-light" style="color:black;text-decoration:none;cursor:pointer;">摆渡人</a>
<span>&nbsp&nbsp</span>
<a class="text-light" style="color:black;text-decoration:none;cursor:pointer;">追风筝的男孩</a>
<span>&nbsp&nbsp</span>
<a class="text-light" style="color:black;text-decoration:none;cursor:pointer;">Java</a>
</div>
</div>
<div class="col-md-5 col-lg-5"></div>
</div>
<!--end--logo、搜索框、推荐信息-->

<!-- start--目录  -->
<script type="text/javascript">
$(document).ready(function(){
	$("#cata a").mouseenter(function(){
		$(this).css("background-color","#4CAF50");
		$(this).css("color","#fff");
	});
	$("#cata a").mouseleave(function(){
		$(this).css("background-color","#fff");
		$(this).css("color","#000");
	});
	$("#cata a").click(function(){
		$("#cata a").css("border-color","#fff");
		$(this).css("border-color","#4CAF50");
	});
});
</script>
<div style="height:20px;"></div>
<ul id="cata" class="nav nav-tabs hidden-xs hidden-sm row" style="border-color: #4CAF50;">
<a class="btn btn-success">首页</a>
<a class="btn btn-success">个性化</a>
<a class="btn btn-success">分类</a>
<a class="btn btn-success">推荐</a>
<a class="btn btn-success">作家</a>
<a class="btn btn-success">出版社</a>
<a class="btn btn-success pull-right">
<span class="glyphicon glyphicon-book"></span>&nbsp书架</a>
</ul>
<!-- end---目录  -->
<!-- PC端  -->

<!-- 登录/注册模板 -->
<%-- <%@include file="common/login.jsp" %> --%>
<c:import url="common/login.jsp"></c:import>
<!-- 登录/注册模板 -->

</div>
