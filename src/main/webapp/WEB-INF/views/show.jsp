<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
    <c:set var="chas" value="${infos.chapter }"/>
    <c:set var="tex" value="${infos.text }"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>iread</title>
<link rel="shortcut icon" href="favicon.png">
<link rel="icon" href="favicon.png" type="image/x-icon">
<link type="text/css" rel="stylesheet" href="${ctp}/resources/css/style.css">
<script src="${ctp }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function etext(tid){
	var bid=${infos.bookId};
	var uri = "${ctp}/text?tid="+tid+"&bid="+bid;
	$("#etext").load(uri);	
}
</script>
</head>

<body>
<%-- <c:out value="bookID：${infos.bookId}"/> --%>
<div class="list_content fn-clear">
<c:if test="${infos.soldout or infos.buy}">
  <div class="list_left">
    <!-- <div class="show_bookname">《山海经》</div> -->
    <div class="show_category">
      <dl>
        <!-- <dt>第一卷</dt> -->
        <!-- <dd><a href="#" class="selected">南山经</a></dd>
        <dd><a href="#">南次一经</a></dd> -->
        <c:forEach items="${chas }" var="cha">
        	<dd style="cursor:pointer;"><a  <%-- href="${ctp}/text?tid=${tex.id}&bid=${infos.bookId}"  --%> onclick="etext(${cha.teid});">${cha.name}</a></dd>
        </c:forEach>
      </dl>
      
    </div>
  </div>
  <div class="list_right">
    <div class="position fn-clear">
      <!-- <span><a href="#">首页</a> > <a href="#">文学</a> > <a href="#">山海经</a> > 南山经</span> -->
      <!-- <em>南山经</em> -->
    </div>
    <div id="etext">
    <div class="showbox">
    	<c:out value="${infos.text.text }" escapeXml="false"></c:out>
    </div>
    <!-- <div class="prevnext">
      <div class="prev">上一卷：<a href="#">第一卷</a></div>
      <div class="next">下一卷：<a href="#">南次一经</a></div>
    </div> -->
    </div>
    <!-- <div class="message">
      <div id="SOHUCS"></div>
	  <script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js" ></script>
      <script type="text/javascript">
          window.changyan.api.config({
              appid: 'cyrVIQX8H',
              conf: 'prod_5c1357557972b98c17b2c748d528888b'
          });
      </script>
    </div> -->
  </div>
  </c:if>
  
  
  <c:if test="${!infos.soldout and !infos.buy}">

  <div class="list_right">
    <div class="position fn-clear">
      <em><a href="${ctp}/">点击此处前往首页</a></em>
    </div>
    <div class="chapterbox">
		<h3 style="text-align: center; font-size: 36px">本书已下架，无法阅读</h3>
    </div>
  </div>
</c:if>
  
</div>


</body>
</html>
