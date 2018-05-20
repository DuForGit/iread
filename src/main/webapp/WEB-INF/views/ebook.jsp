<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
    <c:set var="book" value="${infos.book }"/>
    <c:set var="comments" value="${infos.comments }"/>
<!doctype html>
<html>
<head>
<style type="text/css">
.area{
width: 100%;
}
.active{
background-color: green;
}
</style>
<meta charset="utf-8">
<title>ebook</title>
<link rel="shortcut icon" href="favicon.png">
<!-- <link rel="icon" href="favicon.png" type="image/x-icon"> -->
<link type="text/css" rel="stylesheet" href="${ctp}/resources/css/style.css">
<script src="${ctp}/resources/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
/* function showComments(date){

} */

$(document).ready(function(){
	$("#butt").click(function(){
		
		var comm = $("#mycomment").val();
		var idd = ${book.id};
		if(comm != undefined  && comm != null && comm != ""){
			if(confirm("是否确定提交该评论？一旦提交无法撤回或修改")){
				$.post("${ctp}/addcomment",{comment:comm,bid:idd} ,function(date){
					if(date != true){
						window.location.href="${ctp}/reg";
					}else{
						window.location.href="${ctp}/ebook?id=${book.id}";
						//alert(date);
						////window.location.href="${ctp}/reg";
						//$("body").load(date);
						//parent.location.reload();
					} 
				});
			}
			
		}else{
			alert("评论不能为空");
		}
	});
});


</script>






<script type="text/javascript">


function commentsShow(date){
	var slider = $("#slider");
	var pags = $("#pages");
	var comments = date.list;//评论列表
	var total = date.total;//总数据量
	var pageNum = date.pageNum;//当前页码
	var pages = date.pages;//总页数
	var pre = date.pre;//上一页
	var next = date.next;//下一页
	var isFirstPage = date.isFirstPage;//是否为第一页
	var isLastPage = date.isLastPage;//是否为最后一页
	var hasPreviousPage = date.hasPreviousPage;//是否有上一页
	var hasNextPage = date.hasNextPage;//是否有下一页
	var size = comments.length;//当前页长度
	var row = "";//一行数据的HTML代码
	var rowpage = "";//分页栏代码
	if(size>0){
		for(var i=0;i<size;i++){
			com = comments[i];
			row = row + "<dl class='fn-clear' style='width: 100%;'><dd style='width: 100%'><a>"+com.userName+"</a>：<span>"+com.comment+"</span></dd></dl>";
			
		}
	}else{
		row = row + "<span style='color:red;'>抢沙发</span>"
	}
	slider.html(row);
	
	
	/* 分页栏start */
	if(total > 0 && pages > 1){
		rowpage = rowpage + "<span>共"+total+"条</span>" 
		+ firstPage(isFirstPage,pageNum)
		+ prePage(hasPreviousPage,pre)
		+ NumPage(pageNum, pages)
		+ nextPage(hasNextPage,next)
		+ lastPage(isLastPage,pages,pageNum);
	}
	/* 分页栏end */
	pags.html(rowpage);
}

var bookID = ${book.id};
$(document).ready(function(){
	getComments(1);
});




//包含页码分页按钮
function NumPage(pageNum, pages){
	var p = "";
	if(pages <= 10 && pages > 1){
		for(var i=1; i<=pages;i++){
			if(i == pageNum){
				p = p + " <a onclick='getComments("+i+")' class='num active' style='cursor:pointer'>"+i+"</a>";
			}else{
				p = p + " <a onclick='getComments("+i+")' class='num' style='cursor:pointer'>"+i+"</a>";
			}
		}
	}else if(pages > 10){
		if(pageNum > 5){
			var start = pageNum-4;
			var end = pageNum+5 < pages ? pageNum+5:pages;
			for(var i = start;i <=end;i++){
				if(i == pageNum){
					p = p + " <a onclick='getComments("+i+")' class='num active' style='cursor:pointer;'>"+i+"</a>";
				}else{
					p = p + " <a onclick='getComments("+i+")' class='num' style='cursor:pointer'>"+i+"</a>";
				}
			}
		}else{
			for(var i = 1;i <=10;i++){
				if(i == pageNum){
					p = p + " <a onclick='getComments("+i+")' class='num active' style='cursor:pointer'>"+i+"</a>";
				}else{
					p = p + " <a onclick='getComments("+i+")' class='num' style='cursor:pointer'>"+i+"</a>";
				}
			}
		}
	}
	return p;
}

