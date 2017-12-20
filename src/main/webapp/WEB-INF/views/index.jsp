<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>爱阅读，i阅读</title>
<%-- <%@include file="common/viewport.jsp" %>
<%@include file="common/content_type.jsp" %>
<%@include file="common/common.jsp" %> --%>
<c:import url="common/viewport.jsp"></c:import>
<c:import url="common/content_type.jsp"></c:import>
<c:import url="common/common.jsp"></c:import>
</head>
<body>

<%-- <jsp:include page="top.jsp"></jsp:include>
<jsp:include page="home.jsp"></jsp:include>
<jsp:include page="bottom.jsp"></jsp:include> --%>
<c:import url="top.jsp"></c:import>
<c:import url="home.jsp"></c:import>
<c:import url="bottom.jsp"></c:import>

</body>
</html>
