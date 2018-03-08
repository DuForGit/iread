<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
    <c:set var="book" value="${infos.book }"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>ebook</title>
<link rel="shortcut icon" href="favicon.png">
<!-- <link rel="icon" href="favicon.png" type="image/x-icon"> -->
<link type="text/css" rel="stylesheet" href="${ctp}/resources/css/style.css">
</head>

<body>
<%-- <c:out value="${infos.chapter}"/> --%>
<%-- <c:out value="${infos}"/> --%>
<div class="list_content fn-clear">
  <div class="list_left">
    <div class="bookpic"><img src="${ctp}/resources/imgs/books/default.jpg" width="134" height="200"  alt=""/></div>
    <div class="bookname">《${book.title}》</div>
    <div class="bookauthor">作者：<a>${book.writer.name}</a></div>
    <div class="bookauthor">出版社：<a>${book.publish.name}</a></div>
    <div class="explain">
      <p>${book.summary }</p>
    </div>
  </div>
  <div class="list_right">
    <div class="position fn-clear">
      <span>
      <c:if test="${infos.existbook==false}">
      <a href="${ctp}/addmybook?id=${book.id}">加入书架</a> | 
      </c:if>
       <c:if test="${infos.existcart==false}">
      <a href="${ctp}/addcart?id=${book.id}">添加购物车</a>|
      </c:if>
      </span> 
      <em><a href="${ctp}/showtext?bid=${book.id}" target="_blank">开始阅读</a></em>
    </div>
    <div class="chapterbox">
      <dl>
        <!-- <dt>第一卷</dt> -->
        <c:forEach items="${infos.chapter}" var="cha"> 
        <dd><a>${cha.name}</a></dd>
        </c:forEach>
      </dl>
    </div>
  </div>
</div>
</body>
</html>
