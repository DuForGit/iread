<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
    <c:set var="books" value="${page.list}"/>
    <c:set var="size" value="${page.list.size() }"/>
<!DOCTYPE html>
<html>
<head>
<%-- <c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/> --%>
<title>我的书架</title>
<!-- <script type="text/javascript">

function loadPage(i){
	var uri =  "${ctp}/mybooks?id=" + i;
	$("#con").load(uri);
}
</script> -->
<style type="text/css">
.title h3{
font-weight: bolder;
}
</style>
</head>
<body>

<body>
<div class="row" style="margin-bottom: 20px;">
	<ul class="nav nav-tabs">
	 	<li class="active title"><h3>我的书架</h3></li>
	</ul>
</div>

<%-- <c:out value="${page.list[0]}"/> --%>
<%-- <hr>
图书总数：<c:out value="${page.total}"/>
<hr>
本页总数：<c:out value="${page.list.size()}"/>
<hr>
页码：<c:out value="${page.pageNum}"/>
<hr>
总页数：<c:out value="${page.pages}"/>
<hr>
前页：<c:out value="${page.pre}"/>
<hr>
下一页：<c:out value="${page.next}"/>
<hr>
是否是第一页：<c:out value="${page.isFirstPage}"/>
<hr>
是否是最后页：<c:out value="${page.isLastPage}"/>
<hr>
是否有上一页：<c:out value="${page.hasPreviousPage}"/>
<hr>
是否有下一页<c:out value="${page.hasNextPage}"/> --%>
<div id="con">
<div class="row">
<c:forEach items="${books}" var="book" >
	<div class="col-lg-2 col-md-2" style="cursor:pointer;margin: auto 10px;;" >
		<img width="150" alt="" src="${ctp}/resources/imgs/books/${book.cover}" >
		<ul class='list-unstyled'>
		<li style="margin-top: 5px;font-family:SimHei; text-align: center;">${book.title }</li>
		<li class="row">
			<a href="${ctp}/delmybook?id=${book.id}" type="button" class="btn btn-xs btn-danger pull-left" style="margin-left: 25px;">删除</a>
			<a type="button" class="btn btn-xs btn-success pull-right" href="${ctp}/ebook?id=${book.id}"  target="_blank">查看</a>
		</li>
		</ul>
	</div>
</c:forEach>
</div>



<%-- <div class="row" style="text-align: center;">
<ul class='pagination'>
<c:if test="${page.pages > 1 and page.pages <= 10}">
	<c:forEach var="i" begin="1" end="${page.pages}" >
		<c:if test="${i == page.pageNum}">
			<li style='cursor:pointer' class='active'><a onclick="loadPage(${i});"><c:out value="${i}"/></a></li>
		</c:if>
		<c:if test="${i != page.pageNum}">
			<li style='cursor:pointer'><a><c:out value="${i}"/></a></li>
		</c:if>
	</c:forEach>
</c:if>
<c:if test="${page.pages > 1 and page.pages > 10}">
	<c:if test="${page.hasPreviousPage}">
		<li style='cursor:pointer'><a onclick="loadPage(1);">首页</a></li>
		<li style='cursor:pointer'><a onclick="loadPage(${page.pre});">上一页</a></li>
	</c:if>
	<c:if test="${page.pageNum > 5}">
		<c:if test="${page.pageNum + 4 < page.pages}">
			<c:forEach var="i" begin="${page.pageNum - 5}"  end="${page.pageNum + 4}">
				<c:if test="${i == page.pageNum}">
					<li style='cursor:pointer' class='active'><a onclick="loadPage(${i});"><c:out value="${i}"/></a></li>
				</c:if>
				<c:if test="${i != page.pageNum}">
					<li style='cursor:pointer'><a onclick="loadPage(${i});"><c:out value="${i}"/></a></li>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${page.pageNum + 4 >= page.pages}">
		<c:forEach var="i" begin="${page.pageNum - 5}"  end="${page.pages}">
			<c:if test="${i == page.pageNum}">
				<li style='cursor:pointer' class='active'><a onclick="loadPage(${i});""><c:out value="${i}"/></a></li>
			</c:if>
			<c:if test="${i != page.pageNum}">
				<li style='cursor:pointer'><a onclick="loadPage(${i});"><c:out value="${i}"/></a></li>
			</c:if>
		</c:forEach>
		</c:if>
	</c:if>
	<c:if test="${page.pageNum < 5}">
		<c:forEach var="i" begin="1" end="10">
			<li style='cursor:pointer'><a onclick="loadPage(${i});"><c:out value="${i}"/></a></li>
		</c:forEach>
	</c:if>
	
	
	<c:if test="${page.hasNextPage}">
		<li style='cursor:pointer'><a onclick="loadPage(${page.next});">下一页</a></li>
		<li style='cursor:pointer'><a onclick="loadPage(${page.pages});">尾页</a></li>
	</c:if>
</c:if>
</ul>
</div> --%>
</div>
</body>
</html>