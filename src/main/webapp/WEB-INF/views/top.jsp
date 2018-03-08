<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctp" value="${pageContext.request.contextPath}"/>
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


	#binfos .row{
		margin:5px auto;
	}
	.stitle{
		font-weight: bold;
		font-size: 25px;
		font-family: '楷体';
	}
	 .stars .glyphicon{  
            color: orange;  
            user-select: none;  
            padding: 0px 1px;  
            margin:0px;
        }
        .color{
        color:#666;
        }
        .b{
        	color:red;
        }
        .price,.inf{
        	font-size: 16px;
        	font-weight: bold;
        }
        .search{margin-top:10px;}
        .booksnum{margin:20px auto;}
		.summary{
					    overflow: hidden;
					    text-overflow: ellipsis;
					    white-space:nowrap;}
		#page{text-align: center;}
</style>

<script type="text/javascript">
<!--
关于搜索框的处理代码
//-->



/* 将book数据进行展示 */
function show(data){
	var con = $(".main");
	var books = data.list;//电子书表单列表
	var book;//包含电子书的内容
	var len = books.length;//数据长度
	var bhtml = "";//列表HTML代码
	
	//展示分页栏
	var total = data.total;//查询的总book数量；不是当前页面的总数，是根据条件查找到的数据库中的总数
	var pageNum = data.pageNum; //当前页码
	var pages = data.pages;//总页数
	var pre = data.pre;//前一页页码
	var next = data.next;//下一页页码
	var isFirstPage = data.isFirstPage;//是否为第一页
	var isLastPage = data.isLastPage;//是否为最后一页
	var hasPreviousPage = data.hasPreviousPage;//是否有前一页
	var hasNextPage = data.hasNextPage;//是否有后一页
	
	
	var startPage = "<div class='row' id='page'><ul class='pagination'>";//关于分页按钮的HTML开始位置代码
	var endPage = "</ul></div>";//关于分页按钮的HTML结束位置代码
	var pa = "";//分页按钮的HTML代码
	//var pagediv = $("#page");
	
//	if(data != null){alert(books);}
	if(len > 0){
		bhtml += "<span class='booksnum' style='color:#aaa; font-size:12px;'>为您找到相关的电子书"+total+"本</span>";
		for(var i = 0; i < len; i++){
			book = books[i];
			
			bhtml += "<div class='row search' >"
			+"<div class='col-lg-9 col-md-9'>"
			+"<div class='row'>"
			+"<div  class='col-lg-2 col-md-2' id='bimg'>"
			+"<img src='${ctp}/resources/imgs/books/"+book.cover+"' class='img-responsive img-rounded' /></div>"
			+"<div  class='col-lg-10 col-md-10' id='binfos'>"
			+"<div class='row'><span class='stitle'>"+book.title+"</span><span class='color'>("+book.publish.name+")</span></div>"
			+"<div class='row stars'>";
			
			for(var j=0;(j<book.grade) && (book.grade > 0);j++){
				bhtml += "<span class='glyphicon glyphicon-star'></span>";
			}
			bhtml += "<span class='color'>  "+book.grade+"</span><span class='color'>   |   </span><span class='color'>"+book.valuator+"</span></div>";
			bhtml += "<div class='row summary'><span class='inf'>介绍  </span><span class='color'>"+book.summary+"</span></div>";
			bhtml += "<div class='row'><span class='inf'>作者  </span><span class='color'>"+book.writer.name+"</span></div>";
			bhtml += "<div class='row'><div class='col-lg-4 col-md-4 pull-left price'><b class='b'>￥</b><span>"+book.price
			+"</span></div><div class='col-lg-2 col-md-2 pull-right'><a class='btn btn-success btn-xs' href='${ctp}/ebook?id="+book.id+"' target='_blank'>了解更多...</a></div></div></div></div></div><div class='col-lg-3 col-md-3'></div></div>";
			if(len > 1){bhtml += "<hr>";}
		}
	}
	
	
 	if(total > 0 && pages > 1){
		pa = startPage
			+ firstPag(isFirstPage,pageNum)
			+ prePag(hasPreviousPage,pre)
			+ NumPag(pageNum, pages)
			+ nextPag(hasNextPage,next)
			+ lastPag(isLastPage,pages,pageNum)
			+ endPage;
			
	}
	bhtml += pa;
	con.html(bhtml);
}

