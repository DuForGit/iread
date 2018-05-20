<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
	 	<li class="active title"><h3>购物车<span style="font-size: 15px;">(总数不得超过<span style="color:red;">99</span>/当前数量<span style="color:red;">${total}</span>)</span></h3></li>
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

<%-- list的长度是：${fn:length(list)} --%>

<div class="row">
<c:forEach items="${list}" var="book" >
	<div class="col-lg-2 col-md-2" style="cursor:pointer;margin: auto 10px;;" >
		<img width="150" alt="" src="http://localhost:8080/iAdmin/images/book/${book.cover}" >
		<ul class='list-unstyled'>
		<li style="margin-top: 5px;font-family:SimHei; text-align: center;">
		<c:if test="${fn:length(book.title)>'7'}">
			 ${fn:substring(book.title,0,7)}...
		 </c:if>
		 <c:if test="${fn:length(book.title)<='7'}">
			 ${book.title}
		 </c:if>
		</li>
		<li class="row">
			<a type="button" class="btn btn-xs btn-danger pull-left" style="margin-left: 25px;" onclick="deleteMyCart(${book.id});">删除</a>
			<a type="button" class="btn btn-xs btn-success pull-right" onclick="buybook(${book.id},${book.price})" <%-- href="${ctp}/buy?bid=${book.id}"  --%>>购买</a>
		</li>
		</ul>
	</div>
</c:forEach>
</div>

<script type="text/javascript">

function deleteMyCart(i){
	
	if(confirm("是否确定将该书从购物车中移除？")){
		
		uri = "${ctp}/delcart";
		$.post(uri,{id:i});
		//window.location.href="${ctp}/my";
		$("#main").load("${ctp}/mycart");
		$("#main").load("${ctp}/mycart");
	}
	
	
	
	
}



function buy(i){
	$.post("${ctp}/pay",{bid:i},function(date){
		//alert(date);
		if(date == "0"){
			alert("你已经购买此书！")
			window.location.href="${ctp}/ebook?id=" + i;
		}else if(date == "1"){
			alert("本书已下架！")
		}else{
			$("body").html(date);
		}
	});
}
function buyNoAlipay(i){
	$.post("${ctp}/buy",{bid:i},function(date){
		if(date == 2){
			alert("购买成功！");
			window.location.href="${ctp}/ebook?id=" + i;
		}else if(date == 1){
			alert("本书已下架！");
		}
		else if(date == 0){
			alert("你已经购买此书！");
			window.location.href="${ctp}/ebook?id=" + i;
		}else{
			alert("购买失败！")
		}
	});
}
function buybook(bo,pr){
	//alert("确认购买：" + "bookid: " + bo + "; price: " + pr);
	if(pr == 0){
		buyNoAlipay(bo);
		}else{
			buy(bo);
		}
}
</script>


<script type="text/javascript">


</script>
</body>
</html>