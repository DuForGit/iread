<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<style type="text/css">
.title h3{
font-weight: bolder;
}
</style>
</head>
<body>
<div class="row" style="margin-bottom: 20px;">
	<ul class="nav nav-tabs">
	 	<li class="active title"><h3>购物车</h3></li>
	</ul>
</div>

<%-- 我的购物车
<c:out value="${list }"></c:out>
<c:forEach items="${list}" var="book">
<tr >  
    <td class="center"><span class="center">${book.title}</span></td>  
    <td><dfn>￥</dfn>${book.price}</td>  
    <td>${book.writer.name}</td>  
    <td>${book.publish.name}</td>  
  </tr> 
</c:forEach> --%>

<div class="row">
<c:forEach items="${list}" var="book" >
	<div class="col-lg-2 col-md-2" style="cursor:pointer;margin: auto 10px;;" >
		<img width="150" alt="" src="${ctp}/resources/imgs/books/${book.cover}" >
		<ul class='list-unstyled'>
		<li style="margin-top: 5px;font-family:SimHei; text-align: center;">${book.title }</li>
		<li class="row">
			<a href="${ctp}/delcart?id=${book.id}" type="button" class="btn btn-xs btn-danger pull-left" style="margin-left: 25px;">删除</a>
			<a type="button" class="btn btn-xs btn-success pull-right" href="${ctp}/buy?bid=${book.id}" >购买</a>
		</li>
		</ul>
	</div>
</c:forEach>
</div>

</body>
</html>