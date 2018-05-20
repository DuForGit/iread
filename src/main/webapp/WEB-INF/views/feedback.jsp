<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>支付异常反馈</title>
<link rel="shortcut icon" href="favicon.png">
<link rel="icon" href="favicon.png" type="image/x-icon">
<link type="text/css" rel="stylesheet" href="${ctp}/resources/css/style.css">
</head>

<body>

<div class="list_content fn-clear">

  
  

  <div class="list_right">
    <div class="position fn-clear">
      <em><a href="${ctp}/">点击此处前往首页</a></em>
    </div>
    <div class="chapterbox">
		<h3 style="text-align: center; font-size: 36px">支付错误 ...</h3>
		<div style="text-align: center;color:red;"><span>请确认支付是否成功</span></div>
    </div>
  </div>
  
</div>


</body>
</html>