//判断和显示前一页按钮
function prePage(hasPreviousPage,pre){
	var p = "";//“前一页按钮HTML代码”
	if(hasPreviousPage == true){
		p = "<a onclick='getComments("+pre+")' class='prev' style='cursor:pointer'>上一页</a>";
	}
	return p;
}
//判断和显示后一页按钮
function nextPage(hasNextPage,next){
	var p="";//“后一页按钮HTML代码”
	if(hasNextPage == true){
		return p = "<a onclick='getComments("+next+")' class='next' style='cursor:pointer'>下一页</a>";
	}
	return p;
}

//判断和显示第一页按钮;isFirstPage:判断是否是第一页;pageNum:大于5显示
function firstPage(isFirstPage,pageNum){
	var p = " ";//“首页按钮HTML代码”
	if(isFirstPage == false && pageNum > 5){
		return p = "<a onclick='getComments("+1+")' class='first' style='cursor:pointer'>首页</a>";
	}
	return p;
}
//判断和显示最后一页按钮;pages:总页数也是最后一页;pageNum:小于pages-5时显示
function lastPage(isLastPage,pages,pageNum){
	var p = " ";//“尾页按钮HTML代码”
	if(isLastPage == false && (pageNum < pages - 5)){
		p = "<a onclick='getComments("+pages+")' class='end' style='cursor:pointer'>尾页</a>";
	}
	return p;
}



function getComments(p){
	$.post("${ctp}/getcomms",{page:p,bid:bookID},function(date){
		commentsShow(date);
	});
}



</script>

</head>
<body>

<%-- <c:out value="${infos.chapter}"/> --%>
<%-- <c:out value="infos:  ${infos}"/> --%>
<div class="list_content fn-clear" >
<c:if test="${not empty infos}">
  <div class="list_left">
    <div class="bookpic"><img src="http://localhost:8080/iAdmin/images/book/${book.cover}" width="134" height="200"  alt=""/></div>
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
       <c:if test="${infos.existcart==false and infos.existorder==false}">
      <a href="${ctp}/addcart?id=${book.id}">添加购物车</a>|
      </c:if>
      </span> 
      <c:if test="${not empty infos.chapter}">
      <em><a href="${ctp}/showtext?bid=${book.id}" target="_blank">开始阅读</a></em>
      </c:if>
      <c:if test="${empty infos.chapter}">
      <em>暂时无法提供阅读</em>
      </c:if>
    </div>
    <div class="chapterbox">
      <dl>
        <!-- <dt>第一卷</dt> -->
        <c:forEach items="${infos.chapter}" var="cha"> 
        <dd><a>${cha.name}</a></dd>
        </c:forEach>
      </dl>
    </div>
    <%-- <c:if test=" ${not empty sessionScope.userId}">    </c:if> --%>
    <div id="mesage" style="margin-bottom: 20px;">
    	<h1><em>畅所欲言:</em></h1>
    	<textarea class="area" maxlength="100" placeholder="100字以内" id="mycomment"></textarea>
    	<button id="butt" style="padding:5px 5px;float: right; color:#fff;background-color: green;border: 0px;cursor:pointer;">提交</button>
    </div>


    
    <div class="commentbox" style="width: 100%;">
        <h1><em>用户评论:</em></h1>
        <div class="comment_list" style="width: 100%;">
          <div id="slider" style="width: 100%;">
            
          </div>
        </div>
        
        <div id="pages" class="pages">
	      
	    </div>
        
      </div>
    
  </div>
  </c:if>
  <c:if test="${empty infos}">
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
