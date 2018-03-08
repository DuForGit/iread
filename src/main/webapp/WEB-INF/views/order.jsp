<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<title>订单</title>
<style type="text/css">
.title h3{
font-weight: bolder;
}
</style>
</head>
<body>

<div class="row" style="margin-bottom: 20px;">
	<ul class="nav nav-tabs">
	 	<li class="active title"><h3>我的订单</h3></li>
	</ul>
</div>

<div class="table-responsive">
	<table class="table invoice-table">
      <thead>
          <tr>
          	  <th>封面</th>
              <th>书名</th>
              <th>作者</th>
              <th>出版社</th>
              <th>购买日期</th>
              <th>价格</th>
          </tr>
      </thead>
      <c:forEach items="${orders}" var="o" >
         <tbody>
             <tr>
             	 <td><img width="100"  src="${ctp}/resources/imgs/books/${o.book.cover}"></td>
                 <td>${o.book.title }</td>
                 <td>${o.book.writer.name }</td>
                 <td>${o.book.publish.name }</td>
                 <td><fmt:formatDate value="${o.date }" pattern="yyyy-MM-dd HH:mm"/></td>
                 <td>${o.price }</td>
             </tr>
         </tbody>
      </c:forEach>
	</table>
</div>
</body>
</html>