//包含页码分页按钮
function NumPag(pageNum, pages){
	var p = "";
	if(pages <= 10 && pages > 1){
		for(var i=1; i<=pages;i++){
			if(i == pageNum){
				p = p + "<li style='cursor:pointer' class='active' onclick='showThePag("+i+")'><a>"+i+"</a></li>";
			}else{
				p = p + "<li style='cursor:pointer' onclick='showThePag("+i+")'><a>"+i+"</a></li>";
			}
		}
	}else if(pages > 10){
		if(pageNum > 5){
			var start = pageNum-4;
			var end = pageNum+5 < pages ? pageNum+5:pages;
			for(var i = start;i <=end;i++){
				if(i == pageNum){
					p = p + "<li style='cursor:pointer' class='active' onclick='showThePag("+i+")'><a>"+i+"</a></li>";
				}else{
					p = p + "<li style='cursor:pointer' onclick='showThePag("+i+")'><a>"+i+"</a></li>";
				}
			}
		}
	}
	return p;
}
var type;
var inf = "";
function showThePag(p){
	//var uri = "${ctp}/search?types=" + type +"&info="+info + "&page=" + page;
	$.post("${ctp}/search",{types:type,info:inf,page:p},function(data){
		show(data);
	},"json");
} 

//判断和显示前一页按钮
function prePag(hasPreviousPage,pre){
	var p = "";//“前一页按钮HTML代码”
	if(hasPreviousPage == true){
		p = "<li style='cursor:pointer' onclick='showThePag("+pre+")'><a>上一页</a></li>";
	}
	return p;
}

//判断和显示后一页按钮
function nextPag(hasNextPage,next){
	var p="";//“后一页按钮HTML代码”
	if(hasNextPage == true){
		return p = "<li style='cursor:pointer' onclick='showThePag("+next+")'><a>下一页</a></li>";
	}
	return p;
}
//判断和显示第一页按钮;isFirstPage:判断是否是第一页;pageNum:大于5显示
function firstPag(isFirstPage,pageNum){
	var p = "";//“首页按钮HTML代码”
	if(isFirstPage == false && pageNum > 5){
		return p = "<li style='cursor:pointer' onclick='showThePag("+1+")'><a>首页</a></li>";
	}
	return p;
}
//判断和显示最后一页按钮;pages:总页数也是最后一页;pageNum:小于pages-5时显示
function lastPag(isLastPage,pages,pageNum){
	var p = "";//“尾页按钮HTML代码”
	if(isLastPage == false && (pageNum < pages - 5)){
		p = "<li style='cursor:pointer' onclick='showThePag("+pages+")'><a>尾页</a></li>";
	}
	return p;
}

</script>

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
 
  <li style="text-align: center;"><a href="/" >首页</a></li> 
 <li class="divider"></li>
 <li style="text-align: center;"><a href="">个性化</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="/books">分类</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">推荐</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">作家</a></li>
  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">出版社</a></li>
 
 </div>
 </div>
 <div id="sky" class="col-md-8 col-lg-8 col-xs-8 col-sm-8" ><!-- 天气预报 --></div>
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
 <div class="col-md-4 col-lg-4 hidden-sm hidden-xs pull-left">
 
 <c:if test="${not empty sessionScope.userId}">
<font id="info_wrap" >
 <a type="button" class="btn btn-link" id="info" style="color:#000000">
