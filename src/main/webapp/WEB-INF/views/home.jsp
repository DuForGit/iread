<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
   
<!DOCTYPE>
<html>
<head>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<style type="text/css">
.container{
margin-top: 2px;
}
 .carousel-inner img{
text-align: center;
}
.carousel-caption{
font-size: 20px;
font-weight: bold;
}
#home{
background-color: #f6f5ee;
}
.row .book_name{
text-align: center;
}
.book_name_mob{
font-size: small;
text-align: left;
color:#000;
}
.writer_mob,.program_mob,.price_mob{
color:#000;
text-align: left;
font-size:xx-small;
}
.book_name{
color:#000;
}
#hot,#hot a,#new,#new a,#sales,#sales a,#orderbook,#cartbook,#bookcase,#orderbook a,#cartbook a,#bookcase a{
margin-top: 5px;
}
h1{
text-align: center;
}

</style>
</head>
<body>
<%-- <c:out value="bookcase：${empty bookcase}"></c:out>
<c:out value="cartbook：${empty cartbook}"></c:out>
<c:out value="orderbook：${empty orderbook}"></c:out> --%>
<c:import url="top.jsp"/>

<div id="home" class="container main">

<div class="row">
<!-- <div class="col-lg-1 col-md-1" style="float:left;"></div> -->
<div id="caro" class="carousel slide" data-ride="carousel"  style="margin:auto 1px;">
<ul class="carousel-indicators">
    <li data-target="#caro" data-slide-to="0" class="active"></li>
    <li data-target="#caro" data-slide-to="1"></li>
    <li data-target="#caro" data-slide-to="2"></li>
 </ul>
<div class="carousel-inner">
<div class="item active">
<a href="${ctp}/ebook?id=${actions[0].bookId}" target="_blank">
<img src="http://localhost:8080/iAdmin/images/action/${actions[0].cover}" style="height: 350px;width: 100%"/>
</a>
</div>
<div class="item">
<a href="${ctp}/ebook?id=${actions[1].bookId}" target="_blank">
<img src="http://localhost:8080/iAdmin/images/action/${actions[1].cover}"  style="height: 350px;width: 100%"/> 
</a>
</div>
<div class="item">
<a href="${ctp}/ebook?id=${actions[2].bookId}" target="_blank">
<img src="http://localhost:8080/iAdmin/images/action/${actions[2].cover}"  style="height: 350px;width: 100%"/>
 </a>
 </div>
</div>
<a class="carousel-control left" href="#caro" 
        data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#caro" 
        data-slide="next">&rsaquo;
    </a>
</div>
<!-- <div class="col-lg-1 col-md-1" style="float:left;"></div> -->
</div>

<div id="hot" class="row">
<h1>热门推荐</h1>

<c:if test="${not empty hots}">
<c:forEach items="${hots}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
				</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>	
</c:if>

</div>
<div id="new" class="row">
	<h1>新书推荐</h1>
	<c:forEach items="${news}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
				</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>
</div>

<c:if test="${not empty bookcase}">

	<h1>根据你的书架为你推荐以下图书</h1>
	<c:forEach items="${bookcase}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
				</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>

</c:if>

<c:if test="${not empty cartbook}">
<div id="cartbook" class="row">
	<h1>根据你的购物车为你推荐以下图书</h1>
	<c:forEach items="${cartbook}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
			</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>
</div>
</c:if>


<c:if test="${not empty orderbook}">
<div id="orderbook" class="row">
	<h1>根据你的购买记录为你推荐以下图书</h1>
	<c:forEach items="${orderbook}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
				</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>
</div>
</c:if>


<div id="sales" class="row">
	<h1>热卖中...</h1>
	<c:forEach items="${sales}" var="bk">
	<a class="col-lg-2 col-md-2" href="${ctp}/ebook?id=${bk.id}" target="_blank">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<img src="http://localhost:8080/iAdmin/images/book/${bk.cover}" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">${bk.title}</li>
				<li class="writer_mob">作者: ${bk.writer.name}</li>
				<li class="price_mob">价格:${bk.price}</li>
				</ul>
			</div>
		</div>
		<div class="row hidden-xs hidden-sm book_name"><span>${bk.title}</span></div>
	</a>
</c:forEach>
</div>

</div>
<c:import url="bottom.jsp"/>
</body>
</html>