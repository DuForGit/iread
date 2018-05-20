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
	<table class="table invoice-table" style="font-size: 12px;">
      <thead>
          <tr>
          	  <th width="10%">封面</th>
              <th width="10%">书名</th>
              <th width="10%">作者</th>
              <th width="15%">出版社</th>
              <th width="20%">购买日期</th>
              <th width="5%">价格</th>
              <th width="15%">订单号</th>
              <th width="15%">支付宝交易号</th>
          </tr>
      </thead>
      <c:forEach items="${orders}" var="o" >
         <tbody>
             <tr>
             	 <td><img height="100"  src="http://localhost:8080/iAdmin/images/book/${o.book.cover}"></td>
                 <td>${o.book.title }</td>
                 <td>${o.book.writer.name }</td>
                 <td>${o.book.publish.name }</td>
                 <td><fmt:formatDate value="${o.date }" pattern="yyyy-MM-dd HH:mm"/></td>
                 <td>${o.price }</td>
                 <td>${o.payID}</td>
                 <td>${o.orderID}</td>
             </tr>
         </tbody>
      </c:forEach>
	</table>
</div>
</body>
</html>