<span id="username">个人信息</span> 
<span id="sign">∨</span> 
 </a>
 <div id="info_list" class="dropdown-menu" style="display:none;">
 <li style="text-align: center;"><a href="${ctp}/my" >个人主页</a></li> 
 <li class="divider"></li>
 <li style="text-align: center;"><a href="${ctp}/myinfos">我的数据</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="${ctp}/mycart">购物车</a></li>
 <li class="divider"></li>
  <li style="text-align: center;"><a href="${ctp}/quit">退出</a></li>
 <!--  <li class="divider"></li>
  <li style="text-align: center;"><a href="#">收藏</a></li> -->
 </div>
 </font>
 <span>|</span>
 <a type="button" class="btn btn-link" style="color:#000000" href="${ctp}/set">设置</a>
 <span>|</span>
 </c:if>
 
 <c:if test="${empty sessionScope.userId}">
 <a type="button" class="btn btn-link"  data-toggle="modal"  data-target="#login" style="color:#000000">登录</a>
 <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000" href="${ctp}/reg">注册</a>
<span>|</span>
</c:if>
<a type="button" class="btn btn-link" style="color:#000000" href="${ctp}/getpass">找回密码</a>


<!-- <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000">设置</a> -->
<!--  <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000">反馈</a>
 <span>|</span>
<a type="button" class="btn btn-link" style="color:#000000">消息</a> -->
 </div>
 </div>

<!--start--logo、搜索框、推荐信息-->
<div class="row" >
<div class="col-md-2 col-lg-2 col-xs-12 col-sm-12">

<c:import url="common/logo.jsp"/>

</div>
<div class="col-md-5 col-lg-5 col-xs-12 col-sm-12">
<script type="text/javascript">
	$(document).ready(function(){
		$("#sub").click(function(){
			type = $("#types").val();
			inf = $("#inf").val();
			showThePag(1);
			
			/* var type = $("#types").val();
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
				}); */
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
<input type="text" id="inf" placeholder="书名/作者/类型/出版社" name="info"/>
<input type="button" id="sub" value="搜索"/>
</form>

<!-- <div class="hidden-sm hidden-xs " >
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
</div> -->
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
<a class="btn btn-success" href='${ctp}'/>首页</a>
<!-- <a class="btn btn-success">个性化</a> -->
<a class="btn btn-success" href="${ctp }/books">分类</a>
<a class="btn btn-success" href="${ctp }/rank"><!-- 推荐 -->榜单</a>
<a class="btn btn-success" href="${ctp}/writers">作家</a>
<a class="btn btn-success" href="${ctp}/publishs">出版社</a>
<%-- <a class="btn btn-success pull-right" href="${ctp}/mybooks">
<span class="glyphicon glyphicon-book"></span>&nbsp书架</a> --%>
</ul>
<!-- end---目录  -->
<!-- PC端  -->

<!-- 登录/注册模板 -->
<%-- <%@include file="common/login.jsp" %> --%>
<c:import url="common/login.jsp"></c:import>
<!-- 登录/注册模板 -->

</div>

<%-- <div class="row" id="search">
	<div class="col-lg-9 col-md-9">
	<div class="row">
		<div  class="col-lg-2 col-md-2" id="bimg"><img src='${ctp}/resources/imgs/books/别输在说话上.jpg' class='img-responsive img-rounded' /></div>
		<div  class="col-lg-10 col-md-10" id="binfos">
			<div class='row'><span class='stitle'>无证之罪</span><span>(湖南人民出版社)</span></div>
			<div class='row stars'>
				<span class="glyphicon glyphicon-star-empty"></span>
				<span>3</span>
				<span class='color'> | </span><span>397条</span>
			</div>
			<div class='row'>
				<span class='inf'>介绍</span>
				<span class='color'>本书故事发生在繁华都市，凶案现场，罪犯总是故意留下一枚指纹和一张字条——“请来抓我”，除此之外，...</span>
			</div>
			<div class='row'>
				<div class='col-lg-4 col-md-4 pull-left price' ><b>￥</b><span>28</span></div>
				<div class='col-lg-2 col-md-2 pull-right'><button class='btn btn-success btn-xs'>了解更多...</button></div>
			</div>
		</div>
	</div>
	</div>

	<div class="col-lg-3 col-md-3"></div>
</div> --%>

