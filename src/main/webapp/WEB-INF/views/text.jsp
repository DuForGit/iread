<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
<div class="showbox" id="text">
<c:if test="${not empty info.text.text}">
   <c:out value="${info.text.text}"/>
</c:if>
<c:if test="${empty info.text.text}">
<div><h1>本章需要购买后才能查看</h1></div>
</c:if>
</div>
<!-- <div class="prevnext">
    <div class="prev">上一卷：<a href="#">第一卷</a></div>
    <div class="next">下一卷：<a href="#">南次一经</a></div>
 </div> -->